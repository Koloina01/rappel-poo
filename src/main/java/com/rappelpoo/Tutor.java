package com.rappelpoo;

import java.time.LocalDateTime;
import lombok.Getter;


@Getter
public class Tutor extends User {
    private String relationWithStudent;
    public Tutor(int id, String firstName, String lastName, LocalDateTime birthDate, String email,
            String phoneNumber, String relationWithStudent) {
        super(id, firstName, lastName, birthDate, email, phoneNumber);
        this.relationWithStudent = relationWithStudent;
    }
}
