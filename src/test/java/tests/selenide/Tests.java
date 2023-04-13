package tests.selenide;

import helpers.Properties;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import pages.selenide.YandexMarketFilters;
import pages.selenide.YandexMarketMainPage;
import pages.selenide.YandexMarketResults;
import static pages.selenide.YandexMarketMainPage.openSite;
/**
 * Класс используется для запуска тестов
 *
 * @author Горячев Роман Юрьевич
 */
public class Tests extends BaseTests{
    /**
     * Метод для запуска теста "Проверка сайта ЯндексМаркет"
     *
     * @author Горячев Роман Юрьевич
     * @param catalogueSection наименование раздела каталога
     * @param category наименование категории
     * @param producer производитель
     */
    @Feature(("Проверка сайта ЯндексМаркет"))
    @DisplayName("Проверка результатов поиска на сайте ЯндексМаркет")
    @ParameterizedTest(name = "{displayName} c параметрами: {arguments}")
    @MethodSource("helpers.DataProvider#provideTestYandexMarket")
    public void testYandexMarket(String catalogueSection, String category, String producer){
        openSite(Properties.testsProperties.yandexmarketUrl(), YandexMarketMainPage.class)
                .getCatalogueList(YandexMarketMainPage.class)
                .goToCategory(catalogueSection, category, YandexMarketFilters.class)
                .setFilters(producer, YandexMarketResults.class)
                .checkFilters(producer);
    }
}
