package org.example.services;

import org.example.entity.Point;
import org.example.entity.Sphere;
import org.example.exceptions.SphereCreationException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SphereValidatorTest {

    @Test
    void validateSphere_ValidSphere_ReturnsTrue() {
        Sphere sphere = new Sphere(new Point(0, 0, 0), 3.0, 1); // Параметры Point, радиус и id_s
        assertTrue(SphereValidator.validateSphere(sphere));
    }

    @Test
    void validateSphere_InvalidSphere_ReturnsFalse() {
        Point center = new Point(0, 0, 0);
        double invalidRadius = -1.0; // Недопустимый радиус
        int id = 1;

        assertThrows(SphereCreationException.class, () -> new Sphere(center, invalidRadius, id));
    }

    @Test
    void testDistanceCalculation() {
        Point p1 = new Point(0.0, 0.0, 0.0);
        Point p2 = new Point(3.0, 4.0, 0.0);
        double expectedDistance = 5.0; // Расстояние по формуле
        assertEquals(expectedDistance, SphereValidator.distance(p1, p2), 0.001, "Расстояние между точками рассчитано неверно");
    }

    @Test
    void testDistanceCalculationWithSameCenter() {
        Point p1 = new Point(1.0, 1.0, 1.0);
        assertEquals(0.0, SphereValidator.distance(p1, p1), 0.001, "Расстояние между одинаковыми точками должно быть равно 0");
    }
}
