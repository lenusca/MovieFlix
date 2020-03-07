import React, { Component } from 'react';


class Home extends Component{
    constructor(){
        super();
        this.state = {
            loading : true,
            tops: [],
            
        }
    }
    componentDidMount(){
        fetch("http://localhost:8888/Top/").then(response=> response.json()).then(data => this.setState({tops: data, isLoading:false}))
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
                                <li class="dropup" style={{marginTop: "-78px",position:"relative"}}><a href="#rated"><span >USER</span>
                                    <div class="dropup-content">
                                        <a href="/MovieStats">Movies Stats</a>
                                        <a href="/SerieStats">Series Stats</a>
                                        <a href="/UserMovies">Movies watched</a>
                                        <a href="/UserSeries">Series watched</a>
                                    </div>
                                </a>
                                </li>
                            </ul>
                        </nav>

                </div>

                </div>

                <div id="main" style={{backgroundImage:"url('images/movie.jpg')",position:"absolute", zIndex:"-1", backgroundPosition:"center", backgroundRepeat:"no-repeat", backgroundSize:"cover", minWidth:"83.8%", minHeight:"100%", backgroundAttachment: "fixed" }}> 
                    <section id="portfolio" class="two">
                            
                            <div style={{position: 'relative', marginTop: '-50px', marginLeft: '1000px'}}>
                            
                                <form action='Search?name=+document.getElementById("name").value'>
                                    <input type="search" name="name" id="name"/>
                                    <i class="fa fa-search"></i>
                                </form>
                            </div>
                    
                                <div>
                                
                                    <h1 style={{textAlign:'left', color: '#e27689', marginTop: '-70px', fontSize: '50px', marginLeft: '50px', fontWeight: 'bold'}}>Top 3 Movies</h1>
                                    <div class="grid-container">
                                    {!this.state.isLoading?(
                                        this.state.tops.length===0?(
                                        <h3 style={{color: "white"}}></h3>
                                        ):(
                                            this.state.tops.topmovies.map(
                                                user => {
                                                    return (
                                                        <div class ="grid-item" style={{position: "relative", right:"50px", marginRight:"50px"}} ><a href={"DetailMovie?id="+user.imdbID}><img alt=" " src={user.Poster} style={{width:"350 px", height:"350px"}}/><p style={{color:"white"}}>{user.Title}<p><small style={{fontSize: "20px", fontWeight: "bolder",color:"grey"}}>{user.Year}</small></p></p></a></div>        
                                                    );
                                                })
                                        )

                                                                            
                                    ):(
                                        <h3>Loading...</h3>
                                )}
                                            
                                    </div>
                                </div>
                                <div>
                                
                                    <h1 style={{textAlign:'left', color: '#e27689', marginTop: '-10px', fontSize: '50px', marginLeft: '50px', fontWeight: 'bold'}}>Top 3 Series</h1>
                                    <div class="grid-container">
                                    {!this.state.isLoading?(
                                        this.state.tops.length===0?(
                                        <h3 style={{color: "white"}}></h3>
                                        ):(
                                            this.state.tops.topseries.map(
                                                user => {
                                                    return (
                                                        <div class ="grid-item" style={{position: "relative", right:"50px", marginRight:"50px"}} ><a href={"DetailSerie?id="+user.imdbID}><img alt=" " src={user.Poster} style={{width:"350 px", height:"350px"}}/><p style={{color:"white"}}>{user.Title}<p><small style={{fontSize: "20px", fontWeight: "bolder",color:"grey"}}>{user.Year}</small></p></p></a></div>        
                                                    );
                                                })
                                        )

                                                                            
                                    ):(
                                        <h3>Loading...</h3>
                                )}                                         
                                    </div>
                                </div>
                                
                                
                        </section>



                </div>
               
             
            </div>
      )
    }
}

 

export default Home;

