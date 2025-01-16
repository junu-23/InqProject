package Inq2.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;
import java.time.LocalDateTime;



@Getter
@Setter
public class StudyDTO {
    private String title;
    private String content;
    private LocalDateTime createdAt;
    private String categoryName;
    private MultipartFile image; // 업로드된 이미지 파일

    //private Long categoryId;

}
