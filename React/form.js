// https://stackblitz.com/edit/react-u4tc3d?file=src/App.js
import React from 'react';
import './style.css';
import 'bootstrap/dist/css/bootstrap.min.css';
import Table from 'react-bootstrap/Table';
import Button from 'react-bootstrap/Button';

export default function App() {
    const poto = [{
            firtName: 'Vesta',
            lastName: 'Hirthe',
            gender: 'Transexual Person',
            email: 'Larry82@hotmail.com',
            id: '1',
        },
        {
            firtName: 'Madyson',
            lastName: 'Jaskolski',
            gender: 'Cisgender',
            email: 'Kip_Ledner31@gmail.com',
            id: '2',
        },
        {
            firtName: 'Marcella',
            lastName: 'Schuster',
            gender: 'Intersex person',
            email: 'Frida_Wilkinson@gmail.com',
            id: '3',
        },
        {
            firtName: 'Kathleen',
            lastName: 'Altenwerth',
            gender: 'MTF',
            email: 'Elton90@hotmail.com',
            id: '4',
        },
        {
            firtName: 'Douglas',
            lastName: 'Rodriguez',
            gender: 'Transexual',
            email: 'Ellis_Nader@hotmail.com',
            id: '5',
        },
        {
            firtName: 'Fausto',
            lastName: 'Kulas',
            gender: 'Cisgender Woman',
            email: 'Katheryn_Weimann@yahoo.com',
            id: '6',
        },
        {
            firtName: 'Justen',
            lastName: 'Olson',
            gender: 'Trans*Male',
            email: 'Colby.Murazik63@yahoo.com',
            id: '7',
        },
        {
            firtName: 'Coby',
            lastName: 'Turner',
            gender: 'Trans*Female',
            email: 'Buck_Streich42@hotmail.com',
            id: '8',
        },
        {
            firtName: 'Darron',
            lastName: 'Willms',
            gender: 'Gender neutral',
            email: 'Marietta59@hotmail.com',
            id: '9',
        },
        {
            firtName: 'Leif',
            lastName: 'Watsica',
            gender: 'Cis',
            email: 'Ramiro.Swift@yahoo.com',
            id: '10',
        },
        {
            firtName: 'River',
            lastName: 'Okuneva',
            gender: 'Transexual Man',
            email: 'Golden.Glover79@yahoo.com',
            id: '11',
        },
        {
            firtName: 'Joesph',
            lastName: 'Crist',
            gender: 'Trans Male',
            email: 'Emil38@yahoo.com',
            id: '12',
        },
        {
            firtName: 'Alanis',
            lastName: 'Dickinson',
            gender: 'Cisgender Man',
            email: 'Hobart_Bogisich@gmail.com',
            id: '13',
        },
        {
            firtName: 'Norberto',
            lastName: 'Nolan',
            gender: 'Trans Man',
            email: 'Jameson37@hotmail.com',
            id: '14',
        },
        {
            firtName: 'Quincy',
            lastName: 'Muller',
            gender: 'Two* person',
            email: 'Jamie13@yahoo.com',
            id: '15',
        },
        {
            firtName: 'Emanuel',
            lastName: 'Ortiz',
            gender: 'Gender neutral',
            email: 'Will_Murphy@gmail.com',
            id: '16',
        },
    ];

    const Poto = poto.map((item) => {
        return ( <
            tr >
            <
            td key = { item.id } > { item.id } < /td> <
            td key = { item.id } > { item.firtName } < /td> <
            td key = { item.id } > { item.lastName } < /td> <
            td key = { item.id } > { item.gender } < /td> <
            td key = { item.id } > { item.email } < /td> < /
            tr >
        );
    });

    return ( <
        div variant = "text-center" >
        <
        Button variant = "outline-info" >
        <
        h5 > Danh Sách Sinh Viên < /h5> < /
        Button > { ' ' } <
        Table striped bordered hover >
        <
        thead >
        <
        tr >
        <
        th > ID < /th> <
        th > Firt name < /th> <
        th > Last name < /th> <
        th > Gender < /th> <
        th > Email < /th> < /
        tr > <
        /thead> <
        tbody > { Poto } < /tbody> < /
        Table > <
        /div>
    );
}