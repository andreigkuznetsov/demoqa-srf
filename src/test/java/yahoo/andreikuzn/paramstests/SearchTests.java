package yahoo.andreikuzn.paramstests;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.stream.Stream;

import static com.codeborne.selenide.Selenide.*;
import static yahoo.andreikuzn.paramstests.TestData.OPENLINK;

public class SearchTests extends TestBase {

    @ParameterizedTest
    @DisplayName("Проверка поиска и отображения товаров в резделе Кофе молотый")
    @Tag("Critical")
    @CsvSource(value = {
            "BAZZARA : BAZZARA",
            "BOASI GRAN : BOASI GRAN",
            "DE ROCCIS : CAFFE DE ROCCIS",
            "Caffe Polli : Caffe Polli",
            "DON CARLOS : CAFFE DON CARLOS",
            "CARRARO AROMA : CARRARO AROMA",

    },
            delimiter = ':')
    void groundCaffeSearchAndDisplayTests(String searchValue, String expectedResult) {
        open(OPENLINK);
        $("input[type='text']").setValue(searchValue);
        $("button[type='button']").click();
        $$("#content")
                .shouldHave(CollectionCondition.texts(expectedResult));
    }

    @ParameterizedTest
    @DisplayName("Проверка поиска и отображения товаров в разделе КАПСУЛЫ NESPRESSO")
    @Tag("Critical")
    @ValueSource(strings = {"BAZZARA Dodicigrancru",
            "BLUES ALLEGRO ESPRESSO",
            "BLUES AMAPETTO ESPRESSO",
            "BLUES CAPRIZZO ESPRESSO",
            "BLUES COLOMBIA ARABICA",
            "BLUES FORTE ESPRESSO",
            "BLUES HONDURAS ARABICA ORGANIC",
            "BLUES MEXICO ARABICA ORGANIC",
            "BLUES PERU ARABICA ORGANIC",
            "BLUES STRETTO ESPRESSO",
            "BLUES VIVA ESPRESSO"
    })
    void caffeNespressoSearchAndDisplayTests(String searchValue) {
        open(OPENLINK);
        $("input[type='text']").setValue(searchValue);
        $("button[type='button']").click();
        $$("#content")
                .find(Condition.text(searchValue))
                .shouldBe(Condition.visible);
    }

    @DisplayName("Проверка отображения элементов боковой навигации по сайту")
    @Tag("Critical")
    static Stream<Arguments> siteNavigationMenuElementsDisplayTests() {
        return Stream.of(
                Arguments.of("НОВЫЙ ГОД"),
                Arguments.of("БАТОНЧИКИ"),
                Arguments.of("ВОСТОЧНЫЕ СЛАДОСТИ"),
                Arguments.of("ДРАЖЕ, ЛЕДЕНЦЫ, ШОКОЛАДНЫЕ ЯЙЦА"),
                Arguments.of("ЖЕВАТЕЛЬНАЯ РЕЗИНКА"),
                Arguments.of("ЗОЖ СЕМЕНА"),
                Arguments.of("КАПСУЛЫ DOLCE GUSTO"),
                Arguments.of("КАПСУЛЫ NESPRESSO"),
                Arguments.of("КОНФЕТЫ"),
                Arguments.of("КОФЕ В ЗЕРНАХ"),
                Arguments.of("КОФЕ МОЛОТЫЙ"),
                Arguments.of("КОФЕ ПОРЦИОННЫЙ"),
                Arguments.of("КОФЕ РАСТВОРИМЫЙ"),
                Arguments.of("НАПИТКИ"),
                Arguments.of("НАТУРАЛЬНЫЕ ДЕСЕРТЫ"),
                Arguments.of("ПАСТИЛА И МАРМЕЛАД"),
                Arguments.of("ПЕЧЕНЬЕ"),
                Arguments.of("ПРОДУКТЫ БЫСТРОГО ПРИГОТОВЛЕНИЯ"),
                Arguments.of("ПРОТЕИНОВОЕ ПИТАНИЕ"),
                Arguments.of("САХАР И САХАРОЗАМЕНИТЕЛИ"),
                Arguments.of("СУШЕНЫЕ ФРУКТЫ И ОРЕХИ"),
                Arguments.of("ЧАЙ"),
                Arguments.of("ЧИПСЫ"),
                Arguments.of("ШОКОЛАД"),
                Arguments.of("ШОКОЛАДНАЯ ПАСТА")
        );
    }
    @ParameterizedTest
    @MethodSource
    void siteNavigationMenuElementsDisplayTests(String searchValue) {
        open(OPENLINK);
        $$(".list-group")
                .find(Condition.text(searchValue))
                .shouldBe(Condition.visible);
    }

    @ParameterizedTest
    @DisplayName("Проверка поиска и отображения товаров в разделе Напитки")
    @Tag("Critical")
    @EnumSource(SearchRequest.class)
    void drinksSectionSearchAndDisplayTestsEnum(SearchRequest value) {
        open(OPENLINK);
        $("input[type='text']").setValue(value.name());
        $("button[type='button']").click();
        $$("#content")
                .find(Condition.text(value.name()))
                .shouldBe(Condition.visible);

    }
}
