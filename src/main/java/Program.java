import java.time.LocalDateTime;

public class Program {
    public static void main(String[] args) throws Exception {
        TravisApiImpl request = new TravisApiImpl();
        TravisBuild result = request.getPassed();
        System.out.println(result.getState());
    }

}