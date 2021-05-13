package exxcellent_challenge.service;

import exxcellent_challenge.shared.AppException;

import java.io.File;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

public class InputFileService implements IInputFileService {

    public InputFileService() {}

    @Override
    public File getInputFile(String importFilePath, Logger logger) {
        logger.log(Level.INFO, "Start getImportFile for " + importFilePath);
        try {
            String filePath = Objects.requireNonNull(getClass()
                    .getClassLoader()
                    .getResource(importFilePath))
                    .getPath();

            logger.log(Level.INFO, "End getImportFile for " + importFilePath);
            return new File(filePath);
        } catch (NullPointerException e) {
            logger.log(Level.SEVERE, "Error by getImportFile ", e);
            throw new AppException("file '" + importFilePath + "' not found", e);
        }
    }
}
