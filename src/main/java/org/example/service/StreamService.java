package org.example.service;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/***
 * Над каждым методом условие задачи, после решения с помощью Stream API,её можно проверить запустив одноименный тест метод в пакете
 * test.org.example.service.StreamServiceTest
 * Каждая задача решается в 1 строчку (очень редко в 2).
 * Начать надо с обращения к геттеру listGenerator в котором можно получить тестовый лист
 * То есть флоу такой:
 * - Взял задачу.
 * - дописал в метод вместо null одну строчку начинающуюся с вызова listGenerator.getНужныйЛист.
 * - Пошел в тестовый пакет, запустил тест.
 *
 * P/S В скобочках под звездочкой наличие усложненного ыварианта решения. По желанию.
 */
public class StreamService {
    private final DataGenerator dataGenerator;

    public StreamService(DataGenerator dataGenerator) {
        this.dataGenerator = dataGenerator;
    }

    //todo Вернуть тот-же лист что и был как бабуля
    // (это пример)
    public List<String> example() {
        return dataGenerator.getRandomStringList()
                .stream()
                .toList();
    }

    //todo Вернуть спиок длинн всех строк в списке в виде списка
    public List<Integer> task_1() {
        return null; //код тут
    }

    //todo Вернуть максимальное число из списка
    public Integer task_2() {
        return null; //код тут
    }

    //todo Вернуть спиок только уникальных строк из списка
    // (* сделать другим способом, сложный вариант)
    public List<String> task_3() {
        return null; //код тут
    }

    //todo Вернуть список строк начинающихся с заданной буквы в любом кейсе
    public List<String> task_4(String letter) {
        return null; //код тут
    }

    //todo Вернуть список нечетных чисел отсортированных в порядке убывания
    // (* сделать другим способом)
    public List<Integer> task_5() {
        return null; //код тут
    }

    //todo Вернуть список строк длинна которых не больше заданной и не меньше заданной
    // (* сделать используя один конвеерный оператор)
    public List<String> task_6(int minLength, int maxLength) {
        return null; //код тут
    }

    //todo Объъедиинть лист строк в одно длинное слово
    // (* сделать другим способом, сложный вариант)
    public String task_7() {
        return null; //код тут
    }

    //todo Вернуть среднее арифметическое по листу чисел
    // (* решить в одну строку, сложный вариант)
    public Double task_8() {
        return null; //код тут
    }

    //todo Вернуть количество строк в которых содержиться заданное слово без учета регистра
    public Long task_9(String word) {
        return null; //код тут
    }

    //todo Необходимо вернуть первую строку которая равна входящему параметру без учета регистра,
    // иначе выкинуть IllegalArgumentException если такой строки нет (регистр содержащейся строки должен сохраниться)
    public String task_10(String word) {
        return null; //код тут
    }

    //todo Вернуть список остортированных по алфовиту, без повторов, состоящий только из первых 3ех слов после сортировки!
    public List<String> task_11() {
        return null; //код тут
    }

    //todo Нужно найти все уникальные символы в заданной строке и вернуть их в массиве в алфавитном порядке.
    // (* в 1 строку без явного приведения типов)
    public String[] task_12() {
        return null;
    }

    //todo Нужно вернуть спиок длинн всех строк в списке в виде списка
    public List<Integer> task_13() {
        return null; //код тут
    }

    //todo Нужно вернуть спиок длинн всех строк в списке в виде списка
    public List<Integer> task_14() {
        return null; //код тут
    }

    //todo Нужно вернуть спиок длинн всех строк в списке в виде списка
    public List<Integer> task_15() {
        return null; //код тут
    }

    //todo Нужно вернуть спиок длинн всех строк в списке в виде списка
    public List<Integer> task_16() {
        return null; //код тут
    }

    //todo Нужно вернуть спиок длинн всех строк в списке в виде списка
    public List<Integer> task_17() {
        return null; //код тут
    }

    //todo Нужно вернуть спиок длинн всех строк в списке в виде списка
    public List<Integer> task_18() {
        return null; //код тут
    }

    //todo Нужно вернуть спиок длинн всех строк в списке в виде списка
    public List<Integer> task_19() {
        return null; //код тут
    }

    //todo Нужно вернуть спиок длинн всех строк в списке в виде списка
    public List<Integer> task_20() {
        return null; //код тут
    }

    //todo Нужно вернуть спиок длинн всех строк в списке в виде списка
    public List<Integer> task_21() {
        return null; //код тут
    }

    //todo Возвращает список простых чисел (число делится только на себя и на 1)
    public List<Integer> task_22() {
        return null;
    }

    public Map<String, Long> boss(String sentence) {
        return Stream.of(sentence.replaceAll("[\\W|\\d]", " ").trim().split("\\s+"))
                .collect(Collectors.groupingBy(String::toLowerCase, Collectors.counting()));

    }

}
