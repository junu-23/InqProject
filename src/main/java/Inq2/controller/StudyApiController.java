package Inq2.controller;

import Inq2.domain.CategoryName;
import Inq2.domain.Study;
import Inq2.dto.StudyDTO;
import Inq2.service.StudyService;
import groovy.lang.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class StudyApiController {
    private final StudyService studyService;

    @Autowired
    public StudyApiController(StudyService studyService) {
        this.studyService = studyService;
    }

    // /api/study 경로로 GET 요청 시 스터디 생성 폼 반환
    @GetMapping("/api/study")
    public String createStudyForm() {
        return "create_form";
    }

    @PostMapping("/api/study")
    public String createStudy(StudyDTO studyDTO) {
        studyService.Create(studyDTO);
        return "redirect:/";
    }

    // 카테고리별 스터디 목록 조회
    @GetMapping("/category/{categoryName}")
    public String getStudiesByCategory(@PathVariable("categoryName")
                                       CategoryName category, Model model) {
        List<Study> studies = studyService.getStudiesByCategoryName(category);
        model.addAttribute("studies", studies);
        return "study_list";
    }
}






