package com.tangbaobao.graphqlcurd.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

/**
 * (Author)实体类
 *
 * @author makejava
 * @since 2020-04-04 21:15:01
 */
@Entity
@Data
public class Author {
    /**
     * 主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /**
     * 创建时间
     */
    private LocalDateTime createdTime;
    /**
     * 更新时间
     */
    private LocalDateTime updatedTime;
    /**
     * firstName
     */
    private String firstName;
    /**
     * lastName
     */
    private String lastName;

}