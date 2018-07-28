import java.time.LocalDateTime;

public interface TravisUser {
    int getId();
    String getLogin();
    String getName();
    int getGitHubId();
    String getAvatarUrl();
    boolean getEducation();
    boolean isSync();
    LocalDateTime getSyncedAt();
}
