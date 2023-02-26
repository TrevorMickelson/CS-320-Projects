package org.snhu.services.objects;

import java.util.Date;

public class Appointment {
    private final String id;
    private Date date;
    private String description;

    public Appointment(String id) {
        this.id = id;
    }

    public Appointment(String id, Date date, String description) {
        this.id = id;
        this.date = date;
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
