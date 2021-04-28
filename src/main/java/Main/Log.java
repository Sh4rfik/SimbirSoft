package Main;

import java.io.File;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;


public class Log {

    private static Logger logger = Logger.getLogger("MyLog");
    private static FileHandler fh;

    public static Logger getLogger() {
        return logger;
    }

    public static void logger() throws IOException {
        File file = new File("C:\\Users\\Administrator\\log.config");
        fh = new FileHandler(file.getAbsolutePath(), true);
        logger.addHandler(fh);
        SimpleFormatter formatter = new SimpleFormatter();
        fh.setFormatter(formatter);
        System.out.println(file.getAbsolutePath());
    }

}
