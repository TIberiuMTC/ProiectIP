import java.util.ArrayList;

public class StoreChain {
    private String _mStoreChainName;
    private String _mOwner;
    private ArrayList<Store> _mChain= new ArrayList<Store>();

    public StoreChain(String _iStoreChainName, String _iOwner, ArrayList<Store> _iChain){
        this._mStoreChainName=_iStoreChainName;
        this._mOwner=_iOwner;
        this._mChain=_iChain;
    }

    public StoreChain(String _iStoreChainName, String _iOwner, Store _iStore){
        this._mStoreChainName=_iStoreChainName;
        this._mOwner=_iOwner;
        this._mChain.add(_iStore);
    }

    public String toBeDisplayed(){
        String _rBuff="";
        _rBuff+="Store Chain name: ";
        _rBuff+=this._mStoreChainName;
        _rBuff+="\n";

        _rBuff+="Owner name: ";
        _rBuff+=this._mOwner;
        _rBuff+="\n";

        _rBuff+="Stores: ";
        _rBuff+="\n";

        for (int i=0;i<this._mChain.size();i++){
            _rBuff+=this._mChain.get(i).stock_display();
        }
        _rBuff+="\n";
        return _rBuff;
    }

    public String get_mOwner() { return this._mOwner; }
    public String get_mStoreChainName(){return this._mStoreChainName;}
    public ArrayList<Store> get_mChain(){return this._mChain;}

    public void set_mStoreChainName(String _iStoreChaineName) {this._mStoreChainName=_iStoreChaineName;}
    public void set_mOwner(String _iOwner){this._mOwner=_iOwner;}
    public void set_mChain(ArrayList<Store> _iChain){this._mChain=_iChain;}

    public void add_Store(Store _iStore){
        int counter=0;
        for (int i=0;i<this._mChain.size();i++) {
            if (this._mChain.get(i).get_mStoreName()==_iStore.get_mStoreName()) {
                counter++;
            }
        }
        if (counter==0){
            this._mChain.add(_iStore);
            return;
        }
        return;
    }

    public void remove_Store(Store _iStore){
        for (int i=0;i<this._mChain.size();i++){
            if (this._mChain.get(i).get_mStoreName()==_iStore.get_mStoreName()){
                this._mChain.remove(i);
            }
        }
        return;
    }
}
