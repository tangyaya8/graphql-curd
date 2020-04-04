package com.tangbaobao.graphqlcurd.repository;

import com.tangbaobao.graphqlcurd.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author tangxuejun
 * @version 2020/4/4 9:19 下午
 */
public interface AuthorRepo extends JpaRepository<Author,Long> {

}
