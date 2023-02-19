package com.elegantsoftware;

 import com.aayushatharva.brotli4j.common.annotations.Local;
 import com.amazon.ask.model.services.reminderManagement.*;
 import io.quarkus.arc.Unremovable;
 import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

 import javax.enterprise.context.ApplicationScoped;
 import javax.ws.rs.GET;
 import javax.ws.rs.POST;
 import javax.ws.rs.Path;
 import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.OffsetDateTime;
 import java.util.Locale;

@Path("/v1")
@RegisterRestClient
public class RemindersIntentService {

    @POST
    public  ReminderRequest createReminderEvent(ReminderItems reminderItems){


        SpokenText spokenText = SpokenText.builder()
                .withText(reminderItems.getMessage())
                .withLocale("eu")
                .build();

        SpokenInfo spokenInfo = SpokenInfo.builder()
                .addContentItem(spokenText)
                .build();

        AlertInfo alertInfo = AlertInfo.builder()
                .withSpokenInfo(spokenInfo)
                .build();


        LocalDateTime triggerTime = LocalDateTime.of(LocalDate.of(reminderItems.getDate().getYear(),reminderItems.getDate().getMonth(),reminderItems.getDate().getDayOfMonth()), LocalTime.of(reminderItems.getTime().getHour(),reminderItems.getTime().getMinute(), reminderItems.getTime().getSecond()));

        Recurrence recurrence = Recurrence.builder()
                .withFreq(RecurrenceFreq.DAILY)
                .build();

        Trigger trigger = Trigger.builder()
                .withType(TriggerType.SCHEDULED_ABSOLUTE)
                .withScheduledTime(triggerTime)
                .withRecurrence(recurrence)
                .withTimeZoneId(reminderItems.getTimeZone())
                .build();

        PushNotification pushNotification = PushNotification.builder()
                .withStatus(PushNotificationStatus.ENABLED)
                .build();

        ReminderRequest reminderRequest = ReminderRequest.builder()
                .withAlertInfo(alertInfo)
                .withRequestTime(OffsetDateTime.now())
                .withTrigger(trigger)
                .withPushNotification(pushNotification)
                .build();


        return reminderRequest;
    }

}

