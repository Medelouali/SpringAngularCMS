package springmvc_ensa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springmvc_ensa.entities.Mark;
import springmvc_ensa.repository.MarkRepo;

import java.util.List;

@Service
public class MarkService {
    private final MarkRepo markRepo;

    @Autowired
    public MarkService(MarkRepo markRepo) {
        this.markRepo = markRepo;
    }

    public List<Mark> getMarks() {
        return this.markRepo.findAll();
    }
}
