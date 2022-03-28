package com.hanhf.onlinetest.mapper;

import com.hanhf.onlinetest.bean.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface UserMapper {
    int insert(User user);

    int delete(Integer id);

    int update(User user);

    User findById(Integer id);

    User findByName(String name);

    List<User> findList();

    List<User> findListByCondition(User user);
}
