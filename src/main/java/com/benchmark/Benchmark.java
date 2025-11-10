package com.benchmark;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Утилитарный класс для измерения производительности операций со списками.
 * Предоставляет статические методы для тестирования основных операций 
 * ArrayList и LinkedList, таких как добавление, получение и удаление элементов.
 * 
 * @author Panova Viktoria
 * @version 1.0
 */
public class Benchmark {
    
    /**
     * Тестирует производительность операции добавления элементов в конец списка.
     * Измеряет время, необходимое для добавления указанного количества элементов
     * в конец списка с помощью метода {@code add()}.
     *
     * @param list список, на основе типа которого создается тестовый список
     * @param elementsCount количество элементов для добавления
     * @return объект {@link Result} с результатами тестирования, содержащий
     *         название метода, тип списка, количество операций и время выполнения
     * @throws NullPointerException если переданный список равен null
     */
    public static Result testAdd(List<Integer> list, int elementsCount) {
        List<Integer> testList = createNewList(list);
        
        long startTime = System.nanoTime();
        for (int i = 0; i < elementsCount; i++) {
            testList.add(i);
        }
        long endTime = System.nanoTime();
        
        return new Result("add", testList.getClass().getSimpleName(), 
                         elementsCount, endTime - startTime, "add");
    }

    /**
     * Тестирует производительность операции добавления элементов в начало списка.
     * Измеряет время, необходимое для добавления указанного количества элементов
     * в начало списка с помощью метода {@code add(0, element)}.
     * Эта операция демонстрирует разницу в производительности между ArrayList
     * и LinkedList при вставке в начало.
     *
     * @param list список, на основе типа которого создается тестовый список
     * @param elementsCount количество элементов для добавления в начало
     * @return объект {@link Result} с результатами тестирования
     * @throws NullPointerException если переданный список равен null
     */
    public static Result testAddFirst(List<Integer> list, int elementsCount) {
        List<Integer> testList = createNewList(list);
        
        long startTime = System.nanoTime();
        for (int i = 0; i < elementsCount; i++) {
            testList.add(0, i);
        }
        long endTime = System.nanoTime();
        
        return new Result("addFirst", testList.getClass().getSimpleName(), 
                         elementsCount, endTime - startTime, "add");
    }

    /**
     * Тестирует производительность операции получения элементов по индексу.
     * Измеряет время, необходимое для выполнения указанного количества операций
     * получения элементов с помощью метода {@code get()}.
     * Перед тестированием заполняет список тестовыми данными.
     *
     * @param list список, на основе типа которого создается тестовый список
     * @param operationsCount количество операций получения элементов
     * @return объект {@link Result} с результатами тестирования
     * @throws NullPointerException если переданный список равен null
     */
    public static Result testGet(List<Integer> list, int operationsCount) {
        List<Integer> testList = createNewList(list);
        
        for (int i = 0; i < operationsCount; i++) {
            testList.add(i);
        }
        
        long startTime = System.nanoTime();
        for (int i = 0; i < operationsCount; i++) {
            testList.get(i % testList.size());
        }
        long endTime = System.nanoTime();
        
        return new Result("get", testList.getClass().getSimpleName(), 
                         operationsCount, endTime - startTime, "get");
    }

    /**
     * Тестирует производительность операции удаления элементов из начала списка.
     * Измеряет время, необходимое для удаления указанного количества элементов
     * из начала списка с помощью метода {@code remove(0)}.
     * Перед тестированием заполняет список достаточным количеством элементов
     * для выполнения всех операций удаления.
     *
     * @param list список, на основе типа которого создается тестовый список
     * @param operationsCount количество операций удаления элементов из начала
     * @return объект {@link Result} с результатами тестирования
     * @throws NullPointerException если переданный список равен null
     */
    public static Result testDeleteFirst(List<Integer> list, int operationsCount) {
        List<Integer> testList = createNewList(list);
        
        for (int i = 0; i < operationsCount * 2; i++) {
            testList.add(i);
        }
        
        long startTime = System.nanoTime();
        for (int i = 0; i < operationsCount; i++) {
            if (!testList.isEmpty()) {
                testList.remove(0);
            }
        }
        long endTime = System.nanoTime();
        
        return new Result("deleteFirst", testList.getClass().getSimpleName(), 
                         operationsCount, endTime - startTime, "delete");
    }

    /**
     * Тестирует производительность операции удаления элементов из конца списка.
     * Измеряет время, необходимое для удаления указанного количества элементов
     * из конца списка с помощью метода {@code remove(list.size() - 1)}.
     * Перед тестированием заполняет список достаточным количеством элементов
     * для выполнения всех операций удаления.
     *
     * @param list список, на основе типа которого создается тестовый список
     * @param operationsCount количество операций удаления элементов из конца
     * @return объект {@link Result} с результатами тестирования
     * @throws NullPointerException если переданный список равен null
     */
    public static Result testDeleteLast(List<Integer> list, int operationsCount) {
        List<Integer> testList = createNewList(list);
        
        for (int i = 0; i < operationsCount * 2; i++) {
            testList.add(i);
        }
        
        long startTime = System.nanoTime();
        for (int i = 0; i < operationsCount; i++) {
            if (!testList.isEmpty()) {
                testList.remove(testList.size() - 1);
            }
        }
        long endTime = System.nanoTime();
        
        return new Result("deleteLast", testList.getClass().getSimpleName(), 
                         operationsCount, endTime - startTime, "delete");
    }

    /**
     * Создает новый экземпляр списка того же типа, что и переданный список.
     * Поддерживает создание ArrayList и LinkedList. Если тип списка неизвестен,
     * по умолчанию создается ArrayList.
     *
     * @param original оригинальный список, тип которого используется для создания нового списка
     * @return новый экземпляр списка того же типа, что и оригинальный список
     * @throws NullPointerException если переданный список равен null
     */
    private static List<Integer> createNewList(List<Integer> original) {
        if (original instanceof ArrayList) {
            return new ArrayList<>();
        } else if (original instanceof LinkedList) {
            return new LinkedList<>();
        } else {
            return new ArrayList<>();
        }
    }
}