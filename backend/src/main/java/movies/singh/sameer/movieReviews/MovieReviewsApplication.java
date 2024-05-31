package movies.singh.sameer.movieReviews;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MovieReviewsApplication {

	@Value("${env.MONGO_DATABASE}")
	private String mongoDatabasename;

	public static void main(String[] args) {
		SpringApplication.run(MovieReviewsApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner() {
		return args -> {
			Logger logger = LoggerFactory.getLogger(MovieReviewsApplication.class);
			logger.info("Mongo Databasename: " + mongoDatabasename);

		};
	}
}
