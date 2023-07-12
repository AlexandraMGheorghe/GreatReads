import { ADD_REVIEW, REMOVE_REVIEW, EDIT_REVIEW, SAVE_REVIEW } from "./action";

const initialState = {
    books: [],
};

const rootReducer = (state = initialState, action) => {
    switch (action.type) {
        case ADD_REVIEW:
            return {
                ...state,
                books: [
                    ...state.books,
                    {
                        title: action.payload.title,
                        description: action.payload.description,
                    },
                ],
            };
        case REMOVE_REVIEW:
            return {
                ...state,
                books: state.books.filter((book) => book.title !== action.payload.title),
            };
        case EDIT_REVIEW:
            return {
                ...state,
                books: state.books.map((book) => {
                    if (book.title === action.payload.title) {
                        return {
                            ...book,
                            description: action.payload.description,
                        };
                    }
                    return book;
                }),
            };
        case SAVE_REVIEW:

            return{
            ...state,
            books: [
                ...state.books,
                {
                    title: action.payload.title,
                    description: action.payload.description,
                },
            ],
        };
        default:
            return state;
    }
};

export default rootReducer;
