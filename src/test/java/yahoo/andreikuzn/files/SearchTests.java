package yahoo.andreikuzn.files;

import com.codeborne.pdftest.PDF;
import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.xlstest.XLS;
import org.apache.commons.io.IOUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;


import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static yahoo.andreikuzn.files.TestData.*;

public class SearchTests extends TestBase {

    @Test
    @DisplayName("Проверка поиска в резделе Кофе")
    void caffeSearchTests() {
        open(OPENLINK);
        $("input[type='text']").setValue("DON CARLOS");
        $("button[type='button']").click();
        $("#content")
                .shouldHave(text("CAFFE DON CARLOS"));
    }

}
