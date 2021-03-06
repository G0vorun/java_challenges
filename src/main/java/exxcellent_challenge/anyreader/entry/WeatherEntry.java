package exxcellent_challenge.anyreader.entry;

import exxcellent_challenge.shared.AppException;

public class WeatherEntry implements IEntry {

    private int day;
    private int mxT;
    private int mnT;
    private int avT;
    private double avDp;
    private int hrPTPcpn;
    private int pDir;
    private double avSp;
    private int dir;
    private int mxS;
    private double skyC;
    private int mxR;
    private int mn;
    private double rAvSlp;

    public WeatherEntry() {}

    @Override
    public void fillEntryFieldFromStringArray(String[] entry) {
        int idx = 0;

        try {
            this.day = Integer.parseInt(entry[idx++]);
            this.mxT = Integer.parseInt(entry[idx++]);
            this.mnT = Integer.parseInt(entry[idx++]);
            this.avT = Integer.parseInt(entry[idx++]);
            this.avDp = Double.parseDouble(entry[idx++]);
            this.hrPTPcpn = Integer.parseInt(entry[idx++]);
            this.pDir = Integer.parseInt(entry[idx++]);
            this.avSp = Double.parseDouble(entry[idx++]);
            this.dir = Integer.parseInt(entry[idx++]);
            this.mxS = Integer.parseInt(entry[idx++]);
            this.skyC = Double.parseDouble(entry[idx++]);
            this.mxR = Integer.parseInt(entry[idx++]);
            this.mn = Integer.parseInt(entry[idx++]);
            this.rAvSlp = Double.parseDouble(entry[idx]);
        }
        catch (NumberFormatException e) {
            throw new AppException("Error by file reading", e);
        }
    }

    @Override
    public String getSearchedDataKey() {
        return String.valueOf(day);
    }

    @Override
    public int getSearchedDataValue() {
        return mxT - mnT;
    }

    @Override
    public String toString() {
        return "WeatherEntry [\n" +
                "Day = " + day + ", \n" +
                "MxT = " + mxT + ", \n" +
                "MnT = " + mnT + ", \n" +
                "AvT = " + avT + ", \n" +
                "AvDP = " + avDp + ", \n" +
                "1HrP TPcpn = " + hrPTPcpn + ", \n" +
                "PDir = " + pDir + ", \n" +
                "AvSp = " + avSp + ", \n" +
                "Dir = " + dir + ", \n" +
                "MxS = " + mxS + ", \n" +
                "SkyC = " + skyC + ", \n" +
                "MxR = " + mxR + ", \n" +
                "Mn = " + mn + ", \n" +
                "R AvSLP = " + rAvSlp + "]";
    }
}
