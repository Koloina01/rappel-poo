package com.rappelpoo;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Comparator;

import lombok.Getter;

@Getter
public class Student extends User {
    private String group;
    private Tutor tutor;

    public Student(int id, String firstName, String lastName, LocalDateTime birthDate, String email,
            String phoneNumber, String group, Tutor tutor) {
        super(id, firstName, lastName, birthDate, email, phoneNumber);
        this.tutor = tutor;
        this.group = group;
    }

    public double getExamGrade(Exam exam, Instant t) {
        return exam.getNotes()
                .stream()
                .filter(grade -> grade.getStudent().equals(this))
                .findFirst()
                .map(grade -> grade.getGradeHistories().stream()
                        .filter(history -> history.getStartDate().isBefore(t))
                        .max(Comparator.comparing(GradeHistory::getStartDate))
                        .map(GradeHistory::getNewValue)
                        .orElse(grade.getInitialNote()))
                .orElse(0.0);
    }

    public double getWeightedExamGrade(Exam exam, Instant t) {
        return getExamGrade(exam, t) * exam.getCoefficient();
    }

    public int getTotalCoefficients(Course course) {
        return course.getExams()
                .stream()
                .mapToInt(Exam::getCoefficient)
                .sum();
    }

    public double getWeightedSum(Course course, Instant t) {
        return course.getExams()
                .stream()
                .mapToDouble(exam -> getWeightedExamGrade(exam, t))
                .sum();
    }

    public double getCourseGrade(Course course, Instant t) {
        int totalCoef = getTotalCoefficients(course);

        if (totalCoef == 0) {
            return 0.0;
        };
        return getWeightedSum(course, t) / totalCoef;
    }

}
