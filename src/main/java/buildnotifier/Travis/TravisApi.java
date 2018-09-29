package buildnotifier.Travis;

public interface TravisApi {
    TravisUser getUser() throws Exception;
    TravisRepoData getPassed() throws Exception;
}
