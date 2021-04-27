package Main;

import java.util.Map;

import static Main.SaveToHTML.saveToHTML;
import static Main.SplitByUniqueWords.splitAndCount;

public class DownloadApp {

    public static void main(String[] args) {

        String site = "https://www.simbirsoft.com/";

        Map<String, Integer> map = splitAndCount(saveToHTML(site));
        DataBaseActions.connect(map);






    }
}
