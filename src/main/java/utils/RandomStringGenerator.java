package utils;

import java.math.BigInteger;
import java.security.SecureRandom;

public class RandomStringGenerator {

    public static String getRandomString(int length) {
        if (length <= 0) {
            throw new IllegalArgumentException("String must be at least 1 character long");
        }
        return new BigInteger(260, new SecureRandom()).toString().substring(0, length);
    }
}
