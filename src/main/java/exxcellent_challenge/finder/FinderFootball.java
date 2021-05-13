package exxcellent_challenge.finder;

import exxcellent_challenge.anyreader.entry.IEntry;
import exxcellent_challenge.shared.AppConstants;

import java.util.Collection;

public class FinderFootball<T extends IEntry> implements IFinder<T>{
    public FinderFootball() {
    }

    @Override
    public String findChallengeDataAsString(Collection<T> entriesCollection) {
        int tmpSmallestDifference = AppConstants.MAX_INTEGER;
        String tmpTeam = AppConstants.UNKNOWN_TEAM;
        for (IEntry entry : entriesCollection) {
            if (entry.getSearchedDataValue() < tmpSmallestDifference) {
                tmpSmallestDifference = entry.getSearchedDataValue();
                tmpTeam = entry.getSearchedDataKey();
            }
        }
        return tmpTeam;
    }
}
