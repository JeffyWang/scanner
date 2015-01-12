package com.jeffy.scanner.dao;

import com.jeffy.scanner.mapper.SystemMapper;
import com.jeffy.scanner.model.*;
import com.jeffy.scanner.model.System;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.BindBean;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

import java.util.List;

/**
 * Created by jeffy on 2015/1/9 0009.
 */
public interface SystemDao {
    @SqlQuery("select * from system where id = :id")
    @RegisterMapper(SystemMapper.class)
    System getById(@Bind("id") int id);

    @SqlQuery("select * from system where name = :name")
    @RegisterMapper(SystemMapper.class)
    System getByName(@Bind("name") String name);

    @SqlQuery("select * from system")
    @RegisterMapper(SystemMapper.class)
    List<System> getAll();

    @SqlUpdate("insert into system (name, host, port, createTime, updateTime) values (:name, :host, :port, :createTime, :updateTime)")
    int add(@BindBean System system);

    @SqlUpdate("update system set name = :name, host = :host, port = :port, updateTime = :updateTime")
    int update(@BindBean System system);

    @SqlUpdate("delete from system where id = :id")
    int deleteById(@Bind("id") int id);

    @SqlUpdate("delete from system where name = :name")
    int deleteByName(@Bind("name") String name);
}
