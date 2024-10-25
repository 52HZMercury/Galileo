package com.galileoastronomycommunity.mapper;

import com.galileoastronomycommunity.pojo.Post;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface PostingMapper {
    int addPosting(Post post);
}
