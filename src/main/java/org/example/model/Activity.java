package org.example.model;

import java.util.Date;

public class Activity {

    private String activity;
    private String userId;
    private Date timestamp;

    public Activity(final String activity, final String userId, final Date timestamp) {
        this.activity = activity;
        this.userId = userId;
        this.timestamp = timestamp;
    }

    public Activity setActivity(final String activity) {
        this.activity = activity;
        return this;
    }

    public Activity setUserId(final String userId) {
        this.userId = userId;
        return this;
    }

    public Activity setTimestamp(final Date timestamp) {
        this.timestamp = timestamp;
        return this;
    }

    public String getActivity() {
        return activity;
    }

    public String getUserId() {
        return userId;
    }

    public Date getTimestamp() {
        return timestamp;
    }
}