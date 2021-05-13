package exxcellent_challenge.anyreader.worker;

import exxcellent_challenge.anyreader.entry.IEntry;
import exxcellent_challenge.anyreader.reader.AbstractReader;
import exxcellent_challenge.finder.IFinder;
import exxcellent_challenge.service.IInputFileService;
import exxcellent_challenge.service.InputFileService;
import exxcellent_challenge.shared.AppConstants;
import exxcellent_challenge.shared.AppException;

import java.io.File;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CSVWorker<T extends IEntry> extends AbstractWorker {

    protected AbstractReader<T> abstractReader;
    protected IFinder<T> finder;

    public CSVWorker(String filePath, Logger logger, AbstractReader<T> abstractReader,
                     IFinder<T> finder) {
        super(filePath, logger);
        this.abstractReader = abstractReader;
        this.finder = finder;
    }

    @Override
    public String getChallengeDataAsString() {
        logger.log(Level.INFO, "Start getChallengeDataAsString for " + filePath);

        IInputFileService fileService = new InputFileService();
        File inputFile = fileService.getInputFile(filePath, logger);

        Collection<T> entryList = abstractReader.getEntryCollecton(inputFile);
        String searchedData = finder.findChallengeDataAsString(entryList);

        if (searchedData.equals(AppConstants.EMPTY_STRING)) {
            String msg = "the day with the smallest temperature spread could not be found";
            logger.log(Level.SEVERE, msg);
            throw new AppException(msg);
        } else {
            logger.log(Level.INFO, "End getChallengeDataAsString for " + filePath);
            return searchedData;
        }
    }
}
