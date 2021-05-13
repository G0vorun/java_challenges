package exxcellent_challenge.anyreader.entry;

public interface IEntry {
    /**
     * Method fills fields of the entry object
     * @param entry row from the input file
     */
    void fillEntryFieldFromStringArray(String[] entry);

    /**
     * @return searched key
     */
    String getSearchedDataKey();


    /**
     * @return searched value
     */
    int getSearchedDataValue();
}
