import java.util.ArrayList;

public class Store {
    private String _mStoreName;
    private String _mAddress;
    private ArrayList<Product> _mStock=new ArrayList<Product>();

    public Store(Product _iProd, String _iStoreName, String _iAddress){
        this._mStock.add(_iProd);
        this._mAddress=_iAddress;
        this._mStoreName=_iStoreName;
    }

    public void add_product(Product _iProd){
        int counter=0;
        for (int i=0;i<this._mStock.size();i++){
            if (this._mStock.get(i).get_mProduct_name()==_iProd.get_mProduct_name()){
                counter++;
            }
        }
        if (counter==0) {
            this._mStock.add(_iProd);
            return;
        }
        System.out.println("A product with the same name is already in the store\n");
        return;
    }

    public int getNrProducts(){
        return this._mStock.size();
    }

    public String stock_display(){
        String _rDescriptor="";
        _rDescriptor+="Store: ";
        _rDescriptor+=this._mStoreName;
        _rDescriptor+="\n";
        _rDescriptor+="Located at: ";
        _rDescriptor+=this._mAddress;
        _rDescriptor+="\n";
        _rDescriptor+="Products available: ";
        _rDescriptor+="\n";
        for (int i=0;i<this._mStock.size();i++){
            _rDescriptor+=i + ". ";
            _rDescriptor+=this._mStock.get(i).details_returner();
            _rDescriptor+="\n";
        }
        return _rDescriptor;
    }

    public void remove_product(Product _iProd){
        for (int i=0;i<this._mStock.size();i++){
            if (this._mStock.get(i).get_mProduct_name()==_iProd.get_mProduct_name()){
                this._mStock.remove(i);
            }
        }
    }

    public void set_mStoreName(String _iStoreName){this._mStoreName=_iStoreName;}
    public void set_mAddress(String _iAddress){this._mAddress=_iAddress;}
    public void set_mStock(ArrayList<Product> _iStock){this._mStock=_iStock;}

    public String get_mStoreName(){return this._mStoreName;}
    public String get_mAddress(){return this._mAddress;}
    public ArrayList<Product> get_mStock(){return this._mStock;}
}
