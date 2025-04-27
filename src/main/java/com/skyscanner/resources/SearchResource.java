package com.skyscanner.resources;

import com.skyscanner.models.Search;
import com.skyscanner.models.SearchResult;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.stream.Collectors;

@Path("/search")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class SearchResource {

    private final List<SearchResult> searchResults;

    public SearchResource(List<SearchResult> searchResults) {
        this.searchResults = searchResults;
    }

    @POST
    public List<SearchResult> search(Search search) {
        return searchResults.stream()
                .filter(result -> result.getCity().equalsIgnoreCase(search.getCity()))
                .collect(Collectors.toList());
    }
}
