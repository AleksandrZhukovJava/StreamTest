package org.example.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/***
 * Просто запускаешь все тесты через стрелку класса, или конкретный метод через ту же стрелку у него.
 * В самих тестах ничего трогать не нужно.
 */
public class StreamServiceTest {
    private final ListGenerator listGenerator = new ListGenerator(100);
    private final StreamService underTest = new StreamService(listGenerator);

    @Test
    @DisplayName("Задание 0 нихрена не делает")
    public void test_0() {
        List<String> expected = listGenerator.getStringList();

        //test
        List<String> actual = underTest.example();

        //check
        assertThat(actual).isNotNull();
        assertThat(actual).hasSize(expected.size());
        assertThat(actual).containsExactlyElementsOf(expected);
    }
    @Test
    @DisplayName("Задание 1 возвращает корректный лист длинн строк")
    public void test_1() {
        List<String> example = listGenerator.getStringList();
        List<Integer> expected = new ArrayList<>();
        for (String s : example) {
            expected.add(s.length());
        }

        //test
        List<Integer> actual = underTest.task_1();

        //check
        assertThat(actual).isNotNull();
        assertThat(actual).hasSize(expected.size());
        assertThat(actual).containsExactlyElementsOf(expected);
    }

    @Test
    @DisplayName("2")
    public void task_2() {
    }

    @Test
    @DisplayName("3")
    public void task_3() {
    }

    @Test
    @DisplayName("4")
    public void task_4() {
    }

    @Test
    @DisplayName("5")
    public void task_5() {
    }

    @Test
    @DisplayName("6")
    public void task_6() {
    }

    @Test
    @DisplayName("7")
    public void task_7() {
    }

    @Test
    @DisplayName("8")
    public void task_8() {
    }

    @Test
    @DisplayName("9")
    public void task_9() {
    }

    @Test
    @DisplayName("10")
    public void task_10() {
    }

    @Test
    @DisplayName("11")
    public void task_11() {
    }

    @Test
    @DisplayName("12")
    public void task_12() {
    }

    @Test
    @DisplayName("13")
    public void task_13() {
    }

    @Test
    @DisplayName("14")
    public void task_14() {
    }

    @Test
    @DisplayName("15")
    public void task_15() {
    }

    @Test
    @DisplayName("16")
    public void task_16() {
    }

    @Test
    @DisplayName("17")
    public void task_17() {
    }

    @Test
    @DisplayName("18")
    public void task_18() {
    }

    @Test
    @DisplayName("19")
    public void task_19() {
    }

    @Test
    @DisplayName("20")
    public void task_20() {
    }

    @Test
    @DisplayName("21")
    public void task_21() {
    }

    @Test
    @DisplayName("22")
    public void task_22() {
    }
}
