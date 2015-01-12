package com.jeffy.scanner.mapper;

import com.jeffy.scanner.model.Item;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Administrator on 2015/1/10.
 */
public class ItemMapper implements ResultSetMapper<Item> {
    @Override
    public Item map(int i, ResultSet resultSet, StatementContext statementContext) throws SQLException {
        return new Item(resultSet.getInt("id"), resultSet.getString("name"), resultSet.getInt("systemId"),
                resultSet.getString("object"), resultSet.getString("attribute"), resultSet.getLong("delay"),
                resultSet.getLong("period"), resultSet.getTimestamp("createTime"), resultSet.getTimestamp("updateTime"));
    }
}
