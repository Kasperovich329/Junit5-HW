package com.example.extensions;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

public class SetUpBrowserExtension implements BeforeAllCallback {

    @BeforeAll
    public void beforeAll(ExtensionContext context) throws Exception {
        Configuration.browser = "chrome";
        Configuration.browserSize = "2560x1440";
        Configuration.pageLoadTimeout = 20000;
        System.out.println(">>> [BeforeAll] Браузер настроен глобально.");
    }

    @BeforeEach
    public void beforeEach(ExtensionContext context) throws Exception {
        // Открытие главной страницы перед каждым тестом
        Selenide.open("https://demoqa.com/");
        System.out.println(">>> [BeforeEach] Открыта главная страница DemoQA.");
    }

    @AfterEach
    public void afterEach(ExtensionContext context) throws Exception {
        // Закрытие браузера после каждого теста
        Selenide.closeWebDriver();
        System.out.println(">>> [AfterEach] Браузер закрыт.");
    }

    @AfterAll
    public void afterAll(ExtensionContext context) throws Exception {
        // Опционально: можно очистить кэш, отчеты и т.д.
        System.out.println(">>> [AfterAll] Все тесты завершены. Глобальная очистка.");
    }
}