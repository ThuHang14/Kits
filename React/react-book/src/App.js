import React from 'react';
import {BrowserRouter as Router, Route, Routes} from 'react-router-dom';

import Home from './page/Home';
import CartDetails from './page/CartDetails'
import Admin from "./page/Admin"
import NavBarsBook from "./bookComponents/NavBarsBook";
import FooterBook from "./bookComponents/FooterBook";
import DetailBook from "./page/DetailsBook";
import EditBook from "./page/EditBook";




function App() {
    return (
        <div>
            <div>
                <NavBarsBook/>
            </div>
            <div>
                <Routes>
                    <Route path="/" element={<Home />} />
                    <Route path="/cart" element={<CartDetails />} />
                    <Route path="/admin" element={<Admin />} />
                    <Route path="/book/:id" element={<DetailBook />} />
                    <Route path="/edit/:id" element={<EditBook />} />
                </Routes>
            </div>
            <div>
                <FooterBook/>
            </div>
        </div>

    );
}

export default App;
