package com.rappelpoo;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Course {
    private int id;
    private String label;
    private int credits;
    private Teacher teacher;
    private List<Exam> exams;
}
