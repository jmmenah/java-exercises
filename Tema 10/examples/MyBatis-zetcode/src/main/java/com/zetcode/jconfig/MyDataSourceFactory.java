/*
 * Introduction to MyBatis
 * http://zetcode.com/db/mybatis/
 */

package com.zetcode.jconfig;

import java.util.Properties;
import javax.sql.DataSource;
import org.apache.ibatis.datasource.DataSourceFactory;
import org.apache.ibatis.datasource.pooled.PooledDataSource;

public class MyDataSourceFactory implements DataSourceFactory {

    private Properties prop;

    @Override
    public DataSource getDataSource() {

        PooledDataSource ds = new PooledDataSource();

        ds.setDriver(prop.getProperty("driver"));
        ds.setUrl(prop.getProperty("url"));
        ds.setUsername(prop.getProperty("user"));
        ds.setPassword(prop.getProperty("password"));

        return ds;
    }

    @Override
    public void setProperties(Properties prprts) {

        prop = prprts;
    }
}
