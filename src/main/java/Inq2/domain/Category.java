package Inq2.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", updatable = false)

    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "categoryName")
    private CategoryName categoryName;

    @OneToMany(mappedBy = "category")
    private List<Study> studies;

    // 기존 생성자에서 접근 제한을 public으로 수정 : 외부에서 사용 가능하게.
    public Category(CategoryName categoryName, String name) {
        this.categoryName = categoryName;
    }


}
