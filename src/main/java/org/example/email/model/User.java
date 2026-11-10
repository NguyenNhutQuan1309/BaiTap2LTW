package org.example.email.model;

import java.io.Serializable;

public class User implements Serializable {

    // 1. Thong tin ca nhan
    private String firstName;
    private String lastName;
    private String email;
    private String dateOfBirth;

    // 2. Nguon biet den website
    private String hearAboutUs;

    // 3. Lua chon nhan thong bao
    private boolean emailAnnouncements;
    private boolean postalAnnouncements;

    // 4. Phuong thuc lien he
    private String contact;

    // Constructor mac dinh
    public User() {
    }

    // Constructor day du tham so
    public User(String firstName, String lastName,
                String email, String dateOfBirth,
                String hearAboutUs,
                boolean emailAnnouncements,
                boolean postalAnnouncements,
                String contact) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
        this.hearAboutUs = hearAboutUs;
        this.emailAnnouncements = emailAnnouncements;
        this.postalAnnouncements = postalAnnouncements;
        this.contact = contact;
    }

    // Getter va Setter cho First Name
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    // Getter va Setter cho Last Name
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    // Getter va Setter cho Email
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // Getter va Setter cho Date of Birth
    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    // Getter va Setter cho Hear About Us
    public String getHearAboutUs() {
        return hearAboutUs;
    }

    public void setHearAboutUs(String hearAboutUs) {
        this.hearAboutUs = hearAboutUs;
    }

    // Getter va Setter cho Email Announcements
    public boolean isEmailAnnouncements() {
        return emailAnnouncements;
    }

    public void setEmailAnnouncements(boolean emailAnnouncements) {
        this.emailAnnouncements = emailAnnouncements;
    }

    // Getter va Setter cho Postal Announcements
    public boolean isPostalAnnouncements() {
        return postalAnnouncements;
    }

    public void setPostalAnnouncements(boolean postalAnnouncements) {
        this.postalAnnouncements = postalAnnouncements;
    }

    // Getter va Setter cho Contact
    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    // Chuyen ma nguon thanh ten hien thi
    public String getHearAboutUsText() {

        if ("searchEngine".equals(hearAboutUs)) {
            return "Search engine";
        } else if ("wordOfMouth".equals(hearAboutUs)) {
            return "Word of mouth";
        } else if ("socialMedia".equals(hearAboutUs)) {
            return "Social Media";
        } else if ("other".equals(hearAboutUs)) {
            return "Other";
        }

        return "Not selected";
    }

    // Chuyen ma contact thanh ten hien thi
    public String getContactText() {

        if ("emailOrPostal".equals(contact)) {
            return "Email or postal mail";
        } else if ("emailOnly".equals(contact)) {
            return "Email only";
        } else if ("postalOnly".equals(contact)) {
            return "Postal mail only";
        }

        return "Not selected";
    }
}
