package buildnotifier;
import buildnotifier.Travis.RepoFactoryImpl;
import buildnotifier.Travis.TravisBuildData;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.List;

public class JavaFxUI  extends Application implements Observer {
    private VBox vbox;
    private Repo repo;

    @Override
    public void update() throws Exception {
        List<Build> builds = repo.getBuilds();
        this.vbox.getChildren().clear();

        for (Build build : builds){
            Label label = new Label(build.getState());
            vbox.getChildren().add(label);
        }

        //this.repo.refresh();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("My First JavaFX App");

        RepoFactory repoFactory = new RepoFactoryImpl();
        this.repo = repoFactory.getRepo();
        repo.addObserver(this);
        this.vbox = new VBox();

        for (Build build : repo.getBuilds()){
            Label label = new Label(build.getState());
            vbox.getChildren().add(label);
        }

        Scene scene = new Scene(vbox, 200, 500);
        primaryStage.setScene(scene);

        primaryStage.show();
    }

    public static void launch(String[] args) {
        Application.launch(args);
    }
}
