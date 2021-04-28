package Main;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class SplintAndSaveMethod {

    //Метод для сохранения страницы в html-файл
    public static String saveToHTML(String site) {

        URL url;
        InputStream input = null;
        BufferedReader reader;
        String line;
        FileWriter file;
        String s = "";

        try {
            url = new URL(site);
            input = url.openStream();
            reader = new BufferedReader(new InputStreamReader(input));
            file = new FileWriter("C:\\Users\\Administrator\\Downloads\\page.html");

            while ((line = reader.readLine()) != null) {
                file.write(line);
                s += line;
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (input != null) input.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return s;
    }

    //Метод для извлечения уникальных слов и подсчёта их количества
     public static Map<String,Integer> splitAndCount(String line){

        String s = "";
        Map<String, Integer> map = new HashMap<>();

        Pattern p = Pattern.compile("[а-яА-Я]+");

        Matcher m1 = p.matcher(line);

        while (m1.find()){
            s += m1.group()+" ";
        }

        String[] array = s.split("['',',','.','!','?','\"',';',':','\\[','\\]','(',')','\\n','\\r','\\t', '\\s']");

        for (String str: array) {
            if (!map.containsKey(str)){
                map.put(str, 1);
            } else map.put(str, map.get(str)+1);
        }

        for (Map.Entry<String, Integer> m : map.entrySet()){
            System.out.println(m.getKey() + " - " + m.getValue());
        }
        return map;
    }

}