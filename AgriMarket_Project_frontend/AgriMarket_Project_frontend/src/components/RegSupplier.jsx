import axios from "axios"
import { useEffect, useState } from "react"
import { useHistory } from "react-router-dom"
import uservalidation from "../validations/uservalidation"
//import zIndex from "@material-ui/core/styles/zIndex"

function RegSupplier() {
    const history = useHistory()
    const [submitted, setSubmitted] = useState(false)
    const [selectedPhoto, setSelectedPhoto] = useState(null)
    const [user, setUser] = useState({
        "name": "",
        "city": "",
        "userid": "",
        "pwd": "",
        "cpwd": "",
        "phone": ""
    })
    const [errors, setErrors] = useState({})

    const handleInput = (e) => {
        setUser({ ...user, [e.target.name]: e.target.value })
    }

    const handleFileInput = e => {
        setSelectedPhoto(e.target.files[0])
    }

    const handleSubmit = (e) => {
        e.preventDefault()
        setErrors(uservalidation(user))
        setSubmitted(true)
    }

    useEffect(() => {
        console.log(errors)
        if (Object.keys(errors).length === 0 && submitted) {
            console.log(user)
            const formData = new FormData()
            formData.append("photo", selectedPhoto)
            formData.append("name", user.name)
            formData.append("city", user.city)
            formData.append("pwd", user.pwd)
            formData.append("phone", user.phone)
            formData.append("userid", user.userid)
            axios.post("http://localhost:5000/api/sellers", formData)
                .then(resp => {
                    console.log(resp)
                    alert("Seller registered successfully")
                    history.push("/slogin")
                })
                .catch(error => console.log("Error", error))
        }
    }, [errors])
    return (
        <body style={{
            backgroundImage: "url('/assets/page3.jpg')",
            backgroundSize: "cover",
            backgroundRepeat: "no-repeat",
            backgroundPosition: "center",
            height: "1000px",
          // filter:"blur(10px)",
            zIndex:"-1"
          }}>
        <div className="container" >
            <div className="card shadow bg-transparent mt-3 text-black font-weight-bold">
                <div className="card-body">
                    <div className="row">
                        <div className="col-sm-9 mx-auto" style={{ width: "50%",marginTop:"30px"}}>
                            <h4 className="text-center p-2 text-dark" style={{fontSize:"40px"}}>
                                Seller Registration 
                            </h4>
                            <br/>
                            <form onSubmit={handleSubmit}>
                                <div className="form-group form-row" >
                                    <label className="col-sm-4 form-control-label  " style={{fontSize:"25px"}}>Supplier Name</label>
                                    <div className="col-sm-8">
                                        <input type="text" name="name" value={user.name} onChange={handleInput} className="form-control" />
                                        {errors.name && <small className="text-danger float-right">{errors.name}</small>}
                                    </div>
                                </div>
                                <div className="form-group form-row">
                                    <label className="col-sm-4 form-control-label" style={{fontSize:"25px"}}>City</label>
                                    <div className="col-sm-8">
                                        <input type="text" name="city" value={user.city} onChange={handleInput} className="form-control" />
                                        {errors.city && <small className="text-danger float-right">{errors.city}</small>}
                                    </div>

                                </div>
                                <div className="form-group form-row">
                                    <label className="col-sm-4 form-control-label" style={{fontSize:"25px"}}>Email_Id</label>
                                    <div className="col-sm-8">
                                        <input type="text" name="userid" value={user.userid} onChange={handleInput} className="form-control" />
                                        {errors.userid && <small className="text-danger float-right">{errors.userid}</small>}
                                    </div>

                                </div>
                                <div className="form-group form-row">
                                    <label className="col-sm-4 form-control-label" style={{fontSize:"25px"}}>Phone</label>
                                    <div className="col-sm-8">
                                        <input type="text" maxLength="10" name="phone" value={user.phone} onChange={handleInput} className="form-control" />
                                        {errors.phone && <small className="text-danger float-right">{errors.phone}</small>}
                                    </div>

                                </div>
                                <div className="form-group form-row">
                                    <label className="col-sm-4 form-control-label" style={{fontSize:"25px"}}>Certificate</label>
                                    <div className="col-sm-8">
                                        <input type="file" accept=".jpg,.png" name="photo" required onChange={handleFileInput} className="form-control" />
                                    </div>

                                </div>
                                <div className="form-group form-row">
                                    <label className="col-sm-4 form-control-label" style={{fontSize:"25px"}}>Password</label>
                                    <div className="col-sm-8">
                                        <input type="password" name="pwd" value={user.pwd} onChange={handleInput} className="form-control" />
                                        {errors.pwd && <small className="text-danger float-right">{errors.pwd}</small>}
                                    </div>
                                </div>
                                <div className="form-group form-row">
                                    <label className="col-sm-4 form-control-label" style={{fontSize:"25px"}}>Confirm Password</label>
                                    <div className="col-sm-8">
                                        <input type="password" name="cpwd" value={user.cpwd} onChange={handleInput} className="form-control" />
                                        {errors.cpwd && <small className="text-danger float-right">{errors.cpwd}</small>}
                                    </div>
                                </div>
                                <button className="btn btn-primary float-right">Register Now</button>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        </body>
    )
}

export default RegSupplier;