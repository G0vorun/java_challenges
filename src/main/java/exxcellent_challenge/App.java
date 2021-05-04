package exxcellent_challenge;

import java.sql.Timestamp;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * The entry class for your solution. This class is only aimed as starting point and not intended as baseline for your software
 * design. Read: create your own classes and packages as appropriate.
 *
 * @author Benjamin Schmid <benjamin.schmid@exxcellent.de>
 */
public final class App {

    /**
     * This is the main entry method of your program.
     * @param args The CLI arguments passed
     */
    public static void main(String... args) {
        Logger logger = Logger.getLogger("AnyReaderApp");

        if (args.length > 0) {
            if (args[0].equals("1")) {
                logger.setLevel(Level.INFO);
            } else if (args[0].equals("2")) {
                logger.setLevel(Level.SEVERE);
            } else {
                logger.setLevel(Level.OFF);
            }
        } else {
            logger.setLevel(Level.OFF);
        }

        Timestamp startTime = new Timestamp(System.currentTimeMillis());
        logger.log(Level.INFO, "weatherApp started at " + startTime);

        // Your preparation code …

        String dayWithSmallestTempSpread = "Someday";     // Your day analysis function call …
        System.out.printf("Day with smallest temperature spread : %s%n", dayWithSmallestTempSpread);

        String teamWithSmallestGoalSpread = "A good team"; // Your goal analysis function call …
        System.out.printf("Team with smallest goal spread       : %s%n", teamWithSmallestGoalSpread);

        Timestamp endTime = new Timestamp(System.currentTimeMillis());
        logger.log(Level.INFO, "weatherApp ended at " + endTime + ". Duration " +
                (endTime.getTime() - startTime.getTime()) + " ms");
    }
}
