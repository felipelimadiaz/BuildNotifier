public class TravisRepoImpl implements TravisRepo {
    TravisBuildImpl[] builds;
    @Override
    public TravisBuild[] getBuilds() {
        return builds;
    }
}
