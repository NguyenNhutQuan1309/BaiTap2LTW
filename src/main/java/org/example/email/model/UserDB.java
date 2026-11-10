package org.example.email.model;

import java.util.ArrayList;
import java.util.List;

public class UserDB {

    // Danh sach luu thong tin nguoi dung
    private static final List<User> users = new ArrayList<>();

    // Them nguoi dung vao danh sach
    public static synchronized void insert(User user) {
        users.add(user);
    }

    // Lay toan bo danh sach nguoi dung
    public static synchronized List<User> getAll() {
        return new ArrayList<>(users);
    }
}
