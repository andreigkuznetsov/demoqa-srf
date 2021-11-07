package yahoo.andreikuzn.tests;

import com.github.javafaker.Faker;

import java.io.File;
import java.util.Locale;

public class TestData {

    public static Faker FAKER = new Faker(new Locale("ru"));
    public static File IMAGE = new File("src/test/resources/pic.jpg");

    static String FIRSTNAME = FAKER.name().firstName();
    static String LASTNAME = FAKER.name().lastName();
    static String ADDRESS = FAKER.address().streetAddress();

    public static String IMAGENAME = "pic.jpg";
    public static String GENDER = "Male";
    public static String EMAIL = "andrey@smith.com";
    public static String PHONE = "8950789456";
    public static String MONTH = "October";
    public static String YEAR = "1996";
    public static String DAY = "30";
    public static String SEARCHLETTER = "c";
    public static String SUBJECT = "Economics";
    public static String HOBBY = "Sports";
    public static String STATE = "Rajasthan";
    public static String CITY = "Jaiselmer";

    }
