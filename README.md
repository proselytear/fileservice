# Прочитайте в первую очередь

* Данный проект является одним из под-проектов в рамках курса "Docker и K8S глазами разработчика".
* В данном проекта мы рассматриваем простое веб-приложение, которое позволяет нам взаимодействовать с файлом.

# Старт проекта

* Для локального старта (без использования Docker) вам потребуется установленный Gradle и JDK
* Необходимо выполнить команды
```
gradle build
```
<br/>

```
gradle bootRun --args='--storage_location=storage/storage.txt'
```

<br/>Перейти на страницу:

```
http://localhost:8080/form
```

* Для старта с использованием **Docker** необходимо:
* Установить Docker
* Создать образ

```
docker build . --tag=fileservice:latest
```

* Запустить контейнер

```
docker run -p 8080:8080 fileservice:latest
```

<br/>Отправить запрос:

```
curl --location 'localhost:8080/api/v1/users'
```

* Пример ответа:

```
[
  {
    "id": 1,
    "firstName": "John",
    "lastName": "Doe",
    "email": "john.doe@mail.com"
  },
  {
    "id": 2,
    "firstName": "Mike",
    "lastName": "Smith",
    "email": "mike.smith@mail.com"
  }
 ]
```

### Дополнительные ссылки

* [GitHub repository](https://github.com/proselytear/user-api)
* [Proselyte Community TG](https://t.me/pse_club)
