import { useState, useEffect } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './App.css'
import { Routes, Route } from 'react-router-dom'
import axiosConfig from './apiComm/axiosConfig';
import Layout from './components/Layout'
import Home from './components/home/Home'

function App() {
  const [ movies, setMovies] = useState();

	const getMovies = async () => {
		try {
        const response = await axiosConfig.get('/movies');
        setMovies(response.data);
    } catch (error) {
        console.error(error);
    }
	};

  useEffect(() => {
    getMovies();

  }, []);


  return (
    <div className='App'>
      <Routes>
        <Route path="/" element={<Layout />}>
          <Route path="/" element={<Home movies={movies} />}></Route>

        </Route>
      </Routes>
        
    </div>
  )
}

export default App
