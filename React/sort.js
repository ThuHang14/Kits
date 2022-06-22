import './App.css';
import 'bootstrap/dist/css/bootstrap.min.css';
import Table from 'react-bootstrap/Table';
import Button from 'react-bootstrap/Button';
import * as PropTypes from "prop-types";
import Protolio from "./header/protolio";


function Link(props) {
    return null;
}

Link.propTypes = {
    to: PropTypes.string,
    children: PropTypes.node
};

function App() {

    let proto = [
        {
            "firtName": "Shea",
            "lastName": "Dach",
            "gender": "T* man",
            "email": "Dahlia83@hotmail.com",
            "mark": 9.2,
            "id": "1"
        },
        {
            "firtName": "Erling",
            "lastName": "hanahan",
            "gender": "MTF",
            "email": "Thad.Haag14@hotmail.com",
            "mark": 8.6,
            "id": "2"
        },
        {
            "firtName": "Luciano",
            "lastName": "Harber",
            "gender": "Transexual Woman",
            "email": "Mckayla_Ferry@hotmail.com",
            "mark": 3.3,
            "id": "3"
        },
        {
            "firtName": "Elbert",
            "lastName": "Gottlieb",
            "gender": "Trans Female",
            "email": "Blanche44@yahoo.com",
            "mark": 7.1,
            "id": "4"
        },
        {
            "firtName": "Monty",
            "lastName": "Boyle",
            "gender": "T* woman",
            "email": "Annetta54@hotmail.com",
            "mark": 5.5,
            "id": "5"
        },
        {
            "firtName": "Israel",
            "lastName": "hCollier",
            "gender": "Neutrois",
            "email": "Afton30@gmail.com",
            "mark": 2.5,
            "id": "6"
        },
        {
            "firtName": "Matilde",
            "lastName": "Pacocha",
            "gender": "Female to male transsexual man",
            "email": "Jessie_Satterfield@hotmail.com",
            "mark": 1.5,
            "id": "7"
        },
        {
            "firtName": "Jordon",
            "lastName": "Murazik",
            "gender": "Bigender",
            "email": "Tyrel31@yahoo.com",
            "mark": 6.2,
            "id": "8"
        },
        {
            "firtName": "Cordelia",
            "lastName": "Romaguera",
            "gender": "Other",
            "email": "Jasper9@yahoo.com",
            "mark": 6.7,
            "id": "9"
        },
        {
            "firtName": "Cordelia",
            "lastName": "Eohr",
            "gender": "HCisgender",
            "email": "Zoey_Kris77@gmail.com",
            "mark": 3.5,
            "id": "10"
        },
        {
            "firtName": "Cordelia",
            "lastName": "Aills",
            "gender": "Asexual",
            "email": "Declan_Osinski51@gmail.com",
            "mark": 10,
            "id": "11"
        },
        {
            "firtName": "Kattie",
            "lastName": "Luettgen",
            "gender": "Androgynes",
            "email": "Jimmy78@yahoo.com",
            "mark": 6.6,
            "id": "12"
        }
    ]
    let arrProto = proto.sort((o1, o2) => o2.mark - o1.mark)


    let proto_list = []

    arrProto.forEach(p => {

        // let mark
        // if(p.mark<5){
        //     mark = <Button variant="danger">{p.mark}</Button>
        // }
        // else if(p.mark>=8){
        //     mark = <Button variant="success">{p.mark}</Button>
        // }
        // else {
        //     mark = <Button variant="primary">{p.mark}</Button>
        // }

        proto_list.push(
            <tr>
                <td key={p.id}> {p.id} </td>
                <td> {p.firtName} </td>
                <td> {p.lastName} </td>
                <td> {p.gender} </td>
                <td> {p.email} </td>
                <td>
                    {p.mark < 5 && (
                        <Button variant="danger">{p.mark}</Button>)}

                    {p.mark > 8 && (
                        <Button variant="success">{p.mark}</Button>)}

                    {p.mark > 5 && p.mark < 8 && (
                        <Button variant="primary">{p.mark}</Button>)}

                </td>
                <td>
                    <Button variant="outline-danger" onClick={delete_proto(p.id)}>Delete</Button>
                </td>
                <td>
                    <Button variant="outline-warning" onClick={update_proto}>Update</Button>
                </td>
            </tr>
        )
    })


    function filter_proto() {
        const filter = proto.filter(p => p.lastName.toLowerCase().indexOf('h') === 0)
        arrProto = filter;
        console.log(arrProto)

    }

    function sort_proto() {

        let sortFirt = proto.sort(function (a,b){
            if(a.firtName.localeCompare(b.firtName) == 0) return a.lastName.localeCompare(b.lastName)
            else return a.firtName.localeCompare(b.firtName);
        })

        console.log(sortFirt)


    }

    function delete_proto(id) {
        const delete_proto = proto.filter(s => s.id == id)
        // console.log(delete_proto)
    }

    function update_proto() {

    }

    return (
        <div>

            <h3>Danh Sach Sinh Vien </h3>
            <Table striped bordered hover>
                <thead>
                <tr>
                    <th>id</th>
                    <th>First Name</th>
                    <th>Last Name</th>
                    <th>Gender</th>
                    <th>Email</th>
                    <th>Mark</th>
                </tr>
                </thead>
                <tbody>
                {proto_list}
                </tbody>
            </Table>

            <Button onClick={filter_proto} variant="outline-dark"> H </Button>
            <Button onClick={sort_proto} variant="outline-dark">sort</Button>


            <Protolio />
        </div>

    );

}

export default App;
