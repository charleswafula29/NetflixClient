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

        Users users=new Users("Brian Mutuma",123456);
        users=feignClient.CreateUser(users);
        Movies movies=feignClient.CreateMovie(users.getId(),"Horror","IT Chapter 2","2019");
        List<Users> allusers = feignClient.getAllUsers();

        System.err.println("New User: "+users.toString());
        System.err.println("All User: "+allusers);
        System.err.println("New Movie: "+movies.toString());
    }
}
