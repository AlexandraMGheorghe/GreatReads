import logo from './great-read-logo.jpeg'
import Home from './Components/Home/HomeComponent'
import Books from './Components/Books/BooksTable';

import Login from './Components/Login/LoginComponent';
import PagenotFound from './Components/pagenotFound';

import {
    BrowserRouter as Router,
    Routes,
    Route,
} from "react-router-dom";
import Navbar from './Components/NavBar/NavigationBar';
import Register from "./Components/Register/RegisterComponent";
import Review from "./Components/Review/ReviewBooks";
function App() {
    return(<>
        <Navbar />
            <Router>

                <Routes>
                    <Route path='/' element={<Home/>} />
                    <Route path='/books' element={<Books/>} />
                    <Route path='/review' element={<Review/>} />
                    <Route path='/login' element={<Login/>} />
                    <Route path='/register' element={<Register/>} />
                    <Route path='**' element={<PagenotFound/>} />
                </Routes>

        </Router>

    </>)
}

export default App;