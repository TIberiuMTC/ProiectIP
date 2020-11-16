public class Product {
    private String _mProduct_name;
    private String _mProduct_producer;
    private int _mPrice;
    private int _mLimit;

    public Product(String _iProduct_name, String _iProduct_producer,
                   int _iPrice, int _iLimit){
        this._mProduct_name=_iProduct_name;
        this._mProduct_producer=_iProduct_producer;
        this._mPrice=_iPrice;
        this._mLimit=_iLimit;
    }

    public String details_returner(){
        String _rTemp_buff="";
        _rTemp_buff=this._mProduct_name;
        _rTemp_buff+=" produced by ";
        _rTemp_buff+=this._mProduct_producer;
        _rTemp_buff+=". Cost: ";
        _rTemp_buff+=this._mPrice;
        _rTemp_buff+=". Expiry date: ";
        _rTemp_buff+=this._mLimit;
        return _rTemp_buff;
    }

    public String get_mProduct_name(){return this._mProduct_name;}
    public String get_mProduct_producer(){return this._mProduct_producer;}
    public int get_mPrice(){return this._mPrice;}
    public int get_mLimit(){return this._mLimit;}

    public void set_mProduct_name(String _iProduct_name){this._mProduct_name=_iProduct_name;}
    public void set_mProduct_producer(String _iProduct_producer){this._mProduct_producer=_iProduct_producer;}
    public void set_mPrice(int _iPrice){this._mPrice=_iPrice;}
    public void set_mLimit(int _iLimit){this._mLimit=_iLimit;}
}
