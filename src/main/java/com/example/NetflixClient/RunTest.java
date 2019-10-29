package com.example.NetflixClient;

import com.example.NetflixClient.models.Categories;
import com.example.NetflixClient.models.Movies;
import com.example.NetflixClient.models.Users;
import org.apache.catalina.User;
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
        Users users=new Users("New User",12447);
//        users=feignClient.CreateUser(users);
//        System.err.println("New User: "+users.toString());


        //list all users
        List<Users> allusers = feignClient.getAllUsers();
        System.err.println("==========ALL USERS===========\n");
        for (Users users1 : allusers) {
            System.err.println("Id : "+users1.getId()+"\n"+"Names : "+users1.getName()+"\n"+"NationalID : "+users1.getNationalID()+"\n");
        }

        //find user by National Id
//        users=feignClient.getUserByNationalID(users.getNationalID());
        users=feignClient.getUserByNationalID(12445667);
        System.err.println("=========FOUND USER=========\n");
        System.err.println("Id : "+users.getId()+"\n"+"Names : "+users.getName()+"\n"+"NationalID : "+users.getNationalID()+"\n");


        //user to create new movie
//        Movies movies=feignClient.CreateMovie(users.getId(),"Action-Gods","Clash of titans","2014");
//        System.err.println("New Movie created: "+movies.toString());

        //Create Original movie
//        Movies movies1=feignClient.CreateOriginalMovie("Action-Gods","Clash of titans 3 - original","2019");
//        System.err.println("New Original Movie created: "+movies1.toString());

        //list user's movies
        List<Movies> usermovies= feignClient.getUserMovies(users.getNationalID());
        System.err.println( "=========="+users.getName()+"'s Movies=============\n");
        for (Movies movies2 : usermovies) {
            System.err.println("Id : "+movies2.getId()+"\n"+"Movie Name : "+movies2.getName()
                    +"\n"+"Movie Type : "+movies2.getType()+"\n"+"Year Released: "+movies2.getYearReleased()+"\n");
        }

        //find particular movie
//        Movies foundmovie= feignClient.getSingleMovie((long)5);
//        System.err.println( users.getName()+"'s Movie Found : "+foundmovie);

        //update found movie
//        Movies updatemovie= new Movies("Updated Movie Again again","2020");
//        updatemovie=feignClient.UpdateMovie(users.getNationalID(),foundmovie.getId(),updatemovie);
//        System.err.println("Updated Movie: "+updatemovie);

        //delete found movie
//        feignClient.deleteMovie(users.getNationalID(),foundmovie.getId());
//        System.err.println("Found Movie DELETED!");

        //list user's movies again
//        usermovies= feignClient.getUserMovies(users.getNationalID());
//        System.err.println( "=========="+users.getName()+"'s Movies Again=============\n");
//        for (Movies movies2 : usermovies) {
//            System.err.println("Id : "+movies2.getId()+"\n"+"Movie Name : "+movies2.getName()
//                    +"\n"+"Movie Type : "+movies2.getType()+"\n"+"Year Released: "+movies2.getYearReleased()+"\n");
//        }

        //list all categories
        List<Categories> cats= feignClient.getAllcategories();
        System.err.println("All Categories: "+cats);

        //list all Movies
        List<Movies> allmovies= feignClient.getAllMovies();
        System.err.println("======ALL AVAILABLE MOVIES========\n");
        for (Movies movies2 : allmovies) {
            System.err.println("Id : "+movies2.getId()+"\n"+"Movie Name : "+movies2.getName()
                    +"\n"+"Movie Type : "+movies2.getType()+"\n"+"Year Released: "+movies2.getYearReleased()+"\n");
        }

        //delete user
        feignClient.deleteUser(users.getId());
        System.err.println("DELETED USER!");
    }
}
