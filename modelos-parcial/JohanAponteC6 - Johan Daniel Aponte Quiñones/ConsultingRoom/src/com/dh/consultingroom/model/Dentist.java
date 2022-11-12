package com.dh.consultingroom.model;

public class Dentist extends User {

    public Dentist(){

    }
    public Dentist(String name, String lastName, String dni, Role role) {
        super(name, lastName, dni, role);
    }
}
