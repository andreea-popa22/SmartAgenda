package storage;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Service {
    public static boolean phoneNumberValidation( String phone) {
            Pattern pattern = Pattern.compile("^(\\+4|)?(07[0-8]{1}[0-9]{1}|02[0-9]{2}|03[0-9]{2}){1}?(\\s|\\.|\\-)?([0-9]{3}(\\s|\\.|\\-|)){2}$");
            Matcher matcher = pattern.matcher(phone);
            return(matcher.matches());
    }
}
