package pages.selenide;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import helpers.Assertions;
import io.qameta.allure.Step;
import lombok.Getter;
import lombok.Setter;
import static com.codeborne.selenide.Selenide.*;
/**
 * Класс используется для задания переменных и методов на странице результатов поиска ЯндексМаркета в паттерне PageObject
 *
 * @author Горячев Роман Юрьевич
 */
@Getter
@Setter
public class YandexMarketResults extends BasePage {
    /**
     * Элемент страницы - Рекомендации
     *
     * @author Горячев Роман Юрьевич
     */
    SelenideElement recommendations = $x("//h2[contains(text(), 'Рекомендации')]");
    /**
     * Элемент страницы, содержащий нумерацию страниц
     *
     * @author Горячев Роман Юрьевич
     */
    SelenideElement pager = $x("//div[@data-baobab-name='pager']");
    /**
     * Элемент страницы, содержащий кнопку "Вперёд"
     *
     * @author Горячев Роман Юрьевич
     */
    SelenideElement forward = $x("//div[@data-baobab-name='next']");
    /**
     * Элемент страницы, содержащий загрузочный экран
     *
     * @author Горячев Роман Юрьевич
     */
    SelenideElement loading = $x("//div[@data-apiary-widget-name = '@marketfront/SearchSerp']//div[@data-auto= 'preloader']");
    /**
     * Список результатов поиска
     *
     * @author Горячев Роман Юрьевич
     */
    ElementsCollection articles = $$x("//article[contains(@data-zone-data, 'shopId')]");
    /**
     * Метод для проверки, что в результатах поиска содержатся товары с заданным производителем с перелистыванием страниц если присутствует кнопка "Вперёд"
     *
     * @author Горячев Роман Юрьевич
     * @param producer производитель
     */
    @Step("Проверяем, что в результатах поиска содержатся товары с производителем: {producer}")
    public void checkFilters(String producer) {
        if(producer.equalsIgnoreCase("Apple")){
            producer = "Iphone";
        }
        while (true) {
            loading.shouldNotBe(Condition.visible);
            for (int i = 0; i < articles.size(); i++) {
                articles.get(i).scrollTo();
                Assertions.assertTrue(articles.get(i).getText().toLowerCase().contains(producer.toLowerCase()),
                        "В резульататх поиска не найдено товара с производителем: " + producer + " в статье под номером " + i);
            }
            if (pager.getText().contains("Вперёд")) {
                forward.click();
            }  else break;
        }
    }
}
