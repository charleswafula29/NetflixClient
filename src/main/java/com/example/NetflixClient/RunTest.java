package com.example.NetflixClient;

import com.example.NetflixClient.models.Categories;
import com.example.NetflixClient.models.Movies;
import com.example.NetflixClient.models.Users;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RunTest implements CommandLineRunner {

    private final FeignRestClient feignClient;

    public RunTest(FeignRestClient feignClient) {
        this.feignClient = feignClient;
    }

    @Override
    public void run(String... args) throws Exception {

        //create new user
        Users users=new Users("Ruth Maina",95885);
//        users=feignClient.CreateUser(users);
//        System.err.println("New User: "+users.toString());


        //list all users
        List<Users> allusers = feignClient.getAllUsers();
        System.err.println("All User: "+allusers);

        //find user by National Id
//        users=feignClient.getUserByNationalID(users.getNationalID());
        users=feignClient.getUserByNationalID(95885);
        System.err.println("Found user: "+users.toString());


        //user to create new movie
//        Movies movies=feignClient.CreateMovie(users.getId(),"Action-Gods","Clash of titans","2014");
//        System.err.println("New Movie created: "+movies.toString());

        //list user's movies
        List<Movies> usermovies= feignClient.getUserMovies(users.getNationalID());
        System.err.println( users.getName()+"'s Movies : "+ usermovies);

        //find particular movie
        Movies foundmovie= feignClient.getSingleMovie((long)5);
        System.err.println( users.getName()+"'s Movie Found : "+foundmovie);

        //update found movie
        Movies updatemovie= new Movies("Updated Movie","2020");
        updatemovie=feignClient.UpdateMovie(users.getNationalID(),foundmovie.getId(),updatemovie);
        System.err.println("Updated Movie: "+updatemovie);

        //list user's movies again
        usermovies= feignClient.getUserMovies(users.getNationalID());
        System.err.println( users.getName()+"'s Movies : "+ usermovies);

        //list all categories
        List<Categories> cats= feignClient.getAllcategories();
        System.err.println("All Categories: "+cats);
    }
}
