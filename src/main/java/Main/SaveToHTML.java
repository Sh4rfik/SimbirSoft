package Main;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;


public class SaveToHTML {

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

}