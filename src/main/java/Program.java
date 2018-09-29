import buildnotifier.Travis.TravisApi;
import buildnotifier.Travis.TravisApiImpl;
import buildnotifier.Travis.TravisRepoData;
import buildnotifier.ConsoleUI;

public class Program {
    public static void main(String[] args) throws Exception {
        TravisApi travisApi = new TravisApiImpl();
        TravisRepoData travisRepo = travisApi.getPassed();
        ConsoleUI console = new ConsoleUI(travisRepo);
        while (true){
            travisRepo.refresh();
            Thread.sleep(10*1000);
        }
    }

}