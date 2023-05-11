import {Link} from "react-router-dom";

export function Navbar()
{
    return (
        <nav>
            <ul>
                <li>
                    <Link to="/">Główna</Link>
                </li>
                <li>
                    <Link to="/getAll">get All</Link>
                </li>
                <li>
                    <Link to="/getId">get Id</Link>
                </li>
                <li>
                    <Link to="/post">post</Link>
                </li>
                <li>
                    <Link to="/put">put</Link>
                </li>
                <li>
                    <Link to="/delete">delete</Link>
                </li>
            </ul>
        </nav>
    )
}