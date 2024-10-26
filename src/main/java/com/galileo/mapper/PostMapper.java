package com.galileo.mapper;

import com.galileo.pojo.Post;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface PostMapper {
    int addPost(Post post);
    void addPostContent(Post post);
}
