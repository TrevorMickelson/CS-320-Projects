package com.snhu.taskservicetest;

import org.snhu.services.objects.Appointment;

import java.util.Date;

public class TestUtil {
    public static Appointment getWorkingMockAppointment() {
        return new Appointment("1", new Date(System.currentTimeMillis() * 1000000), "3");
    }

    public static Appointment getWorkingMockAppointment(long timeStamp) {
        return new Appointment("1", new Date(timeStamp), "3");
    }
}
