package org.acme.resource;

import org.acme.model.User;
import org.acme.resource.request.CreateUserRequest;
import org.acme.service.UserServiceImpl;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.Optional;

@Path("/api/users")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UserResource {

    @Inject
    UserServiceImpl userService;

    @POST
    public User registerUser(CreateUserRequest createUserRequest) throws Exception {
        return userService.createUser(createUserRequest);
    }

    @GET
    @Path("/{userId}")
    public void getUserById(@PathParam("userId") Integer userId){

        userService.findUser(userId);
    }

    @PUT
    public User updateUser(User users){
        return userService.updateUser(users);
    }

    @DELETE
    @Path("/{userId)}")
    public Optional<User> removeUser(@PathParam("userId)") Integer userId){
        return userService.delete(userId);
    }
    @GET
    public List<User> getAllUser(){
        return userService.findUsers();
    }
}
