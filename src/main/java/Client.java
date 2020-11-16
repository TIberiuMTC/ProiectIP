public class Client {
    private String mNume;
    private String mPrenume;
    private int mSumaBani;
    private String mUsername;
    private String mPassword;

    public Client(String mNume, String mPrenume, int mSumaBani, String mUsername, String mPassword) {
        this.mNume = mNume;
        this.mPrenume = mPrenume;
        this.mSumaBani = mSumaBani;
        this.mUsername = mUsername;
        this.mPassword = mPassword;
    }

    public Client(Client c) {
        this.mNume = c.mNume;
        this.mPrenume = c.mPrenume;
        this.mSumaBani = c.mSumaBani;
        this.mUsername = c.mUsername;
        this.mPassword = c.mPassword;
    }

    @Override
    public String toString() {
        return "Client{" +
                "mNume='" + mNume + '\'' +
                ", mPrenume='" + mPrenume + '\'' +
                ", mSumaBani=" + mSumaBani +
                ", mUsername='" + mUsername + '\'' +
                ", mPassword='" + mPassword + '\'' +
                '}';
    }
}
