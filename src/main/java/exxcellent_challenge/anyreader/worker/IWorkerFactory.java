package exxcellent_challenge.anyreader.worker;

public interface IWorkerFactory {
    /**
     * @return concrete worker factory for data type
     */
    AbstractWorker getWorker();
}
