import axios from "axios";
import image2 from '../Books/book.jpeg'
import {
    FaGoogle,
    FaTwitter,
    FaLinkedin,
    FaGithub,
    FaInstagram,
    FaYoutube,
} from 'react-icons/fa'
import bookData2 from '../Books/Books.json';
import Image from "./Image";
import image3 from './Summer_reading.jpeg'
import Quotes from "./Quotes";
import {TableFooter} from "@mui/material";
import image4 from "./imagesQ.jpeg"
import {useEffect, useState} from "react";
import moment from "moment";

const HomeComponent = () => {

    const [currentTime, setCurrentTime] = useState(moment().format("YYYY-MM-DD HH:mm:ss"));

    useEffect(() => {
        const interval = setInterval(() => {
            setCurrentTime(moment().format("YYYY-MM-DD HH:mm:ss"));
        }, 1000);

        return () => {
            clearInterval(interval);
        };
    }, []);

    return (
        <h3>
            <p style={{ textAlign: 'left', fontSize: '20px' }}>
                {currentTime}
            </p>
            <header style={{textAlign: 'center'}}><img src={image3} alt="Logo" /> </header>
            <p style={{
                textAlign: 'center',
                fontSize: '28px',
            }}> What will you discover? </p>
            <p style={{
                textAlign: 'left',
                fontSize: '28px',
            }}> Redears liked...</p>

            <div id="container">

                {bookData2.map((book) => (
                    <Image
                        title={book.title}
                        author={book.author}
                        genre={book.genre}
                        image={book.image}

                    />
                ))}

            </div>
            <p style={{
                textAlign: 'left',
                fontSize: '26px',
            }}>    <img
                src={image4}
                alt="Quotes"
                style={{ width: '100px', height: '100px' }}
            /> Quotes:
            </p>
            <p style={{
                textAlign: 'center',
                fontSize: '16px',
            }}>  <Quotes/> </p>
            <TableFooter>
                <div className="footer-container">
                    <div className="icons-container">
                        <a href="mailto:greatreads@gmail.com" className="footer-icon-button">
                            <FaGoogle className={`footer-icon `} />
                        </a>
                        <a
                            href="https://www.linkedin.com/in/alexandra-gheorghe-/"
                            target="__blank"
                            rel="noopener noreferrer"
                            className="footer-icon-button"
                        >
                            <FaLinkedin className={`footer-icon `} />
                        </a>
                        <a
                            href="https://github.com/AlexandraMGheorghe"
                            target="__blank"
                            rel="noopener noreferrer"
                            className="footer-icon-button"
                        >
                            <FaGithub className={`footer-icon `} />
                        </a>
                        <a
                            href="https://www.twitter.com"
                            target="__blank"
                            rel="noopener noreferrer"
                            className="footer-icon-button"
                        >
                            <FaTwitter className={`footer-icon `} />
                        </a>
                        <a
                            href="https://www.instagram.com/kiran_gottumukkala/"
                            target="__blank"
                            rel="noopener noreferrer"
                            type="button"
                            className="footer-icon-button"
                        >
                            <FaInstagram className={`footer-icon `} />
                        </a>
                        <a
                            href="https://www.youtube.com/greatreads"
                            target="__blank"
                            rel="noopener noreferrer"
                            type="button"
                            className="footer-icon-button"
                        >
                            <FaYoutube className={`footer-icon `} />
                        </a>
                    </div>
                    <p className={`contact-us-text `}>Contact us</p>
                </div>
            </TableFooter>

        </h3>



    )};


export default HomeComponent;