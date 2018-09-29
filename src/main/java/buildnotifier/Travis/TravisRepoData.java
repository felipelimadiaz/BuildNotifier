package buildnotifier.Travis;

public interface TravisRepoData {
  TravisBuildData[] getBuilds();
  void refresh();
}
