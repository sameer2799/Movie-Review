import { useState, useEffect } from 'react'
import './App.css'
import { Routes, Route } from 'react-router-dom'
import axiosConfig from './apiComm/axiosConfig';
import Layout from './components/Layout'
import Home from './components/home/Home'
import Header from './components/header/header'
import Trailer from './components/trailer/trailer';
import Reviews from './components/reviews/Reviews';
import NotFound from './components/notFound/NotFound';

function App() {
  const [ movies, setMovies] = useState();
  const [ movie, setMovie] = useState();
  const [ reviews, setReviews] = useState();

	const getMovies = async () => {
		try {
        const response = await axiosConfig.get('/movies');
        setMovies(response.data);
    } catch (error) {
        console.error(error);
    }
	};

  const getMovieData = async (movieId) => {
    try {
      const response = await axiosConfig.get(`/api/v1/movies/${movieId}`);
      const singleMovie = response.data;
      setMovie(singleMovie);
      setReviews(singleMovie.reviews);
    } catch (error) {
      console.error(error);
    }
  };

  useEffect(() => {
    getMovies();

  }, []);


  return (
    <div className='App'>
      <Header />
      <Routes>
        <Route path="/" element={<Layout />}>
          <Route path="/" element={<Home movies={movies} />}></Route>
          <Route path='/Trailer/:ytTrailerId' element={<Trailer />}></Route>
          <Route path='/Reviews/:movieId' element={<Reviews getMovieData={getMovieData} movie={movie} reviews={reviews} setReviews={setReviews} />}></Route>
          <Route path='*' element={<NotFound />}></Route>
        </Route>
      </Routes>
        
    </div>
  )
}

export default App
