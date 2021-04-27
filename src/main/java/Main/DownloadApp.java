package Main;

import static Main.SaveToHTML.saveToHTML;
import static Main.SplitByUniqWords.splitAndCount;

public class DownloadApp {

    public static void main(String[] args) {

        String site = "https://ww.simbirsoft.com/";

        splitAndCount(saveToHTML(site));



    }
}
