# Wednesday-Mobo

## Overview

"Wednesday-Mobo" is a project developed using JSP and Servlets. This document explains the importance of logging, the different logging levels, and how to set up and configure logging in a Java application.

## 1. What is Logging?

Logging is the process of recording information about the execution of a program. Logs provide a way to capture the sequence of events and states within an application. This information is crucial for monitoring, debugging, and maintaining the application.

## 2. Why Logging is Important

Logging is important for several reasons:
-** Debugging: Logs help developers trace issues by providing a detailed record of system behavior and error messages.
-** Monitoring: Logs allow for the monitoring of application performance and usage patterns.
-** Auditing: Logs can provide a trail of actions and changes, which is essential for compliance and security auditing.
-** Performance Tuning: By analyzing logs, developers can identify performance bottlenecks and optimize system performance.
-**   Error Tracking: Logs help track and record errors, making it easier to identify and fix bugs.

## 3. Understanding Logging Levels

Logging levels represent the severity or importance of log messages. Common logging levels include:

**DEBUG: Provides detailed information, typically used for diagnosing problems. Not intended for production use due to verbosity.
**INFO: General information about the application's operation, typically used to log important events.
**WARN: Indicates a potential issue or warning that may require attention but does not necessarily cause immediate problems.
**ERROR: Logs errors that indicate a significant problem affecting functionality. Immediate attention may be required.
**FATAL: Represents severe errors that cause the application to terminate or become unusable. Usually requires immediate resolution.

## 4. Setting Up a Logger in Java

To set up a logger in Java, use the `java.util.logging` package or a third-party library like Log4j. Here's an example using `java.util.logging`:

```java
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import java.util.logging.Level;

public class ExampleLogging {
    private static final Logger logger = Logger.getLogger(ExampleLogging.class.getName());

    static {
        try {
            FileHandler fileHandler = new FileHandler("app.log", true);
            fileHandler.setFormatter(new SimpleFormatter());
            logger.addHandler(fileHandler);
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Failed to initialize file logging", e);
        }
    }

    public static void main(String[] args) {
        logger.info("Application started");

        try {
            throw new Exception("Sample exception");
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Exception occurred", e);
        }

        logger.info("Application finished");
    }
}
