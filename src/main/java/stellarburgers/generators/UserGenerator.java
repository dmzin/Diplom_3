package stellarburgers.generators;

import java.util.Random;

public class UserGenerator {

    private static final Random RANDOM = new Random();

    public static String generateRandomEmail() {
        return "test" + RANDOM.nextInt(100000) + "@yandex.ru";
    }

    public static String generateRandomPassword() {
        return "validPass" + RANDOM.nextInt(10000);
    }

    public static String generateRandomName() {
        return "Пользователь" + RANDOM.nextInt(1000);
    }

}
