package com.example.NetflixClient;

import com.example.NetflixClient.Config.FeignConfig;
import com.example.NetflixClient.models.Categories;
import com.example.NetflixClient.models.Movies;
import com.example.NetflixClient.models.Users;
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




}
