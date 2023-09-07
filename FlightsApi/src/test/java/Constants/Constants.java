package Constants;


import java.util.List;
import java.util.Random;

public interface Constants {


    public  String ENDPOINT = "dev";

    default boolean areAllIntegers(List<Integer> list) {
        for (Integer value : list) {
            if (!(value instanceof Integer)) {
                return false;
            }
        }
        return true;
    }

    default boolean areAllStringsNonEmpty(List<String> stringList) {
        for (String str : stringList) {
            // Check if the string is null or has a length of 0 (empty).
            if (str == null || str.isEmpty()) {
                return false; // At least one empty string found.
            }
        }
        return true; // All strings are non-empty.
    }




}
