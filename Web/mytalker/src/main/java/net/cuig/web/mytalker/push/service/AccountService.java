package net.cuig.web.mytalker.push.service;

import net.cuig.web.mytalker.push.bean.User;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/account")
public class AccountService {
    @GET
    @Path("/login")
    public String get(){
        return "you get the login";
    }

    @POST
    @Path("/login")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public User pose(){
        User user =new User();
        user.setName("美女");
        user.setSex(2);
        return user;
    }
}
