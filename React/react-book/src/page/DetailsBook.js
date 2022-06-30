import React, {useEffect, useState} from 'react';

import {useParams} from 'react-router-dom';

const DetailBook = () => {
    const params = useParams();
    const [student, setStudent] = useState(null);
    useEffect(() => {
        console.log(' render user ');

        let url = 'https://62baa4fb573ca8f832881fa9.mockapi.io/book/' + params.id;

        console.log(url);
        fetch(url)
            .then((response) => response.json())
            .then((data) => {
                data.publishingYear = new Date(data.publishingYear);
                console.log('publishingYear', data.publishingYear);
                setStudent(data); //setStudents(data)
            });
    }, []);

    const formatDate = (date) => {
        return date.toLocaleDateString();
    };

    return (
        <>
            {student != null ? (
                <div class="container bootstrap snippets bootdey">
                    <div class="panel-body inf-content">
                        <div class="row">
                            <div class="col-md-6">
                                <h1>Book</h1>
                                <br/>
                                <div class="table-responsive">
                                    <table class="table table-user-information">
                                        <tbody>
                                        <tr>
                                            <td>
                                                <strong>Stt</strong>
                                            </td>
                                            <td class="text-primary">{student.id}</td>
                                        </tr>
                                        <tr>
                                            <td>
                                                <strong> Name</strong>
                                            </td>
                                            <td class="text-primary">{student.name}</td>
                                        </tr>
                                        <tr>
                                            <td>
                                                <strong>Price</strong>
                                            </td>
                                            <td class="text-primary">{student.price}</td>
                                        </tr>

                                        <tr>
                                            <td>
                                                <strong>Category</strong>
                                            </td>
                                            <td class="text-primary">{student.category}</td>
                                        </tr>

                                        <tr>
                                            <td>
                                                <strong>Author</strong>
                                            </td>
                                            <td class="text-primary">{student.author}</td>
                                        </tr>

                                        <tr>
                                            <td>
                                                <strong>Publishing Year</strong>
                                            </td>
                                            <td class="text-primary">
                                                {formatDate(student.publishingYear)}
                                            </td>
                                        </tr>

                                        <tr>
                                            <td>
                                                <strong>Title</strong>
                                            </td>
                                            <td className="text-primary">{student.details}</td>
                                        </tr>

                                        <tr>
                                            <td>
                                                <strong>Image</strong>
                                            </td>
                                            <td class="text-primary">
                                                <img src={student.image} className="img-circle"/>
                                            </td>
                                        </tr>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            ) : (
                'loading....    '
            )}
        </>
    );
};

export default DetailBook;

