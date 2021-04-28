# SimbirSoftApp

Тестовое задание по треку Java. Backend-практикум онлайн от IT-компании SimbirSoft. 

Приложение на Java, которое скачивает HTML-страницу на жесткий диск, выводит уникальные слова и считает их количетсво,
а так же записывает эту информацию в таблицу базы данных.

Задание отправлено в виде ссылки на GitHub. Все рабочие файлы находятся в дирректории "src/main/java/Main/". 

Точкой входа в программу является файл DownloadApp.java. В этом файле в переменной site типа String нужно указать адрес сайта, который требуется сохранить
как HTML-страницу.
В файле Log.java реализовано логирование исключений и запись их в текстовый файл. Логирование происходит при помощи библиотеки java.util.logging.
По умолчанию логи сохраняются в файл - "C:\Users\Administrator\log.config", если нужно сохранять в другой файл или дирректорию, то необходимо это указать
в переменной file метода logger.

В файле SplintAndSaveMethod.java - реализованы два метода: saveToHTML - для сохранения страницы на диск, splitAndCount - для поиска уникальных слов и их подсчёта.

В файле DataBaseActions.java - описана работа с базой данных: открытие соединения, добавление данных в таблицу статистики, и закрытие соединения. Данный функционал 
реализован при помощи postgresql JDBC драйвера, зависимость прописана в файле pom.xml. 
По умолчанию для доступа к базе указаны следующие настройки:

    URL - jdbc:postgresql://localhost:5432/postgres;
    USERNAME = "postgres";
    PASSWORD = "postgres";
    
Если требуется использовать другие настройки подключения, то эту информацию необходимо изменить в переменных класса DataBaseActions(URL, USER, PASSWORD).
 
Логика работы программы реализована таким образом, что нам необходимо только лишь указать адрес сайта, далее все действия выполнятся автоматически, при условии
что все настройки(БД, пути к файлам и тд) были указаны корректно.

Программа завершается после выполнения всех действий.