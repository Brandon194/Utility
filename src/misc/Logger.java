package misc;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by Brandon194 on 11/3/2014.
 */
public class Logger {
    /** The filename error log log.file. */
    private final static String errorLog = "error_log.file";
    /** A type of Log. */
    public final static int LOG_WARNING = 0, LOG_ERROR = 1, LOG_DEBUG = 2;

    /**
     * Writes log
     * @param message The error log to be written.
     * @param type The error type.
     */
    public static void writeLog(final String message, final int type) {
        try {
            PrintWriter out;
            out = new PrintWriter(new BufferedWriter(new FileWriter(errorLog, true)));

            // Get the timestamp and then append the log to the file.
            String timeStamp = new SimpleDateFormat("yyyy/MMM/dd-HH:mm:ss").format(Calendar.getInstance().getTime());
            out.println("[" + timeStamp + "] " + getLogTypeAsString(type) + ": " + message);
            out.close();

            System.out.println(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     *
     * @param type The error type.
     * @return The name name of the error type
     */
    private static String getLogTypeAsString(final int type) {
        switch(type) {
            case LOG_WARNING:
                return "WARNING";
            case LOG_ERROR:
                return "ERROR";
            case LOG_DEBUG:
                return "DEBUG";
            default:
                return "UNKNOWN";
        }
    }
}
