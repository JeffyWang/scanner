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

    @SqlQuery("select * from system order by :order limit :offset, :length")
    @RegisterMapper(SystemMapper.class)
    List<System> getPage(@Bind("order") String order, @Bind("offset") int offset, @Bind("length") int length);

    @SqlUpdate("insert into system (name, host, port, status, createTime, updateTime) values (:name, :host, :port, :status, :createTime, :updateTime)")
    int add(@BindBean System system);

    @SqlUpdate("update system set name = :name, host = :host, port = :port, status = :status, updateTime = :updateTime where id = :id")
    int update(@BindBean System system);

    @SqlUpdate("delete from system where id = :id")
    int deleteById(@Bind("id") int id);

    @SqlUpdate("delete from system where name = :name")
    int deleteByName(@Bind("name") String name);

    @SqlUpdate("CREATE TABLE IF NOT EXISTS `system` (\n" +
            "  `id` int(8) NOT NULL AUTO_INCREMENT,\n" +
            "  `createTime` datetime DEFAULT NULL,\n" +
            "  `updateTime` datetime DEFAULT NULL,\n" +
            "  `name` varchar(64) DEFAULT NULL,\n" +
            "  `host` varchar(32) DEFAULT NULL,\n" +
            "  `port` int(8) DEFAULT NULL,\n" +
            "  `status` int(8) DEFAULT NULL,\n" +
            "  PRIMARY KEY (`id`),\n" +
            "  UNIQUE KEY `name` (`name`)\n" +
            ") ENGINE=InnoDB AUTO_INCREMENT=79 DEFAULT CHARSET=utf8;")
    void createTable();
}
