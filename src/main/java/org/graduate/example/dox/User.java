package org.graduate.example.dox;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.ReadOnlyProperty;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;


import java.time.LocalDateTime;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table("my_user")
public class User {
    public static final String ROLE_STUDENT = "qpCf";
    public static final String ROLE_TEACHER = "kU4T";
    public static final String ROLE_ADMIN = "R2md";
    @Id
    @CreatedBy
    private String id;
    private String name;
    @Column("number")
    private String account;
    private String password;
    private String role;
    @Column("department_id")
    private String department;
    @Column("group_number")
    private Integer groupNumber;
    private String teacher;
    private String student;
    @ReadOnlyProperty
    @Column("insert_time")
    private LocalDateTime createTime;
    @ReadOnlyProperty
    @Column("update_time")
    private LocalDateTime updateTime;
}
