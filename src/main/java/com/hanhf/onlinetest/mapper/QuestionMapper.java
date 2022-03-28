package com.hanhf.onlinetest.mapper;

import com.hanhf.onlinetest.bean.Question;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface QuestionMapper {
    int insert(Question question);

    int delete(Integer id);

    int update(Question question);

    Question findById(Integer id);

    List<Question> findList();

    List<Question> findListByCondition(Question question);
}
