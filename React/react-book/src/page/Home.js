import React, {useEffect, useState} from 'react';
import 'bootstrap/dist/css/bootstrap.min.css';
import Form from 'react-bootstrap/Form';
import InputGroup from 'react-bootstrap/InputGroup';
import RenderBook from '../bookComponents/RenderBook';
import Container from 'react-bootstrap/Container';
import Row from 'react-bootstrap/Row';
import Col from 'react-bootstrap/Col';
import {Button, Nav, Navbar} from 'react-bootstrap';
import Cart from '../bookComponents/CartTask';
import Carousel_Slideshow from "../bookComponents/Carousel_Slideshow";

const Home = () => {
    const [data, setData] = useState([]);
    const [searchBook, setSearchBook] = useState('');

    useEffect(() => {
        console.log('effect data book home page');
        let url = 'https://62baa4fb573ca8f832881fa9.mockapi.io/book';
        if (searchBook.length > 0) {
            url = url + '?search=' + searchBook;
        }
        fetch(url)
            .then((response) => response.json())
            .then((data) => {
                setData(data);
                console.log("get data", data);
            });
    }, [searchBook]);

    const sort_price = () => {
        // console.log([...data].sort((o1,o2) => o1.price-o2.price))
        setData([...data].sort((o1, o2) => o1.price - o2.price));
    };
    return (
        <div>
            <Container>
                <Carousel_Slideshow/>

                <h1 className="text-center m-3">Shop</h1>
                <Row>
                    <Col xs={12} md={9}>
                        <Row>
                            <div className="col-sm-6">
                                <InputGroup className="mb-3">
                                    <Form.Control
                                        placeholder="Search Book Store"
                                        aria-label="Recipient's username"
                                        aria-describedby="basic-addon2"
                                        value={searchBook}
                                        onChange={(e) => setSearchBook(e.target.value)}
                                    />
                                    <InputGroup.Text id="basic-addon2">search</InputGroup.Text>
                                </InputGroup>
                            </div>
                        </Row>

                        <RenderBook data={data}/>
                    </Col>

                    <Col xs={6} md={3}>
                        <div className="text-start mt-5">
                            <Button onClick={sort_price} variant="outline-info">
                                Sort Price
                            </Button>{' '}
                            <br/> <br/>
                            {/*<Link as={Cart}>*/}
                            {/*    <Button variant="outline-info">Cart</Button>*/}
                            {/*</Link>*/}
                            <Navbar>
                                <Nav>
                                    <Nav.Link as={Cart} to="/cart" exact>
                                        <Button variant="outline-info">Cart</Button>
                                    </Nav.Link>
                                </Nav>
                            </Navbar>
                        </div>
                    </Col>
                </Row>
            </Container>
        </div>

    );
};

export default Home;
