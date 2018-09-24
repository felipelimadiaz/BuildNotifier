import java.util.ArrayList;
import java.util.List;

public class TravisBuildImpl implements TravisBuild, Observable {
    private String state;
    List<Observer> observers = new ArrayList<Observer>();
    @Override
    public String getState(String state) {
        if (this.state != state){
            notifyObserver();
        }
        return this.state;
    }

    @Override
    public void notifyObserver() {

    }
}
