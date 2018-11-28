/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.kyiv.time.calc.configuratin;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ua.kyiv.time.calc.entities.Airline;

/**
 *
 * @author firsov
 */
public final class HibernateConfig {
    
    private static SessionFactory sessionFactory;
    private static HibernateConfig hibernateConfig;
    
    private HibernateConfig(){
        String url = "jdbc:sqlite:" 
                + SettingsApplication.USER_APLICATION_FOLDER 
                + SettingsApplication.DATABSE_APPLICATION_NAME;
        
        Properties properties = new Properties();
        properties.setProperty("hibernate.dialect", "org.hibernate.dialect.SQLiteDialect");
        properties.setProperty("hibernate.connection.driver_class", "org.sqlite.JDBC");
        properties.setProperty("hibernate.connection.url", url);
        properties.setProperty("hibernate.show_sql", "true");
        properties.setProperty("hibernate.hbm2ddl.auto", "update");
        
  
        Configuration cfg = new Configuration();
        cfg.addAnnotatedClass(Airline.class);
        cfg.setProperties(properties);
                
        sessionFactory = cfg.buildSessionFactory();
    }

    public static Session getSession(){
        if(null == hibernateConfig){
            hibernateConfig = new HibernateConfig();
        }
        return sessionFactory.openSession();
    }
}
