package com.jeffy.scanner.dao;

import com.jeffy.scanner.mapper.ItemMapper;
import com.jeffy.scanner.model.Item;
import org.skife.jdbi.v2.sqlobject.Bind;
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
