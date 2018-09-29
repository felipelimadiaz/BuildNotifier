package buildnotifier.Travis;

class TravisRepoDataImpl implements TravisRepoData {
    TravisBuildDataImpl[] builds;
    @Override
    public TravisBuildData[] getBuilds() {
        return builds;
    }

    @Override
    public void refresh() {

    }

}
