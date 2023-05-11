import React, {useState, useEffect} from 'react';
import './Oplaty.css';

function Oplaty()
{
    const [oplaty, setOplaty] = useState([]);

    let url='http://localhost:8080/take'
    useEffect(() =>
    {
        fetchOplatyAll();
    }, []);

    function fetchOplatyAll()
    {
        fetch(url+'/Akademiki/Oplata')
            .then(response =>response.json())
            .then(data => setOplaty(data))
            .catch(error => console.error(error));
    }

    return (
        <div>
            <h1>OPŁATY</h1>
            <table>
                <thead>
                <tr>
                    <th>ID</th>
                    <th>DATA</th>
                    <th>KWOTA</th>
                </tr>
                </thead>
                <tbody>
                {oplaty.map(oplata => (
                    <tr key={oplata.id}> {}
                        <td>{oplata.id}</td>
                        <td>{oplata.data}</td>
                        <td>{oplata.kwota}</td>
                    </tr>
                ))}
                </tbody>
            </table>
        </div>
    );
}

export default Oplaty;