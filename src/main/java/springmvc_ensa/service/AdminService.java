package springmvc_ensa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import springmvc_ensa.entities.Admin;
import springmvc_ensa.entities.Prof;
import springmvc_ensa.helpers.dtos.NewUserDto;
import springmvc_ensa.repository.AdminRepo;
import springmvc_ensa.repository.ProfRepo;

import java.util.List;
import java.util.Optional;

@Service
public class AdminService {
    private final AdminRepo adminRepo;
    private final ProfRepo profRepo;

    @Autowired
    public AdminService(AdminRepo adminRepo, ProfRepo profRepo) {
        this.adminRepo = adminRepo;
        this.profRepo=profRepo;
    }

    public List<Admin> getAdmins() {
        return this.adminRepo.findAll();
    }

    public Admin deleteAdmin(long id) {
        Optional<Admin> optionalAdmin = adminRepo.findById(id);
        if (optionalAdmin.isPresent()) {
            Admin admin = optionalAdmin.get();
            adminRepo.deleteById(id);
            return admin;
        }
        return null;
    }
}
