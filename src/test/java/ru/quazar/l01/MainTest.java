package ru.quazar.l01;

import lombok.SneakyThrows;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class MainTest {

    List<Integer> expectedList = new ArrayList<>();
    CustomList<Integer> actualList = new CustomList<>();
    int testMinRange;
    int testMaxRange;
    int actualMinRange;
    int actualMaxRange;

    @SneakyThrows
    @BeforeEach
    public void setUp() {
        testMinRange = 0;
        testMaxRange = 999;
        actualMinRange = 0;
        actualMaxRange = 999;
        actualList.add(actualMinRange);
        actualList.add(actualMaxRange);
    }

    @SneakyThrows
    @AfterEach
    public void tearDown() {
        expectedList.add(testMinRange);
        expectedList.add(testMaxRange);
        actualMinRange = 0;
        actualMaxRange = 0;
    }

    @Test
    void testMain() {
        MinimumClass<Integer> minClass = new MinimumClass<>();
        MaximumClass<Integer> maxClass = new MaximumClass<>();

        Assertions.assertEquals(testMinRange, (int) minClass.minElement(actualList));
        Assertions.assertEquals(testMaxRange, (int) maxClass.maxElement(actualList));

    }

    @Test
    void testEquals() {
    }

    @Test
    void testHashCode() {
    }

    @Test
    void testToString() {
    }
}