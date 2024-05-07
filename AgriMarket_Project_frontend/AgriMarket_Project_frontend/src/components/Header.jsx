import { useSelector } from "react-redux";

function Header(){
    const state=useSelector((state)=>state);
    console.log("Header ",state.loggedin.Username)
    return (
        <div className="jumbotron p-3 mb-0 rounded-0 bg-muted bg-light text-black" style={{backgroundImage:"url('/assets/bgh.jpg')"}} >
            <img src={'/logo.jpg'} style={{width:"150px",height:"70px"}} className="float-left"/>
            {state.loggedin.IsLoggedIn ?
            <>
            <h5 className="float-right">Welcome ! {state.loggedin.Username}</h5> </>:
            ''}
            <h1 className="text-center" style={{ fontweight:"bolder",fontfamily: "cursive" }}>𝐸𝒜𝒮𝒴 𝒯𝒪 𝒪𝑅𝒟𝐸𝑅 𝑅𝐸𝒮𝒯𝒜𝒰𝑅𝒜𝒩𝒯</h1>
            <div className="clearfix"></div>
        </div>
    )
}

export default Header;