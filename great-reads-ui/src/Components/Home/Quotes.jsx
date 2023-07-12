import React, { useState, useEffect } from "react";

const Quotes = () => {
    const [message, setMessage] = useState("“To live is the rarest thing in the world. Most people exist, that is all.”\n" +
        "Oscar Wilde");

    useEffect(() => {
        setTimeout(() => {
            setMessage("“You only live once, but if you do it right, once is enough.” Mae West");
        }, 2000);
        setTimeout(() => {
            setMessage("“A room without books is like a body without a soul.” Marcus Tullius Cicero");
        }, 5000);
    }, []);
    return <h1>{message}</h1>;
};

export default Quotes;