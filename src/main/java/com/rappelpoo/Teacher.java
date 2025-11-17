package com.rappelpoo;

import java.time.LocalDateTime;
import lombok.Getter;

@Getter
public class Teacher extends User {
    private String speciality;
    public Teacher(int id, String firstName, String lastName, LocalDateTime birthDate, String email,
            String phoneNumber, String speciality) {
        super(id, firstName, lastName, birthDate, email, phoneNumber);
        this.speciality = speciality;
    }
}
