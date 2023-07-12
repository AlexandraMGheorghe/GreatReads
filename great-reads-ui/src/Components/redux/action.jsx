export const ADD_REVIEW = "ADD_REVIEW";
export const REMOVE_REVIEW = "REMOVE_REVIEW";
export const EDIT_REVIEW = "EDIT_REVIEW";
export const SAVE_REVIEW = "SAVE_REVIEW";

export const addReview = (title, description) => {
    return {
        type: ADD_REVIEW,
        payload: {
            title: title,
            description: description,
        },
    };
};

export const removeReview = (noteId) => {
    return {
        type: REMOVE_REVIEW,
        payload: {
            noteId: noteId,
        },
    };
};

export const editReview = (noteId, newDescription) => {
    return {
        type: EDIT_REVIEW,
        payload: {
            noteId: noteId,
            newDescription: newDescription,
        },
    };
};



export const saveReview = (noteId, updatedDescription) => {
    return {
        type: SAVE_REVIEW,
        payload: {
            noteId: noteId,
            updatedDescription: updatedDescription,
        },
    };
};