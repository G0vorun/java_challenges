package exxcellent_challenge.finder;

import exxcellent_challenge.anyreader.entry.IEntry;
import exxcellent_challenge.anyreader.reader.IReader;

import java.util.Collection;
import java.util.function.Supplier;
import java.util.logging.Logger;

public abstract class AbstractFinder<T extends IReader> {
    protected final String filePath;
    protected final Supplier<T> supplier;
    protected final Logger logger;

    public AbstractFinder(String filePath, Supplier<T> supplier, Logger logger) {
        this.filePath = filePath;
        this.supplier = supplier;
        this.logger = logger;
    }

    /**
     * @return the searched result defined in the task
     */
    protected abstract String getChallengeDataAsString();

    protected abstract String findChallengeDataAsString(Collection<IEntry> entriesCollection);
}
