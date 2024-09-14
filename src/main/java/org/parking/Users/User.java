package org.parking.Users;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {
    private String userId;
    private String name;

    public User(String userId, String name) {
        this.userId= userId;
        this.name = name;
    }
}
