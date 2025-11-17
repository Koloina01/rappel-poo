package com.rappelpoo;

import java.time.LocalDateTime;
import lombok.Getter;
import lombok.AllArgsConstructor;

@Getter
@AllArgsConstructor
public abstract class User {
    protected int id;
    protected String firstName;
    protected String lastName;
    protected LocalDateTime birthDate;
    protected String email;
    protected String phoneNumber;
    
}
