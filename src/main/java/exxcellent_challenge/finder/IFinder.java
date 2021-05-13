package exxcellent_challenge.finder;

import exxcellent_challenge.anyreader.entry.IEntry;

import java.util.Collection;

public interface IFinder <T extends IEntry> {
    String findChallengeDataAsString(Collection<T> entriesCollection);
}
