package org.example.services;

import org.example.entity.Point;
import org.example.entity.Sphere;
import org.example.exceptions.SphereCreationException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SphereActionsTest {

    @Test
    void calculateVolume_ValidSphere_ReturnsCorrectVolume() {
        Sphere sphere = new Sphere(new Point(0, 0, 0), 3, 1); // Параметр id_s
        double expectedVolume = (4.0 / 3) * Math.PI * Math.pow(3, 3); // Формула объема сферы
        assertEquals(expectedVolume, SphereActions.calculateVolume(sphere), 0.001);
    }

    @Test
    void calculateVolume_InvalidSphere_ThrowsException() {
        Point center = new Point(1.0, 2.0, 3.0);
        double invalidRadius = -1.0; // Недопустимый радиус
        int id = 1;

        assertThrows(SphereCreationException.class, () -> new Sphere(center, invalidRadius, id));
    }

    @Test
    void calculateSurfaceArea_ValidSphere_ReturnsCorrectSurfaceArea() {
        Sphere sphere = new Sphere(new Point(0, 0, 0), 3, 1); // Параметр id_s
        double expectedSurfaceArea = 4 * Math.PI * Math.pow(3, 2); // Формула площади поверхности сферы
        assertEquals(expectedSurfaceArea, SphereActions.calculateSurfaceArea(sphere), 0.001);
    }

    @Test
    void calculateSurfaceArea_InvalidSphere_ThrowsException() {
        Point center = new Point(0, 0, 0);
        double invalidRadius = 0; // Радиус 0
        int id = 1;

        assertThrows(SphereCreationException.class, () -> new Sphere(center, invalidRadius, id));
    }

    @Test
    void isUnitSphere_UnitSphere_ReturnsTrue() {
        Sphere sphere = new Sphere(new Point(0, 0, 0), 1, 1); // Параметр id_s
        assertTrue(SphereActions.isUnitSphere(sphere));
    }

    @Test
    void isUnitSphere_NotUnitSphere_ReturnsFalse() {
        Sphere sphere = new Sphere(new Point(0, 0, 0), 3, 1); // Параметр id_s
        assertFalse(SphereActions.isUnitSphere(sphere));
    }
}
