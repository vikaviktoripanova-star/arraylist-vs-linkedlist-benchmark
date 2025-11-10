package com.benchmark;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit-тесты для класса {@link Benchmark}.
 * Проверяет корректность работы методов тестирования производительности
 * для операций со списками {@link ArrayList} и {@link LinkedList}.
 * 
 * @author Panova Viktoria
 * @version 1.0
 */
class ListPerformanceTesterTest {

    /**
     * Стандартный размер тестовых данных для выполнения операций.
     * Используется для всех тестов производительности.
     */
    private static final int TEST_SIZE = 100;

    /**
     * Тестирует операцию добавления элементов в {@link ArrayList}.
     * Проверяет, что метод {@link Benchmark#testAdd(List, int)} возвращает
     * корректный объект {@link Result} с правильными значениями полей.
     */
    @Test
    void testArrayListAdd() {
        List<Integer> list = new ArrayList<>();
        Result result = Benchmark.testAdd(list, TEST_SIZE);
        
        assertNotNull(result);
        assertEquals("add", result.getMethodName());
        assertEquals("ArrayList", result.getListType());
        assertEquals(TEST_SIZE, result.getOperationsCount());
        assertTrue(result.getExecutionTime() >= 0);
    }

    /**
     * Тестирует операцию добавления элементов в {@link LinkedList}.
     * Проверяет корректность работы метода добавления для связного списка.
     */
    @Test
    void testLinkedListAdd() {
        List<Integer> list = new LinkedList<>();
        Result result = Benchmark.testAdd(list, TEST_SIZE);
        
        assertNotNull(result);
        assertEquals("add", result.getMethodName());
        assertEquals("LinkedList", result.getListType());
        assertEquals(TEST_SIZE, result.getOperationsCount());
        assertTrue(result.getExecutionTime() >= 0);
    }

    /**
     * Тестирует операцию получения элементов из {@link ArrayList}.
     * Проверяет работу метода {@link Benchmark#testGet(List, int)} для массива.
     */
    @Test
    void testArrayListGet() {
        List<Integer> list = new ArrayList<>();
        Result result = Benchmark.testGet(list, TEST_SIZE);
        
        assertNotNull(result);
        assertEquals("get", result.getMethodName());
        assertEquals("ArrayList", result.getListType());
        assertEquals(TEST_SIZE, result.getOperationsCount());
        assertTrue(result.getExecutionTime() >= 0);
    }

    /**
     * Тестирует операцию получения элементов из {@link LinkedList}.
     * Проверяет работу метода получения для связного списка.
     */
    @Test
    void testLinkedListGet() {
        List<Integer> list = new LinkedList<>();
        Result result = Benchmark.testGet(list, TEST_SIZE);
        
        assertNotNull(result);
        assertEquals("get", result.getMethodName());
        assertEquals("LinkedList", result.getListType());
        assertEquals(TEST_SIZE, result.getOperationsCount());
        assertTrue(result.getExecutionTime() >= 0);
    }

    /**
     * Тестирует операцию удаления элементов из начала {@link ArrayList}.
     * Проверяет работу метода {@link Benchmark#testDeleteFirst(List, int)} для массива.
     */
    @Test
    void testArrayListDeleteFirst() {
        List<Integer> list = new ArrayList<>();
        Result result = Benchmark.testDeleteFirst(list, TEST_SIZE);
        
        assertNotNull(result);
        assertEquals("deleteFirst", result.getMethodName());
        assertEquals("ArrayList", result.getListType());
        assertEquals(TEST_SIZE, result.getOperationsCount());
        assertTrue(result.getExecutionTime() >= 0);
    }

    /**
     * Тестирует операцию удаления элементов из начала {@link LinkedList}.
     * Проверяет работу метода удаления из начала для связного списка.
     */
    @Test
    void testLinkedListDeleteFirst() {
        List<Integer> list = new LinkedList<>();
        Result result = Benchmark.testDeleteFirst(list, TEST_SIZE);
        
        assertNotNull(result);
        assertEquals("deleteFirst", result.getMethodName());
        assertEquals("LinkedList", result.getListType());
        assertEquals(TEST_SIZE, result.getOperationsCount());
        assertTrue(result.getExecutionTime() >= 0);
    }

    /**
     * Тестирует операцию добавления элементов в начало {@link ArrayList}.
     * Проверяет работу метода {@link Benchmark#testAddFirst(List, int)} для массива.
     */
    @Test
    void testArrayListAddFirst() {
        List<Integer> list = new ArrayList<>();
        Result result = Benchmark.testAddFirst(list, TEST_SIZE);
        
        assertNotNull(result);
        assertEquals("addFirst", result.getMethodName());
        assertEquals("ArrayList", result.getListType());
        assertEquals(TEST_SIZE, result.getOperationsCount());
        assertTrue(result.getExecutionTime() >= 0);
    }

    /**
     * Тестирует операцию добавления элементов в начало {@link LinkedList}.
     * Проверяет работу метода добавления в начало для связного списка.
     */
    @Test
    void testLinkedListAddFirst() {
        List<Integer> list = new LinkedList<>();
        Result result = Benchmark.testAddFirst(list, TEST_SIZE);
        
        assertNotNull(result);
        assertEquals("addFirst", result.getMethodName());
        assertEquals("LinkedList", result.getListType());
        assertEquals(TEST_SIZE, result.getOperationsCount());
        assertTrue(result.getExecutionTime() >= 0);
    }

    /**
     * Тестирует операцию удаления элементов из конца {@link ArrayList}.
     * Проверяет работу метода {@link Benchmark#testDeleteLast(List, int)} для массива.
     */
    @Test
    void testArrayListDeleteLast() {
        List<Integer> list = new ArrayList<>();
        Result result = Benchmark.testDeleteLast(list, TEST_SIZE);
        
        assertNotNull(result);
        assertEquals("deleteLast", result.getMethodName());
        assertEquals("ArrayList", result.getListType());
        assertEquals(TEST_SIZE, result.getOperationsCount());
        assertTrue(result.getExecutionTime() >= 0);
    }

    /**
     * Тестирует операцию удаления элементов из конца {@link LinkedList}.
     * Проверяет работу метода удаления из конца для связного списка.
     */
    @Test
    void testLinkedListDeleteLast() {
        List<Integer> list = new LinkedList<>();
        Result result = Benchmark.testDeleteLast(list, TEST_SIZE);
        
        assertNotNull(result);
        assertEquals("deleteLast", result.getMethodName());
        assertEquals("LinkedList", result.getListType());
        assertEquals(TEST_SIZE, result.getOperationsCount());
        assertTrue(result.getExecutionTime() >= 0);
    }

    /**
     * Тестирует создание и функциональность объекта {@link Result}.
     * Проверяет корректность работы геттеров и методов преобразования,
     * включая преобразование времени из наносекунд в миллисекунды.
     */
    @Test
    void testResultObject() {
        Result result = new Result("test", "ArrayList", 100, 5000000L, "add");
        
        assertEquals("test", result.getMethodName());
        assertEquals("ArrayList", result.getListType());
        assertEquals(100, result.getOperationsCount());
        assertEquals(5000000L, result.getExecutionTime());
        assertEquals(5.0, result.getTimeInMillis(), 0.001);
        assertEquals("add", result.getOperationType());
        
        assertNotNull(result.toString());
    }
}