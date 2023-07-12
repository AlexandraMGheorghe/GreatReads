import React, { useState } from "react";
import { useDispatch } from "react-redux";
import { editReview, removeReview } from "../redux/action";
import RemoveButton from "./RemoveButton";
import EditButton from "./EditButton";
import SaveButton from "./SaveButton";
import { useSelector } from "react-redux";

const Review = (props) => {
    const [isEditing, setIsEditing] = useState(false);
    const [updatedDescription, setUpdatedDescription] = useState(
        props.description
    );
    const dispatch = useDispatch();
    const books = useSelector((state) => state.books);

    const handleEdit = () => {
        setIsEditing(true);
    };

    const handleSave = () => {
        dispatch(editReview(props.title, updatedDescription));
        setIsEditing(false);
    };

    const handleRemove = () => {
        dispatch(removeReview(props.title));
    };

    const handleDescriptionChange = (event) => {
        setUpdatedDescription(event.target.value);
    };

    return (
        <div
            style={{
                width: "240px",
                height: "240px",
                background: "#f5b042",
                borderRadius: "10px",
                overflowY: "auto",
                margin: "4px",
            }}
        >
            <h3>{props.title}</h3>
            {isEditing ? (
                <textarea
                    style={{ flex: 1, width: "100%", marginBottom: "4px" }}
                    onChange={handleDescriptionChange}
                    value={updatedDescription}
                />
            ) : (
                <span style={{ marginTop: "8px" }}>{props.description}</span>
            )}
            {isEditing ? (
                <SaveButton handleSave={handleSave} />
            ) : (
                <EditButton handleEdit={handleEdit} />
            )}
            <RemoveButton title={props.title} />
        </div>
    );
};

export default Review;