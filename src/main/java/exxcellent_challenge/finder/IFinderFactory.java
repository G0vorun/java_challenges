package exxcellent_challenge.finder;

public interface IFinderFactory {
    /**
     * @return concrete file finder
     */
    AbstractFinder getDataFinder();
}
