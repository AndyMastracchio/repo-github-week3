package com.dh.consultingroom.usersflyweight;

import com.dh.consultingroom.model.Dentist;
import com.dh.consultingroom.model.Patient;
import com.dh.consultingroom.model.Role;
import com.dh.consultingroom.model.User;

import java.util.HashMap;
import java.util.Map;


public class UserFlyweight {

    public static final Map<Integer, User> usersStorage = new HashMap<>();

    /**
     * Checks if a user instance already exists into our users storage if not it stores a new one
     * @params name, lastName, dni, role informtaion that conforms a user
     * @return user instance which can be Dentist or Patient type
     * @author Aponte
     */
    public static User getUserInstance(String name, String lastName, String dni, Role role) {

        Integer key = dni.hashCode();
        User user;

        user = (role.getRole().equals("ROLE_ADMIN")) ?
                usersStorage.getOrDefault(key, new Dentist(name, lastName, dni, role)) :
                usersStorage.getOrDefault(key, new Patient(name, lastName, dni, role));

        usersStorage.put(key, user);
        return user;
    }

    public static User getUserByDni(String dni){
        return usersStorage.get(dni.hashCode());
    }
}
