package exxcellent_challenge.finder;

import exxcellent_challenge.anyreader.entry.IEntry;
import exxcellent_challenge.shared.AppConstants;
import exxcellent_challenge.shared.AppException;

import java.util.Collection;

public class FinderWeather<T extends IEntry> implements IFinder<T> {

    public FinderWeather() {
    }

    @Override
    public String findChallengeDataAsString(Collection<T> entriesCollection) {
        final int dayNumberUnknown = AppConstants.MIN_INTEGER;
        final int temperatureSpreadUnknown = AppConstants.MAX_INTEGER;

        int resultDayNumber = dayNumberUnknown;
        int tmpTemperatureSpread = temperatureSpreadUnknown;

        for (IEntry entry : entriesCollection) {
            int tmpResultDayNumber;
            try {
                tmpResultDayNumber = Integer.parseInt(entry.getSearchedDataKey());
            } catch (NumberFormatException e) {
                throw new AppException("no valid number", e);
            }
            if (entry.getSearchedDataValue() < tmpTemperatureSpread) {
                resultDayNumber = tmpResultDayNumber;
                tmpTemperatureSpread = entry.getSearchedDataValue();
            }
        }

        if (resultDayNumber != dayNumberUnknown) {
            return String.valueOf(resultDayNumber);
        } else {
            return AppConstants.EMPTY_STRING;
        }
    }
}
