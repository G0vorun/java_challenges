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

    protected Supplier<T> supplier;
    protected Logger logger;

    public AbstractReader(Supplier<T> supplier, Logger logger) {
        this.supplier = supplier;
        this.logger = logger;
    }

    /**
     * @param file File object for input file
     * @return collection of entries for input file
     */
    public abstract Collection<T> getEntryCollecton(File file);
}
