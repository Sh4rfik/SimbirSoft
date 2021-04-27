package Main;


import static Main.SaveToHTML.saveToHTML;
import static Main.SplitByUniqWords.splitAndCount;


public class DownloadApp {

    public static void main(String[] args) {

        String site = "https://www.simbirsoft.com/";
        String s = saveToHTML(site);

        //System.out.println("__________________________________");
        System.out.println(s);

        //System.out.println("__________________________________");
        splitAndCount(s);


    }
}
