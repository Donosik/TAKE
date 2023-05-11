import React, {useState} from "react";
import "./GetId.css";

export function GetId()
{
    const [data, setData] = useState([]);
    const [formData, setFormData] = useState(-1)
    const [error, setError] = useState("")

    function handleSubmit(e)
    {
        e.preventDefault()
        if (!isNaN(formData))
        {
            fetch('http://localhost:8080/take/Akademiki/Oplata/' + formData)
                .then(response =>
                {
                    if (response.ok)
                        return response.json()
                    else
                        throw new Error("404")
                })
                .then(response =>
                {
                    setData(response)
                    setError("")
                })
                .catch(error =>
                {
                    setData([])
                    setError("--- NIE ZNALEZIONO ---")
                })
        }
    }

    function handleChange(e)
    {
        const id = parseInt(e.target.value)
        setFormData(id);
    }

    return (
        <div>
            <form onSubmit={handleSubmit}>
                <label>
                    <h1> PODAJ ID OPŁATY</h1>
                    <input class="wpisywarka" type="text" name="id" onChange={handleChange}/>
                </label>
                <br/>
                <button class="klikaczka" type="submit">POBIERZ</button>
            </form>
            <h2>{error}</h2>
            <table>
                <thead>
                <tr>
                    <th>ID</th>
                    <th>DATA</th>
                    <th>KWOTA</th>
                </tr>
                </thead>
                <tbody>
                <tr key={data.id}>
                    <td>{data.id}</td>
                    <td>{data.data}</td>
                    <td>{data.kwota}</td>
                </tr>
                </tbody>
            </table>

        </div>
    )
}