package com.snhu.taskservicetest;

import org.junit.jupiter.api.Test;
import org.snhu.services.objects.Appointment;
import org.snhu.services.validators.AppointmentValidator;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ValidatorTest {
    /**
     * Because every validator has the same
     * null and length checks, I've wrapped all
     * of these functions in each validator using
     * one single function
     * <p>
     * The idea here is to test that specific function
     * which will tell me all the code works everywhere
     * else
     * <p>
     * I picked an arbitrary object here just
     * to access the function
     */
    @Test
    void testValidatorNullAndLengthCheck() {
        Appointment appointment = TestUtil.getWorkingMockAppointment();
        AppointmentValidator validator = new AppointmentValidator(appointment);

        // Checking for null and if the string is too long
        assertFalse(validator.isStringNotNullAndWithinLength(null, 25));
        assertFalse(validator.isStringNotNullAndWithinLength("test", 1));

        // Checking if the string is less than or the exact size
        assertTrue(validator.isStringNotNullAndWithinLength("test", 25));
        assertTrue(validator.isStringNotNullAndWithinLength("test", 4));
    }

    /**
     * This is the validator that's actually
     * different, so it's getting its own test
     */
    @Test
    void testAppointmentDateValidator() {
        Appointment mockAppointment = new Appointment("1");
        AppointmentValidator mockValidator = new AppointmentValidator(mockAppointment);

        mockAppointment.setDate(null);
        assertFalse(mockValidator.isValidDate());

        // Making sure it's not in the past
        mockAppointment.setDate(new Date(0));
        assertFalse(mockValidator.isValidDate());

        // Setting to current time (and it's not null)
        mockAppointment.setDate(new Date(System.currentTimeMillis()));
        assertTrue(mockValidator.isValidDate());
    }
}
