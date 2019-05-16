package edu.upc.dsa.services;


import edu.upc.dsa.models.User;
import edu.upc.dsa.models.UserLogin;
import edu.upc.dsa.models.UserProfile;
import edu.upc.dsa.models.UserStatics;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Api(value = "/user", description = "Endpoint to User Service")
@Path("/user")

public class UserService {

    public UserService(){

    }
    @POST
    @ApiOperation(value = "Login", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful"),
            @ApiResponse(code = 500, message = "Validation Error")

    })
    @Path("/login")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response Login(UserLogin user) {
        System.out.println("LOGIN "+user);
        UserLogin userPrueba = new UserLogin("mario","mario");
        if(user.getUsername().equals(userPrueba.getUsername())&& user.getPassword().equals(userPrueba.getPassword())){
            System.out.println("LOGIN "+user);
            String s = "{'result': 'OK'}";
            return Response.status(200).entity(s).build();
        }
        else
            return Response.status(500).build();

    }
    @POST
    @ApiOperation(value = "Register", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful"),
            @ApiResponse(code = 500, message = "Validation Error")

    })
    @Path("/register")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response Register(UserProfile user) {
        UserProfile userPrueba = new UserProfile("izan","izan","izan","izan","izan","21");
        if(user.getUsername().equals(userPrueba.getUsername())&& user.getPassword().equals(userPrueba.getPassword()))
            return Response.status(201).build();
        else
            return Response.status(500).build();

    }
    @GET
    @ApiOperation(value = "profile", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = UserProfile.class),
            @ApiResponse(code = 404, message = "User not found")
    })
    @Path("/profile")
    @Produces(MediaType.APPLICATION_JSON)
    public Response profile() {
        UserProfile user = new UserProfile("Marioboto3","contraseña","Mario","Sánchez","marioboto@gmail.com","21");
     return Response.status(201).entity(user).build();
    }
    @GET
    @ApiOperation(value = "statics", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = UserStatics.class),
            @ApiResponse(code = 404, message = "User not found")
    })
    @Path("/statics")
    @Produces(MediaType.APPLICATION_JSON)
    public Response statics() {
        UserStatics user = new UserStatics(2,10,5,3);
        return Response.status(201).entity(user).build();
    }

}
