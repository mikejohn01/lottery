# lottery

При запуске указан порт 8080. 

Структура БД создастся автоматически (установлен ddl-auto: update), поэтому для развертывания базы достаточно создать БД lottery со схемой lottery (не успел добавить контроль версий БД (flyway или liquibase).

####Url's запросов:
   1. Post запрос сохранения участника в БД: `/lottery/participant`
   2. Get запрос получения списока всех участников, которые есть в БД: `/lottery/participant`
   3. Get запрос запуска лотереи: `/lottery/start`
        Количество участников лотереи не должно быть меньше 2!
        После каждого розыгрыша таблица участников очищается!
   4. Get запрос для просмотра списка победителей: `/lottery/winners`

Тест отключен, т.к. не подымал H2.

####Примеры запросов можно найти в авто документации Swagger:

    `http://localhost:8080/swagger-ui.html#/Lottery/`

В качестве рандом генератора используется сайт https://www.random.org/
>(пример запроса: https://www.random.org/integers/?num=1&min=1&max=998&col=1&base=10&format=plain&rnd=new)
