import buildnotifier.Repo;
import buildnotifier.RepoFactory;
import buildnotifier.Travis.RepoFactoryImpl;
import buildnotifier.ConsoleUI;

public class Program {
    public static void main(String[] args) throws Exception {
        RepoFactory repoFactory = new RepoFactoryImpl();
        Repo repo = repoFactory.getRepo();
        ConsoleUI console = new ConsoleUI(repo);
        while (true){
            Thread.sleep(4*1000);
            repo.refresh();
        }
    }

}