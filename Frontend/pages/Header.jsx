import {NavLink} from "react-router-dom";
import "./Header.css";

export function Header()
{
    return (
        <header>
            <div class="akademiki">AKADEMIKI</div>
            <div>
                <NavLink to="/">STRONA GŁÓWNA</NavLink>
                <NavLink to="/getId">POBIERZ OPŁATE</NavLink>
                <NavLink to="/getAll">POBIERZ WSZYSTKIE OPŁATY</NavLink>
                <NavLink to="/post">DODAJ OPŁATĘ</NavLink>
                <NavLink to="/put">ZMIEŃ OPŁATE</NavLink>
                <NavLink to="/delete">USUŃ OPŁATE</NavLink>
            </div>
        </header>
    )
}