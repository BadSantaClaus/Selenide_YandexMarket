package helpers;

import org.junit.jupiter.params.provider.Arguments;
import java.util.stream.Stream;
/**
 * Класс для предоставления аргурментов тестам
 *
 * @author Горячев Роман Юрьевич
 */
public class DataProvider {
    /**
     * Метод для задания аргументов, которые будут переданы в тест
     *
     * @author Горячев Роман Юрьевич
     * @return стрим аргументов для прохождения теста
     */
    public static Stream<Arguments> provideTestYandexMarket() {
        return Stream.of(
                Arguments.of("Электроника", "Смартфоны", "Apple")
        );
    }
}
