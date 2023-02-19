package com.elegantsoftware;

import com.amazon.ask.model.services.reminderManagement.ReminderRequest;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import java.time.LocalDate;
import java.time.LocalTime;

@Path("/v1")
@RegisterRestClient
public class SnsController {

    @Inject
    @RestClient
    RemindersIntentService snsService;

    @POST
    @Path("/reminder")

   public ReminderRequest addItems( ReminderItems reminderItems ) {

        return snsService.createReminderEvent(reminderItems);
    }

}

