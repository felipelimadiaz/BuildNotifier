public interface TravisApi {
    TravisUser getUser() throws Exception;
    TravisBuild getPassed() throws Exception;
}
