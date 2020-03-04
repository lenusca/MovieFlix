import React, { Component } from 'react';


class SerieStats extends Component{
    constructor(){
        super();
        this.state = {
            loading : true,
            series: [],
            
        }
    }
   
    render (){
        return(
            <div>
                
                <div id="header" >
                

                    <div class="top">

                        <div id="logo">
                            <div class="grid-container">
                            <div style={{marginRight:"10%"}}><img src={'images/logo.png'} style={{width: "100px", marginLeft:"10%", position:"relative", right:"20%"}} alt="..."/></div>
                            <div style={{marginRight:"10%",marginTop:"18%"}}><a href="/" style={{fontSize: "30px", marginTop: "30px", fontWeight: "bold", position:"relative", right:"10%"}}>MOVIEFLIX</a></div>
                            </div>
                        </div>
                        
                            <nav id="nav">
                                <ul>
                                    <li><a href="/"><span class="icon solid fa-home">HOME</span></a></li>
                                    <li><a href="/ListMovies"><span class="icon solid  fa-film">MOVIES</span></a></li>
                                    <li><a href="/ListSeries"><span class="icon solid  fa-tv">SERIES</span></a></li>
                                    <img alt=" " src={'images/user.jpg'} style={{height: "60px", marginRight: "80%", position: "relative", marginTop: "460px", borderRadius: "60px"}}/>
                                    <li class="dropup" style={{marginTop: "-78px"}}><a href="#rated"><span >USER</span>
                                        <div class="dropup-content">
                                            <a href="/MovieStats">Stats movie</a>
                                            <a href="/SerieStats">Stats serie</a>
                                            <a href="/UserMovies">Movies watched</a>
                                            <a href="/UserSeries">Series watched</a>
                                        </div>
                                    </a>
                                    </li>
                                </ul>
                            </nav>

                    </div>

                    

                </div>
                <div id="main" style={{backgroundImage:"url('images/movie.jpg')",position:"absolute", zIndex:"-1", backgroundPosition:"center", backgroundRepeat:"no-repeat", backgroundSize:"cover", width:"83.8%", height:"100%" }}> 
                
                </div>
               
             
            </div>
      )
    }
}

 

export default SerieStats;

