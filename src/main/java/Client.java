public class Client {
    private String mNume;
    private String mPrenume;
    private int mSumaBani;
    private String mUsername;
    private String mPassword;

    private Cart mCart = new Cart();

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
        return "Client {" +
                "mNume='" + mNume + '\'' +
                ", mPrenume='" + mPrenume + '\'' +
                ", mSumaBani=" + mSumaBani +
                ", mUsername='" + mUsername + '\'' +
                ", mPassword='" + mPassword + '\'' +
                '}';
    }

    public void addProductInCart(Product product, int quantity){
        this.mCart.addProduct(product, quantity);
    }
    public void removeProductFromCart(Product product){
        this.mCart.removeProduct(product);
    }
    public void removeEverythingFromCart(){
        this.mCart.removeAllProducts();
    }
    public void addMoney(int sum){
        mSumaBani += sum;
        System.out.println("Money added to pocket!");
    }

    public void buyCart(){
        int cost = this.mCart.getTotalSum();
        if(mSumaBani < cost){
            System.out.println("Insufficient funds!");
            return;
        }

        mSumaBani -= cost;
        this.removeEverythingFromCart();
        System.out.println("The products were bought successfully!");
    }

    public String CartToString(){
        return this.mCart.toString();
    }
}
