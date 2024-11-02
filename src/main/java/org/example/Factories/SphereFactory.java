package org.example.Factories;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.entity.Point;
import org.example.entity.Sphere;
//import org.example.exceptions.IncorrectNumberOfPointsHasBeenReceivedAtTheInputException;

import java.util.List;

public class SphereFactory {
    private static final Logger logger = LogManager.getLogger(SphereFactory.class);
    private static int id_counter = 1;

    public static Sphere createSphere(Point center, double radius) {
        if (radius <= 0) {
            logger.error("Ошибка: радиус шара должен быть положительным. Получено: {}", radius);
            throw new IllegalArgumentException("Радиус шара должен быть положительным числом.");
        }

        Sphere sphere = new Sphere(center, radius, id_counter);
        logger.info("Создан шар с ID {}: {}", id_counter, sphere);
        id_counter++; // Увеличиваем счётчик для следующего шара
        return sphere;
    }

    // Метод для сброса счётчика (опционально, если нужно)
    public static void resetCounter() {
        logger.info("Сброс счетчика ID шара с текущего значения: {}", id_counter);
        id_counter = 1;
        logger.info("Счетчик ID успешно сброшен на 1");
    }
}
