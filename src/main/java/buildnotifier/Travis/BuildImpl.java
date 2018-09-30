package buildnotifier.Travis;
import buildnotifier.Build;

public class BuildImpl implements Build {
    private String state;

    @Override
    public String getState() {
        return this.state;
    }


    protected void setState(String state) throws Exception {
        this.state = state;
    }

}
