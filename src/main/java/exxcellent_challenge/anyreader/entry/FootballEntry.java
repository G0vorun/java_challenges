package exxcellent_challenge.anyreader.entry;

import exxcellent_challenge.shared.AppException;

/**
 * The entry class for a row of the football.csv file.
 */
public class FootballEntry implements IEntry{

    private String team;
    private int games;
    private int wins;
    private int losses;
    private int draws;
    private int goals;
    private int goalsAllowed;
    private int points;

    public FootballEntry() {}

    @Override
    public void fillEntryFieldFromStringArray(String[] entry) {
        int idx = 0;

        try {
            this.team = entry[idx++];
            this.games = Integer.parseInt(entry[idx++]);
            this.wins = Integer.parseInt(entry[idx++]);
            this.losses = Integer.parseInt(entry[idx++]);
            this.draws = Integer.parseInt(entry[idx++]);
            this.goals = Integer.parseInt(entry[idx++]);
            this.goalsAllowed = Integer.parseInt(entry[idx++]);
            this.points = Integer.parseInt(entry[idx]);
        }
        catch (NumberFormatException e) {
            throw new AppException("Error by file reading", e);
        }
    }

    @Override
    public String getSearchedDataKey() {
        return team;
    }

    @Override
    public int getSearchedDataValue() {
        return Math.abs((goals - goalsAllowed));
    }

    @Override
    public String toString() {
        return "FootballEntry [\n" +
                "Team = " + team + ", \n" +
                "Games = " + games + ", \n" +
                "Wins = " + wins + ", \n" +
                "Losses = " + losses + ", \n" +
                "Draws = " + draws + ", \n" +
                "Goals = " + goals + ", \n" +
                "Goals Allowed = " + goalsAllowed + ", \n" +
                "Points = " + points + "]";
    }
}
