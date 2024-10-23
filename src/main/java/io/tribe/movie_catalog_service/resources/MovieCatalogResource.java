package io.tribe.movie_catalog_service.resources;

import io.tribe.movie_catalog_service.models.CatalogItem;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogResource {
    
    @GetMapping("/{userId}")
    public List<CatalogItem> getCatalogList(@PathVariable("userId") String userId ) {
        return Collections.singletonList(
                new CatalogItem("John", "Wick", 9)
        );
    }
}