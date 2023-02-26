package com.snhu.taskservicetest;

import org.junit.jupiter.api.Test;
import org.snhu.services.Service;
import org.snhu.services.objects.Appointment;
import org.snhu.services.validators.AppointmentValidator;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

/**
 * I figured the service class only needed a single
 * class with one arbitrarily chosen object to test it
 * <p>
 * This class can handle a lot more than the current set
 * of objects, and increasing the size of the test just to
 * add more objects, seems unnecessary
 * <p>
 * In fact, I do wonder if a fake object (that isn't a part of the project)
 * that implements "Validator" would be better to test with. This would
 * de-couple the test more from the project itself, whilst still testing everything
 */
public class ServiceTest {
    @Test
    void testAdd() {
        Appointment appointment = TestUtil.getWorkingMockAppointment();
        Service<Appointment, AppointmentValidator> service = new Service<>(new AppointmentValidator(appointment));

        // Making sure nothing is there
        assertEquals(service.size(), 0);

        // Adding
        service.add("test", appointment);

        // This determines if it was added or not
        assertEquals(service.size(), 1);
    }

    @Test
    void testRemove() {
        Appointment appointment = TestUtil.getWorkingMockAppointment();
        Service<Appointment, AppointmentValidator> service = new Service<>(new AppointmentValidator(appointment));
        service.add("test", appointment);

        // Making sure the contact is there
        assertEquals(service.size(), 1);

        // Removing
        service.remove("test");

        // This determines if it was removed
        assertEquals(service.size(), 0);
    }

    @Test
    void testUpdate() {
        long timeStamp = System.currentTimeMillis() + Integer.MAX_VALUE * 1000L;
        Appointment appointment = TestUtil.getWorkingMockAppointment(timeStamp);
        Service<Appointment, AppointmentValidator> service = new Service<>(new AppointmentValidator(appointment));
        service.add("test", appointment);

        // Checking default status
        assertEquals(appointment.getId(), "1");
        assertEquals(appointment.getDate().getTime(), timeStamp);
        assertEquals(appointment.getDescription(), "3");

        // Updating value
        long newTimeStamp = System.currentTimeMillis();
        service.update("test", contact -> {
            contact.setDate(new Date(newTimeStamp));
            contact.setDescription("I'm mr ducky");
        });

        // Testing new value
        assertEquals(appointment.getDate().getTime(), newTimeStamp);
        assertEquals(appointment.getDescription(), "I'm mr ducky");
    }

    @Test
    void testGet() {
        Appointment appointment = TestUtil.getWorkingMockAppointment();
        Service<Appointment, AppointmentValidator> service = new Service<>(new AppointmentValidator(appointment));
        service.add("test", appointment);

        assertFalse(service.get("test").isEmpty());
    }
}
