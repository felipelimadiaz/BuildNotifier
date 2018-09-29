package buildnotifier;

public interface Build extends Observable {
    String getState();
}
