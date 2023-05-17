package springmvc_ensa.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import springmvc_ensa.helpers.Role;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
public class Prof {
//
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name = "id")
private Long id;
    private String username;
    private String email;
    private String description;

    @Enumerated(EnumType.STRING)
    private final Role role=Role.PROF;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JsonIgnore
    @JoinTable(name = "prof_student",
            joinColumns = @JoinColumn(name = "prof_id"),
            inverseJoinColumns = @JoinColumn(name = "student_id"))
    private List<Student> students=new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "prof")
    private List<Course> courses = new ArrayList<>();

    public Prof(String username, String email, String description) {
        this.username = username;
        this.email = email;
        this.description = description;
    }

    public Prof() {
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


    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }


}
