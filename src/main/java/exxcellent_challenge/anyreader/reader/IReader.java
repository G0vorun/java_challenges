package exxcellent_challenge.anyreader.reader;

import exxcellent_challenge.anyreader.entry.IEntry;

import java.io.File;
import java.util.Collection;

public interface IReader<T extends IEntry> {
    /**
     * @param file File object for input file
     * @return collection of entries for input file
     */
    Collection<T> getEntryCollecton(File file);
}
