package com.elegantsoftware;

import software.amazon.awssdk.services.sns.endpoints.internal.Value;

import java.time.LocalDate;
import java.time.LocalTime;

public class ReminderItems {

    private String timeZone;
    private String message;
    private LocalDate date;
    private LocalTime time;

    public String getTimeZone() {
        return timeZone;
    }

    public void setTimeZone(String timeZone) {
        this.timeZone = timeZone;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }
}
