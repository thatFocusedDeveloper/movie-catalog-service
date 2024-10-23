package io.tribe.movie_catalog_service.resources;

import io.tribe.movie_catalog_service.models.CatalogItem;
import io.tribe.movie_catalog_service.models.Movie;
import io.tribe.movie_catalog_service.models.Rating;
import io.tribe.movie_catalog_service.models.UserRating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogResource {
    
    private RestTemplate  restTemplate;
    private WebClient.Builder webClientBuilder;

    public MovieCatalogResource(RestTemplate restTemplate, WebClient.Builder webClientBuilder) {
        this.restTemplate = restTemplate;
        this.webClientBuilder = webClientBuilder;
    }

    @GetMapping("/{userId}")
    public List<CatalogItem> getCatalogList(@PathVariable("userId") String userId ) {
        UserRating userRating = restTemplate.getForObject("http://localhost:8083/ratingsdata/user/" + userId, UserRating.class);
        return userRating.getRatings().stream().map(rating -> {
            Movie movie = restTemplate.getForObject("http://localhost:8083/movie/" + rating.getMovieId(), Movie.class);
            return new CatalogItem(movie.getName(), "Description", rating.getRating());
        }).collect(Collectors.toList());
    }
}