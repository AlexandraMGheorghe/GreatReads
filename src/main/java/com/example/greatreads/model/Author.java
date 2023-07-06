package com.example.greatreads.model;

import com.example.greatreads.model.enums.UserRole;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.Set;

@Data
@Entity
@SuperBuilder
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@DiscriminatorValue(UserRole.Roles.AUTHOR)
public class Author extends User {

    @JsonIgnore
    @OneToMany(mappedBy = "author")
    @Column(name = "published_books")
    private Set<Book> books;
}