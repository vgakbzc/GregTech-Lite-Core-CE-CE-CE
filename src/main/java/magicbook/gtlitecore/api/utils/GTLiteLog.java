package magicbook.gtlitecore.api.utils;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@NoArgsConstructor
public class GTLiteLog {
    @Getter
    public static Logger logger = LogManager.getLogger("GregTech Lite Core");
}
