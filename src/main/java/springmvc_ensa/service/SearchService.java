package springmvc_ensa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springmvc_ensa.helpers.dtos.SearchResponse;
import springmvc_ensa.repository.AdminRepo;
import springmvc_ensa.repository.CourseRepo;
import springmvc_ensa.repository.ProfRepo;
import springmvc_ensa.repository.StudentRepo;

@Service
public class SearchService {
    private final ProfRepo profRepo;
    private final StudentRepo studentRepo;
    private final CourseRepo courseRepo;
    private final AdminRepo adminRepo;

    @Autowired
    public SearchService(ProfRepo profRepo, StudentRepo studentRepo, CourseRepo courseRepo, AdminRepo adminRepo) {
        this.profRepo = profRepo;
        this.studentRepo = studentRepo;
        this.courseRepo = courseRepo;
        this.adminRepo = adminRepo;
    }


    public SearchResponse search(String query) {
        return  new SearchResponse(
                this.studentRepo.searchByNameOrDescription(query),
                this.profRepo.searchByNameOrDescription(query),
                this.adminRepo.searchByNameOrDescription(query)
        );
    }
}
