# Diplom_3 — UI-автотесты для Stellar Burgers

Набор UI-автотестов для веб-приложения **Stellar Burgers** — сервиса по сборке и заказу космических бургеров.

## Технологии

| Технология | Версия |
|---|---|
| Java | 11 |
| JUnit | 4.13.2 |
| Selenium | 4.29.0 |
| WebDriverManager | 5.7.0 |
| REST Assured | 5.3.1 |
| Allure | 2.21.0 |
| Lombok | 1.18.28 |
| Maven | 3.9.0+ |

## Что тестируется

- **Регистрация**: успешная регистрация, ошибка при коротком пароле
- **Вход**: через кнопку на главной, Личный кабинет, форму регистрации, форму восстановления пароля
- **Конструктор**: переключение табов Булки / Соусы / Начинки

## Структура проекта

```
src/
├── main/java/stellarburgers/
│   ├── Urls.java                   — URL и пути страниц
│   ├── Endpoints.java              — эндпоинты API (/api/auth/...)
│   ├── client/UserClient.java      — API-клиент (REST Assured)
│   ├── generators/UserGenerator.java — генерация тестовых данных
│   ├── model/User.java             — модель пользователя (Lombok)
│   └── pages/
│       ├── BasePage.java           — базовый класс для страниц
│       ├── MainPage.java           — главная страница и конструктор
│       ├── LoginPage.java          — страница входа
│       ├── RegisterPage.java       — страница регистрации
│       └── ForgotPasswordPage.java — страница восстановления пароля 
└── test/java/stellarburgers/
    ├── BaseTest.java               — базовый класс тестов
    ├── RegistrationTest.java       — тесты регистрации
    ├── LoginTest.java              — тесты входа
    └── ConstructorTest.java        — тесты конструктора
```

## Запуск

```bash
# Chrome
mvn clean test

# Яндекс Браузер (предварительно укажите путь к драйверу)
mvn clean test -Dbrowser=yandex -Dyandex.driver.path=/path/to/yandexdriver

# Allure-отчёт
mvn allure:report
```

Отчёт формируется в `target/site/allure-maven-plugin/`.
