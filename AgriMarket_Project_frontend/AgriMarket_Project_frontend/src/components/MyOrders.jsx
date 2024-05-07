import axios from "axios";
import { useEffect } from "react";
import { useState } from "react";
import Moment from "react-moment";

function MyOrders() {
    const [orders, setOrders] = useState([])
    const [show, setShow] = useState(false)
    const [details, setDetails] = useState([])

    useEffect(() => {
        axios.get("http://localhost:5000/api/orders?custid=" + sessionStorage.getItem("id"))
            .then(resp => {
                console.log(resp.data)
                setOrders(resp.data.data)
            })
    }, []);

    const showDetails = (orderid) => {
        axios.get("http://localhost:5000/api/orders/" + orderid)
            .then(resp => {
                console.log(resp.data)
                setDetails(resp.data.data.details)
            })
        setShow(true)
    }

    return (
        <body style={{ 
            backgroundImage: "url('/assets/cus.jpg')", 
            backgroundPosition: "center",
            backgroundRepeat: "no-repeat",
            backgroundSize: "cover",
            height: "500px"
          }}>
        <div className="container-fluid text-white font-weight-bolder">
            <div className="row">
                <div className="col-sm-7">
                    <h4 className="p-2">My Purchased Orders</h4>
                    <table className="table table-bordered table-sm table-light table-striped">
                        <thead>
                            <tr>
                                <th>Id</th>
                                <th>Order Date</th>
                                
                                <th>Amount</th>
                                <th>Action</th>
                            </tr>
                        </thead>
                        <tbody>
                            {orders.map(x => (
                                <tr key={x.orderid}>
                                    <td>{x.orderid}</td>
                                    <td><Moment format="ddd, DD-MMM-YYYY">{x.orderDate}</Moment></td>
                                    
                                    <td>&#8377; {x.payment.amount}</td>
                                    <td><button onClick={e => showDetails(x.orderid)} className="btn btn-primary btn-sm">Show Details</button></td>
                                </tr>
                            ))}
                        </tbody>
                    </table>
                </div>
                <div className="col-sm-5">
                    {show ? <>
                        <h4 className="p-2">Order Details</h4>
                        <table className="table table-bordered table-sm table-light table-striped">
                            <thead>
                                <tr>
                                    <th>Id</th>
                                    <th>Product</th>
                                    <th>Table No</th>
                                    <th>Price</th>
                                    <th>Qty</th>
                                </tr>
                            </thead>
                            <tbody>
                                {details.map(x => (
                                    <tr>
                                        <td>{x.product.prodid}</td>
                                        <td>{x.productImgUtility && (
                                            <img
                                                style={{ width: "90%", height: "250px", marginBottom: "10px" }}
                                                src={
                                                    "data:image/jpeg;base64," + x.productImgUtility
                                                }
                                                className="img-thumbnail"
                                                alt={x.pname} // Add alt attribute for accessibility
                                            />
                                        )}
                                            {x.product.pname}<br />
                                            Category: {x.product.category.catname}<br />
                                        </td>
                                        <td>{x.selectedItem}</td>
                                        <td>{x.product.price}</td>
                                        <td>{x.qty}</td>
                                    </tr>
                                ))}
                            </tbody>
                        </table>
                    </> : ''}
                </div>
            </div>

        </div>
        </body>
    )
}
export default MyOrders;