package com.jeffy.scanner.mapper;

import com.jeffy.scanner.model.Data;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Administrator on 2015/1/10.
 */
public class DataMapper implements ResultSetMapper<Data> {
    @Override
    public Data map(int i, ResultSet resultSet, StatementContext statementContext) throws SQLException {
        return new Data(resultSet.getInt("id"), resultSet.getString("monitorKey"), resultSet.getString("monitorValue"),
                resultSet.getInt("itemId"), resultSet.getTimestamp("createTime"), resultSet.getTimestamp("updateTime"));
    }
}
