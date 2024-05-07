import axios from "axios";
import { useEffect, useState } from "react";
import { useDispatch } from "react-redux";
import { useHistory } from "react-router-dom";
import loginvalidation from "../validations/loginvalidation"

function SellerLogin() {
    const dispatch = useDispatch()
    const [user, setUser] = useState({
        "userid": "",
        "pwd": ""
    })
    const [errors, setErrors] = useState({})
    const [submitted, setSubmitted] = useState(false)
    const history = useHistory()

    const handleInput = (e) => {
        setUser({ ...user, [e.target.name]: e.target.value })
    }

    const handleSubmit = e => {
        e.preventDefault()
        setErrors(loginvalidation(user))
        setSubmitted(true)
    }

    useEffect(() => {
        console.log(errors)
        if (Object.keys(errors).length === 0 && submitted) {
            console.log(user)
            axios.post("http://localhost:5000/api/sellers/validate", user)
                .then(resp => {
                    console.log(resp.data)
                    if (resp.data.status === 'error') {
                        alert(resp.data.error)
                    } else {
                        let result = resp.data.data;
                        console.log(resp.data.data)
                        sessionStorage.setItem("userid", result.userid)
                        sessionStorage.setItem("uname", result.name)
                        sessionStorage.setItem("role", "seller")
                        sessionStorage.setItem("id", result.id)
                        dispatch({ type: 'IsLoggedIn' })
                        history.push("/sprofile")
                    }
                })
                .catch(error => {
                    console.log("Error", error);
                })
        }
    }, [errors])


    return (
        <body style={{ 
            backgroundImage: "url('/assets/seller.jpg')", 
            backgroundPosition: "center",
            backgroundRepeat: "no-repeat",
            backgroundSize: "cover",
            height: "500px"
          }}>
            <br/>
        <div className="container" style={{ width: "50%" }}>
            <div className="card shadow bg-transparent mt-3 text-black font-weight-bold">
                <div className="card-body">
                    <div className="row">
                        <div className="col-sm-8 mx-auto" >
                            <h4 className="text-center p-2" style={{fontSize:"40px"}}>
                                Add Item Login 
                            </h4>
                            <form onSubmit={handleSubmit}>
                                <div className="form-group form-row">
                                    <label className="col-sm-4 form-control-label" style={{fontSize:"25px"}}>Email_Id</label>
                                    <div className="col-sm-8">
                                        <input type="text" name="userid" value={user.userid} onChange={handleInput} className="form-control" />
                                        {errors.userid && <small className="text-danger float-right">{errors.userid}</small>}
                                    </div>

                                </div>
                                <div className="form-group form-row">
                                    <label className="col-sm-4 form-control-label" style={{fontSize:"25px"}}>Password</label>
                                    <div className="col-sm-8">
                                        <input type="password" name="pwd" value={user.pwd} onChange={handleInput} className="form-control" />
                                        {errors.pwd && <small className="text-danger float-right">{errors.pwd}</small>}
                                    </div>
                                </div>
                                <button className="btn btn-primary float-right" style={{fontSize:"25px"}}>Login Now</button>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        </body>
    );
}

export default SellerLogin;