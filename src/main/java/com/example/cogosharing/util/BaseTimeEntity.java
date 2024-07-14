package com.example.cogosharing.util;


import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@Getter
@MappedSuperclass
public class BaseTimeEntity  {

    @CreatedDate    //생성시 날짜 자동 생성
    @Column(name = "created_date", updatable = false)
    private LocalDateTime createdDate;

    @LastModifiedDate   //수정시 날짜 자동 갱신
    @Column(name = "modified_date", updatable = true)
    private LocalDateTime modifiedDate;
}
