package buildnotifier;

import buildnotifier.Travis.TravisBuildData;
import buildnotifier.Travis.TravisRepoData;

public class ConsoleUI implements Observer {
    private TravisRepoData travisRepo;

    public ConsoleUI(TravisRepoData travisRepo) throws Exception {
        this.travisRepo = travisRepo;
        this.printBuilds();
    }

    @Override
    public void update() throws Exception {
       this.printBuilds();
    }

    private void printBuilds()throws Exception{
        TravisBuildData build = this.travisRepo.getBuilds()[0];
        System.out.println(build.getState());
    }
}
