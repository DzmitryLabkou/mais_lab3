package org.example.services;

import org.example.entity.Sphere;
import org.example.exceptions.SphereFileException;

public class SphereActions {

    private static final double PI = Math.PI;

    /**
     * Вычисляет объём сферы.
     * @param sphere сфера для расчета
     * @return объём сферы
     * @throws SphereFileException если сфера недопустима
     */
    public static double calculateVolume(Sphere sphere) {
        if (!SphereValidator.validateSphere(sphere)) {
            throw new SphereFileException("Невозможно вычислить объём: недопустимая сфера.");
        }
        double radius = sphere.getRadius();  // Получаем радиус напрямую
        return (4.0 / 3.0) * PI * Math.pow(radius, 3);
    }

    /**
     * Вычисляет площадь поверхности сферы.
     * @param sphere сфера для расчета
     * @return площадь поверхности сферы
     * @throws SphereFileException если сфера недопустима
     */
    public static double calculateSurfaceArea(Sphere sphere) {
        if (!SphereValidator.validateSphere(sphere)) {
            throw new SphereFileException("Невозможно вычислить площадь поверхности: недопустимая сфера.");
        }
        double radius = sphere.getRadius();  // Получаем радиус напрямую
        return 4 * PI * Math.pow(radius, 2);
    }

    /**
     * Проверяет, является ли сфера единичной.
     * @param sphere сфера для проверки
     * @return true, если сфера единичная, иначе false
     */
    public static boolean isUnitSphere(Sphere sphere) {
        return sphere.getRadius() == 1;
    }
}
