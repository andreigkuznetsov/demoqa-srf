package yahoo.andreikuzn;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class DragAndDrop {

    @Test
    void dragAndDropSquares() {
        //Открыть https://the-internet.herokuapp.com/drag_and_drop
        open ("https://the-internet.herokuapp.com/drag_and_drop");
        $(".example h3").shouldHave(text("Drag and Drop"));

        $("#column-a header").shouldHave(text("A"));
        //Перенести прямоугольник А на место В
        $("#column-a").dragAndDropTo($("#column-b"));
        //Проверить, что прямоугольники действительно поменялись
        $("#column-a header").shouldHave(text("B"));
    }
}
