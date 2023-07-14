package com.shivanshu.user.entity;

public class Contact {
    private Long contact_id;
    private String email;
    private String contactName;
    private Long user_id;

    public Contact(Long contact_id, String email, String contactName, Long user_id) {
        this.contact_id = contact_id;
        this.email = email;
        this.contactName = contactName;
        this.user_id = user_id;
    }

    public Contact() {
    }

    public Long getContact_id() {
        return contact_id;
    }

    public void setContact_id(Long contact_id) {
        this.contact_id = contact_id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }
}
