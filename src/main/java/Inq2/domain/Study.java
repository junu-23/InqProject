package Inq2.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.List;

@EntityListeners(AuditingEntityListener.class)
@Entity
@Getter
@Setter
@NoArgsConstructor
public class Study {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", updatable = false)
    private Long id;

    @Column(name= "title", nullable = false, unique = true)
    private String title;

    @Column(name="content", nullable = false)
    private String content;

    @CreatedDate
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;  // LocalDateTime으로 변경

    @LastModifiedDate
    @Column(name="updated_at")
    private LocalDateTime updatedAt;

    @OneToMany(mappedBy = "study")
    private List<Application> applications;

    @OneToMany(mappedBy = "study")
    private List<Comment> comments;

    @OneToMany(mappedBy = "study")
    private List<Member> members;

    @ManyToOne
    @JoinColumn(name="category_id")
    private Category category;

    @Enumerated(EnumType.STRING)
    private CategoryName categoryName;

    //@Column(name = "image_path")
    //private String image; // 이미지







}
