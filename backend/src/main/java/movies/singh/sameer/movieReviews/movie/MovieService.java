package movies.singh.sameer.movieReviews.movie;

import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    Logger log = LoggerFactory.getLogger(MovieService.class);

    public List<Movie> allMovies() {
        log.info("Getting all movies");
        List<Movie> movies = movieRepository.findAll();
//        log.info(movies.toString());
        return movieRepository.findAll();
    }

    public Optional<Movie> getMovie(String imdbId) {
        return movieRepository.findByImdbId(imdbId);
    }




    public Movie updateMovie(ObjectId id, Movie movie) {
        Movie movieToUpdate = movieRepository.findById(id).orElse(null);
        if (movieToUpdate == null) {
            return null;
        }
        movieToUpdate.setTitle(movie.getTitle());

        return movieRepository.save(movieToUpdate);
    }
}
