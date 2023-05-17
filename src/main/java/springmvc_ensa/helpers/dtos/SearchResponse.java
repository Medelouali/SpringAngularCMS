package springmvc_ensa.helpers.dtos;

import springmvc_ensa.entities.Admin;
import springmvc_ensa.entities.Prof;
import springmvc_ensa.entities.Student;

import java.util.List;

public class SearchResponse {
    private List<Student> students;
    private List<Prof> profs;
    private List<Admin> admins;

    public SearchResponse(List<Student> students, List<Prof> profs, List<Admin> admins) {
        this.students = students;
        this.profs = profs;
        this.admins = admins;
    }

    public SearchResponse() {
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public List<Prof> getProfs() {
        return profs;
    }

    public void setProfs(List<Prof> profs) {
        this.profs = profs;
    }

    public List<Admin> getAdmins() {
        return admins;
    }

    public void setAdmins(List<Admin> admins) {
        this.admins = admins;
    }
}
