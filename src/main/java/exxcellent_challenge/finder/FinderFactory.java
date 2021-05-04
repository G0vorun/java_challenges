package exxcellent_challenge.finder;

import exxcellent_challenge.shared.AppConstants;
import exxcellent_challenge.shared.AppException;

import java.util.logging.Logger;

public class FinderFactory implements IFinderFactory {
    private final String filePath;
    private final Logger logger;

    public FinderFactory(String filePath, Logger logger) {
        this.filePath = filePath;
        this.logger = logger;
    }

    @Override
    public AbstractFinder getDataFinder() {
//        if (AppConstants.CSV_FILE_TYP.equals(getInputFileType())) {
//            CSVReaderFactory csvReaderFactory = new CSVReaderFactory();
//            return csvReaderFactory.getSpecificFileReader(filePath, logger);
//        } else if (AppConstants.JSON_FILE_TYP.equals(getInputFileType())) {
//            IFinderHelper finderHelper = entriesCollection -> null;
//            return new AppJSONReader<>(filePath, logger, finderHelper);
//        } else {
//            throw new AppException("File type unknown, reader not found");
//        }
        return null;
    }

    private String getInputFileType() {
        int lastDotIndex = filePath.lastIndexOf(AppConstants.EXTENSION_SEPARATOR);
        String extension = filePath.substring(lastDotIndex + 1);
        if (extension.isEmpty()) {
            throw new AppException("Extension could not be found");
        }
        return extension.toLowerCase();
    }
}
