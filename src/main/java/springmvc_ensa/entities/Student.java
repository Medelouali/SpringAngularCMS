package springmvc_ensa.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import springmvc_ensa.helpers.Role;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    private String username;
    private String email;
    private String description;

    @Enumerated(EnumType.STRING)
    private final Role role=Role.STUDENT;

    @JsonManagedReference
    @JsonBackReference
    @ManyToMany(mappedBy = "students", cascade = CascadeType.PERSIST)
    private List<Prof> profs=new ArrayList<>();

    @ManyToMany
    @JsonIgnore
    @JoinTable(name = "student_course",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id"))
    private List<Course> courses;

    @OneToMany(mappedBy = "student")
    private List<Mark> marks;

    public Student(Long id, String username, String email, List<Prof> profs, List<Course> courses, List<Mark> marks) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.profs = profs;
        this.courses = courses;
        this.marks = marks;
    }

    public Student(String username, String email, String description) {
        this.username = username;
        this.email = email;
        this.description = description;
    }

    public Student() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Role getRole() {
        return role;
    }


    public List<Prof> getProfs() {
        return profs;
    }

    public void setProfs(List<Prof> profs) {
        this.profs = profs;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public List<Mark> getMarks() {
        return marks;
    }

    public void setMarks(List<Mark> marks) {
        this.marks = marks;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


}
