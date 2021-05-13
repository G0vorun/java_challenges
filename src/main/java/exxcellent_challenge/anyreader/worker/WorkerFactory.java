package exxcellent_challenge.anyreader.worker;

import exxcellent_challenge.anyreader.entry.FootballEntry;
import exxcellent_challenge.anyreader.entry.WeatherEntry;
import exxcellent_challenge.anyreader.reader.CSVReader;
import exxcellent_challenge.finder.FinderFootball;
import exxcellent_challenge.finder.FinderWeather;
import exxcellent_challenge.shared.AppConstants;
import exxcellent_challenge.shared.AppException;

import java.util.logging.Logger;

public class WorkerFactory implements IWorkerFactory {
    private final String filePath;
    private final Logger logger;

    public WorkerFactory(String filePath, Logger logger) {
        this.filePath = filePath;
        this.logger = logger;
    }

    @Override
    public AbstractWorker getWorker() {
        if (AppConstants.CSV_FILE_TYP.equals(getInputFileType())) {

            if (filePath.endsWith(AppConstants.CSV_WEATHER_FILE_EXTENSION)) {
                return new CSVWorker<>(
                        filePath,
                        logger,
                        new CSVReader<>(WeatherEntry::new, logger),
                        new FinderWeather<>()
                );
            } else if (filePath.endsWith(AppConstants.CSV_FOOTBALL_FILE_EXTENSION)) {
                return new CSVWorker<>(
                        filePath,
                        logger,
                        new CSVReader<>(FootballEntry::new, logger),
                        new FinderFootball<>()
                );
            } else {
                throw new AppException("unknown file, reader not found");
            }

        } else if (AppConstants.JSON_FILE_TYP.equals(getInputFileType())) {
            throw new AppException("JSON Reader is not implemented");
        } else {
            throw new AppException("File type unknown, reader not found");
        }
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
