# Тестовое задание 

[![Slotegrator](https://slotegrator.pro/images/2022-images/new-slot-logo-011.svg)](https://slotegrator.pro/)

## Запуск тестов
 - Зайти в Google Chrome -> Справка -> О браузере Google Chrome
 - Посмотреть установленную версию Google Chrome на локальном компьютере
 - По умолчанию в проекте стоит версия Google Chrome 99.0
 - Если версия на локальном компьютере отличается от указанной выше,
  поменять значение в классе 
 `src\test\java\com\slotegrator\core\DriverFactory`
  у параметра `LOCAL_DRIVER_VERSION`
  на версию Google Chrome на локальном компьютере.
 Версия укорачивается до одного символа после точки
 
 ```java
private static String LOCAL_DRIVER_VERSION = "99.0";
```
 - После этого запустить в терминале в папке с проектом
```shell script
mvn clean test
```

## Сборка отчета Allure
- Для сборки отчета Allure нужно после тестов запустить в терминале в папке с проектом
```shell script
mvn allure:report
```

## Технологии
 - Java 8
 - Maven
 - JUnit 5
 - Rest-Assured
 - Selenium WebDriver
 - Cucumber
 - Lombok
 - Allure

## Параметры запуска
|Параметр|Что делает|Обязательность|Комментарий|
|-------|--------|--------|--------|
|`-Denv=`|Выставление окружения на котором запускать тесты. По умолчанию `default`|&#10060; |Окружение считывается из файла с названием параметра %env%.properties. Новые файлы окружений должны находиться в папке `src\test\resources\environment` |
|`-Dbrowser=`|Выбор браузера для запуска UI-тестов. По умолчанию Chrome. Доступны варианты: `firefox`, `chrome`|&#10060;|Firefox не протестирован|
|`-Dtimeout=`|Выставление таймаута ожидания элементов для UI-тестов. По умолчанию `30`|&#10060;| - |