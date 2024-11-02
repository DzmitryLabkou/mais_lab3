package org.example.services;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.entity.Point;
import org.example.entity.Sphere;

public class SphereValidator {
    private static final Logger logger = LogManager.getLogger(SphereValidator.class);
    private static final double EPSILON = 0.001;

    /**
     * Проверяет, является ли объект валидной сферой.
     * @param sphere сфера для проверки
     * @return true, если сфера валидна
     */
    public static boolean validateSphere(Sphere sphere) {
        logger.info("Проверка валидности сферы: {}", sphere);
        double radius = sphere.getRadius();

        if (radius <= EPSILON) {
            logger.error("Ошибка: радиус сферы должен быть больше нуля. Радиус: {}", radius);
            return false;
        }

        logger.info("Сфера валидна.");
        return true;
    }

    /**
     * Вычисляет расстояние между двумя точками.
     * @param p1 первая точка
     * @param p2 вторая точка
     * @return расстояние между точками
     */
    public static double distance(Point p1, Point p2) {
        double dist = Math.sqrt(Math.pow(p2.getX() - p1.getX(), 2) +
                Math.pow(p2.getY() - p1.getY(), 2));
        logger.debug("Расстояние между {} и {}: {}", p1, p2, dist);
        return dist;
    }
}
