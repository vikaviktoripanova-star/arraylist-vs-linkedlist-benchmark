package com.benchmark;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Основной класс для тестирования производительности ArrayList и LinkedList.
 * Выполняет сравнительный анализ основных операций коллекций и выводит
 * результаты в табличном формате с детальным сравнением производительности.
 * 
 * @author Panova Viktoria 
 * @version 1.0
 */
public class ListPerformanceTester {
    
    /**
     * Массив размеров тестовых данных для проведения измерений производительности.
     * Определяет количество операций, выполняемых в каждом тестовом прогоне.
     */
    private static final int[] TEST_SIZES = {1000, 2000, 5000};

    /**
     * Основной метод приложения, запускающий процесс тестирования производительности.
     * Выполняет серию тестов для каждого размера данных из {@code TEST_SIZES},
     * выводит результаты в консоль в удобочитаемом формате.
     *
     * @param args аргументы командной строки (не используются)
     */
    public static void main(String[] args) {
        System.out.println("=== Сравнение производительности ArrayList и LinkedList ===\n");
        
        for (int size : TEST_SIZES) {
            System.out.println("Тестирование для " + size + " операций:");
            System.out.println("=".repeat(80));
            
            runPerformanceTests(size);
            System.out.println();
        }
    }

    /**
     * Выполняет полный цикл тестирования производительности для указанного количества операций.
     * Тестирует основные операции со списками: добавление в конец, добавление в начало,
     * получение по индексу, удаление из начала и удаление из конца.
     *
     * @param operationsCount количество операций для выполнения в каждом тесте
     */
    private static void runPerformanceTests(int operationsCount) {
        List<Result> results = new ArrayList<>();
        
        // Создаем экземпляры списков для тестирования
        List<Integer> arrayList = new ArrayList<>();
        List<Integer> linkedList = new LinkedList<>();
        
        // Тестируем операции добавления в конец
        results.add(Benchmark.testAdd(arrayList, operationsCount));
        results.add(Benchmark.testAdd(linkedList, operationsCount));
        
        // Тестируем операции добавления в начало
        results.add(Benchmark.testAddFirst(arrayList, operationsCount));
        results.add(Benchmark.testAddFirst(linkedList, operationsCount));
        
        // Тестируем операции получения по индексу
        results.add(Benchmark.testGet(arrayList, operationsCount));
        results.add(Benchmark.testGet(linkedList, operationsCount));
        
        // Тестируем операции удаления из начала
        results.add(Benchmark.testDeleteFirst(arrayList, operationsCount));
        results.add(Benchmark.testDeleteFirst(linkedList, operationsCount));
        
        // Тестируем операции удаления из конца
        results.add(Benchmark.testDeleteLast(arrayList, operationsCount));
        results.add(Benchmark.testDeleteLast(linkedList, operationsCount));
        
        printResults(results);
    }

    /**
     * Выводит результаты тестирования в табличном формате.
     * Форматирует данные для удобного восприятия, включая название метода,
     * тип списка, количество операций и время выполнения.
     *
     * @param results список объектов {@link Result} с результатами тестирования
     */
    private static void printResults(List<Result> results) {
        // Заголовок таблицы
        System.out.printf("%-15s | %-12s | %10s | %12s | %-8s%n",
                "Method", "List Type", "Operations", "Time (ms)", "Type");
        System.out.println("-".repeat(75));
        
        // Данные таблицы
        for (Result result : results) {
            System.out.printf("%-15s | %-12s | %10d | %12.3f | %-8s%n",
                    result.getMethodName(),
                    result.getListType(),
                    result.getOperationsCount(),
                    result.getTimeInMillis(),
                    result.getOperationType());
        }
        
        // Дополнительное сравнение производительности
        printComparison(results);
    }

    /**
     * Выводит сравнительный анализ производительности ArrayList и LinkedList.
     * Для каждой пары тестов (ArrayList vs LinkedList) вычисляет, какая реализация
     * быстрее и во сколько раз, выводит эту информацию в формате:
     * "Метод: ArrayList: X.XXX ms, LinkedList: Y.YYY ms | Быстрее: Реализация (в Z.ZZ раз)"
     *
     * @param results список объектов {@link Result}, сгруппированных попарно
     *                (ArrayList, LinkedList для каждого метода)
     */
    private static void printComparison(List<Result> results) {
        System.out.println("\nСравнение производительности:");
        System.out.println("-".repeat(50));
        
        // Обрабатываем результаты попарно (ArrayList и LinkedList для каждого метода)
        for (int i = 0; i < results.size(); i += 2) {
            if (i + 1 < results.size()) {
                Result arrayListResult = results.get(i);
                Result linkedListResult = results.get(i + 1);
                
                double arrayListTime = arrayListResult.getTimeInMillis();
                double linkedListTime = linkedListResult.getTimeInMillis();
                
                // Выполняем сравнение только если оба времени положительные
                if (arrayListTime > 0 && linkedListTime > 0) {
                    String faster = arrayListTime < linkedListTime ? "ArrayList" : "LinkedList";
                    double ratio = Math.max(arrayListTime, linkedListTime) / Math.min(arrayListTime, linkedListTime);
                    
                    System.out.printf("%-12s: ArrayList: %6.3f ms, LinkedList: %6.3f ms | Быстрее: %-10s (в %.2f раз)%n",
                            arrayListResult.getMethodName(),
                            arrayListTime,
                            linkedListTime,
                            faster,
                            ratio);
                }
            }
        }
    }
}