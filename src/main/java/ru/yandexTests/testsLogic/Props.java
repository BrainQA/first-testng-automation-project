package ru.yandexTests.testsLogic;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Props {
    //путь к нашему файлу конфигураций
    public static final String PATH_TO_PROPERTIES = "src/main/resources/config/local.properties";

    public static void main(String[] args) {

        FileInputStream fileInputStream;
        //инициализируем специальный объект Properties
        //типа Hashtable для удобной работы с данными
        Properties prop = new Properties();

        try {
            //обращаемся к файлу и получаем данные
            fileInputStream = new FileInputStream(PATH_TO_PROPERTIES);
            prop.load(fileInputStream);

            String siteUrl = prop.getProperty("site.url");
            String username = prop.getProperty("user.username");
            String password = prop.getProperty("user.password");
            String browserName = prop.getProperty("browser.name");
            String browserVersion = prop.getProperty("browser.version");
            String browserPlatform = prop.getProperty("browser.platform");

            //печатаем полученные данные в консоль
            System.out.println(
                    "site.url: " + siteUrl
                            + "\nuser.username: " + username
                            + "\nuser.password: " + password
                            + "\nbrowser.name: " + browserName
                            + "\nbrowser.version: " + browserVersion
                            + "\nbrowser.platform: " + browserPlatform
            );

        } catch (IOException e) {
            System.out.println("Ошибка в программе: файл " + PATH_TO_PROPERTIES + " не обнаружено");
            e.printStackTrace();
        }

    }

}