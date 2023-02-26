package org.snhu.services.validators;

import org.snhu.services.objects.Task;

public class TaskValidator extends AbstractValidator<Task> {
    private static final int MAX_ID_LENGTH = 10;
    private static final int MAX_NAME_LENGTH = 20;
    private static final int MAX_DESCRIPTION_LENGTH = 50;

    public TaskValidator(Task task) {
        super(task);
    }

    @Override
    public boolean isValid() {
        return isValidId() && isValidName() && isValidDescription();
    }

    private boolean isValidId() {
        return isStringNotNullAndWithinLength(object.getId(), MAX_ID_LENGTH);
    }

    private boolean isValidName() {
        return isStringNotNullAndWithinLength(object.getName(), MAX_NAME_LENGTH);
    }

    private boolean isValidDescription() {
        return isStringNotNullAndWithinLength(object.getDescription(), MAX_DESCRIPTION_LENGTH);
    }
}
