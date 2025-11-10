package com.benchmark;

/**
 * Класс для хранения результатов тестирования производительности.
 * Содержит информацию о выполненной операции, типе коллекции,
 * количестве операций и времени выполнения. Предоставляет методы
 * для удобного форматирования и представления результатов.
 * 
 * @author Panova Viktoria 
 * @version 1.0
 */
public class Result {
    private final String methodName;
    private final String listType;
    private final int operationsCount;
    private final long executionTime;
    private final String operationType;

    /**
     * Конструктор для создания объекта результата тестирования.
     *
     * @param methodName название тестируемого метода (например, "add", "get", "deleteFirst")
     * @param listType тип списка ("ArrayList" или "LinkedList")
     * @param operationsCount количество выполненных операций
     * @param executionTime время выполнения операций в наносекундах
     * @param operationType тип операции ("add", "get", "delete", "mixed")
     */
    public Result(String methodName, String listType, int operationsCount, 
                  long executionTime, String operationType) {
        this.methodName = methodName;
        this.listType = listType;
        this.operationsCount = operationsCount;
        this.executionTime = executionTime;
        this.operationType = operationType;
    }

    /**
     * Возвращает название тестируемого метода.
     *
     * @return название метода
     */
    public String getMethodName() { return methodName; }

    /**
     * Возвращает тип списка, для которого проводилось тестирование.
     *
     * @return тип списка ("ArrayList" или "LinkedList")
     */
    public String getListType() { return listType; }

    /**
     * Возвращает количество выполненных операций в тесте.
     *
     * @return количество операций
     */
    public int getOperationsCount() { return operationsCount; }

    /**
     * Возвращает время выполнения операций в наносекундах.
     *
     * @return время выполнения в наносекундах
     */
    public long getExecutionTime() { return executionTime; }

    /**
     * Возвращает общий тип операции.
     *
     * @return тип операции ("add", "get", "delete", "mixed")
     */
    public String getOperationType() { return operationType; }

    /**
     * Возвращает время выполнения операций в миллисекундах.
     * Выполняет преобразование из наносекунд в миллисекунды.
     *
     * @return время выполнения в миллисекундах
     */
    public double getTimeInMillis() {
        return executionTime / 1_000_000.0;
    }

    /**
     * Возвращает строковое представление объекта результата.
     * Форматирует данные в виде табличной строки для удобного вывода.
     * Формат: "Метод | ТипСписка | КоличествоОпераций | Время(мс) | ТипОперации"
     *
     * @return форматированное строковое представление результата
     */
    @Override
    public String toString() {
        return String.format("%-15s | %-12s | %10d | %12.3f ms | %-8s",
                methodName, listType, operationsCount, getTimeInMillis(), operationType);
    }
}