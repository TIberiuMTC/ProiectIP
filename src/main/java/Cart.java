import java.util.HashMap;

public class Cart {
    private HashMap<Product, Integer> mProducts;

    public Cart() {
        this.mProducts = new HashMap<Product, Integer>();
    }

    public void addProduct(Product product, int quantity){
        this.mProducts.put(product, quantity);
    }

    public void removeProduct(Product product){
        this.mProducts.remove(product);
    }

    public void removeAllProducts(){
        this.mProducts.clear();
    }

    public int getTotalSum() {
        int suma = 0;
        for(Product p : this.mProducts.keySet())
            suma += this.mProducts.get(p) * p.get_mPrice();
        return suma;
    }

    @Override
    public String toString() {
        String ret = new String();
        ret += "Cart:\n";
        for(Product p : this.mProducts.keySet()){
            ret += p.details_returner();
            ret += "; Number of products: ";
            ret += this.mProducts.get(p);
            ret += "\n";
        }
        ret += "Total Cost: ";
        ret += this.getTotalSum();
        return ret;
    }
}
