package com.jeffy.scanner.dao;

import com.jeffy.scanner.mapper.DataMapper;
import com.jeffy.scanner.model.Data;
import com.jeffy.scanner.model.Item;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.BindBean;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

import java.util.List;

/**
 * Created by Jeffy on 2015/1/12 0012.
 */
public interface DataDao {
    @SqlQuery("select * from item where itemId = :itemId")
    @RegisterMapper(DataMapper.class)
    List<Data> getItemData(@Bind("itemId") int itemId);

    @SqlQuery("select * from item where createTime between :startTime and :endTime")
    @RegisterMapper(DataMapper.class)
    List<Data> getItemDataForPeriod(@Bind("itemId") int itemId, @Bind("startTime") String startTime, @Bind("endTime") String endTime);

    @SqlUpdate("insert into data (monitorKey, monitorValue, itemId, createTime, updateTime) values (:monitorKey, :monitorValue, :itemId, :createTime, :updateTime)")
    int add(@BindBean Data data);

    @SqlUpdate("delete form data where id = :id")
    int delete(@Bind("id") int id);

    @SqlUpdate("CREATE TABLE IF NOT EXISTS `data` (\n" +
            "  `id` int(8) NOT NULL AUTO_INCREMENT,\n" +
            "  `createTime` datetime DEFAULT NULL,\n" +
            "  `updateTime` datetime DEFAULT NULL,\n" +
            "  `monitorKey` varchar(1024) DEFAULT NULL,\n" +
            "  `monitorValue` varchar(1024) DEFAULT NULL,\n" +
            "  `itemId` int(8) DEFAULT NULL,\n" +
            "  PRIMARY KEY (`id`)\n" +
            ") ENGINE=InnoDB DEFAULT CHARSET=utf8;")
    void createTable();
}
