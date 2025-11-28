FROM maven:3.9.6-eclipse-temurin-17

WORKDIR /app

# Копируем POM для кэширования зависимостей
COPY pom.xml .

# Скачиваем зависимости (кэшируется в Docker слое)
RUN mvn dependency:go-offline -B

# Копируем исходный код
COPY src ./src

# Команда по умолчанию - запуск тестов
CMD ["mvn", "clean", "test"]