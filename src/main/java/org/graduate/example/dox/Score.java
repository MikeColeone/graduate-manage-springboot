package org.graduate.example.dox;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table("my_process_score")
public class Score {
    @CreatedBy
    @Id
    private String id;//自己生成
    private String studentId;
    private String processId;
    private Integer group;
    private String teacher;
    private String processName;
    private String detail;
}