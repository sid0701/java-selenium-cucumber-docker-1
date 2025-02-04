package com.sidgupta.utils;

import lombok.extern.slf4j.Slf4j;

import java.io.InputStream;
import java.util.Properties;

@Slf4j
public class Config {

    private static final String DEFAULT_PROPERTIES = "config/default.properties";
    private static Properties properties;

    public static void setDefaultProperties(){
        properties = loadProperties();

        for(String key : properties.stringPropertyNames()){
            if(System.getProperties().containsKey(key))
                properties.setProperty(key, System.getProperty(key));
        }

        log.info("Final value of all the default properties :: ");
        for(String key : properties.stringPropertyNames())
            log.info("{} = {}",key,properties.getProperty(key));

    }

    public static String getProperties(String key){
        return properties.getProperty(key);
    }

    private static Properties loadProperties(){
        Properties properties = new Properties();

        try(InputStream stream = ResourceLoader.getResource(DEFAULT_PROPERTIES)){
            properties.load(stream);
        } catch(Exception e){
            log.error("Cannot read properties file located at : {}", DEFAULT_PROPERTIES, e);
        }
        return properties;
    }

}
