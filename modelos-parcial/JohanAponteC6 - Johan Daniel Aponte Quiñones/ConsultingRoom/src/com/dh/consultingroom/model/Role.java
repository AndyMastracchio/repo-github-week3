package com.dh.consultingroom.model;

public enum Role {
    ADMIN("ROLE_ADMIN"),
    USER("ROLE_USER");


    private String role;

    Role(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
