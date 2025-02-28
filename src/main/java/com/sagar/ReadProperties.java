package com.sagar;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ReadProperties {
    public static void main(String[] args) {
        Properties p = new Properties();

        try {
            p.load(new FileReader("C:\\SAGAR WORK\\SELENIUM_JAVA\\Java-Selenium-Rahulshetty-Course\\src\\main\\java\\com\\sagar\\application.properties"));
            String url = p.getProperty("url");
            System.out.println(url);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
