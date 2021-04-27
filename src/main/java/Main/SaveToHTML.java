package Main;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class SaveToHTML {

    public static void saveToHTML(String site) {
        URL url = null;
        try {
            url = new URL(site);
        } catch (
                MalformedURLException e) {
            e.printStackTrace();
        }
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(
                    new InputStreamReader(url.openConnection().getInputStream(), "UTF-8"));
        } catch (
                IOException e) {
            e.printStackTrace();
        }
        while (true) {
            String line = null;
            try {
                line = reader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (line == null)
                break;
            System.out.println(line);
            FileWriter file = null;
            try {
                file = new FileWriter("page.html");
                file.write(line);
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    file.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
