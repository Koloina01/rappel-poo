package com.rappelpoo;

import java.time.Instant;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Exam {
    private int id;
    private String title;
    private Instant date;
    private int coefficient;
    private List<Grades> notes;
}
