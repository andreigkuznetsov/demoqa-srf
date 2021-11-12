package yahoo.andreikuzn.files;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class FilesTests {

    @Test
    @DisplayName("Загрузка файлов в файловый обменник")
    void uploadFileInToFilesStorage() {
        open("http://file.karelia.ru/");
        $("#file_0").uploadFromClasspath("pic.jpg", "pic1.jpg");
        $("#file_submit").click();
        $("#fileQueue").shouldHave(text("pic.jpg"));
        $("#fileQueue").shouldHave(text("pic1.jpg"));
    }
}
