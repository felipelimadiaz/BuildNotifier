package buildnotifier;

import buildnotifier.Travis.RepoImpl;
import buildnotifier.Travis.TravisBuildData;
import buildnotifier.Travis.TravisRepoData;

public class ConsoleUI implements Observer {
    private Repo repo;

    public ConsoleUI(Repo repo) throws Exception {
        this.repo = repo;
        this.repo.addObserver(this);
        this.printBuilds();
    }

    @Override
    public void update() throws Exception {
       this.printBuilds();
    }

    private void printBuilds()throws Exception{
        for (Build build : this.repo.getBuilds())
        {
            System.out.println(build.getState());
        }

        System.out.println();
    }
}
