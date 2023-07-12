import React from "react";
import Review from "./Review";
import { useSelector } from "react-redux";
import AddReview from "./AddReview";
import books from "../Books/Books.json";

const ReviewsList = () => {
    //const books = books2;

    return (
        <div
            style={{
                padding: "8px",
                display: "flex",
                width: "100%",
                flexWrap: "wrap",
                justifyContent: "center",
            }}
        >
            {books &&
                books.map((book, index) => (
                    <div key={`book-${index}-${book.title}`}>
                        <Review
                            title={book.title}
                            description={book.description}
                        />
                        <AddReview bookId={book.id} />
                    </div>
                ))}
        </div>
    );
};

export default ReviewsList;
