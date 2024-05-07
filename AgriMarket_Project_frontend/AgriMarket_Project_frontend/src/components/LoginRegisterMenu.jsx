import { Fragment } from "react";
import { Link } from "react-router-dom";

function LoginRegisterMenu(){
    return(
        <ul className="navbar-nav ml-auto text-black font-weight-bold">
            <li className="nav-item dropdown">
                <a className="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                Login
                </a>
                <div className="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
                <Link className="dropdown-item" to="/alogin">Admin</Link>
                <Link className="dropdown-item" to="/slogin">Add Item</Link>                        
                <Link className="dropdown-item" to="/clogin">Waiter</Link>                        
                </div>
            </li>
            <li className="nav-item dropdown">
                <a className="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                Register
                </a>
                <div className="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
                <Link className="dropdown-item" to="/regsupplier">Add Item</Link>
                <Link className="dropdown-item" to="/register">Waiter</Link>                        
                </div>
            </li>
        </ul>
    )
}

export default LoginRegisterMenu;