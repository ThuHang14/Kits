import React from 'react';
import {BrowserRouter as Router, Route, Routes} from 'react-router-dom';

import Home from './page/Home';
import CartDetails from './page/CartDetails'
import Admin from "./page/Admin"
import NavBarsBook from "./bookComponents/NavBarsBook";
import FooterBook from "./bookComponents/FooterBook";




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
                </Routes>
            </div>
            <div>
                <FooterBook/>
            </div>
        </div>

    );
}

export default App;
