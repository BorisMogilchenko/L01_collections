package ru.quazar.l01;

import lombok.SneakyThrows;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.util.Objects;

class CustomListTest {

    CustomList<Integer> expectedList = new CustomList<>();
    CustomList<Integer> actualList = new CustomList<>();
    String actualListString;
    String expectedListString;
    int testMinRange;
    int testMaxRange;
    int actualMinRange;
    int actualMaxRange;

    @SneakyThrows
    @BeforeEach
    void setUp() {
        testMinRange = 0;
        testMaxRange = 999;
        actualMinRange = 0;
        actualMaxRange = 999;
        expectedList.add(testMinRange);
        expectedList.add(testMaxRange);
        actualList.add(actualMinRange);
        actualList.add(actualMaxRange);
    }

    @SneakyThrows
    @AfterEach
    void tearDown() {
        expectedList = null;
        actualList = null;
    }

    @Test
    public void listInstance_NO_NULL() {
        Assertions.assertNotNull(actualList);
    }

    @Test
    void testAdd() {
        Assertions.assertEquals(expectedList.getList().get(0), actualList.getList().get(0));
    }

    @Test
    void testRemove() {
        Assertions.assertEquals(expectedList.getList().remove(0), actualList.getList().remove(0));
    }

    @Test
    void testMaximumValue() {
        Assertions.assertTrue(actualList.getList().contains(actualMaxRange));
    }

    @Test
    void testMinimumValue() {
        Assertions.assertTrue(actualList.getList().contains(actualMinRange));
    }

    @SneakyThrows
    @Test
    void testList() {
        Field field = actualList.getClass().getDeclaredField("list");
        field.setAccessible(true);
//        List<?> actual = (List<?>) field.get(actualList);
        String actual = (String) field.get(actualList);

        Assertions.assertEquals(expectedList.toString(), actual);
    }

    @Test
    void testEquals() {
        Assertions.assertEquals(expectedList, actualList);
    }

/*    @Test
    public void hashCodeCustomList() {
        Assertions.assertEquals(Objects.hash(expectedList), actualList.hashCode());
    }

    @Test
    public void toStringTest() {
        Assertions.assertEquals(equals(expectedList), equals(actualList.toString()));
    }*/

    @Test
    void testHashCode() {
        Assertions.assertEquals(Objects.hash(expectedList), actualList.hashCode());
    }

    @Test
    void testToString() {

        actualListString = actualList.toString();
        expectedListString = expectedList.toString();

        Assertions.assertEquals(expectedListString, actualListString);
    }

    @SneakyThrows
    @Test
    void getList() {
        Field field = actualList.getClass().getDeclaredField("list");
        field.setAccessible(true);
        CustomList<?> actual = (CustomList<?>) field.get(actualList);

        Assertions.assertEquals(expectedList, actual);
        System.out.println("Получение списка: " + actual.toString());
    }

    @Test
    void setList() {
        Assertions.assertEquals(expectedList.getList().get(0), actualList.getList().get(0));
    }

    @Override
    public String toString() {
        return String.valueOf(expectedList);
    }
}
