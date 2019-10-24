package com.example.NetflixClient;

import com.example.NetflixClient.Config.FeignConfig;
import com.example.NetflixClient.models.Categories;
import com.example.NetflixClient.models.Movies;
import com.example.NetflixClient.models.Users;
import org.apache.catalina.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "client", url = "http://localhost:9090", configuration = FeignConfig.class)
public interface FeignRestClient {

    @RequestMapping(method = RequestMethod.GET, value = "users")
    List<Users> getAllUsers();

    @RequestMapping(method = RequestMethod.POST, value = "users")
    Users CreateUser(@RequestBody Users users);

    @RequestMapping(method = RequestMethod.POST, value = "movies/{id}/categories")
    Categories CreateCategory(@PathVariable Long id,@RequestBody Categories categories);

    @RequestMapping(method = RequestMethod.POST, value = "users/{id}/movies")
    Movies CreateMovie(@PathVariable Long id, @RequestParam(name = "category") String category,
                       @RequestParam(name = "movieName") String movieName,
                       @RequestParam(name = "yearReleased") String yearReleased);

    @RequestMapping(method = RequestMethod.GET, value = "categories")
    List<Categories> getAllcategories();

    @RequestMapping(method = RequestMethod.GET, value = "users/{nationalId}/movies")
    List<Movies> getUserMovies( @PathVariable Integer nationalId);

    @RequestMapping(method = RequestMethod.GET, value = "movies/movies/{id}")
    Movies getSingleMovie(@PathVariable Long id);

    @RequestMapping(method = RequestMethod.GET, value = "users/UserNationalId/{nationalId}")
    Users getUserByNationalID ( @PathVariable Integer nationalId);

    @RequestMapping(method = RequestMethod.DELETE, value = "users/{nationalId}/movies/{movieid}")
    Users deleteMovie (@PathVariable(name = "nationalId") Integer nationalId, @PathVariable(name = "movieid") Long movieid);

    @RequestMapping(method = RequestMethod.DELETE, value = "users/deleteUser/{userId}")
    Users deleteUser (@PathVariable(name = "userId") Integer userId);

    @RequestMapping(method = RequestMethod.PATCH, value = "movies/{NationalId}/updatemovies/{id}")
    Movies UpdateMovie (@PathVariable Integer NationalId,@PathVariable long id, @RequestBody Movies movies);








}
