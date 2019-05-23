package edu.upc.dsa.services;


import edu.upc.dsa.MockAPI;
import edu.upc.dsa.MockAPIImpl;
import edu.upc.dsa.models.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Api(value = "/user", description = "Endpoint to User Service")
@Path("/user")

public class UserService {

    private MockAPI ma;

    public UserService() throws Exception {
        this.ma = MockAPIImpl.getInstance();
        if (ma.sizeUsers() == 0) {
            this.ma.addUserLogin("admin", "admin");
            this.ma.addUserLogin("carlo", "carlo");
            this.ma.addUser("Mario","Mario","Mario","San","mama",21,10,10,10,10);
        }
    }
    @POST
    @ApiOperation(value = "Mock Login", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = UserLogin.class, responseContainer="List"),
            @ApiResponse(code = 404, message = "User not found", responseContainer="List"),
            @ApiResponse(code = 500, message = "Password not match", responseContainer="List")
    })
    @Path("/login")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response login(UserLogin user) {
        try{
            UserLogin u = this.ma.getUserLogin(user.getUsername(),user.getPassword());
            return Response.status(201).entity(u).build();
        }catch(UserNotFoundException e1){
            return Response.status(404).build();
        }catch(PasswordNotMatchException e2){
            return Response.status(500).build();
        }
    }
    @POST
    @ApiOperation(value = "Mock Register", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = User.class, responseContainer="List"),
            @ApiResponse(code = 500, message = "Existant user", responseContainer="List")
    })
    @Path("/register")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response register(User user) {
        try{
            UserLogin u = this.ma.addUserLogin(user.getUsername(),user.getPassword());
            return Response.status(201).entity(u).build();
        }catch(ExistantUserException e1) {
            return Response.status(500).build();
        }
    }
    @GET
    @ApiOperation(value = "profile", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = UserProfile.class),
            @ApiResponse(code = 404, message = "User not found")
    })
    @Path("/{username}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response profile(@PathParam("username") String username) {
        try{
            UserProfile userProfile = this.ma.getProfile(username);
            return Response.status(201).entity(userProfile).build();
        }catch(UserNotFoundException e1){
            return Response.status(404).build();
        }
    }
    @GET
    @ApiOperation(value = "statics", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = UserStatistics.class),
            @ApiResponse(code = 404, message = "User not found")
    })
    @Path("/statistics")
    @Produces(MediaType.APPLICATION_JSON)
    public Response statics() {
        UserStatistics user = new UserStatistics(2,10,5,3);
        return Response.status(201).entity(user).build();
    }
    @GET
    @ApiOperation(value = "inventory", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = UserInventary.class),
            @ApiResponse(code = 404, message = "User not found")
    })
    @Path("/inventory")
    @Produces(MediaType.APPLICATION_JSON)
    public Response inventory() {
        String fusil = "fusildetambor";
        String cluered = "cluered";
        String clueyellow = "clueyellow";
        String katana = "katana";
        String keyred = "keyred";
        String keyyellow = "keyyellow";

        UserInventary user = new UserInventary();
        List<String> lista = new ArrayList<>();
        lista.add(fusil);
        lista.add(cluered);
        lista.add(clueyellow);
        lista.add(katana);
        lista.add(keyyellow);
        lista.add(keyyellow);
        lista.add(keyred);
        user.setLista(lista);
        return Response.status(201).entity(user).build();
    }
    @GET
    @ApiOperation(value = "inventoryHome", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = UserInventary.class),
            @ApiResponse(code = 404, message = "User not found")
    })
    @Path("/inventoryHome")
    @Produces(MediaType.APPLICATION_JSON)
    public Response inventoryHome() {
        String fusil = "fusil";
        String katana = "katana";
        UserInventary user = new UserInventary();
        List<String> lista = new ArrayList<>();
        lista.add(fusil);
        lista.add(katana);
        user.setLista(lista);
        return Response.status(201).entity(user).build();
    }
    @POST
    @ApiOperation(value = "Buy", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful"),
            @ApiResponse(code = 500, message = "Validation Error")

    })
    @Path("/buy")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response buy(Weapon weapon) {
            return Response.status(201).entity(weapon).build();
    }

}
