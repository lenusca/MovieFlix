import React from 'react';

import './App.css';
import ListMovies from './pages/ListMovies'
import DetailMovie from './pages/detailMovie';
import ListSeries from './pages/ListSeries';
import DetailSerie from './pages/detailSerie';
import Home from './pages/home';
import MovieStats from './pages/MovieStats';
import SerieStats from './pages/SerieStats';
import UserMovies from './pages/UserMovies';
import UserSeries from './pages/UserSeries';
import {
  BrowserRouter as Router,
  Switch,
  Route,
} from "react-router-dom";







function App() {
  return (
    <Router>
      <Switch>
        
        <Route path="/ListMovies">
          <ListMovies />
        </Route>
        <Route path="/DetailMovie">
          <DetailMovie />
        </Route>
        <Route path="/ListSeries">
          <ListSeries />
        </Route>
        <Route path="/DetailSerie">
          <DetailSerie />
        </Route>
        <Route path="/MovieStats">
          <MovieStats />
        </Route>
        <Route path="/SerieStats">
          <SerieStats />
        </Route>
        <Route path="/UserMovies">
          <UserMovies />
        </Route>
        <Route path="/UserSeries">
          <UserSeries />
        </Route>
        <Route path="/">
          <Home />
        </Route>
      </Switch>
  </Router>
  );
}

export default App;
