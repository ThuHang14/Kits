import React from 'react';
import {Route, Routes} from 'react-router-dom';
import Home from './page/Home';
import CartDetails from './page/CartDetails'
import Navbar from "./bookComponents/NavBars";
import Admin from "./page/Admin"

function App() {
    return (
        <div>
            <Navbar/>
            {<Routes>
                <Route path="/" element={<Home/>}>
                    <Route index element={<Home/>}/>
                    <Route path="cart" element={<CartDetails/>}>
                        <Route path="admin" element={<Admin/>}/>
                    </Route>
                </Route>
            </Routes>}
        </div>
    );
}

export default App;
