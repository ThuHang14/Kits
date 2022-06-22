import './App.css';
import Table from 'react-bootstrap/Table';


function App() {

    const name = ['a', 'b', 'c', 'd', 'e'];
    const numbers = [1, 2, 3, 4, 5];

    var poto = [
        {
            "firtName": "Vesta",
            "lastName": "Hirthe",
            "gender": "Transexual Person",
            "email": "Larry82@hotmail.com",
            "id": "1"
        }, {
            "firtName": "Vesta",
            "lastName": "hirthe",
            "gender": "Transexual Person",
            "email": "Larry82@hotmail.com",
            "id": "1"
        },
        {
            "firtName": "Madyson",
            "lastName": "Jaskolski",
            "gender": "Cisgender",
            "email": "Kip_Ledner31@gmail.com",
            "id": "2"
        },
        {
            "firtName": "Marcella",
            "lastName": "Schuster",
            "gender": "Intersex person",
            "email": "Frida_Wilkinson@gmail.com",
            "id": "3"
        }
    ]


    let Poto = poto.map((item) => {
        return (
            <tr>
                <td key={item.id}>{item.id}</td>
                <td key={item.id}>{item.firtName}</td>
                <td key={item.id}>{item.lastName}</td>
                <td key={item.id}>{item.gender}</td>
                <td key={item.id}>{item.email}</td>
            </tr>
        )
    })
    var poto_list = []

    var fil = []
    function filter_fc() {
        poto_list = []
        const filter = poto.filter( p => p.lastName.toLowerCase().indexOf('h') == 0)

        console.log(filter)
        // filter.forEach(p => {
        //     fil.push(
        //         <tr>
        //             <td> {p.firtName} </td>
        //             <td> {p.email} </td>
        //             <td> {p.gender} </td>
        //             <td> {p.lastName} </td>
        //         </tr>
        //     )
        // })
        //
        // let fil_div = document.querySelector('.div_fil')
        // fil_div.innerHTML(
        //     '123'
        // )

    }

    for (var i = 0;i <poto.length;i++) {
        poto_list.push(
            <tr>
                <td> {poto[i].id} </td>
                <td> {poto[i].firtName} </td>
                <td> {poto[i].lastName} </td>
                <td> {poto[i].email} </td>
                <td> {poto[i].gender} </td>
            </tr>
        )
    }

    const poto_list_2 = []


    poto.forEach(p => {
        poto_list_2.push(
            <tr>
                <td> {p.id} </td>
                <td> {p.firtName} </td>
            </tr>
        )
    })


    return (
        <div>
            <h3>OL</h3>
            <ol>
                {name.map((item) => {
                    return (
                        <li>{item}</li>
                    )
                })}
            </ol>

            <h3>LI</h3>
            {numbers.map((number) => {
                    return (
                        <li key={number.toString()}>
                            {number}
                        </li>)
                }
            )}

            <h3>Danh Sach Sinh Vien 1 </h3>
            <Table striped bordered hover>
                <tbody>
                {poto_list_2}
                </tbody>
            </Table>

            <h3>Danh Sach Sinh Vien 2 </h3>
            <table>
                {poto_list}
            </table>

            <h3>Danh Sach Sinh Vien 3 </h3>
            <table>
                <tbody>
                {Poto}
                </tbody>
            </table>

            <div className="div_fil" ></div>
            <button onClick={filter_fc}>last name = H</button>


        </div>

    );
}

export default App;
