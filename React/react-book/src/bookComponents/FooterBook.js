import React from 'react';

const FooterBook = () => {
    return (
        <section className="">
            <footer className="bg-secondary text-white text-center text-md-start">
                <div className="container p-4">
                    <div className="row">
                        <div className="col-lg-6 col-md-12 mb-4 mb-md-0">
                            <h5 className="text-uppercase">Footer Content</h5>

                            <p>
                                Footer ContentFooter ContentFooter ContentFooter ContentFooter Content
                                Footer ContentFooter ContentFooter ContentFooter ContentFooter Content
                                Footer ContentFooter ContentFooter ContentFooter ContentFooter Content
                            </p>
                        </div>

                        <div className="col-lg-3 col-md-6 mb-4 mb-md-0">
                            <h5 className="text-uppercase">Links</h5>

                            <ul className="list-unstyled mb-0">
                                <li>
                                    <a href="/" className="text-white">Link 1</a>
                                </li>
                                <li>
                                    <a href="/" className="text-white">Link 2</a>
                                </li>
                                <li>
                                    <a href="/" className="text-white">Link 3</a>
                                </li>
                                <li>
                                    <a href="/" className="text-white">Link 4</a>
                                </li>
                            </ul>
                        </div>

                        <div className="col-lg-3 col-md-6 mb-4 mb-md-0">
                            <h5 className="text-uppercase mb-0">Links</h5>

                            <ul className="list-unstyled">
                                <li>
                                    <a href="/" className="text-white">Link 1</a>
                                </li>
                                <li>
                                    <a href="/" className="text-white">Link 2</a>
                                </li>
                                <li>
                                    <a href="/" className="text-white">Link 3</a>
                                </li>
                                <li>
                                    <a href="/" className="text-white">Link 4</a>
                                </li>
                            </ul>
                        </div>
                    </div>
                </div>

                <div className="text-center p-3" style={{}}>
                    © 2022 Footer Content :
                    <a className="text-white" href="https://mdbootstrap.com/"> Footer Content </a>
                </div>
            </footer>
        </section>
    );
};

export default FooterBook;