package yahoo.andreikuzn.pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class CalendarComponent {

    private SelenideElement dateInput = $("#dateOfBirthInput");

    public void setDate(String day, String month, String year) {
        dateInput.click();
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOptionByValue(month);
        $(".react-datepicker__year-select").selectOptionByValue(year);
        $(".react-datepicker__day--030"+ day +":not(.react-datepicker__day--outside-month)").click();
    }
}

