package org.example.data;

import org.example.model.Activity;

import java.util.ArrayList;
import java.util.List;

import static org.example.utils.DateUtil.parseDate;

public class ActivityData {

    private final List<Activity> activities =  new ArrayList<>();

    public ActivityData() {

        final Activity activity1 = new Activity("market email interaction", "User 2", parseDate("2020-07-10T15:00:00.000"));
        final Activity activity2 = new Activity("market email interaction", "User 3", parseDate("2024-04-20T15:00:00.000"));
        final Activity activity3 = new Activity("website login", "User 1", parseDate( "2024-03-10T15:00:00.000"));
        final Activity activity4 = new Activity("website login", "User 2", parseDate("2024-04-10T15:00:00.000"));
        final Activity activity5 = new Activity("mobile app login", "User 3", parseDate("2020-07-10T15:00:00.000"));

        activities.add(activity1);
        activities.add(activity2);
        activities.add(activity3);
        activities.add(activity4);
        activities.add(activity5);
    }

    public List<Activity> fetchActivities() {
        return activities;
    }

    public void addActivity(final String activity, final String userId, final String dateTime) {
        activities.add(new Activity(activity, userId, parseDate(dateTime)));
    }
}