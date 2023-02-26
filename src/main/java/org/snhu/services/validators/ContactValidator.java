package org.snhu.services.validators;

import org.snhu.services.objects.Contact;

public class ContactValidator extends AbstractValidator<Contact> {
    private static final int ID_LENGTH = 10;
    private static final int FIRST_NAME_LENGTH = 10;
    private static final int LAST_NAME_LENGTH = 10;
    private static final int PHONE_NUMBER_LENGTH = 10;
    private static final int ADDRESS_LENGTH = 30;

    public ContactValidator(Contact object) {
        super(object);
    }

    @Override
    public boolean isValid() {
        return isValidId() && isValidFirstName() && isValidLastName()
                && isValidPhoneNUmber() && isValidAddress();
    }

    private boolean isValidId() {
        return isStringNotNullAndWithinLength(object.getId(), ID_LENGTH);
    }

    private boolean isValidFirstName() {
        return isStringNotNullAndWithinLength(object.getFirstName(), FIRST_NAME_LENGTH);
    }

    private boolean isValidLastName() {
        return isStringNotNullAndWithinLength(object.getLastName(), LAST_NAME_LENGTH);
    }

    private boolean isValidPhoneNUmber() {
        return isStringNotNullAndWithinLength(object.getPhoneNumber(), PHONE_NUMBER_LENGTH);
    }

    private boolean isValidAddress() {
        return isStringNotNullAndWithinLength(object.getAddress(), ADDRESS_LENGTH);
    }
}
