package Inq2.service;

import Inq2.domain.Category;
import Inq2.domain.CategoryName;
import Inq2.domain.Study;
import Inq2.dto.StudyDTO;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;

import Inq2.repository.CategoryRepository;
import Inq2.repository.StudyRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class StudyService {

    @Autowired
    private FileService fileService;

    private final StudyRepository studyRepository;
    private final CategoryRepository categoryRepository;

    // 스터디 만드는 메서드
    public void Create(StudyDTO studyDTO) {
        // 카테고리 이름으로 카테고리 찾기
        Category category = categoryRepository.findByCategoryName(CategoryName.valueOf(studyDTO.getCategoryName().toUpperCase()))
                .orElseThrow(() -> new IllegalArgumentException("Category not found"));
        /*
        // 사진 파일 저장
        String image = null;
        if (studyDTO.getImage() != null && !studyDTO.getImage().isEmpty()) {
            String fileName = UUID.randomUUID().toString() + "_" + studyDTO.getImage().getOriginalFilename();
            Path path = Paths.get("uploads/" + fileName);
            try {
                Files.createDirectories(path.getParent());
                Files.write(path, studyDTO.getImage().getBytes());
                image = path.toString(); // 저장된 경로
            } catch (IOException e) {
                throw new RuntimeException("Failed to save image", e);
            }
        }
         */

        // 스터디 생성
        Study s = new Study();
        s.setTitle(studyDTO.getTitle());
        s.setContent(studyDTO.getContent());
        s.setCreatedAt(LocalDateTime.now());  // 현재 시간 설정
        s.setCategory(category); // 해당 카테고리 설정
        studyRepository.save(s); // 스터디 저장
    }


    // 카테고리 이름으로 스터디 조회
    public List<Study> getStudiesByCategoryName(CategoryName categoryName) {
        return studyRepository.findByCategory_CategoryName(categoryName);
    }

}






