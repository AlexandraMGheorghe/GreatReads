import React from 'react'
import './NavBar.css'
import logo from "./great.jpeg";

function Navbar() {
    return (
        <>
            <div className='nav'>
                <div className='logo-image'>
                    <img src={logo} className="App-logo" alt=" Logo" />
                </div>
                <div className='logo-home'>
                    <span onClick={()=>{window.location.assign('/')}}>Home</span>
                </div>

                <div className='logo-books'>
                    <span onClick={()=>{window.location.assign('/books')}}>Books</span>
                </div>
                <div className='logo-review'>
                    <span onClick={()=>{window.location.assign('/review')}}>Review</span>
                </div>
                <div className='register'>
                    <span onClick={()=>{window.location.assign('/register')}}>Register</span>
                    <span onClick={()=>{window.location.assign('/login')}}>Login</span>
                </div>

            </div>
        </>
    )
}

export default Navbar