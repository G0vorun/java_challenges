package exxcellent_challenge.anyreader.reader;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import exxcellent_challenge.anyreader.entry.IEntry;
import exxcellent_challenge.shared.AppException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Supplier;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class AbstractReader<T extends IEntry> {

    private Supplier<T> supplier;
    private Logger logger;

    public AbstractReader(Supplier<T> supplier, Logger logger) {
        this.supplier = supplier;
        this.logger = logger;
    }

    /**
     * @param file File object for input file
     * @return collection of entries for input file
     */
    public Collection<T> getEntryCollecton(File file) {
        logger.log(Level.INFO, "Start getEntryList for " + file.getPath());
        List<T> result = new ArrayList<>();

        try {
            CSVReader csvReader = new CSVReader(new FileReader(file));

            String[] entryStringArray;
            int counter = 0;

            while ((entryStringArray = csvReader.readNext()) != null) {

                // skip first header line
                if (counter == 0){
                    counter++;
                    continue;
                }

                T typEntry = supplier.get();
                typEntry.fillEntryFieldFromStringArray(entryStringArray);
                result.add(typEntry);
            }

            logger.log(Level.INFO, "End getEntryList found " + result.size() + " Entries for " + file.getPath());

        } catch (FileNotFoundException e) {
            logger.log(Level.SEVERE, "Error by getEntryList ", e);
            throw new AppException("file '" + file.getPath() + "' not found", e);
        } catch (IOException | CsvValidationException e) {
            logger.log(Level.SEVERE, "Error by getEntryList ", e);
            throw new AppException("file '" + file.getPath() + "' cannot be read", e);
        }
        return result;
    }
}
