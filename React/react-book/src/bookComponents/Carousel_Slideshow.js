import Carousel from 'react-bootstrap/Carousel';

function CarouselSlideshow() {
    return (
        <Carousel>
            <Carousel.Item interval={1000}>
                <img
                    className="d-block w-100"
                    src="https://i.pinimg.com/564x/68/a6/93/68a693e81018f5e4ef76a501aadfa7c2.jpg"
                    alt="First slide"
                    height="300px"
                />
                <Carousel.Caption>
                    <h3>First slide label</h3>
                    <p>Nulla vitae elit libero, a pharetra augue mollis interdum.</p>
                </Carousel.Caption>
            </Carousel.Item>
            <Carousel.Item interval={500}>
                <img
                    className="d-block w-100"
                    src="https://i.pinimg.com/564x/68/a6/93/68a693e81018f5e4ef76a501aadfa7c2.jpg"
                    alt="First slide"
                    height="300px"
                />
                <Carousel.Caption>
                    <h3>Second slide label</h3>
                    <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.</p>
                </Carousel.Caption>
            </Carousel.Item>
            <Carousel.Item>
                <img
                    className="d-block w-100"
                    src="https://i.pinimg.com/564x/68/a6/93/68a693e81018f5e4ef76a501aadfa7c2.jpg"
                    alt="First slide"
                    height="300px"
                />
                <Carousel.Caption>
                    <h3>Third slide label</h3>
                    <p>
                        Praesent commodo cursus magna, vel scelerisque nisl consectetur.
                    </p>
                </Carousel.Caption>
            </Carousel.Item>
        </Carousel>
    );
}

export default CarouselSlideshow;