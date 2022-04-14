
import BuyersList from "./BuyersList";
import FarmersList from "./FarmersList";
import {useState} from "react";
import TotalProducts from "./TotalProducts";
import TotalOrders from "./TotalOrders";

function AdminWelcome()
{
    const [components, setComponents] = useState(<FarmersList/>); 

    function handleFarmerClick(){
        setComponents(<FarmersList/>);
    }
    function handleBuyerClick(){
        setComponents(<BuyersList/>);
    }
    function handleProductClick(){
        setComponents(<TotalProducts/>);
    }
    function handleOrderClick(){
        setComponents(<TotalOrders/>);
    }
    return(
        <div>

            

                <div style={{backgroundColor : "grey"}}>

                <nav class="navbar navbar-light bg-light">
                    <div class="container-fluid">
                    <form class="container-fluid d-flex justify-content-evenly">
                        <button class="btn btn-outline-success me-2" type="button" onClick={handleFarmerClick}>Farmer List</button>
                        <button class="btn btn-outline-success me-2" type="button" onClick={handleBuyerClick}>Buyers List</button>
                        <button class="btn btn-outline-success me-2" type="button" onClick={handleProductClick}>Products List</button>
                        <button class="btn btn-outline-success me-2" type="button" onClick={handleOrderClick}>Orders List</button>
                    </form>
                    </div>
                    </nav>
                {components}
                </div>

            
            
        </div>
    )
}

export default AdminWelcome;