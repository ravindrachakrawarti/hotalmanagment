import axios from "axios";
import jsPDF from "jspdf";
import { useEffect, useState } from "react";
import Moment from "react-moment";
import 'jspdf-autotable';
import images from "../images/Logo.jpg"

import QRCode from 'qrcode.react';

function Orders(){
    const [orders,setOrders]=useState([])
    const [show,setShow]=useState(false)
    const [details,setDetails]=useState([])
    

   

    useEffect(()=>{
        axios.get("http://localhost:5000/api/orders")
        .then(resp=>{
            console.log(resp.data)
            setOrders(resp.data.data)
           
        })
    },[]);

    const showDetails=(orderid)=>{
        axios.get("http://localhost:5000/api/orders/"+orderid)
        .then(resp=>{
            console.log(resp.data)
            setDetails(resp.data.data.details)
          
 
           
        })
        setShow(true)

       
    }

   
const Payment= async (itemId)=>{

           var selectedItem = orders.find((x) => x.orderid === itemId);

                     var amount=selectedItem.payment.amount;
                     var discount=selectedItem.payment.amount*10/100;
                     var  gst=selectedItem.payment.amount*15/100;
                    var totalAmount=amount+gst-discount;

                     console.log("abc"+totalAmount)
                                                                

                     const createOrder = async () => {

  
                        console.log("payment started...");
                      
                        
                       // let amount = document.getElementById('ab').innerHTML;
                      
                        console.log("abc"+totalAmount);
                        return await fetch('http://localhost:5000/payment/'+totalAmount*100, {
                        mode: 'no-cors',
                        method: 'GET',
                    });
                    
                    
                    
                      }

                      const order = await createOrder();

  const options = {
  
    key: "rzp_test_4xOJiuPbQ8GlQA",
    amount: totalAmount*100, 
    currency: "INR",
   
    
    description: "Test Transaction",
    image: images,
   
    name: selectedItem.customer.name,
    order_id: order, 
    handler: function (response) {
      alert(response.razorpay_payment_id);
      alert(response.razorpay_order_id);
      alert(response.razorpay_signature);
    },
    prefill: {
      name: selectedItem.customer.name,
      email: 'email',
      contact: 'contact',
    },
    notes: {
      address: "ABC, Delhi",
    },
    theme: {
      color: "#3399cc",
    },
  };
  const rzp1 = new window.Razorpay(options);

  rzp1.on("payment.failed", function (response) {
    alert(response.error.code);
    alert(response.error.description);
    alert(response.error.source);
    alert(response.error.step);
    alert(response.error.reason);
    alert(response.error.metadata.order_id);
    alert(response.error.metadata.payment_id);
  });

  rzp1.open();

                     
                     
};




    const showBill = (itemId) => {

        var selectedItem = orders.find((x) => x.orderid === itemId);

                     var amount=selectedItem.payment.amount;
                     var discount=selectedItem.payment.amount*10/100;
                     var  gst=selectedItem.payment.amount*15/100;
                     var  totalAmount=amount+gst-discount;
                   
                      



        if (!selectedItem) {
          console.error('Selected item not found');
          return;
        }


        const doc = new jsPDF();

        doc.addImage('/Logo.jpg', 'JPEG', 12, 0, 30, 30);



        let yPos = 10;

        doc.addFileToVFS('path/to/font.ttf', 'customfont');
        doc.addFont('customfont', 'Custom', 'normal');
        doc.setFont('Custom');
    
        doc.setFontSize(18);
        doc.text("Eazy To Order Restautent", 70, yPos);
        yPos += 10;
    doc.text("Restaurant Receipt", 75, yPos);
    yPos += 10;
    
    // Add receipt details
   
      doc.setFontSize(12);
      doc.text(`Project ID:       ${selectedItem.orderid}`, 70, yPos);
      doc.text(`Customer Name:    ${selectedItem.customer.name}`, 70, yPos + 8);
      doc.text(`ToDay Date:       ${selectedItem.orderDate}`, 70, yPos + 16);

      details.forEach((item1,index) => { 

        const { product} =item1;
        
        doc.setFontSize(12);

          doc.text(`Product Name:   ${product.pname}`, 70, yPos+24);
          doc.text(`Product Name:   ${item1.selectedItem}`, 70, yPos+32);
          doc.text(`Category :      ${product.category.catname}`, 70, yPos +40);
          doc.text(`Quantity:       ${item1.qty}`, 70, yPos+48);
          doc.text(`Per peace :     ${product.price}`, 70, yPos +56);
          doc.text(`Amount :        ${amount}`, 70, yPos + 64);
          doc.text(`DisCount :      ${discount}`, 70, yPos + 72);
          doc.text(`GST :           ${gst}`, 70, yPos + 80);
          doc.text(`Total Amount :  ${totalAmount}`, 70, yPos + 88);
          yPos += 96; 
          
          });
     // yPos += 32; 
      // Increase yPos for the next ite
   

   
  

    // Add footer
    doc.line(20, yPos, 180, yPos); // Horizontal line
    yPos += 10;
    doc.setFontSize(10);
    doc.text("Thank you for dining with us!", 75, yPos);

    doc.save('restaurant_receipt.pdf');


    
  };

 


  var jsonData = {
    "product_id": orders.orderid,
    "product_name": "Burger",
    "price": 345
   
  };
 
  //console.log(`item = ${selectedItem.totalAmount}`)

  
    // Convert JSON data to string
    const jsonString = JSON.stringify(jsonData);

   
    return (
      
        <body style={{ 
            backgroundImage: "url('/assets/product.jpg')", 
            backgroundPosition: "center",
            backgroundRepeat: "no-repeat",
            backgroundSize: "cover",
            height: "500px"
          }}>

        <div className="content">

        <div className="container-fluid ">
            <div className="row ">
                <div className="col-sm-7">
                    <br/>
                <h4 className="p-2 text-center text-black font-weight-bold" style={{fontSize:"40px"}}>Recent Orders</h4>
                <table className="table table-bordered table-sm table-light table-hover table-striped">
                    <thead>
                        <tr>
                            <th>Id</th>
                            <th>Order Date</th>
                           
                            <th>Amount</th>
                            <th>Customer</th>
                            <th>Action</th>                       
                        </tr>
                    </thead>
                    <tbody>
                        {orders.map(x=>(
                            <tr key={x.orderid}>
                                <td>{x.orderid}</td>
                                <td><Moment format="ddd, DD-MMM-YYYY">{x.orderDate}</Moment></td>
                               
                                <td>&#8377; {x.payment.amount}</td>
                                <td>{x.customer.name}</td>
                                <td><button onClick={e=>showDetails(x.orderid)} className="btn btn-primary btn-sm">Show Details</button></td>
                                <td><button onClick={()=>showBill(x.orderid)} className="btn btn-primary btn-sm">Billing Print</button></td>
                                <td><button onClick={()=>Payment(x.orderid)} className="btn btn-primary btn-sm">Payment</button></td>
                                <td>  <button
                      onClick={() => deletUsers(x.orderid)}
                      className="btn btn-danger btn-sm"
                    >
                      Delete
                    </button></td>
                           
                            </tr>
                        ))}
                    </tbody>
                </table>  
                </div>
                <div className="col-sm-5">
                    {show ? <>
                    <h4 className="p-2">Order Details</h4>
                    <table className="table table-bordered table-light table-hover table-striped table-sm">
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
                                <tr key={x.product.prodid}>
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
                                    {x.product.pname}<br/>
                                    {x.product.category.catname}
                                    </td>
                                    <td>{x.selectedItem}</td>
                                    
                                    <td>{x.product.price}</td>
                                    <td>{x.qty}</td>
                                </tr>
                            ))}
                               <div className="text-center">
                              {/* Render the QR code */}
                              <QRCode value={jsonString} />
                              {/* Optionally, display the JSON string */}
      
                           </div>
                        </tbody>
                    </table>
                    </> : ''}
                </div>
            </div>                
            </div>           
        </div> 
        
       
        </body>                  
    )
}

export default Orders;