package buildnotifier;

import buildnotifier.Build;

public interface Repo {
    Build[] getBuilds();
}
