package org.example.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static java.util.Collections.reverse;
import static java.util.Collections.sort;
import static org.assertj.core.api.Assertions.assertThat;

/***
 * Просто запускаешь все тесты через стрелку класса, или конкретный метод через ту же стрелку у него.
 * В самих тестах ничего трогать не нужно.
 *
 * P/S решения для сверки в тестах специально иногда сделаны не оптимально или даже коряво,
 * что-бы не подсказывать решения с помощью Stream API, не стоит на них ориентироваться в дальнейшем.
 */
public class StreamServiceTest {
    private final DataGenerator dataGenerator = new DataGenerator(100);
    private final StreamService underTest = new StreamService(dataGenerator);

    @Test
    @DisplayName("(test_0) Задание 0 нихрена не делает")
    public void test_0() {
        List<String> expected = dataGenerator.getRandomStringList();

        //test
        List<String> actual = underTest.example();

        //check
        assertThat(actual).hasSize(expected.size());
        assertThat(actual).containsExactlyElementsOf(expected);
    }

    @Test
    @DisplayName("(test_1) Задание 1 возвращает корректный лист длинн строк")
    public void test_1() {
        List<String> example = dataGenerator.getRandomStringList();
        List<Integer> expected = new ArrayList<>();
        for (String s : example) {
            expected.add(s.length());
        }

        //test
        List<Integer> actual = underTest.task_1();

        //check
        assertThat(actual).hasSize(expected.size());
        assertThat(actual).containsExactlyElementsOf(expected);
    }

