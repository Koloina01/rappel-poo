import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.rappelpoo.*;

public class StudentTest {

    private Student student;
    private Course course;
    private Exam exam1;
    private Exam exam2;
    private Grades grades1;
    private Grades grades2;

    @BeforeEach
    public void setUp() {
        Tutor tutor = new Tutor(1, "LINDCY", "Samoina", LocalDateTime.of(1999, 12, 1, 0, 0),
                "samoina@gmail.com", "0123456789", "Tutor");

        student = new Student(1, "MAHERISON", "Koloina Vatosoa", LocalDateTime.of(2005, 1, 15, 0, 0),
                "koloina@gmail.com", "0987654321", "K3", tutor);

        exam1 = new Exam(1, "PROG1 2nd exam", Instant.parse("2025-11-10T10:00:00Z"), 2, new ArrayList<>());
        exam2 = new Exam(2, "PROG1 last exam", Instant.parse("2025-11-12T10:00:00Z"), 3, new ArrayList<>());

        List<GradeHistory> histories1 = new ArrayList<>();
        histories1.add(new GradeHistory(Instant.parse("2025-11-05T10:00:00Z"), 10.0, "Correction"));

        List<GradeHistory> histories2 = new ArrayList<>();
        histories2.add(new GradeHistory(Instant.parse("2025-11-11T10:00:00Z"), 12.0, "Bonus points"));

        grades1 = new Grades(student, 10.0, histories1);
        grades2 = new Grades(student, 11.0, histories2);

        exam1.getNotes().add(grades1);
        exam2.getNotes().add(grades2);

        List<Exam> exams = new ArrayList<>();
        exams.add(exam1);
        exams.add(exam2);

        Teacher teacher = new Teacher(2, "RAMAROZAKA", "Tokimahery", LocalDateTime.of(1975, 3, 20, 0, 0),
                "toky@gmail.com", "0112233445", "Programming");

        course = new Course(1, "Prog2", 6, teacher, exams);
    }

    @Test
    public void testGetExamGrade() {
        double gradeBefore = student.getExamGrade(exam1, Instant.parse("2025-11-01T10:00:00Z"));
        assertEquals(10.0, gradeBefore);

        double gradeAfter = student.getExamGrade(exam1, Instant.parse("2025-11-06T10:00:00Z"));
        assertEquals(10.0, gradeAfter);
    }

    @Test
    public void testGetWeightedExamGrade() {
        double weighted = student.getWeightedExamGrade(exam1, Instant.parse("2025-11-06T10:00:00Z"));
        assertEquals(20.0, weighted);
    }
    @Test
    public void testGetTotalCoefficients() {
        int totalCoef = student.getTotalCoefficients(course);
        assertEquals(5, totalCoef);
    }

    @Test
    public void testGetWeightedSum() {
        double weightedSum = student.getWeightedSum(course, Instant.parse("2025-11-13T10:00:00Z"));
        assertEquals(56.0, weightedSum);
    }

    @Test
    public void testGetCourseGrade() {
        double courseGrade = student.getCourseGrade(course, Instant.parse("2025-11-13T10:00:00Z"));
        assertEquals(11.2, courseGrade, 0.0001);
    }

    @Test
    public void testNoGrades() {
        Exam emptyExam = new Exam(3, "Empty Exam", Instant.now(), 1, new ArrayList<>());
        assertEquals(0.0, student.getExamGrade(emptyExam, Instant.now()));
    }
}

