package com.rappelpoo;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Grades {
    private Student student;
    private double initialNote;
    private List<GradeHistory> gradeHistories;
}
