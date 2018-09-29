package buildnotifier.Travis;

import buildnotifier.Build;
import buildnotifier.Repo;

public class RepoImpl implements Repo {
    BuildImpl[] builds;

    @Override
    public Build[] getBuilds() {
        return  builds;
    }
}
