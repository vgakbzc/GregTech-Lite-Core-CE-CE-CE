package magicbook.gtlitecore.integration.appliedenergistics2.parts;

import java.util.Comparator;
import java.util.Map;

public class RegisteredComparator implements Comparator<Map.Entry<Integer, PartTypeWithVariant>> {

    @Override
    public int compare(final Map.Entry<Integer, PartTypeWithVariant> o1,
                       final Map.Entry<Integer, PartTypeWithVariant> o2) {
        final var string1 = o1.getValue().part().name();
        final var string2 = o2.getValue().part().name();
        final var comparedString = string1.compareTo(string2);
        if (comparedString == 0) {
            return Integer.compare(o1.getKey(), o2.getKey());
        }
        return comparedString;
    }
}
