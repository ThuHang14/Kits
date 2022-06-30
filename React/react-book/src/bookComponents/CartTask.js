import React, { useEffect, useState } from 'react';
import Col from 'react-bootstrap/Col';
import Row from 'react-bootstrap/Row';
import Toast from 'react-bootstrap/Toast';
import Image from 'react-bootstrap/Image';
import {Button} from "react-bootstrap";

const CartTask = () => {
    const [cart, setCart] = useState();
    const [showB, setShowB] = useState(true);

    var today = new Date(),
        date = today.getFullYear() + '-' + (today.getMonth() + 1) + '-' + today.getDate();

    const toggleShowB = () => setShowB(!showB);
    let url = 'https://62baa4fb573ca8f832881fa9.mockapi.io/cart';
    useEffect(() => {
        fetch(url)
            .then((response) => response.json())
            .then((cart) => {
                setCart(cart);
            });
    }, [url]);

    var list_cart = [];

    if (cart != null) {
        cart.map((c, id) => {
            return list_cart.push(
            <Toast onClose={toggleShowB} show={showB} animation={false} className="mt-3">
                <Toast.Header>
                    <Image src={c.image} style={{ height: '40px' }} />
                    <strong className="me-auto ms-3">Name : {c.name}</strong>
                    <small>{c.amount}</small>
                </Toast.Header>
                <Toast.Body>{date}</Toast.Body>
            </Toast>

            );
        });
    }

    return (
        <div>
            <Row>
                <Col md={12} className="mt-2 mb-2 ">
                    <Button onClick={toggleShowB} className="mb-2">
                        Details <strong>Cart</strong>
                    </Button>
                    {list_cart}
                </Col>
            </Row>
        </div>
    );
};

export default CartTask;
