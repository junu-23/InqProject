package Inq2;

import Inq2.domain.Category;
import Inq2.domain.CategoryName;
import Inq2.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

// 데이터베이스에 초기 데이터 삽입 해주는 역할.
@Component
public class CategoryDataInitializer {

    @Autowired
    private CategoryRepository categoryRepository;

    @PostConstruct
    public void init() {
        // 이미 데이터가 존재하지 않으면 데이터 삽입(중복방지)
        if (categoryRepository.count() == 0) {
            categoryRepository.save(new Category(CategoryName.SCHOOL, "SCHOOL"));
            categoryRepository.save(new Category(CategoryName.LANGUAGE, "LANGUAGE"));
            categoryRepository.save(new Category(CategoryName.ETC, "ETC"));
            categoryRepository.save(new Category(CategoryName.CSAT, "CSAT"));
            categoryRepository.save(new Category(CategoryName.CSE, "CSE"));
        }
    }
}

