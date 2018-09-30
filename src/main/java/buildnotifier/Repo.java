package buildnotifier;

import buildnotifier.Build;

import java.util.Collection;
import java.util.List;

public interface Repo extends Observable {
    List<Build> getBuilds() throws Exception;
    void refresh() throws Exception;
}
