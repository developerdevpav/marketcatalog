## Структура Liquibase module

```text
- | db
  - | changelog
     - | changeSets
      - | data - инициализации таблиц данными
      - | index - индексы
      - | schema - схемы таблиц
  - changelog-master.xml - общий файл миграции
```

## Данные инициализации

_**Entity-Metadata-Resource**_

```json
[
  {
    "id": "ae842f08-27b8-4d4a-9027-25883f352f9e",
    "tableName": "data_type",
    "description": "Тип данных",
    "container": "825faa65-9f1f-4ed1-94dc-58d97754e328"
  },
  {
    "id": "edcab99b-1fc6-4423-9f76-1218a98277b9",
    "tableName": "container",
    "description": "Контейнер",
    "container": "825faa65-9f1f-4ed1-94dc-58d97754e328"
  },
  {
    "id": "283de48b-c432-4314-9274-7d0b978248f6",
    "tableName": "category",
    "description": "Категория",
    "container": "825faa65-9f1f-4ed1-94dc-58d97754e328"
  },
  {
    "id": "35985b15-36a0-4324-8c92-dead84d1a6b3",
    "tableName": "entity_metadata",
    "description": "Метаданные сущности",
    "container": "825faa65-9f1f-4ed1-94dc-58d97754e328"
  },
  {
    "id": "8e7afb48-ee0b-4df7-8b14-80e42cb4e081",
    "tableName": "characteristic",
    "description": "Характеристика продукта",
    "container": "4b4f01af-4e88-4a5f-b2f8-c151f977fb0c"
  },
  {
    "id": "c8d321e0-41fe-4cd2-a097-bc9a04582721",
    "tableName": "string_characteristic",
    "description": "Строковая характеристика",
    "container": "4b4f01af-4e88-4a5f-b2f8-c151f977fb0c"
  },
  {
    "id": "383314ff-6cc2-44e1-84a6-9bb3e5612a77",
    "tableName": "double_characteristic",
    "description": "Числовая характеристика",
    "container": "4b4f01af-4e88-4a5f-b2f8-c151f977fb0c"
  },
  {
    "id": "57ef02b6-eed2-489d-a41b-584a5bdc970a",
    "tableName": "product",
    "description": "Продукт",
    "container": "25529bd7-7663-4998-9a04-90696481b12f"
  },
  {
    "id": "7933be4f-b392-4a2b-81fe-61df5d7f9cdd",
    "tableName": "tbx_rb_unit",
    "description": "Единицы измерений и группы измерений",
    "container": "36642cd8-c479-42bf-985c-cc78f7feacc6"
  }
]
```

**Data-Type-Resource**

```json
[
  {
    "id": "f8a17421-5b48-4d22-8899-25a8765bbecc",
    "name": "STRING"
  },
  {
    "id": "bb2c2f80-6fed-4504-ae5a-e8604ae8591f",
    "name": "DOUBLE"
  }
]
```

**Container-Metadata**

```json
[
  {
    "id": "25529bd7-7663-4998-9a04-90696481b12f",
    "description": "Продукт",
    "systemName": "p"
  },
  {
    "id": "4b4f01af-4e88-4a5f-b2f8-c151f977fb0c",
    "description": "Характеристика",
    "systemName": "ch"
  },
  {
    "id": "825faa65-9f1f-4ed1-94dc-58d97754e328",
    "description": "Системный",
    "systemName": "s"
  },
  {
    "id": "36642cd8-c479-42bf-985c-cc78f7feacc6",
    "description": "Справочник",
    "systemName": "rb"
  }
]
```

