package buildnotifier.Travis;
import buildnotifier.Build;
import buildnotifier.Observer;
import buildnotifier.Repo;
import java.util.ArrayList;
import java.util.List;

public class RepoImpl implements Repo {
    TravisApi travisApi;
    ArrayList<Build> listBuilds = new ArrayList<Build>();
    ArrayList<Observer> listObservers = new ArrayList<Observer>();


    public RepoImpl(TravisApi travisApi) throws Exception {
        this.travisApi = travisApi;
        TravisBuildData[] buildsOld =  this.travisApi.getRepoData().getBuilds();
        for (TravisBuildData buildData : buildsOld){
            BuildImpl build = new BuildImpl();
            build.setState(buildData.getState());
            listBuilds.add(build);
        }
    }

    @Override
    public List<Build> getBuilds() throws Exception {
        return listBuilds;

    }

    @Override
    public void refresh() throws Exception {
        TravisBuildData[] buildsNew = this.travisApi.getRepoData().getBuilds();
        int count = 0;
        boolean hasChanged = false;
        for (TravisBuildData buildData : buildsNew){
            hasChanged = !listBuilds.get(count).getState().equalsIgnoreCase(buildData.getState());

            listBuilds.remove(count);
            BuildImpl buildNew = new BuildImpl();
            buildNew.setState(buildData.getState());
            listBuilds.add(count, buildNew);
            count++;

            if (hasChanged)
                this.notifyObserver();
        }
    }

    @Override
    public void addObserver(Observer observer) {
       this.listObservers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        this.listObservers.remove(observer);
    }

    private void notifyObserver() throws Exception {
        for (Observer observer : this.listObservers){
            observer.update();
        }
    }
}
