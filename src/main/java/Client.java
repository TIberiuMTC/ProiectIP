import java.io.*;

public class Client extends User {
    private String mNume;
    private String mPrenume;
    private int mSumaBani;

    private Cart mCart = new Cart();

    public Client(String mNume, String mPrenume, int mSumaBani, String mUsername, String mPassword) {
        super(mUsername, mPassword);
        this.mNume = mNume;
        this.mPrenume = mPrenume;
        this.mSumaBani = mSumaBani;
        this.isAdmin = false;
    }

    public Client(Client c) {
        super(c.mUsername, c.mPassword);
        this.mNume = c.mNume;
        this.mPrenume = c.mPrenume;
        this.mSumaBani = c.mSumaBani;
        this.isAdmin = false;
    }

    public String getUsername(){
        return this.mUsername;
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

    private void updateMoney(int sum)
    {
        File fileToBeModified = new File("resources/users.txt");

        String content = "";

        BufferedReader reader = null;
        FileWriter writer = null;

        try {
            reader = new BufferedReader(new FileReader(fileToBeModified));
            String line = reader.readLine();

            while (line != null) {
                String[] creds = line.split("\t");

                if(creds[0].equals(this.mUsername))
                    line = line.replaceAll("\t" + this.mSumaBani, "\t" + sum);

                content = content + line + System.lineSeparator();
                line = reader.readLine();
            }

            writer = new FileWriter(fileToBeModified);
            writer.write(content);

            this.mSumaBani = sum;
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        finally
        {
            try {
                reader.close();
                writer.close();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void addMoney(int sum){
        int money = this.mSumaBani + sum;

        this.updateMoney(money);

        System.out.println("Money added to pocket!");
    }

    public void buyCart(){
        int cost = this.mCart.getTotalSum();
        if(mSumaBani < cost){
            System.out.println("Insufficient funds!");
            return;
        }

        int money = this.mSumaBani - cost;
        this.updateMoney(money);
        this.removeEverythingFromCart();
        System.out.println("The products were bought successfully!");
    }

    public String CartToString(){
        return this.mCart.toString();
    }
}
