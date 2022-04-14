import{useState}from "react";


import FarmerProduct from "./FarmerProduct";
import FarmerOrder from "./FarmerOrder";
import FarmerProfile from "./FarmerProfile";
import FarmerAddedProduct from "./FarmerAddedProduct";

function Welcome()
{

const [components, setComponents] = useState(<FarmerProduct/>); 
     
    var handleOrder = ()=>{
    //   window.location = `/farmer-order/${username}`;
    setComponents(<FarmerOrder/>)
    }
    var handleProduct = ()=>{
        // window.location = `/farmer-product`;
        setComponents(<FarmerProduct/>)
      }

      function handleMyProduct(){
        setComponents(<FarmerAddedProduct/>)
      }
  

      function handleProfile(){
        setComponents(<FarmerProfile/>)
      }
    

      

    return(
        <>
            <div className="container-fluid" >
                <div className="row " style={{backgroundColor:"grey"}}>

                <div class=" col-3" style={{width:"20vw" ,backgroundColor:"rgb(44, 56, 61)"}}>
               
                
                    <button class="btn btn-outline-info me-2" type="button" style={{width:"30vh" , marginTop:"10vh"}} onClick={handleProduct} >Add Products</button>
                    <button class="btn btn-outline-info me-2" type="button" style={{width:"30vh" ,marginTop:"10vh"}} onClick={handleOrder}>See Orders</button>
                    <button class="btn btn-outline-info me-2" type="button" style={{width:"30vh" , marginTop:"10vh"}} onClick={handleMyProduct} >My Product</button>
                    <button class="btn btn-outline-info me-2" type="button" style={{width:"30vh" , marginTop:"10vh"}} onClick={handleProfile} >Update Profile</button>
                   
                </div>
                <div className="col-9">
                    {components}
                </div>

                </div>
              
            </div>
            
        </>
    );
}

export default Welcome;