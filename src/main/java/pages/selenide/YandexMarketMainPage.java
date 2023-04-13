package pages.selenide;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.page;
/**
 * Класс используется для задания переменных и методов на главной странице ЯндексМаркета в паттерне PageObject
 *
 * @author Горячев Роман Юрьевич
 */
public class YandexMarketMainPage extends BasePage{
    /**
     * Элемент страницы - каталог
     *
     * @author Горячев Роман Юрьевич
     */
    SelenideElement catalogue = $x("//button[@aria-controls='catalogPopup']");
    /**
     * Метод для проверки, что в результатах поиска содержатся товары с заданным производителем с перелистыванием страниц если присутствует кнопка "Вперёд"
     *
     * @author Горячев Роман Юрьевич
     * @param url адрес страницы
     * @param typeNextPage класс, PageObject которого нужно получить по завершению метода
     * @return PageObject класса, который был передан в качестве аргумента
     */
    @Step("Переходим на сайт: {url}")
    public static <T extends BasePage> T openSite(String url, Class<T> typeNextPage){ ;
        open(url);
        return typeNextPage.cast(page(typeNextPage));
    }
    /**
     * Метод для открытия каталога
     *
     * @author Горячев Роман Юрьевич
     * @param typeNextPage класс, PageObject которого нужно получить по завершению метода
     * @return PageObject класса, который был передан в качестве аргумента
     */
    @Step("Открываем каталог")
    public <T extends BasePage> T getCatalogueList(Class<T> typeNextPage){
        catalogue.click();
        return typeNextPage.cast(page(typeNextPage));
    }
    /**
     * Метод для выбора заданной категории
     *
     * @author Горячев Роман Юрьевич
     * @param catalogueSection наименование раздела каталога
     * @param typeNextPage класс, PageObject которого нужно получить по завершению метода
     * @return PageObject класса, который был передан в качестве аргумента
     */
    @Step("Выбираем категорию: {category}")
    public <T extends BasePage> T goToCategory(String catalogueSection, String category, Class<T> typeNextPage){
        SelenideElement cataloguePart = $x("//li[@data-zone-name='category-link']//span[translate(.,'ABCDEFGHIJKLMNOPQRSTUVWXYZАБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ'," +
                "'abcdefghijklmnopqrstuvwxyzабвгдеёжзийклмнопрстуфхцчшщъыьэюя')='" + catalogueSection.toLowerCase() + "']");
        cataloguePart.shouldBe(enabled);
        actions().moveToElement(cataloguePart).perform();
        SelenideElement categoryElem = $x("//div[@role='tabpanel']//div[translate(.,'ABCDEFGHIJKLMNOPQRSTUVWXYZАБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ'," +
                "'abcdefghijklmnopqrstuvwxyzабвгдеёжзийклмнопрстуфхцчшщъыьэюя')='" + category.toLowerCase() + "']");
        categoryElem.shouldBe(visible);
        categoryElem.click();
        return typeNextPage.cast(page(typeNextPage));
    }


}




//li[@data-zone-name='category-link']//span[translate(.,'ABCDEFGHIJKLMNOPQRSTUVWXYZАБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ','abcdefghijklmnopqrstuvwxyzабвгдеёжзийклмнопрстуфхцчшщъыьэюя')='электроника']