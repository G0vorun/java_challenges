package exxcellent_challenge.anyreader.reader;
import exxcellent_challenge.anyreader.entry.IEntry;

import java.io.File;
import java.util.Collection;
import java.util.function.Supplier;
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
