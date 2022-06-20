import './App.css';


function App() {

    const name = ['a', 'b', 'c', 'd', 'e'];
    const numbers = [1, 2, 3, 4, 5];

    const poto = [
        {
            "firtName": "Vesta",
            "lastName": "Hirthe",
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

    const namePoto = poto.map((poto) => {
        return (<td key={poto.id}>{poto.firtName}</td>)
    });

    const agePoto = poto.map((poto) => {
        return (<td key={poto.id}>{poto.lastName}</td>)
    });

    const mailPoto = poto.map((poto) => {
        return (<td key={poto.id}>{poto.email}</td>)
    });

    const idPoto = poto.map((poto) => {
        return (<td key={poto.id}>{poto.id}</td>)
    });

    const genderPoto = poto.map((poto) => {
        return (<td key={poto.id}>{poto.gender}</td>)
    });

    const Poto = poto.map((item) => {
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

    return (
        <div>
            <ol>
                {name.map((item) => {
                    return (
                        <li>{item}</li>
                    )
                })}
            </ol>


            {numbers.map((number) => {
                    return (
                        <li key={number.toString()}>
                            {number}
                        </li>)
                }
            )}


            {/*<table>*/}
            {/*    <tr>*/}
            {/*        {idPoto}*/}
            {/*    </tr>*/}
            {/*    <tr>*/}
            {/*        {namePoto}*/}
            {/*    </tr>*/}
            {/*    <tr>*/}
            {/*        {genderPoto}*/}
            {/*    </tr>*/}
            {/*    <tr>*/}
            {/*        {agePoto}*/}
            {/*    </tr>*/}

            {/*    <tr>*/}
            {/*        {mailPoto}*/}
            {/*    </tr>*/}

            {/*</table>*/}

            <h3>Danh Sach Sinh Vien </h3>
            <table className={'table-bordered'}>
                {Poto}
            </table>


        </div>

    );
}

export default App;
