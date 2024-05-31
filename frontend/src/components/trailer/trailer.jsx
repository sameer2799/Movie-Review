import { useParams } from 'react-router-dom';
import ReactPlayer from 'react-player';
import "./Trailer.css";
import React from 'react'

const Trailer = () => {

    const params = useParams();
    const key = params.ytTrailerId;

    return (
        <div className='react-player-container'>
            {(key!=null)? <ReactPlayer url={`https://www.youtube.com/watch?v=${key}`} controls={true} autoplay={true} width="100%" height="100%" /> : <h1>Trailer not available</h1>}
        </div>
    )
}

export default Trailer