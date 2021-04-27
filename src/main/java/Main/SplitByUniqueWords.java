package Main;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SplitByUniqueWords {

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
