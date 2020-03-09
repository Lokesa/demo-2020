package com.example.demo.dao;

import com.example.demo.entity.Entity;
import com.example.demo.sql.UserSqlProvider;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.StatementType;

import java.util.List;
public interface HelloDao {
    @Select("select id,username,password from USERS")
    @Results(id="Entity", value={
            @Result(property="id",   column="id"),
            @Result(property="username",  column="username"),
            @Result(property="password", column="password"),
    })
    List<Entity>  getList();

    /*@SelectProvider(type = UserSqlProvider.class, method = "getAll")*/
    @Select("call getAll();")
    @Options(statementType = StatementType.CALLABLE)
    List<Entity> getAll();

    @Select("call getOne(" +
            "#{id});")
    @Options(statementType = StatementType.CALLABLE)
    List<Entity> getOne(@Param("id") String id);

}
