import React, {useState} from "react";
import "./GetId.css";

export function Delete()
{
    const [data, setData] = useState("");
    const [formData, setFormData] = useState(-1)

    function handleSubmit(e)
    {
        e.preventDefault()
        if (!isNaN(formData))
        {
            console.log(formData)
            fetch('http://localhost:8080/take/Akademiki/Oplata/' + formData,
                {
                    method: 'DELETE'
                })
                .then(response =>
                {
                    if(response.ok)
                        setData("--- USUNIĘTO ---")
                    else
                        setData("--- NIE ZNALEZIONO ---")
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
                    <h1>PODAJ ID OPŁATY</h1>
                    <input class="wpisywarka" type="text" name="id" onChange={handleChange}/>
                </label>
                <br/>
                <button class="klikaczka" type="submit">USUŃ</button>
            </form>
           <h2> {data}</h2>
        </div>
    )
}