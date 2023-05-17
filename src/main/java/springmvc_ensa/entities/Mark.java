package springmvc_ensa.entities;

import javax.persistence.*;

@Entity
@Table
public class Mark {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    private String note;
    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

    public Mark(Long id, Student student, Course course, double markValue) {
        this.id = id;
        this.student = student;
        this.course = course;
        this.markValue = markValue;
    }

    public Mark() {
    }

    private double markValue;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public double getMarkValue() {
        return markValue;
    }

    public void setMarkValue(double markValue) {
        this.markValue = markValue;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
