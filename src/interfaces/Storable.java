package interfaces;

public interface Storable {
    void saveToFile() throws Exception;
    void loadFromFile() throws Exception;
}
