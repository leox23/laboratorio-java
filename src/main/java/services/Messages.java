package services;

import org.jboss.logging.Logger;

public class Messages {
    private static final Logger logger = Logger.getLogger(Messages.class);
    private static Messages instance = null;

    public static Messages getInstance() {
        if (instance instanceof Messages) {
            return instance;
        } else {
            instance = new Messages();
        }
        return instance;
    }

    public void showMessage(String message) {
        logger.info(message);
    }
}
