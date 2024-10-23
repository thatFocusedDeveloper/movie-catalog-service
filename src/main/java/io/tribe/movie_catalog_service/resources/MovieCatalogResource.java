package io.tribe.movie_catalog_service.resources;

import io.tribe.movie_catalog_service.models.CatalogItem;
import io.tribe.movie_catalog_service.models.Rating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogResource {
    
    private RestTemplate  restTemplate;

    public MovieCatalogResource(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("/{userId}")
    public List<CatalogItem> getCatalogList(@PathVariable("userId") String userId ) {
        List<Rating> ratingList = Arrays.asList(
          new Rating("1234", 8),      
          new Rating("5678", 9)     
        );
        
        return ratingList.stream()
                .map(rating -> new CatalogItem("Name", "Desc", rating.getRating()))
                .collect(Collectors.toList());
    }
}