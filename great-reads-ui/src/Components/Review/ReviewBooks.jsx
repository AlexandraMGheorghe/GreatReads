import React from "react";
import ReviewsList from "./ReviewsList";
import { Provider } from "react-redux";
import store from "../redux/store";
import AddReview from "./AddReview";

const ReviewBooks = () => {
    return (
        <Provider store={store}>
            <AddReview/>
            <ReviewsList />
        </Provider>
    );
};

export default ReviewBooks;