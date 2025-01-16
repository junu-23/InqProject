package Inq2.repository;

import Inq2.domain.Category;

import Inq2.domain.CategoryName;
import Inq2.domain.Study;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudyRepository extends JpaRepository<Study, Long> {
    // 카테고리 이름을 기준으로 스터디 목록 조회
    List<Study> findByCategory_CategoryName(CategoryName categoryName);
}

