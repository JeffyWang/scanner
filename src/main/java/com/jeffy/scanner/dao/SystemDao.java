package com.jeffy.scanner.dao;

import com.jeffy.scanner.mapper.SystemMapper;
import com.jeffy.scanner.model.*;
import com.jeffy.scanner.model.System;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.BindBean;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

/**
 * Created by jeffy on 2015/1/9 0009.
 */
public interface SystemDao {
    @SqlQuery("select * from system where id = :id")
    @RegisterMapper(SystemMapper.class)
    System getById(@Bind("id") int id);

    @SqlUpdate("insert into system (name, host, port, createTime, updateTime) values (:name, :host, :port, :createTime, :updateTime)")
    int add(@BindBean System system);
}
