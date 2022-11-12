package com.dh.consultingroom.model;

public class Patient extends User {
    public Patient(){
    }
    public Patient(String name, String lastName, String dni, Role role) {
        super(name, lastName, dni, role);
    }
}
