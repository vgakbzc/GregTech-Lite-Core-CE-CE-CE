package magicbook.gtlitecore.api.utils;

import org.apache.logging.log4j.Logger;

public class GTLiteLog {

    public static Logger logger;

    public GTLiteLog() {}

    public static void init(Logger modLogger) {
        logger = modLogger;
    }
}
