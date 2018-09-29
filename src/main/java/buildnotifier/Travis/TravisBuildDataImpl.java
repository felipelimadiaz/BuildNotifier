package buildnotifier.Travis;

class TravisBuildDataImpl implements TravisBuildData {
    private String state;

    @Override
    public String getState() {
        return this.state;
    }
}
