package org.example;

import org.example.FileReader.SphereFileReader;
import org.example.entity.Sphere;
import org.example.services.SphereActions;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;

public class Main {
    private static final Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        String filePath = "C:\\Users\\path\\to\\your\\input.txt";

        try {
            Sphere sphere = SphereFileReader.readSphereFromFile(filePath);
            if (sphere != null) {
                logger.info("Сфера успешно создана: " + sphere);

                double volume = SphereActions.calculateVolume(sphere);
                double surfaceArea = SphereActions.calculateSurfaceArea(sphere);

                logger.info("Объем сферы: " + volume);
                logger.info("Площадь поверхности сферы: " + surfaceArea);
            } else {
                logger.warn("Не удалось создать сферу: неверные или неполные данные в файле.");
            }
        } catch (IOException e) {
            logger.error("Ошибка при чтении файла: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            logger.error("Ошибка: " + e.getMessage());
        }
    }
}
