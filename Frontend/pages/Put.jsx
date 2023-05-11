import React, {useState} from "react";

export function Put()
{
    const [data, setData] = useState("");
    const [formData, setFormData] = useState({
        id:"",
        kwota: "",
        data: ""
    })

    function handleSubmit(e)
    {
        e.preventDefault()

        console.log(formData)
        if ((formData.id==="")||(formData.kwota === "") || (formData.data === ""))
        {
            setData("--- WYPEŁNIJ CAŁY FORMULARZ ---")
        }
        else
        {
            fetch('http://localhost:8080/take/Akademiki/Oplata',
                {
                    method: 'PUT',
                    headers:{'Content-Type':'application/json'},
                    body:JSON.stringify(formData)
                })
                .then(() =>
                {
                    setData("--- ZMIENIONO OPŁATE ---")
                })
        }
    }

    function handleChange(e)
    {
        if(e.target.name==="id")
        {
            const id = parseInt(e.target.value)
            if (!isNaN(id))
            {
                setFormData({...formData, [e.target.name]: e.target.value})
            }
            else
            {
                setFormData({...formData, [e.target.name]: ""})
            }
        }
        else if (e.target.name === "data")
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
                    <h1>PODAJ ID OPŁATY DO MODYFIKACJI</h1>
                    <input className="wpisywarka" type="text" name="id" onChange={handleChange}/>
                    <h1>NOWA DATA OPŁATY</h1>
                    <input class="wpisywarka" type="text" name="data" onChange={handleChange}/>
                    <h1>NOWA KWOTA OPŁATY</h1>
                    <input className="wpisywarka" type="text" name="kwota" onChange={handleChange}/>
                </label>
                <br/>
                <button class="klikaczka" type="submit">ZMIEŃ</button>
            </form>
            <h2> {data}</h2>
        </div>
    )
}