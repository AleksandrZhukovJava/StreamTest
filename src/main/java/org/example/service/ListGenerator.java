package org.example.service;

import com.github.javafaker.Faker;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

import static java.util.Collections.unmodifiableList;

/***
 * Сервис для генерации рандомных листов, тебе сюда не надо... Ладно на Faker можешь посмотреть, но остальное
 * не трогать) Тебе в StreamService
 */
public class ListGenerator {
    private static final List<Integer> INTEGER_LIST = new ArrayList<>();
    private static final List<String> STRING_LIST = new ArrayList<>();
    private static final Faker faker = new Faker();

    public ListGenerator(int testDataAmount) {
        INTEGER_LIST.addAll(Stream.generate(() -> new Random().nextInt(1000))
                .limit(testDataAmount)
                .toList());
        STRING_LIST.addAll(Stream.generate(() -> faker.animal().name())
                .limit(testDataAmount)
                .toList());
    }

    public List<Integer> getIntegerList(){
        return unmodifiableList(INTEGER_LIST);
    }
    public List<String> getStringList(){
        return unmodifiableList(STRING_LIST);
    }
}
