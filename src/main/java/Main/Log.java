package Main;

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
        FileHandler fh;
        fh = new FileHandler("C:\\Users\\Administrator\\log.config", true);
        logger.addHandler(fh);
        SimpleFormatter formatter = new SimpleFormatter();
        fh.setFormatter(formatter);
    }

}
