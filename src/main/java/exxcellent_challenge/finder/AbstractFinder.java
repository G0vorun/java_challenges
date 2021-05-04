package exxcellent_challenge.finder;

import exxcellent_challenge.anyreader.entry.IEntry;

import java.util.Collection;
import java.util.logging.Logger;

public abstract class AbstractFinder {
    protected final String filePath;
    protected final Logger logger;

    public AbstractFinder(String filePath, Logger logger) {
        this.filePath = filePath;
        this.logger = logger;
    }

    /**
     * @return the searched result defined in the task
     */
    protected abstract String getChallengeDataAsString();

    protected abstract String findChallengeDataAsString(Collection<IEntry> entriesCollection);
}
