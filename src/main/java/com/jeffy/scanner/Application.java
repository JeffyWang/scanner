package com.jeffy.scanner;

import com.jeffy.scanner.dao.SystemDao;
import com.jeffy.scanner.resource.SystemResource;
import com.jeffy.scanner.service.SystemService;
import io.dropwizard.assets.AssetsBundle;
import io.dropwizard.jdbi.DBIFactory;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.skife.jdbi.v2.DBI;

/**
 * Created by jeffy on 2015/1/9 0009.
 */
public class Application extends io.dropwizard.Application<Configuration> {
    public static void main(String[] args) throws Exception {
        new Application().run(args);
    }

    @Override
    public void initialize(Bootstrap<Configuration> bootstrap) {
        bootstrap.addBundle(new AssetsBundle("/static", "/portal", null, null));
    }

    @Override
    public void run(Configuration configuration, Environment environment) throws Exception {
        //databases init
        final DBIFactory factory = new DBIFactory();
        final DBI dbi = factory.build(environment, configuration.getDataSourceFactory(), "mysql");

        //init dao
        final SystemDao systemDao = dbi.onDemand(SystemDao.class);

        //init service
        SystemService systemService = new SystemService(systemDao);

        //resource
        environment.jersey().register(new SystemResource(systemService));
    }
}
