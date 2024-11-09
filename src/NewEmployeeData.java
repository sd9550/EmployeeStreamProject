import java.util.Random;

public class NewEmployeeData {
    public static final String[] FIRST_NAMES = {"Joe", "Marsha", "Johnny", "Richard", "Molly", "Taylor", "Olga", "David", "Ralph", "Cornelius"};
    public static final String[] LAST_NAMES = {"Anderson", "Township", "Maximus", "Reed", "Neil", "Hughes", "Gibbons", "Lawrence", "Gibbons"};
    public static final String[] STATES = {"California", "Nevada", "Oregon", "Washington", "Florida", "Georgia"};
    private static final String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final Random random = new Random();

    public static String getRandomName() {
        String randomFirstName = NewEmployeeData.FIRST_NAMES[random.nextInt(0, NewEmployeeData.FIRST_NAMES.length)];
        String randomLastName = NewEmployeeData.LAST_NAMES[random.nextInt(0, NewEmployeeData.LAST_NAMES.length)];
        char randomMiddleName = ALPHABET.charAt(random.nextInt(0, ALPHABET.length()));
        return "%s %c. %s".formatted(randomFirstName, randomMiddleName, randomLastName);
    }
}
