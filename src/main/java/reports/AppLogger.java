package reports;

import org.apache.logging.log4j.LogManager;


public final class AppLogger {
	private static final org.apache.logging.log4j.Logger logger = LogManager.getLogger();

    enum Level {Error, Warn, Fatal, Info, Debug}

    private AppLogger() {/* do nothing */};

    public static void logError(Class<?> c, String msg) {
        log(Level.Error, c, msg, null);
    }

    public static void logWarn(Class<?> c, String msg) {
        log(Level.Warn, c, msg, null);
    }

    public static void logFatal(Class<?> c, String msg) {
        log(Level.Fatal, c, msg, null);
    }

    public static void logInfo(Class<?> c, String msg) {
        log(Level.Info, c, msg, null);
    }

    public static void logDebug(Class<?> c, String msg) {
        log(Level.Debug, c, msg, null);
    }


    public static void logError(Class<?> c, String msg, Throwable throwable) {
        log(Level.Error, c, msg, throwable);
    }


    public static void logWarn(Class<?> c, String msg, Throwable throwable) {
        log(Level.Warn, c, msg, throwable);
    }

    public static void logFatal(Class<?> c, String msg, Throwable throwable) {
        log(Level.Fatal, c, msg, throwable);
    }

    public static void logInfo(Class<?> c, String msg, Throwable throwable) {
        log(Level.Info, c, msg, throwable);
    }

    public static void logDebug(Class<?> c, String msg, Throwable throwable) {
        log(Level.Debug, c, msg, throwable);
    }

    private static void log(Level level, Class<?> c, String msg, Throwable throwable) {
        String message = String.format("[%s] : %s", c, msg);
        switch (level) {
            case Info:
                logger.info(message, throwable);
                break;
            case Warn:
                logger.warn(message, throwable);
                break;
            case Error:
                logger.error(message, throwable);
                break;
            case Fatal:
                logger.fatal(message, throwable);
                break;
            default:
            case Debug:
                logger.debug(message, throwable);
        }
    }

}