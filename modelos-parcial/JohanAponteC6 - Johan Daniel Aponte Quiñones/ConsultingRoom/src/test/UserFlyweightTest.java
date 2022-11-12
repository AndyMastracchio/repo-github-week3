package test;

import com.dh.consultingroom.model.Role;
import com.dh.consultingroom.model.User;
import com.dh.consultingroom.usersflyweight.UserFlyweight;


import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UserFlyweightTest {


    @Test
    @DisplayName("Checks not replied objects")
    public void testUserFlyweight(){
        User paciente1 = UserFlyweight.getUserInstance("Johan", "Aponte", "1013666999", Role.USER);
        paciente1.setMail("usuario1@gmail.com");
        paciente1.setPhone("3222730000");

        User paciente2 = UserFlyweight.getUserInstance("Jorg", "Gómez", "1013777101", Role.USER);
        paciente2.setMail("usuario2@gmail.com");
        paciente2.setPhone("3222731111");

        User paciente3 = UserFlyweight.getUserInstance("John", "Aponte", "1013555888", Role.USER);
        paciente3.setMail("usuario3@gmail.com");
        paciente3.setPhone("3222732222");

        User paciente4 = UserFlyweight.getUserInstance("Johan", "Aponte", "1013666999", Role.USER);
        paciente1.setMail("usuario1@gmail.com");
        paciente1.setPhone("3222730000");

        User paciente5 = UserFlyweight.getUserInstance("Jorg", "Gómez", "1013777101", Role.USER);
        paciente2.setMail("usuario2@gmail.com");
        paciente2.setPhone("3222731111");

        User paciente6 = UserFlyweight.getUserInstance("John", "Aponte", "1013555888", Role.USER);
        paciente3.setMail("usuario3@gmail.com");
        paciente3.setPhone("3222732222");

        assertEquals(UserFlyweight.usersStorage.size(),3);
    }


    @Test
    @Disabled("Not implemented yet")
    @DisplayName("Checks if a user exists")
    public void isUserPresent(){
        User paciente1 = UserFlyweight.getUserInstance("Johan", "Aponte", "1013666999", Role.USER);
        paciente1.setMail("usuario1@gmail.com");
        paciente1.setPhone("3222730000");

        assertEquals(UserFlyweight.getUserByDni("1013666999"),paciente1);
    }


    @Test
    @DisplayName("Checks if a user exists")
    public void isNotUserPresent(){
        User paciente1 = UserFlyweight.getUserInstance("Johan", "Aponte", "1013666999", Role.USER);
        paciente1.setMail("usuario1@gmail.com");
        paciente1.setPhone("3222730000");

        assertNull(UserFlyweight.getUserByDni("2013666999"));
    }
}