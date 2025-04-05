package utils;

import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Utilities {
    public enum ProcessLogger {
        PRINTER,
        PASSENGER,
        TONER_TECHNICIAN,
        PAPER_TECHNICIAN,
        PRINTING_SYSTEM,
        INFO,
        WARN,
        ERROR;
    }

    /**
     * Prints a given message with logging time
     *
     * @param processName        Process that intiates the message
     * @param message              The message to be logged
     * @param infoType            Whether the message is info/warn/error log
     *
     */

    public static synchronized void printLogs(ProcessLogger processName, String message, ProcessLogger infoType) {
        String logLine = "";

        Date date = new Date(System.currentTimeMillis());
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        String currentTimeDate = formatter.format(date);

        logLine = "[" + currentTimeDate + "]  " + "[" + processName.toString().toUpperCase().replace("_", " ")
                + "]  [" + infoType.toString().toUpperCase() + "]  " + message + ".";

        System.out.println(logLine);

        //writes log into file.
        try {
            FileWriter myWriter = new FileWriter("OutputFile.txt", true);
            myWriter.write(logLine + "\n");
            myWriter.close();

        } catch (IOException e) {

            e.printStackTrace();
        }

    }
}

