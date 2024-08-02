package registration.auca.students;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import java.util.logging.Level;

public class ExampleLogging {
    // Initialize the logger
    private static final Logger logger = Logger.getLogger(ExampleLogging.class.getName());

    static {
        try {
            // Configure file logging
            FileHandler fileHandler = new FileHandler("java-util-log.log", true);
            fileHandler.setFormatter(new SimpleFormatter());
            logger.addHandler(fileHandler);
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Failed to initialize file logging", e);
        }
    }

    public static void main(String[] args) {
        // Log messages at different levels
        logger.severe("This is a SEVERE message");
        logger.warning("This is a WARNING message");
        logger.info("This is an INFO message");
        logger.config("This is a CONFIG message");
        logger.fine("This is a FINE message");
        logger.finer("This is a FINER message");
        logger.finest("This is a FINEST message");

        try {
            // Some code that could throw an exception
            throw new Exception("Sample exception");
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Exception occurred", e);
        }

        logger.info("Application finished");
    }
}
