package org.jbpm.cases.orderithwapp;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.sql.SQLException;
import java.util.Arrays;

import javax.sql.DataSource;
import javax.transaction.TransactionManager;

import org.apache.commons.dbcp2.managed.BasicManagedDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DBConfiguration {

    
    Logger logger = LoggerFactory.getLogger(DBConfiguration.class);

    @Autowired
    private TransactionManager tm;

    @Value("${spring.custom.datasource.url}")
    private String url;

    @Value("${spring.custom.datasource.driver-class-name}")
    private String driverName;

    @Value("${spring.custom.datasource.username}")
    private String username;

    @Value("${spring.custom.datasource.password}")
    private String password;

    // @Bean
    // DataSource getDataSource() {
    //     BasicManagedDataSource ds = new BasicManagedDataSource();
    //     ds.setDriverClassName(driverName);
    //     ds.setUrl(url);
    //     ds.setUsername(username);
    //     ds.setPassword(password);

    //     ds.setInitialSize(10);
    //     ds.setMaxTotal(30);
    //     ds.setMaxWaitMillis(30000);
    //    // ds.setRemoveAbandonedOnBorrow(true);
    //    //  ds.setAbandonedUsageTracking(true);
    //     if (tm != null) {
    //         try {
    //             tm.setTransactionTimeout(240);
    //         } catch (Exception e) {
    //             System.out.println("error setting tm timeout");
    //         }
    //     } else System.out.println("tm is null..");
    //     ds.setTransactionManager(tm);
    //     return ds;
    // }

//    @Bean
//    DataSource getDataSource() throws SQLException {
//        BasicManagedDataSource ds = new BasicManagedDataSource();
//
//
//        ds.setDriverClassName(driverName);
//        ds.setUrl(url);
//        ds.setUsername(username);
//        ds.setPassword(password);
//
//        ds.setInitialSize(1);
//        ds.setMaxTotal(8);
//        ds.setMaxWaitMillis(1000);
//        ds.setAbandonedUsageTracking(true);
//       //  ds.setRemoveAbandonedOnBorrow(true);
//       //  ds.setAbandonedUsageTracking(true);
//        if (tm != null) {
//            try {
//                tm.setTransactionTimeout(2);
//            } catch (Exception e) {
//                System.out.println("error setting tm timeout");
//            }
//        } else System.out.println("tm is null..");
//        ds.setTransactionManager(tm);
//        ds.setLogWriter( new PrintWriter(new Writer() {
//
//            @Override
//            public void write(char[] cbuf, int off, int len) throws IOException {
//                char[] newCbuf = Arrays.copyOfRange(cbuf, off, len);
//                logger.info(new String(newCbuf));
//            }
//
//            @Override
//            public void flush() throws IOException {
//                // do nothing
//            }
//
//            @Override
//            public void close() throws IOException {
//                // do nothing
//            }
//            
//        }));
//        return ds;
//    }
}