    @Test
    @DisplayName("(test_2) Находится максимальное число в списке")
    public void task_2() {
        List<Integer> example = dataGenerator.getRandomIntegerList();
        Integer expected = example.get(0);
        for (Integer i : example) {
            if (i > expected) {
                expected = i;
            }
        }

        //test
        Integer actual = underTest.task_2();

        //check
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("(test_3) Возвращает только уникальные строки в виде листа")
    public void task_3() {
        List<String> example = dataGenerator.getRandomStringList();
        List<String> expected = new ArrayList<>();
        for (String s : example) {
            if (!expected.contains(s)) {
                expected.add(s);
            }
        }

        //test
        List<String> actual = underTest.task_3();

        //check
        assertThat(actual).hasSize(expected.size());
        assertThat(actual).containsExactlyElementsOf(expected);
    }

    /***
     * В меню тестов слева снизу можно посмотреть все тесты, их тут на само деле 5 штук в одном.
     * @param letter - передается автоматически
     */
    @ParameterizedTest
    @MethodSource("paramsForTask_4")
    @DisplayName("(test_4) Возвращается список из слов начинающихся на заданную букву")
    public void task_4(String letter) {
        List<String> example = dataGenerator.getRandomStringList();
        List<String> expected = new ArrayList<>();
        for (String s : example) {
            if (s.substring(0, 1).equalsIgnoreCase(letter)) {
                expected.add(s);
            }
        }

        //test
        List<String> actual = underTest.task_4(letter);

        //check
        assertThat(actual).hasSize(expected.size());
        assertThat(actual).containsExactlyElementsOf(expected);
    }

    @Test
    @DisplayName("(test_5) Возвращает лист нечетных чисел отсортированных по убыванию")
    public void task_5() {
        List<Integer> example = dataGenerator.getRandomIntegerList();
        List<Integer> expected = new ArrayList<>();
        for (Integer i : example) {
            if (i % 2 != 0) {
                expected.add(i);
            }
        }
        sort(expected);
        reverse(expected);

        //test
        List<Integer> actual = underTest.task_5();

        //check
        assertThat(actual).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("paramsForTask_6")
    @DisplayName("(test_6) Возвращает список строк длинна которых не больше заданной и не меньше заданной")
    public void task_6(int minLength, int maxLength) {
        List<String> example = dataGenerator.getRandomStringList();
        List<String> expected = new ArrayList<>();
        for (String s : example) {
            if (s.length() > minLength && s.length() < maxLength) {
                expected.add(s);
            }
        }

        //test
        List<String> actual = underTest.task_6(minLength, maxLength);

        //check
        assertThat(actual).hasSize(expected.size());
        assertThat(actual).containsExactlyElementsOf(expected);
    }

    @Test
    @DisplayName("(test_7) Возвращает строку состояющую из всех строк из листа вместе взятых")
    public void task_7() {
        List<String> example = dataGenerator.getRandomStringList();
        String expected = "";
        for (String s : example) {
            expected = expected.concat(s);
        }

        //test
        String actual = underTest.task_7();

        //check
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("(test_8) Возвращает среднее арифметичекое по листу чисел")
    public void task_8() {
        List<Integer> example = dataGenerator.getRandomIntegerList();
        Double sum = 0d;
        for (Integer i : example) {
            sum += i;
        }
        Double expected = sum / example.size();

        //test
        Double actual = underTest.task_8();

        //check
        assertThat(actual).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("paramsForTask_9_10")
    @DisplayName("(test_9) Возвращает количество строк в которых содержиться заданное слово")
    public void task_9(String word) {
        List<String> example = dataGenerator.getRandomStringList();
        Long expected = 0L;
        for (String s : example) {
            if (s.toLowerCase().contains(word.toLowerCase())) {
                expected++;
            }
        }

        //test
        Long actual = underTest.task_9(word);

        //check
        assertThat(actual).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("paramsForTask_9_10")
    @DisplayName("(test_10) Возвращает первую строку которая равна входящему параметру без учета регистра " +
            "иначе, если такой нет, выкидывает IllegalArgumentException")
    public void task_10(String word) {
        List<String> example = dataGenerator.getRandomStringList();
        String expected = null;
        for (String s : example) {
            if (s.equalsIgnoreCase(word)) {
                expected = s;
                break;
            }
        }

        //test
        String actual = null;
        try {
            actual = underTest.task_10(word);
        } catch (IllegalArgumentException e) {
            assertThat(expected).isNull();
        }

        //check
        if (actual != null) {
            assertThat(actual).isEqualTo(expected);
        }
    }

    @Test
    @DisplayName("(test_11) Возвращает список остортированных по алфовиту слов, без повторов, состоящий только из первых 3ех слов.")
    public void task_11() {
        List<String> example = dataGenerator.getRandomStringList();
        List<String> modifybleList = new ArrayList<>(example);
        sort(modifybleList);
        List<String> expected = new ArrayList<>();
        for (int i = 0; i < modifybleList.size() && expected.size() != 3; i++) {
            if (!expected.contains(modifybleList.get(i))) {
                expected.add(modifybleList.get(i));
            }
        }

        //test
        List<String> actual = underTest.task_11();
        System.out.println(actual);

        //check
        assertThat(actual).hasSize(expected.size());
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("Возвращает все уникальные символы в заданной строке в массиве в алфавитном порядке")
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
        List<Integer> example = dataGenerator.getRandomIntegerList();
        List<Integer> expected = new ArrayList<>();
        for (Integer integer : example) {
            boolean isEasy = integer != 0;
            for (int i = 2; i < integer; i++) {
                if (integer % i == 0) {
                    isEasy = false;
                    break;
                }
            }
            if (isEasy){
                expected.add(integer);
            }
        }

        //test
        List<Integer> actual = underTest.task_22();

        //check
        assertThat(actual).isEqualTo(expected);
    }

    private static Stream<Arguments> paramsForTask_4() {
        return Stream.of("w", "W", "ZZ", "A", "a").map(Arguments::of);
    }

    private static Stream<Arguments> paramsForTask_6() {
        return Stream.of(Arguments.of(2, 5),
                Arguments.of(0, 6),
                Arguments.of(2, 3),
                Arguments.of(0, 0));
    }

    private static Stream<Arguments> paramsForTask_9_10() {
        return Stream.of("ox", "OX", "foX", "fox", "FOX","Foxes").map(Arguments::of);
    }
}
