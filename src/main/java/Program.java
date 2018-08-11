import java.time.LocalDateTime;

public class Program {
    public static void main(String[] args) throws Exception {
        TravisApiImpl request = new TravisApiImpl();
        TravisUser travisUserser = request.getUser();
    }

}