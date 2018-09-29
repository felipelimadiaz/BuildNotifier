package buildnotifier.Travis;
import buildnotifier.Build;

import java.util.ArrayList;

public class BuildImpl implements Build {
    private String state;
    ArrayList<buildnotifier.Observer> listObserver = new ArrayList<buildnotifier.Observer>();

    @Override
    public String getState() {
        return this.state;
    }

    @Override
    public void addObserver(buildnotifier.Observer observer) {
        this.listObserver.add(observer);
    }

    @Override
    public void removeObserver(buildnotifier.Observer observer) {
        this.listObserver.remove(observer);
    }

    private void notifyObserver() throws Exception {
        for (buildnotifier.Observer observer : listObserver)
        {
            observer.update();
        }
    }

    private void setState(String state) throws Exception {
        if (this.state != state)
        {
            this.state = state;
            this.notifyObserver();
        }

    }

}
