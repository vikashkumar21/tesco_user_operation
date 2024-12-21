package org.example.service;

import org.example.data.ActivityData;
import org.example.data.UserData;
import org.example.enums.IgnoredActivityForLastInteraction;
import org.example.model.Activity;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static java.time.ZoneId.systemDefault;
import static org.example.enums.State.ACTIVE;
import static org.example.enums.State.TO_BE_DELETED;

public class UserOperation {

    private static final Integer DAYS_TO_MARK_USER_FOR_DELETION = 90;

    private final UserData userData;
    private final ActivityData activityData;

    public UserOperation(final UserData userData, final ActivityData activityData) {
        this.userData =  userData;
        this.activityData = activityData;
    }

    public void markInactiveUsersForDeletion(final Date now) {

        final List<Activity> activities = activityData.fetchActivities();

        userData.fetchUsers().stream()
                .filter(user -> ACTIVE == user.getState())
                .forEach(user -> activities.stream()
                        .filter(activity -> activity.getUserId().equals(user.getId()))
                        .filter(this::isConsideredActivityForLastInteraction)
                        .min(this::compareActivitiesBasedOnTimestamp)
                        .ifPresentOrElse(latestActivity -> {
                            if (isLatestActivityBeforeNow(now, latestActivity, DAYS_TO_MARK_USER_FOR_DELETION)) {
                                user.setState(TO_BE_DELETED);
                            }
                        }, () -> user.setState(TO_BE_DELETED)));
    }

    private boolean isLatestActivityBeforeNow(final Date now, final Activity latestActivity, int days) {
        return LocalDateTime.ofInstant(latestActivity.getTimestamp().toInstant(), systemDefault())
                .plusDays(days)
                .isBefore(LocalDateTime.ofInstant(now.toInstant(), systemDefault()));
    }

    private int compareActivitiesBasedOnTimestamp(final Activity activity1, final Activity activity2) {
        return activity2.getTimestamp().compareTo(activity1.getTimestamp());
    }

    private boolean isConsideredActivityForLastInteraction(final Activity activity) {
        return Arrays.stream(IgnoredActivityForLastInteraction.values())
                .noneMatch(ignoredActivity ->
                        activity.getActivity().equalsIgnoreCase(ignoredActivity.getName()));
    }
}