package com.elegantsoftware;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

@Path("/subscribe")
public class SnsController {

    @Inject
    SnsService snsService;

//    @GET("/")
//    public String root() {
//        return "index";
//    }
//
//    @GET("/subscribe")
//    public String add() {
//        return "sub";
//    }

    // Adds a new item to the database.
    @POST
   public String addItems(HttpServletRequest request, HttpServletResponse response) {

        String email = request.getParameter("email");
        return snsService.subEmail(email);
    }

    @DELETE
    public String delSub(HttpServletRequest request, HttpServletResponse response) {

        String email = request.getParameter("email");
        snsService.unSubEmail(email);
        return email +" was successfully deleted!";
    }

    @POST
    public String addMessage(HttpServletRequest request, HttpServletResponse response) {

        String body = request.getParameter("body");
        String lang = request.getParameter("lang");
        return snsService.pubTopic(body,lang);
    }

    @GET
    public String getSubs(HttpServletRequest request, HttpServletResponse response) {

        String mySub = snsService.getAllSubscriptions();
        return mySub;
    }
}

