package org.example.FileReader;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.Factories.SphereFactory;
import org.example.entity.Point;
import org.example.entity.Sphere;
import org.example.exceptions.InvalidSphereCoordinateFormatException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class SphereFileReader {
    private static final Logger logger = LogManager.getLogger(SphereFileReader.class);

    public static Sphere readSphereFromFile(String filePath) throws IOException {
        logger.info("Чтение файла сферы из: {}", filePath);
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                logger.debug("Обработка строки: {}", line);
                Sphere sphere = parseLineAndCreateSphere(line);
                if (sphere != null) {
                    logger.info("Успешно создан шар: {}", sphere);
                    return sphere;
                } else {
                    logger.warn("Недопустимый формат строки: {}", line);
                }
            }
        }
        logger.warn("Не удалось создать шар: все строки в файле неверны.");
        return null; // Возвращает null, если не удалось создать ни одного Sphere
    }

    private static Sphere parseLineAndCreateSphere(String line) {
        String[] values = line.trim().split("\\s+");

        // Проверяем, что строка содержит ровно 4 значения (3 координаты и радиус)
        if (values.length != 4) {
            logger.error("Некорректное количество значений. Ожидалось 4, получено: {}", values.length);
            throw new InvalidSphereCoordinateFormatException("Некорректное количество значений. Ожидалось 4, получено: " + values.length);
        }

        try {
            // Извлекаем координаты центра и радиус
            Point center = new Point(
                    Double.parseDouble(values[0]),
                    Double.parseDouble(values[1]),
                    Double.parseDouble(values[2])
            );
            double radius = Double.parseDouble(values[3]);

            // Используем SphereFactory для создания Sphere
            return SphereFactory.createSphere(center, radius);

        } catch (NumberFormatException e) {
            logger.error("Ошибка при разборе значений: {}. Причина: {}", line, e.getMessage());
            throw new InvalidSphereCoordinateFormatException("Ошибка при разборе значений: " + line + ". Причина: " + e.getMessage());
        }
    }
}
