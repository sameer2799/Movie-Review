package movies.singh.sameer.movieReviews.review;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/reviews")
@CrossOrigin(origins="http://localhost:5173", allowedHeaders="*")
public class ReviewController {

    private final ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

     @PostMapping
     @ResponseStatus(HttpStatus.CREATED)
     public Review createReview(@RequestBody Map<String, String> payload) {
         return reviewService.createReview(payload.get("body"), payload.get("imdbId"));
     }
}
