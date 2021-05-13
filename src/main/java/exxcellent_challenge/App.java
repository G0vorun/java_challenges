package exxcellent_challenge;

import exxcellent_challenge.anyreader.worker.AbstractWorker;
import exxcellent_challenge.anyreader.worker.IWorkerFactory;
import exxcellent_challenge.anyreader.worker.WorkerFactory;
import exxcellent_challenge.shared.AppConstants;

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
        IWorkerFactory workerFactory = new WorkerFactory(AppConstants.WEATHER_FILE_PATH, logger);
        AbstractWorker worker = workerFactory.getWorker();
        String dayWithSmallestTempSpread = worker.getChallengeDataAsString();
        System.out.printf("Day with smallest temperature spread : %s%n", dayWithSmallestTempSpread);

        workerFactory = new WorkerFactory(AppConstants.FOOTBALL_FILE_PATH, logger);
        worker = workerFactory.getWorker();
        String teamWithSmallestGoalSpread = worker.getChallengeDataAsString();
        System.out.printf("Team with smallest goal spread : %s%n", teamWithSmallestGoalSpread);

        Timestamp endTime = new Timestamp(System.currentTimeMillis());
        logger.log(Level.INFO, "weatherApp ended at " + endTime + ". Duration " +
                (endTime.getTime() - startTime.getTime()) + " ms");
    }
}
