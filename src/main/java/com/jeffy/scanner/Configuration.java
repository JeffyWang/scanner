package com.jeffy.scanner;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.db.DataSourceFactory;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * Created by jeffy on 2015/1/9 0009.
 */
public class Configuration extends io.dropwizard.Configuration {
    @NotEmpty
    private String defaultName;
    @Valid
    @NotNull
    @JsonProperty("database")
    private DataSourceFactory database = new DataSourceFactory();

    public String getDefaultName() {
        return defaultName;
    }

    public DataSourceFactory getDataSourceFactory() {
        return database;
    }
}
