package Inq2.repository;

import Inq2.domain.Category;
import Inq2.domain.CategoryName;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    // 카테고리 엔티티에서 CategoryName 기준으로 카테고리를 조회한다.
    Optional<Category> findByCategoryName(CategoryName categoryName);
}
