package com.brights.zwitscher.user;

import java.util.List;

public class UserCollection {
    List<User> userList;

    public UserCollection(List<User> userList) {
        this.userList = userList;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }
}