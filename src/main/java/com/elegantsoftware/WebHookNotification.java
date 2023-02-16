package com.elegantsoftware;

import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.DefaultAWSCredentialsProviderChain;
import com.amazonaws.regions.Regions;

import javax.enterprise.context.ApplicationScoped;


@ApplicationScoped
public class WebHookNotification {

//    public static SendNotificationResult getNotification() {
//        Target target = Target.builder()
//                .withType(TargetType.PUSH_NOTIFICATION)
//                .withValue("your-device-id")
//                .build();
//        // Create a Notification object with the message you want to send
//        Notification notification = Notification.builder()
//                .withNotificationId("your-notification-id")
//                .withTitle("Notification Title")
//                .withMessage("Notification message")
//                .build();
//
//        // Set up the AWS credentials and client
//        AWSCredentialsProvider credentialsProvider = new DefaultAWSCredentialsProviderChain();
//        AWSNotifications notificationsClient = AWSNotificationsClientBuilder.standard()
//                .withCredentials(credentialsProvider)
//                .withRegion(Regions.US_EAST_1)
//                .build();
//        // Send the notification
//        SendNotificationRequest request = SendNotificationRequest.builder()
//                .withTarget(target)
//                .withNotification(notification)
//                .build();
//        SendNotificationResult result = notificationsClient.sendNotification(request);
//
//          return result;
//    }

}