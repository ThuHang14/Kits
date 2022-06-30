import React, {useEffect, useState} from 'react';
import {Button} from "react-bootstrap";
import {Link} from "react-router-dom";

const CartDetails = () => {
    const [cart, setCart] = useState()
    const [total, setTotal] = useState()
    useEffect(() => {
            let url = 'https://62baa4fb573ca8f832881fa9.mockapi.io/cart'
            fetch(url)
                .then((response) => response.json())
                .then((data) => {
                    setCart(data);
                });
        }
        , [cart]);
    let products_jsx = []
    if (cart != null) {
        cart.map((cart,index) => {
            return products_jsx.push(
                <tr key={index}>
                    <td>{cart.name}</td>
                    <td>
                        <img src={cart.image} style={{height: "40px"}}/>
                    </td>
                    <td>{cart.amount}</td>
                    <td>{cart.price}</td>
                    <td></td>
                </tr>
            )
        })
    }

    const totalPrice = () => {
        cart.map((cart) => {
            return cart.amount * cart.price
        })
    }

    return (
        <div className="container-fluid">

            <div className="row">
                <div className="col mt-2">
                    <h2 className="text-center">Your Cart</h2>
                    <table className="table table-bordered table-striped p-2">
                        <thead>
                        <tr>
                            <th>Product</th>
                            <th>image</th>
                            <th>Quantity</th>
                            <th className="text-right">Price</th>
                            <th className="text-right">Subtotal</th>
                        </tr>

                        </thead>
                        <tbody>
                        {products_jsx}
                        </tbody>
                        <tfoot>
                        <tr>
                            <td colSpan="3" className="text-right">
                                Total:
                            </td>
                            <td className="text-right">$</td>
                        </tr>
                        </tfoot>
                    </table>
                </div>
            </div>
            <div className="row">
                <div className="col mb-4">
                    <div className="text-center">
                        <Button variant="outline-info" className="me-3">
                            <Link to="/" className="nav-link">Continue Shopping</Link>
                        </Button>
                        <Button variant="danger">
                            <Link to="/" className="nav-link">Checkout </Link>
                        </Button>
                    </div>
                </div>
            </div>
        </div>
    );
};

export default CartDetails;