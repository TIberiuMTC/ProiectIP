public class Admin extends User {
    public Admin(String mUsername, String mPassword) {
        super(mUsername, mPassword);
        isAdmin = true;
    }

}
