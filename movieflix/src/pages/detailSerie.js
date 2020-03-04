import React, { Component } from 'react';



class DetailSerie extends Component{
    constructor(){
        super();
        this.state = {
            loading : true,
            series: [],
            favorites:null,
            
        }
    }

    componentDidMount(){
        const queryString = window.location.search;
        const urlParams = new URLSearchParams(queryString);
        const id = urlParams.get('id');
        console.log(id);
        fetch("http://localhost:8888/Serie/?id="+id).then(response=> response.json()).then(data => this.setState({series: data, isLoading:false, favorites:data.user}))
    }
    
    render (){
        let star = [];
        let rating = parseInt(this.state.series.imdbRating);
        for(let i = 0; i < rating; i++){
           star.push( <i class="fas fa-star" style={{color:"#fa7f72"}}></i>);
        }
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
                    <div class="card" style={{marginTop: "10%", marginLeft:"12%"}}>
                            <div class="c_left" >
                                <img class="img_f" src={this.state.series.poster} alt="..." style={{height: "700px", width: "100%"}}/>
                            </div>
                            <div class="c_right">

                                <h1 style={{color: "white",
                                fontFamily: "'Montserrat', sans-serif",
                                fontWeight:"400",
                                textAlign: "left",
                                fontSize:"40px",
                                margin:"30px 0 0 0",
                                padding:"0 0 0 40px",
        letterSpacing:"1px"}}>{this.state.series.Title}</h1>
                                <div class="c_right_details">
                                    <ul style={{listStyleType:"none", padding:"0 0 0 40px", margin:"10px 0 0 0"}}>
        <li style={{display:"inline", color:"#e3e3e3", fontFamily: "'Montserrat', sans-serif", fontWeight:"400", fontSize:"16px", padding:"0 40px 0 0"}}>{this.state.series.Released}</li>
                                        <li style={{display:"inline", color:"#e3e3e3", fontFamily: "'Montserrat', sans-serif", fontWeight:"400", fontSize:"16px", padding:"0 40px 0 0"}}>{this.state.series.Runtime}</li>
                                        <li style={{display:"inline", color:"#e3e3e3", fontFamily: "'Montserrat', sans-serif", fontWeight:"400", fontSize:"16px", padding:"0 40px 0 0"}}>{this.state.series.genre}</li>
                                    </ul>
                                    <ul style={{listStyleType:"none", padding:"0 0 0 40px", margin:"0 0 0 0"}}>
                                        <li style={{display:"inline", color:"#e3e3e3", fontFamily: "'Montserrat', sans-serif", fontWeight:"400", fontSize:"16px", padding:"0 40px 0 0"}}>{this.state.series.Language}</li>
                                        <li style={{display:"inline", color:"#e3e3e3", fontFamily: "'Montserrat', sans-serif", fontWeight:"400", fontSize:"16px", padding:"0 40px 0 0"}}>{this.state.series.totalSeasons} Seasons</li>
                                        <li style={{display:"inline", color:"#e3e3e3", fontFamily: "'Montserrat', sans-serif", fontWeight:"400", fontSize:"16px", padding:"0 40px 0 0"}}>{this.state.series.genre}</li>
                                    </ul>
                                    <ul style={{listStyleType:"none", padding:"0 0 0 40px", margin:"0 0 0 0"}}>
                                         <li style={{display:"inline", color:"#e27689", fontFamily: "'Montserrat', sans-serif", fontWeight:"400", fontSize:"16px", padding:"0 10px 0 0"}}>Writers:</li>
                                        <li style={{display:"inline", color:"#e3e3e3", fontFamily: "'Montserrat', sans-serif", fontWeight:"400", fontSize:"16px", padding:"0 20px 0 0"}}>{this.state.series.Writer}</li>
                                    </ul>
                                    <ul style={{listStyleType:"none", padding:"0 0 0 40px", margin:"0 0 0 0"}}>
                                         <li style={{display:"inline", color:"#e27689", fontFamily: "'Montserrat', sans-serif", fontWeight:"400", fontSize:"16px", padding:"0 10px 0 0"}}>Actors:</li>
                                        <li style={{display:"inline", color:"#e3e3e3", fontFamily: "'Montserrat', sans-serif", fontWeight:"400", fontSize:"16px", padding:"0 20px 0 0"}}>{this.state.series.Actors}</li>
                                    </ul>
                                    <ul style={{listStyleType:"none", padding:"0 0 0 40px", margin:"0 0 0 0"}}>
                                         <li style={{display:"inline", color:"#e27689", fontFamily: "'Montserrat', sans-serif", fontWeight:"400", fontSize:"16px", padding:"0 10px 0 0"}}>Awards:</li>
                                        <li style={{display:"inline", color:"#e3e3e3", fontFamily: "'Montserrat', sans-serif", fontWeight:"400", fontSize:"16px", padding:"0 20px 0 0"}}>{this.state.series.Awards}</li>
                                    </ul>
                                    
                                    <div class="rating" style={{marginLeft: "45px"}}>
                                    {rating!==0?(
                                        star
                                ):(
                                    <div></div>
                                )}
                                       
                                    </div>
                                    <div class="card_review">
                                        <p style={{ color:"white",
                                        fontFamily: "'Montserrat', sans-serif",
                                        fontSize:"18px",
                                        padding: "0 40px 0 40px",
                                        letterSpacing:"1px",
                                        
                                        lineHeight:"20px"}}>
                                        {this.state.series.plot}
                                        </p>
                                       
                                    </div>
                                    <div class="button_c" style={{position: "relative", top:"-40px", marginLeft: "700px", width: "50px"}}>
                                        {this.state.favorites!==0?(
                                             <a href="" onClick={()=> {
                                                this.setState(
                                                    {
                                                        favorites:0,
                                                    }
                                                );
                                                fetch("http://localhost:8888/removeSerieFavorites/?id="+this.state.series.imdbID)
                                             }}><i class="fas fa-heart" style={{color:"red"}}></i></a>
                                        ):(
                                            <a href="" onClick={()=> {
                                                this.setState(
                                                    {
                                                        favorites:1,
                                                    }
                                                );
                                                fetch("http://localhost:8888/addSerieFavorites/?id="+this.state.series.imdbID)
                                             }}><i class="fas fa-heart"></i></a>
                                        )
                                            
                                        }
                                       
                                    </div>
                                </div>
                                </div>
                            </div>
                            
                    </div>
            </div>
      )
    }
}

 

export default DetailSerie;

