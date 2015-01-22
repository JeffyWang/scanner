package com.jeffy.scanner.mapper;

import com.jeffy.scanner.model.*;
import com.jeffy.scanner.model.System;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 * Created by jeffy on 2015/1/9 0009.
 */
public class SystemMapper implements ResultSetMapper<System> {
    @Override
    public System map(int i, ResultSet resultSet, StatementContext statementContext) throws SQLException {
        return new System(resultSet.getInt("id"), resultSet.getString("name"), resultSet.getString("host"),
                resultSet.getInt("port"), resultSet.getString("status"), resultSet.getTimestamp("createTime"),
                resultSet.getTimestamp("updateTime"));
    }
}
