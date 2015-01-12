package com.jeffy.scanner.dao;

import org.skife.jdbi.v2.sqlobject.SqlUpdate;

/**
 * Created by Jeffy on 2015/1/12 0012.
 */
public interface DataDao {
    @SqlUpdate("CREATE TABLE IF NOT EXISTS `data` (\n" +
            "  `id` int(8) NOT NULL AUTO_INCREMENT,\n" +
            "  `createTime` datetime DEFAULT NULL,\n" +
            "  `updateTime` datetime DEFAULT NULL,\n" +
            "  `key` varchar(128) DEFAULT NULL,\n" +
            "  `value` varchar(128) DEFAULT NULL,\n" +
            "  `itemId` int(8) DEFAULT NULL,\n" +
            "  PRIMARY KEY (`id`)\n" +
            ") ENGINE=InnoDB DEFAULT CHARSET=utf8;")
    void createTable();
}
