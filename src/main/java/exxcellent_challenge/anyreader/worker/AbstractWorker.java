package exxcellent_challenge.anyreader.worker;

import java.util.logging.Logger;

public abstract class AbstractWorker {
    protected final String filePath;
    protected final Logger logger;

    public AbstractWorker(String filePath, Logger logger) {
        this.filePath = filePath;
        this.logger = logger;
    }

    /**
     * @return the searched result defined in the task
     */
    public abstract String getChallengeDataAsString();
}
