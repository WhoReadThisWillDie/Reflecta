FROM gradle:8.12.1

WORKDIR /app

COPY . .

RUN chmod +x gradlew

EXPOSE 8000

CMD ["./gradlew", "bootRun", "--no-daemon"]