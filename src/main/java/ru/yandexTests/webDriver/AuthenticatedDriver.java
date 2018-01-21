package ru.yandexTests.webDriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.DefaultCredentialsProvider;
import com.gargoylesoftware.htmlunit.WebClient;

public class AuthenticatedDriver extends HtmlUnitDriver {
    private static String USERNAME;
    private static String PASSWORD;

    public AuthenticatedDriver() {
    }

    public static WebDriver create(String username, String password) {
        USERNAME = username;
        PASSWORD = password;
        return new AuthenticatedDriver();
    }

    protected WebClient newWebClient(BrowserVersion browserVersion) {
        WebClient client = super.newWebClient(browserVersion);
        DefaultCredentialsProvider provider = new DefaultCredentialsProvider();
        provider.addCredentials(USERNAME, PASSWORD);
        client.setCredentialsProvider(provider);
        return client;
    }
}