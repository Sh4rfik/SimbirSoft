package Main;


import java.io.IOException;
import java.util.Map;
import java.util.logging.Level;
import static Main.Log.*;
import static Main.SplintAndSaveMethod.*;


public class DownloadApp {

    public static void main(String[] args) throws IOException {

        //Адрес сайта для сохранения страницы
        String site = "https://www.simbirsoft.com/";

        try {
            //Метод для логирования исключений
            logger();
            /*Вызов методов для сохранения страницы и извлечения уникальных слов.
            Результат записывается в коллекцию типа Map для дальнейшего добавления в таблицу базы данных*/
            Map<String, Integer> map = splitAndCount(saveToHTML(site));
            //Вызов метода для добавления статистики в таблицу
            DataBaseActions.connect(map);
        } catch (Exception e) {
            //Запись исключений в файл логов
            getLogger().log(Level.WARNING, "Exception: ", e);
        }
    }


}

