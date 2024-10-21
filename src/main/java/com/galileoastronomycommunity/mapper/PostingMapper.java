package com.galileoastronomycommunity.mapper;

import com.galileoastronomycommunity.pojo.Posting;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface PostingMapper {
    int addPosting(Posting posting);
}
