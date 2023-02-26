# MarketCatalog (mcat)

Репозиторий содержит исходный код проекта интернет каталога для бизнеса в сфере продаж.

### Technology Stack

#### Programing language:

- **Kotlin** > 1.8.0 version

#### Frameworks:

- **Spring Boot** > 3.0.1 version [data, test, web]

#### Documentation:

- **Swagger** > 1.5.14 version
- **Slf4j** logging

#### Database:

- **H2** > 1.4.200 version
- **PostgreSQL** > 42.2.8 version

### The application infrastructure

- **nginx** - proxy service
- **backend** - API market catalog
- **postgres** - database

### Running

*Переходим в корневую папку*:

```
.
..
|- docker / docker configuration
|- market-api / root module / controllers
|- market-api-contract / contract API market
|- market-aspect / project AOP
|- market-core / base constants / abstract records
|- market-domain / domain entities
|- market-exception / project exceptions
|- market-facade / facade-services (user request -> user response)
|- market-liquibase / database migration
|- market-mapper / project mappers
|- market-record / project entity records
|- market-repository / domain repositories
|- market-service / domain services
|- .gitignore / ignored files and folders
|- pom.xml / root pom
```

### Contract API

Для отслеживания операций пользователя в системе разработан _мобильный_ контракт API

Любой запрос пользователя должен сопровождаться соответствующими метаданными:

**id** - идентификатор запроса / UUID<br>
**sourceSystem** - именование системы запроса / frontend::mcat<br>
**sourcePerformer** - система получатель запроса / backend::mcat

Запросы всегда отправляются с использованием **protocol HTTP/ method POST**

Результаты ответа не привязаны к **HTTP**. Результат ответа всегда будет иметь **HTTP status 200**

Пример запроса для получения страницы ресурсов

```json
POST http://localhost:8080/api/portable/units
Content-Type: application/json

{
"id": "2fa85f64-5717-4562-b3fc-2c963f66afa6",
"sourceSystem": "frontend::mcat",
"sourcePerformer": "backend::mcat"
}
```

### Localization i18

В запросах поддерживается локализация **EN / RU**. Сообщения статусов/ошибок локализованы.

Управление локализацией доступно через **HTTP header**:

```text
Accept-Language: en/ru
```

### Liquibase (version control for your database)

Миграция и версионирование базы данных выражено в модуле **market-liquibase**

Описание миграции производиться в формате: ``xml``

Директория изменений: **/db/changelog/changeSets/**

Определенная структура расположения скриптов:

```
.
..
|- db
  |- changelog
    |- chnageSets
      |- data / csv files
      |- index / table indexes
      |- schema / main schemes
    |- changelog-master.xml / main migration catalog
```

Правила добавления новых файлов для миграции БД:

1) Именование файлов **_YYYYMMDD_HHMM_TASKNUMBER_DESCRIPTION.xml_**
2) Точно понимать, что выполняют changeSets в файле изменений (меняют структуру БД, добавляют данные или добавляют
   indexes) и помещать в соответствующую папку
3) Каждый changeSets имеет автора и идентификатор
4) Идентификатор changeSet должен быть формата: _**YYYYMMDD_HHMM**_

Пример к пункту 1:

```text
20200508_2251_117_CREATE_TABLE_TBX_RB_UNIT.xml
```

Пример к пункту 3:

```xml

<changeSet author="devpav" id="20200508_2253"/>
```
