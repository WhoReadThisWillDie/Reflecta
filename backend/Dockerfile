FROM gradle:8.12

WORKDIR /app

COPY .. .

EXPOSE 8000

CMD ["./gradlew", "bootRun", "--no-daemon"]