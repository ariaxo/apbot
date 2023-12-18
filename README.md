
# Apbot Project Documentation (DEMO)

## Introduction

The Apbot project is a Java application that scrapes a specific shopping website (MANDARAKE) for new arrivals and provides the foundation for future integration with Mirai Console to notify a user on QQ when new products are detected.

## Project Structure

The project has the following structure:

```
├── src
│   ├── main
│   │   ├── java
│   │   │   └── com.example.apbot.apbotdemo
│   │   │       └── SimpleWebScraper.java
│   │   └── resources
│   └── test
│       └── java
├── pom.xml
└── README.md
```

- `SimpleWebScraper.java`: The main Java class containing the web scraping logic.
- `pom.xml`: Maven project configuration file.
- `README.md`: Project documentation.

## Dependencies

The project relies on the following dependencies:

- Java 19.0.2
- Jsoup for HTML parsing

## Setup

1. Clone the project from the repository:

   ```bash
   git clone this repo
   ```

2. Open the project in your preferred IDE.

3. Build and run the project.

## Usage

1. Run the `SimpleWebScraper` application to perform web scraping.

2. Check the console output for information about new arrivals.

## Development Plan

The future development plan includes:

- Integration with Mirai Console for QQ notifications.

- Add more scrapped websites.

## Contributing

If you want to contribute to the project, please follow these steps:

1. Fork the repository.

2. Create a new branch for your feature or bug fix:

   ```bash
   git checkout -b feature/new-feature
   ```

3. Make your changes and commit:

   ```bash
   git commit -m "Add new feature"
   ```

4. Push your changes to your fork:

   ```bash
   git push origin feature/new-feature
   ```

5. Open a pull request on the original repository.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
```
