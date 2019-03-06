# Avios


[![Build Status](https://travis-ci.org/joemccann/dillinger.svg?branch=master)](https://travis-ci.org/joemccann/dillinger)

HolyWar это студенческий проект.

### Технологии

Для разработки или установки нужно следущее:

* [Spring] - Отличный фреймворк для разработки
* [MySql] - Самая популярная субд
* [Maven] - Прекрасный сборщик для проекта

Исходные код можете найти в [git-repo-url]

### Установка

Для запуска проекта нужен java 11, mysql и maven.

Установка окружения
```sh
$ sudo apt install git openjdk-11-jre-headless maven mariadb-server
```

Установка и сборка проекта
```sh
$ git clone https://github.com/CyberDoge/HolyWar
$ cd HolyWar
$ mvn package && java -jar target/HolyWar-0.0.1-SNAPSHOT.jar
```
Переходим в браузере по адресу localhost:8080/hello

### Разработка

Четкого код-стайла пока нет. Кто хочет помочь, присоединяйтесь. Будем рады помощи и замечаниям

### Todos

 - Написать четкое тз
 - Начать разработку


[//]: # (These are reference links used in the body of this note and get stripped out when the markdown processor does its job. There is no need to format nicely because it shouldn't be seen. Thanks SO - http://stackoverflow.com/questions/4823468/store-comments-in-markdown-syntax)


   [git-repo-url]: <https://github.com/CyberDoge/HolyWar>
   [Spring]: <https://spring.io>
   [MySql]: <https://www.mysql.com/>
   [Maven]: <https://maven.apache.org/>
