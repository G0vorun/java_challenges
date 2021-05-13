package exxcellent_challenge.service;

import java.io.File;
import java.util.logging.Logger;

public interface IInputFileService {
    /**
     * @param importFilePath path with name to the input file
     * @param logger a logger object
     * @return File object for input file
     */
    File getInputFile(String importFilePath, Logger logger);
}
