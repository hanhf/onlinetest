package com.hanhf.onlinetest.mapper;

import com.hanhf.onlinetest.bean.Test;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface TestMapper {
    int insert(Test test);

    List<Test> findListByUserId(Integer userId);
}
