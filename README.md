# Store
## Инструкция по сборке, настройке, конфигурированию и развертыванию приложения
### 1. Склонируйте репозиторий
git clone https://github.com/Reivi/Store.git

cd Store
### 2. Настройка проекта
Проверьте файл application.properties для настройки базы данных H2:

spring.datasource.url=jdbc:h2:mem:testdb

spring.datasource.driverClassName=org.h2.Driver

spring.datasource.username=sa

spring.datasource.password=

spring.jpa.database-platform=org.hibernate.dialect.H2Dialect

spring.h2.console.enabled=true

spring.h2.console.path=/h2-console

spring.jpa.hibernate.ddl-auto=update

### 3. Сборка проекта
В корне проекта выполните команду:

mvn clean install

### 4. Запуск приложения
Для запуска приложения выполните команду:

mvn spring-boot:run

### 5. Доступ к H2 консоли
H2 консоль будет доступна по адресу: http://localhost:8080/h2-console

JDBC URL: jdbc:h2:mem:testdb

User Name: sa

Password: оставьте пустым

### 6. Использование API

Добавление товара: POST /api/harddisks

Редактирование товара: PUT /api/harddisks/{id}

Просмотр всех существующих товаров по типу: GET /api/harddisks

Просмотр товара по идентификатору: GET /api/harddisks/{id}
