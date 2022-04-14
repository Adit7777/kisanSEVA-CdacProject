
import Card from "./Card";
import Slider from "./Slider";
import './home.css'
function Home() {
    const myStyle = {
        backgroundImage:
            "url('https://wallpaperaccess.com/full/4293117.jpg')",
        height: '130vh',
        marginTop: '-60px',
        backgroundSize: 'cover',
        backgroundRepeat: 'no-repeat',
    };


    return (
        <div className="gradient__bg">
            <div style={myStyle} >

            </div>

            <div className="container-fluid d-flex justify-content-evenly" >

                 <Card />
                              
            </div>

            <div class="mycards-list">
                
                <div class="mycard 1">
                    <div class="mycard_image"> <img src="https://i.redd.it/b3esnz5ra34y.jpg" /> </div>
                    <div class="mycard_title title-white">
                    <p>Card Title</p>
                    </div>
                </div>
                
                    <div class="mycard 2">
                    <div class="mycard_image">
                    <img src="http://joewinograd.tumblr.com/" />
                    </div>
                    <div class="mycard_title title-white">
                    <p>Card Title</p>
                    </div>
                </div>
                
                <div class="mycard 3">
                    <div class="mycard_image">
                    <img src="https://media.giphy.com/media/10SvWCbt1ytWCc/giphy.gif" />
                    </div>
                    <div class="mycard_title">
                    <p>Card Title</p>
                    </div>
                </div>
                    
                    <div class="mycard 4">
                    <div class="mycard_image">
                    <img src="https://media.giphy.com/media/LwIyvaNcnzsD6/giphy.gif" />
                    </div>
                    <div class="mycard_title title-black">
                    <p>Card Title</p>
                    </div>
                    </div>
                
                </div>


            <Slider />

        </div>



    )
};

export default Home;