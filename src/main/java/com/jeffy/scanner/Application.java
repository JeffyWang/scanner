package com.jeffy.scanner;

import com.jeffy.scanner.dao.DataDao;
import com.jeffy.scanner.dao.ItemDao;
import com.jeffy.scanner.dao.SystemDao;
import com.jeffy.scanner.handler.MonitorHandler;
import com.jeffy.scanner.model.Data;
import com.jeffy.scanner.model.Item;
import com.jeffy.scanner.resource.DataResource;
import com.jeffy.scanner.resource.ItemResource;
import com.jeffy.scanner.resource.SystemResource;
import com.jeffy.scanner.service.DataService;
import com.jeffy.scanner.service.ItemService;
import com.jeffy.scanner.service.SystemService;
import io.dropwizard.assets.AssetsBundle;
import io.dropwizard.jdbi.DBIFactory;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.apache.log4j.Logger;
import org.skife.jdbi.v2.DBI;

/**
 * Created by jeffy on 2015/1/9 0009.
 */
public class Application extends io.dropwizard.Application<Configuration> {
    private Logger log = Logger.getLogger(this.getClass());


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
        log.debug("Init databases");
        final DBIFactory factory = new DBIFactory();
        final DBI dbi = factory.build(environment, configuration.getDataSourceFactory(), "mysql");

        //init dao
        log.debug("Init dao");
        final SystemDao systemDao = dbi.onDemand(SystemDao.class);
        final ItemDao itemDao = dbi.onDemand(ItemDao.class);
        final DataDao dataDao = dbi.onDemand(DataDao.class);
        systemDao.createTable();
        itemDao.createTable();
        dataDao.createTable();

        //init service
        log.debug("Init service");
        SystemService systemService = new SystemService(systemDao);
        ItemService itemService = new ItemService(systemDao, itemDao);
        DataService dataService = new DataService(systemDao, itemDao, dataDao);

        //init handler
        log.debug("Init handler");
        MonitorHandler monitorHandler = new MonitorHandler(systemService, itemService, dataService);
        monitorHandler.execute();

        //resource
        log.debug("Init resource");
        environment.jersey().register(new SystemResource(systemService));
        environment.jersey().register(new ItemResource(itemService));
        environment.jersey().register(new DataResource(dataService));
    }

}
