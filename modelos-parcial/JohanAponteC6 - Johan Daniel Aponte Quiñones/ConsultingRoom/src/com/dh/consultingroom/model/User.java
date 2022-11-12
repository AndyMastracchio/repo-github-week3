package com.dh.consultingroom.model;

import lombok.*;

import java.util.regex.*;
import java.util.*;


/**
 * Represents a person
 */
@Getter
@Setter
public abstract class User {

    public int id;
    private String dni;
    private String name;
    private String lastName;
    private String mail;
    private String phone;
    private Role role;

    @Getter(AccessLevel.NONE)
    private static int nextId = 1;
    @Getter(AccessLevel.NONE)
    private String regex = "^(.+)@(.+)$";

    @Getter(AccessLevel.NONE)
    Pattern pattern = Pattern.compile(regex);


    public User() {
    }

    public User(String name, String lastName, String dni, Role role) {
        if (!dni.isBlank()) {
            this.id = nextId;
            this.dni = dni;
            this.name = name;
            this.lastName = lastName;
            this.mail = "Sin Mail";
            this.phone = "Sin número telefónico";
            this.role = role;
        }
        nextId++;
    }

    public void setMail(String mail) {
        Matcher matcher = pattern.matcher(mail);
        if (matcher.find()) {
            this.mail = mail;
        } else {
            System.out.println("Correo no valido");
        }

    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + ": { " +
                "\n\tid=" + id +
                ", \n\tdni='" + dni + '\'' +
                ", \n\tname='" + name + '\'' +
                ", \n\tlastName='" + lastName + '\'' +
                ", \n\tmail='" + mail + '\'' +
                ", \n\tphone='" + phone + '\'' +
                ", \n\trole=" + role +
                "\n}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return dni.equals(user.dni) && mail.equals(user.mail) && phone.equals(user.phone) && role == user.role;
    }

    @Override
    public int hashCode() {
        return Objects.hash(dni, mail, phone, role);
    }
}
