package org.example.entity;

import org.example.exceptions.SphereCreationException;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SphereTest {

    @Test
    void testSphereCreation() {
        Point center = new Point(1.0, 2.0, 3.0);
        double radius = 5.0;
        int id = 1;

        Sphere sphere = new Sphere(center, radius, id);

        assertEquals(center, sphere.getCenter());
        assertEquals(radius, sphere.getRadius(), 0.0001);
        assertEquals(id, sphere.getId());
    }

    @Test
    void testEqualsSameSphere() {
        Sphere sphere1 = new Sphere(new Point(1.0, 2.0, 3.0), 5.0, 1);
        Sphere sphere2 = new Sphere(new Point(1.0, 2.0, 3.0), 5.0, 1);

        assertEquals(sphere1, sphere2);
    }

    @Test
    void testEqualsDifferentSpheres() {
        Sphere sphere1 = new Sphere(new Point(1.0, 2.0, 3.0), 5.0, 1);
        Sphere sphere2 = new Sphere(new Point(4.0, 5.0, 6.0), 10.0, 2);

        assertNotEquals(sphere1, sphere2);
    }

    @Test
    void testEqualsWithNull() {
        Sphere sphere = new Sphere(new Point(1.0, 2.0, 3.0), 5.0, 1);
        assertNotEquals(sphere, null);
    }

    @Test
    void testEqualsWithDifferentClass() {
        Sphere sphere = new Sphere(new Point(1.0, 2.0, 3.0), 5.0, 1);
        String notASphere = "Not a Sphere";

        assertNotEquals(sphere, notASphere);
    }

    @Test
    void testHashCodeSameSpheres() {
        Sphere sphere1 = new Sphere(new Point(1.0, 2.0, 3.0), 5.0, 1);
        Sphere sphere2 = new Sphere(new Point(1.0, 2.0, 3.0), 5.0, 1);

        assertEquals(sphere1.hashCode(), sphere2.hashCode());
    }

    @Test
    void testHashCodeDifferentSpheres() {
        Sphere sphere1 = new Sphere(new Point(1.0, 2.0, 3.0), 5.0, 1);
        Sphere sphere2 = new Sphere(new Point(4.0, 5.0, 6.0), 10.0, 2);

        assertNotEquals(sphere1.hashCode(), sphere2.hashCode());
    }

    @Test
    void testToString() {
        Sphere sphere = new Sphere(new Point(1.0, 2.0, 3.0), 5.0, 1);
        assertEquals("Sphere(1): центр=Point(1.0, 2.0, 3.0), радиус=5.0", sphere.toString());
    }

    @Test
    void testCreateSphereWithValidCenterAndRadius() {
        Point center = new Point(1.0, 2.0, 3.0);
        double radius = 5.0;
        int id = 1;

        Sphere sphere = new Sphere(center, radius, id);

        assertNotNull(sphere);
        assertEquals(center, sphere.getCenter());
        assertEquals(radius, sphere.getRadius(), 0.0001);
        assertEquals(id, sphere.getId());
    }

    @Test
    void testCreateSphereWithInvalidRadius() {
        Point center = new Point(1.0, 2.0, 3.0);
        double radius = -1.0;
        int id = 1;

        Exception exception = assertThrows(SphereCreationException.class, () -> new Sphere(center, radius, id));
        assertEquals("Радиус шара должен быть положительным числом.", exception.getMessage());
    }

    @Test
    void testCreateSphereWithNullCenter() {
        double radius = 5.0;
        int id = 1;

        Exception exception = assertThrows(NullPointerException.class, () -> new Sphere(null, radius, id));
        assertEquals("Центр сферы не может быть null", exception.getMessage());
    }
}
