package com.jeffy.scanner.dao;

import com.jeffy.scanner.mapper.ItemMapper;
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
public interface ItemDao {
    @SqlQuery("select * from item where id = :id")
    @RegisterMapper(ItemMapper.class)
    Item getById(@Bind("id") int id);

    @SqlQuery("select * from item where name = :name")
    @RegisterMapper(ItemMapper.class)
    Item getByName(@Bind("name") String name);

    @SqlQuery("select * from item")
    @RegisterMapper(ItemMapper.class)
    List<Item> getAll();

    @SqlQuery("select * from item order by :order limit :offset, :length")
    @RegisterMapper(ItemMapper.class)
    List<Item> getPage(@Bind("order") String order, @Bind("offset") int offset, @Bind("length") int length);

    @SqlQuery("select * from item where systemId = :systemId")
    @RegisterMapper(ItemMapper.class)
    List<Item> getSystemItems(@Bind("systemId") int systemId);

    @SqlQuery("select * from item where systemId = :systemId order by :order limit :offset, :length")
    @RegisterMapper(ItemMapper.class)
    List<Item> getSystemItemsForPage(@Bind("systemId") int systemId, @Bind("order") String order, @Bind("offset") int offset, @Bind("length") int length);

    @SqlUpdate("insert into item (name, systemId, object, attribute, delay, period, createTime, updateTime) " +
            "values (:name, :systemId, :object, :attribute, :delay, :period, :createTime, :updateTime)")
    int add(@BindBean Item item);

    @SqlUpdate("update item set name = :name, systemId = :systemId, object = :object, attribute = :attribute, delay = :delay, period = :period, updateTime = :updateTime where id = :id")
    int update(@BindBean Item item);

    @SqlUpdate("delete from item where systemId = :systemId")
    int deleteSystemItems(@Bind("systemId") int systemId);

    @SqlUpdate("delete from item where id = :id")
    int deleteById(@Bind("id") int id);

    @SqlUpdate("delete from item where name = :name")
    int deleteByName(@Bind("name") String name);

    @SqlUpdate("CREATE TABLE IF NOT EXISTS `item` (\n" +
            "  `id` int(8) NOT NULL AUTO_INCREMENT,\n" +
            "  `createTime` datetime DEFAULT NULL,\n" +
            "  `updateTime` datetime DEFAULT NULL,\n" +
            "  `name` varchar(64) DEFAULT NULL,\n" +
            "  `systemId` int(8) DEFAULT NULL,\n" +
            "  `object` varchar(1536) DEFAULT NULL,\n" +
            "  `attribute` varchar(1536) DEFAULT NULL,\n" +
            "  `delay` bigint(20) DEFAULT NULL,\n" +
            "  `period` bigint(20) DEFAULT NULL,\n" +
            "  PRIMARY KEY (`id`)\n" +
            ") ENGINE=InnoDB DEFAULT CHARSET=utf8;\n")
    void createTable();
}
