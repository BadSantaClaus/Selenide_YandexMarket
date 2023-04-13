package pages.selenide;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.page;
/**
 * Класс используется для задания фильтров на странице результатов поиска ЯндексМаркета в паттерне PageObject
 *
 * @author Горячев Роман Юрьевич
 */
public class YandexMarketFilters extends BasePage{
    /**
     * Элемент страницы - Все фильтры
     *
     * @author Горячев Роман Юрьевич
     */
    SelenideElement allFilters = $x("//button//span[text() = 'Все фильтры']");
    /**
     * Элемент страницы - Показать ещё
     *
     * @author Горячев Роман Юрьевич
     */
    SelenideElement allProducers = $x("//span[text() = 'Показать ещё']");
    /**
     * Элемент страницы - Показать товары, соответветствующие заданному фильтру
     *
     * @author Горячев Роман Юрьевич
     */
    SelenideElement showGoods = $x("//a[contains(text(), 'Показать')]");
    /**
     * Метод для задания фильтров
     *
     * @author Горячев Роман Юрьевич
     * @param producer производитель
     * @param typeNextPage класс, PageObject которого нужно получить по завершению метода
     * @return PageObject класса, который был передан в качестве аргумента
     */
    @Step("Устанавливаем фильтр по производителю: {producer}")
    public <T extends BasePage> T setFilters(String producer, Class<T> typeNextPage){
        allFilters.click();
        allProducers.click();
        SelenideElement producerElem = $x("//div[translate(text(),'ABCDEFGHIJKLMNOPQRSTUVWXYZАБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ'," +
                "'abcdefghijklmnopqrstuvwxyzабвгдеёжзийклмнопрстуфхцчшщъыьэюя')='" + producer.toLowerCase() + "']");
        producerElem.shouldBe(Condition.visible);
        producerElem.click();
        showGoods.click();
        return typeNextPage.cast(page(typeNextPage));
    }

}