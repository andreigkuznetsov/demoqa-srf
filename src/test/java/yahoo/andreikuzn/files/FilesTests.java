package yahoo.andreikuzn.files;

import com.codeborne.pdftest.PDF;
import com.codeborne.xlstest.XLS;
import org.apache.commons.io.IOUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;


import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static yahoo.andreikuzn.files.TestData.*;

public class FilesTests extends TestBase {

    @Test
    @DisplayName("Загрузка файлов в файловый обменник")
    void uploadFileInToFilesStorage() {
        open(UPLOADFILESLINK);
        $("#file_0").uploadFromClasspath(FILETOUPLOAD1, FILETOUPLOAD2);
        $("#file_submit").click();
        $("#fileQueue").shouldHave(text(FILETOUPLOAD1));
        $("#fileQueue").shouldHave(text(FILETOUPLOAD2));
    }

    @Test
    @DisplayName("Работа с .txt файлом (скачивание и поиск по содержимому)")
    void downloadTextFileAndSearchInsideIt() throws IOException {
        open(DOWNLOADTXTFILELINK);
        $(".CookieAcceptance-accept").click();
        File download = $("#downloadButton").download();
        String fileContent = IOUtils.toString(new FileReader(download));
        assertTrue(fileContent.contains(TXTFILECONTAINSTEXT));
    }

    @Test
    @DisplayName("Работа с .pdf файлом (скачивание и поиск по содержимому)")
    void downloadPdfFileAndSearchInsideIt() throws IOException {
        open(DOWNLOADPDFFILELINK);
        //$(".CookieAcceptance-accept").click(); //необходимо раскомментировать, если тест запускается отдельно
        File pdf = $("#downloadButton").download();
        PDF parsedPdf = new PDF(pdf);
        Assertions.assertEquals(false, parsedPdf.encrypted);
    }

    @Test
    @DisplayName("Работа с .xls файлом (скачивание и поиск по содержимому)")
    void downloadXlsFileAndSearchInsideIt() throws IOException {
        open(DOWNLOADXLSFILELINK);
        //$(".CookieAcceptance-accept").click(); //необходимо раскомментировать, если тест запускается отдельно
        File file = $("#downloadButton").download();

        XLS parsedXls = new XLS(file);
        boolean checkPassed = parsedXls.excel
                .getSheetAt(0)
                .getRow(3)
                .getCell(2)
                .getStringCellValue()
                .contains(XLSFILECONTAINSTEXT);

        assertTrue(checkPassed);
    }

}
