package com.ziggle.dao;


import com.ziggle.modules.User;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

@Component
public interface StudentDao {
    @Select("select * from user where id = #{id}")
    User selectUser(int id);
}
