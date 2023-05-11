import React, {useState} from "react";

export function Post()
{
    const [data, setData] = useState("");
    const [formData, setFormData] = useState({
        kwota: "",
        data: ""
    })

    function handleSubmit(e)
    {
        e.preventDefault()

        console.log(formData)
        if ((formData.kwota === "") || (formData.data === ""))
        {
            setData("--- WYPEŁNIJ CAŁY FORMULARZ ---")
        }
        else
        {
            fetch('http://localhost:8080/take/Akademiki/Oplata',
                {
                    method: 'POST',
                    headers:{'Content-Type':'application/json'},
                    body:JSON.stringify(formData)
                })
                .then(() =>
                {
                    setData("--- DODANO OPŁATE ---")
                })
        }
    }

    function handleChange(e)
    {
        if (e.target.name === "data")
        {
            setFormData({...formData, [e.target.name]: e.target.value})
        }
        else if (e.target.name === "kwota")
        {
            const kwota = parseInt(e.target.value)
            if (!isNaN(kwota))
            {
                setFormData({...formData, [e.target.name]: e.target.value})
            }
            else
            {
                setFormData({...formData, [e.target.name]: ""})
            }
        }
    }

    return (
        <div>
            <form onSubmit={handleSubmit}>
                <label>
                    <h1>PODAJ DATE OPŁATY</h1>
                    <input class="wpisywarka" type="text" name="data" onChange={handleChange}/>
                    <h1>PODAJ KWOTE OPŁATY</h1>
                    <input className="wpisywarka" type="text" name="kwota" onChange={handleChange}/>
                </label>
                <br/>
                <button class="klikaczka" type="submit">DODAJ</button>
            </form>
            <h2> {data}</h2>
        </div>
    )
}