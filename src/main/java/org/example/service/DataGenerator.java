package org.example.service;

import com.github.javafaker.Faker;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

import static java.util.Collections.unmodifiableList;
import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;

/***
 * Сервис для генерации рандомных листов, тебе сюда не надо... Ладно на Faker можешь посмотреть, но остальное
 * не трогать) Тебе в StreamService
 */
public class DataGenerator {
    private static final List<Integer> INTEGER_LIST = new ArrayList<>();
    private static final List<String> STRING_LIST = new ArrayList<>();
    private static final String RANDOM_STRING = randomAlphabetic(30,100);
    private static final Faker faker = new Faker();

    public DataGenerator(int testDataAmount) {
        INTEGER_LIST.addAll(Stream.generate(() -> new Random().nextInt(1000))
                .limit(testDataAmount)
                .toList());
        STRING_LIST.addAll(Stream.generate(() -> faker.animal().name())
                .limit(testDataAmount)
                .toList());
    }

    public List<Integer> getRandomIntegerList(){
        return unmodifiableList(INTEGER_LIST);
    }
    public List<String> getRandomStringList(){
        return unmodifiableList(STRING_LIST);
    }
    public String getRandomString(){
        return RANDOM_STRING;
    }
}
