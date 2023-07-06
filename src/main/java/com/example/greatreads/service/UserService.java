package com.example.greatreads.service;

import com.example.greatreads.dto.LoginRequestDTO;
import com.example.greatreads.dto.LoginResponseDTO;
import com.example.greatreads.dto.UserDTO;
import com.example.greatreads.model.Author;
import com.example.greatreads.model.Reader;
import com.example.greatreads.model.User;
import com.example.greatreads.model.enums.UserRole;
import com.example.greatreads.repository.AuthorRepository;
import com.example.greatreads.repository.ReaderRepository;
import com.example.greatreads.repository.UserRepository;
import com.example.greatreads.security.UserDetailsImplementation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Locale;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {

    private final AuthenticationManager authenticationManager;
    private final UserRepository userRepository;
    private final ReaderRepository readerRepository;
    private final AuthorRepository authorRepository;
    private final PasswordEncoder encoder;
    private final JWTService jwtHelper;

    public ResponseEntity<?> login(LoginRequestDTO loginRequest) {

        Authentication authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        UserDetailsImplementation userDetails = (UserDetailsImplementation) authentication.getPrincipal();

        ResponseCookie jwtCookie = jwtHelper.generateJwtCookie(userDetails);

        String role = userDetails.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList()).get(0);

        return ResponseEntity.ok()
                .header(HttpHeaders.SET_COOKIE, jwtCookie.toString())
                .body(new LoginResponseDTO(userDetails.getEmail(), jwtCookie.getValue(), userDetails.getId(), role));
    }

    @Transactional
    public ResponseEntity<?> register(UserDTO registerRequestDTO) {
        if (userRepository.existsByEmail(registerRequestDTO.getEmail())) {
            return ResponseEntity.badRequest().body("Email used");
        }

        String role = registerRequestDTO.getRole();

        if (UserRole.Roles.READER.toUpperCase(Locale.ROOT).equals(role)) {
            Reader reader = Reader.builder()
                    .email(registerRequestDTO.getEmail())
                    .password(encoder.encode(registerRequestDTO.getPassword()))
                    .firstName(registerRequestDTO.getFirstName())
                    .lastName(registerRequestDTO.getLastName())
                    .role(UserRole.valueOf(role)).build();
            readerRepository.save(reader);
        } else if (UserRole.Roles.AUTHOR.toUpperCase(Locale.ROOT).equals(role)) {
            Author author = Author.builder()
                    .email(registerRequestDTO.getEmail())
                    .password(encoder.encode(registerRequestDTO.getPassword()))
                    .firstName(registerRequestDTO.getFirstName())
                    .lastName(registerRequestDTO.getLastName())
                    .role(UserRole.valueOf(role)).build();
            authorRepository.save(author);
        } else if (UserRole.Roles.ADMIN.toUpperCase(Locale.ROOT).equals(role)) {
            User user = Reader.builder()
                    .email(registerRequestDTO.getEmail())
                    .password(encoder.encode(registerRequestDTO.getPassword()))
                    .firstName(registerRequestDTO.getFirstName())
                    .lastName(registerRequestDTO.getLastName())
                    .role(UserRole.valueOf(role)).build();
            userRepository.save(user);
        } else {
            throw new RuntimeException("Invalid role");
        }

        return ResponseEntity.ok("User registered successfully!");
    }

    public ResponseEntity<?> update(Long userId, LoginRequestDTO loginRequestDTO) {
        Optional<User> userToUpdate = userRepository.findById(userId);

        if (!userToUpdate.isPresent()) {
            return ResponseEntity.badRequest().body("User not found for updating!");
        }

        User user = userToUpdate.get();
        user.setEmail(loginRequestDTO.getEmail());
        user.setPassword(loginRequestDTO.getPassword());
        userRepository.save(user);

        return ResponseEntity.ok("User updated successfully!");
    }
}