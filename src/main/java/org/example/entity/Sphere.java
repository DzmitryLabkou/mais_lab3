package org.example.entity;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.exceptions.SphereCreationException;

public class Sphere {
    private static final Logger logger = LogManager.getLogger(Sphere.class);

    private final Point center;
    private final double radius;
    private final int id_s;

    public Sphere(Point center, double radius, int id_s) {
        if (center == null) {
            throw new NullPointerException("Центр сферы не может быть null");
        }

        if (radius <= 0) {
            logger.error("Ошибка создания шара: радиус должен быть положительным, получен {}", radius);
            throw new SphereCreationException("Радиус шара должен быть положительным числом.");
        }
        this.center = center;
        this.radius = radius;
        this.id_s = id_s;
        logger.info("Создан шар: {}", this);
    }

    public Point getCenter() {
        return center;
    }

    public double getRadius() {
        return radius;
    }

    public int getId() {
        return id_s;
    }

    public double calculateSurfaceArea() {
        return 4 * Math.PI * Math.pow(radius, 2);
    }

    public double calculateVolume() {
        return (4.0 / 3.0) * Math.PI * Math.pow(radius, 3);
    }

    @Override
    public String toString() {
        return "Sphere(" + id_s + "): центр=" + center + ", радиус=" + radius;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Sphere sphere = (Sphere) obj;
        return Double.compare(sphere.radius, radius) == 0 && center.equals(sphere.center);
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + center.hashCode();
        long temp = Double.doubleToLongBits(radius);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
