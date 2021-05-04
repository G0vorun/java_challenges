package exxcellent_challenge.finder;

import exxcellent_challenge.anyreader.entry.IEntry;

import java.util.Collection;
import java.util.logging.Logger;

public class CSVFinderFactory extends AbstractFinder {

    public CSVFinderFactory(String filePath, Logger logger) {
        super(filePath, logger);
    }

    @Override
    protected String getChallengeDataAsString() {
        return null;
    }

    @Override
    protected String findChallengeDataAsString(Collection<IEntry> entriesCollection) {
        return null;
    }
}
