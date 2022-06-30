import React, {useEffect, useState} from 'react';

const CartDetails = () => {
    const [cart,setCart] = useState()
    useEffect( () => {
            let url = 'https://62baa4fb573ca8f832881fa9.mockapi.io/cart'
        fetch(url)
            .then((response) => response.json())
            .then((data) => {
                setCart(data);
            });
        }
    ,[cart] );
    let products_jsx = []
    
    return (
        <div className="container-fluid">
            <div className="row">
                <div className="col mt-2">
                    <h2 className="text-center">Your Cart</h2>
                    <table className="table table-bordered table-striped p-2">
                        <thead>
                        <tr>
                            <th>Quantity</th>
                            <th>Product</th>
                            <th className="text-right">Price</th>
                            <th className="text-right">Subtotal</th>
                        </tr>
                        </thead>
                        <tbody>
                        <tr>
                            <td colSpan="4" className="text-center">
                                Your cart is empty
                            </td>
                        </tr>

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
                <div className="col">
                    <div className="text-center">
                        <button className="btn btn-primary m-1">Continue Shopping</button>
                        <button className="btn btn-danger m-1" type="button">
                            Checkout
                        </button>
                    </div>
                </div>
            </div>
        </div>
    );
};

export default CartDetails;