import React, {useEffect, useState} from "react";
import "./Oplaty.css";

export function GetAll()
{
    const [oplaty, setOplaty] = useState([]);
    useEffect(() =>
    {
        fetchOplatyAll();
    }, []);

    function fetchOplatyAll()
    {
        fetch('http://localhost:8080/take/Akademiki/Oplata')
            .then(response =>response.json())
            .then(data => setOplaty(data))
            .catch(error => console.error(error));
    }

    return (
        <>
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
            </>
    )
}