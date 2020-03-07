import React, { Component } from 'react';
import Chart from "react-google-charts";

class MovieStats extends Component{
    constructor(){
        super();
        this.state = {
            loading : true,
            movies: [],
            
        }
    }
    componentDidMount(){
        fetch("http://localhost:8888/UserMovies/").then(response=> response.json()).then(data => this.setState({movies: data, isLoading:false}))
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
                <div id="main" style={{backgroundColor:"black",position:"absolute", zIndex:"-1", backgroundPosition:"center", backgroundRepeat:"no-repeat", backgroundSize:"cover", minWidth:"83.8%", minHeight:"100%" }}> 
                   
                    <h1 style={{marginTop: "50px", marginLeft: "580px", color: "white", fontWeight: "bold"}}>TIME WATCHING MOVIES</h1>
                    <div class="grid-container" style={{marginTop: "20px", marginLeft: "250px"}}>
                        <div class="grid-item" style={{fontSize: "100px",color: "#e27689", fontWeight: "bold"}}>{this.state.movies.months}<a style={{fontSize: "20px"}}>MONTHS</a></div>
                        <div class="grid-item" style={{fontSize: "100px",color: "#e27689", fontWeight: "bold"}}>{this.state.movies.days}<a style={{fontSize: "20px"}}>DAYS</a></div>
                        <div class="grid-item" style={{fontSize: "100px",color: "#e27689", fontWeight: "bold"}}>{this.state.movies.hours}<a style={{fontSize: "20px"}}>HOURS</a></div>
                    </div> 
                    <div class="grid-container-charts" style={{marginTop: "100px"}}>         
                        <div class="grid-item-charts" >                
                        <Chart
                            width={'850px'}
                            height={'700px'}
                            
                            chartType="PieChart"
                            loader={<div>Loading Chart</div>}
                            data={[
                                ['Task', 'Hours per Day'],
                                ['Adventure', this.state.movies.Adventure],
                                ['Romance', this.state.movies.Romance],
                                ['Horror', this.state.movies.Horror],
                                ['Animation', this.state.movies.Animation],
                                ['Comedy', this.state.movies.Comedy],
                                ['Drama',this.state.movies.Drama],
                                ['Crime',this.state.movies.Crime],
                                ['Action', this.state.movies.Action],
                               
                            ]}
                            options={{
                                legend:{ textStyle:{ color:'white'} },
                                backgroundColor: 'transparent',
                                title: 'Genres ',
                            }}
                            rootProps={{ 'data-testid': '1' }}
                        />
                        </div>
                        <div class="grid-item-charts" style={{backgroundColor:"transparent"}}> 

                        <Chart
                            width={'750px'}
                            height={'550px'}
                            chartType="ColumnChart"
                            loader={<div>Loading Chart</div>}
                            data={[
                                ['NºMovies', 'Rating ', {role:'style'}],
                                ['2', this.state.movies.imdbRating2, 'color:yellow'],
                                ['4', this.state.movies.imdbRating4, 'color:blue'],
                                ['6', this.state.movies.imdbRating6, 'color:red'],
                                ['8', this.state.movies.imdbRating8, 'color: green'],
                                ['10', this.state.movies.imdbRating10, 'color:purple'],
                            ]}
                            options={{
                                legend:{ textStyle:{ color:'black'} },
                                chartArea: { width: '50%' },
                                hAxis: {  
                                    titleTextStyle:{color:'white'},
                                    title:'Rating',
                                    textStyle: {color:'white'},
                                    minValue: 2,
                                },
                                vAxis: {
                                    titleTextStyle:{color:'white'},
                                    title: 'Nº Movies', 
                                    textStyle: {color:'white'}
                                },
                                backgroundColor:'transparent',
                                colors:['black'],
                            }}
                            // For tests
                            rootProps={{ 'data-testid': '1' }}
                            />
                        </div>
                            
                    </div>
                    
                </div>
               
             
            </div>
      )
    }
}

 

export default MovieStats;

