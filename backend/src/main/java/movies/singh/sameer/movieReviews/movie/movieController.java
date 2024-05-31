package movies.singh.sameer.movieReviews.movie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/movies")
@CrossOrigin(origins="*", allowedHeaders = "*")
public class movieController {

    @Autowired
    private MovieService movieService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Movie> getAllMovies() {
        return movieService.allMovies();
    }

    @GetMapping("/{imdbId}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<Movie> getMovie(@PathVariable String imdbId) {
        return movieService.getMovie(imdbId);
    }
}
