import React from "react";




class Image extends React.Component {
    render() {
        const {title, author, genre, image} = this.props;
        return (
            <div
                style={{
                    //border: "1px solid black",
                    width: "1024px",
                    borderRadius: "16px",
                    padding: "8px",
                    display: "flex",
                    height: "180px",

                }}
            >
                <div style={{width: "100%", textAlign: 'center'}}>
                    <h4>Title: {this.props.title}</h4>
                    <h5>Author: {this.props.author}</h5>
                    <h6>Genre: {this.props.genre}</h6>
                </div>
                {/*<Books*/}
                {/*    title={this.props.title}*/}
                {/*    author={this.props.author}*/}
                {/*    genre={this.props.genre}*/}
                {/*/>*/}
                <img src={this.props.image} height="120px" alt="Image"/>
            </div>

        );
    };
}

export default Image;
