package org.example;

import org.example.data.ActivityData;
import org.example.data.UserData;
import org.example.model.User;
import org.example.service.UserOperation;

import static org.example.enums.State.TO_BE_DELETED;
import static org.example.utils.DateUtil.parseDate;

public class Main {

    /*
    As part of the Data minimisation efforts and GDPR, Tesco wants to implement a system that flags user accounts which are ready to delete based on the below rules. More rules will be introduced later.
If a user has not performed any valid activity within a specified inactivity period (e.g., 90 days), their account is ready for deletion.

Certain activities (e.g., market email interactions) are ignored when deciding the last valid interaction.

User raised a request to delete the account. This could be managed by a flag set at the account level by an external process, which is out of the scope of this exercise.

Input
A list of users, where each user is represented by a unique identifier
A list of activities, where each activity corresponds to an interaction performed by a user (e.g., website login, mobile app login, store purchase, market email interaction, etc.).

Output
A list of users whose accounts are ready for deletion.

Constraints
The input lists can contain up to 10^5 elements.
Timestamps are in ISO 8601 format.
Example

Input

Users
User 1
User 2
User 3




Activities
Activity
User
Time
market email interaction
User 2
2020-07-10 15:00:00.000
market email interaction
User 3
2024-04-20 15:00:00.000
website login
User 1
2024-03-10 15:00:00.000
website login
User 2
2024-04-10 15:00:00.000
mobile app login
User 3
2020-07-10 15:00:00.000

Time now
2024-05-01 11:00:00.000
Output

User 3
has context menu

Inputs:
UserIds
Activity | UserId | Time
Time now
    */
    public static void main(String[] args) {
        final UserData userData = new UserData();
        final ActivityData activityData = new ActivityData();

        new UserOperation(userData, activityData)
                .markInactiveUsersForDeletion(parseDate("2024-05-01T11:00:00.000"));

        System.out.println(userData.fetchUsers().stream()
                .filter(user -> TO_BE_DELETED == user.getState())
                .map(User::getId)
                .toList());
    }
}