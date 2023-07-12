import React from "react";
import { useDispatch } from "react-redux";
import { removeReview } from "../redux/action";

const RemoveButton = ({ title }) => {
    const dispatch = useDispatch();

    const handleDelete = () => {
        dispatch(removeReview(title));
    };

    return <button onClick={handleDelete}>Remove</button>;
};

export default RemoveButton;