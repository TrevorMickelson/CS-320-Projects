package org.snhu.services.validators;

import org.snhu.services.objects.Appointment;

import java.util.Date;

public class AppointmentValidator extends AbstractValidator<Appointment> {
    private static final int MAX_ID_LENGTH = 10;
    private static final int MAX_DESCRIPTION_LENGTH = 50;

    public AppointmentValidator(Appointment object) {
        super(object);
    }

    @Override
    public boolean isValid() {
        return isValidId() && isValidDate() && isValidDescription();
    }

    public boolean isValidDate() {
        if (object.getDate() == null) return false;

        return !object.getDate().before(new Date());
    }

    private boolean isValidId() {
        return isStringNotNullAndWithinLength(object.getId(), MAX_ID_LENGTH);
    }

    private boolean isValidDescription() {
        return isStringNotNullAndWithinLength(object.getDescription(), MAX_DESCRIPTION_LENGTH);
    }
}
