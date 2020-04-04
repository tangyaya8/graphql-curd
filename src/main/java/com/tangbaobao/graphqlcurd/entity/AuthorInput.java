package com.tangbaobao.graphqlcurd.entity;

import lombok.Data;

import java.util.Date;

/**
 * @author tangxuejun
 * @version 2020/4/4 9:45 下午
 */
@Data
public class AuthorInput {
    private Long id;
    /**
     * 创建时间
     */
    private Date createdTime;
    /**
     * 更新时间
     */
    private Date updatedTime;
    /**
     * firstName
     */
    private String firstName;
    /**
     * lastName
     */
    private String lastName;
}
