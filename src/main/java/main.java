import java.util.ArrayList;
import java.util.Scanner;

class main {
    public static Client Login_prompt()
    {
        System.out.println("Options:");
        System.out.println("0. Exit program");
        System.out.println("1. Log in");
        System.out.println("2. Log in as admin");
        System.out.println("3. Register");
        System.out.println();

        Scanner _scanner = new Scanner(System.in);

        boolean _done = false;
        while(!_done){
            System.out.print("client >> ");
            String _option = _scanner.nextLine();

            switch (_option){
                case "0":
                    System.exit(0);
                    break;
                case "1":
                    _done = UserManager.LogIn();
                    break;
                case "2":
                    _done = UserManager.LogInAdmin();
                    break;
                case "3":
                    _done = UserManager.Register();
                    break;
                default:
                    System.out.println("Error: " + _option + " is not an option");
            }
        }
        System.out.println();

        return new Client(UserManager.mClient);
    }

    public static Store Stores_prompt(Client client, ArrayList<Store> stores)
    {
        System.out.println("Options:");
        System.out.println("'exit': Exit program");
        System.out.println("'logout': Log out");
        System.out.println("Stores:");
        int i = 0;
        for(Store s : stores){
            System.out.println(i + ". " + s.get_mStoreName());
            i++;
        }
        System.out.println();

        Scanner _scanner = new Scanner(System.in);

        while(true){
            System.out.print(client.getUsername() + " >> ");
            String _option = _scanner.nextLine();

            switch (_option){
                case "exit":
                    System.exit(0);
                case "logout":
                    return null;
                default:
                    try { Integer.parseInt(_option); }
                    catch(Exception e){
                        System.out.println("Not an option!");
                        continue;
                    }
                    if(Integer.parseInt(_option) < 0 || Integer.parseInt(_option) + 1 > stores.size()){
                        System.out.println("Not an option!");
                        continue;
                    }
                    return stores.get(Integer.parseInt(_option));
            }
        }
    }

    public static int Final_prompt(Client client, Store store)
    {
        System.out.println("Extra options:");
        System.out.println("'exit': Exit program");
        System.out.println("'logout': Log out");
        System.out.println("'cart': Print cart");
        System.out.println("'add money': Adds money to pocket");
        System.out.println("'buy': Buy products and exit");
        System.out.println();

        Scanner _scanner = new Scanner(System.in);

        while(true) {
            System.out.print(client.getUsername() + " >> ");
            String _option = _scanner.nextLine();

            switch (_option) {
                case "exit":
                    System.exit(0);
                case "logout":
                    return -1;
                case "cart":
                    System.out.println(client.CartToString());
                    break;
                case "add money":
                    System.out.print("Type sum >> ");
                    String money = _scanner.nextLine();
                    try { Integer.parseInt(money); }
                    catch(Exception e){
                        System.out.println("Not an option!");
                        continue;
                    }
                    if(Integer.parseInt(money)>-1)
                        client.addMoney(Integer.parseInt(money));
                    else System.out.println("Not an option!");
                    break;
                case "buy":
                    client.buyCart();
                    return 0;
                default:
                    try { Integer.parseInt(_option); }
                    catch(Exception e){
                        System.out.println("Not an option!");
                        continue;
                    }
                    if(Integer.parseInt(_option) < 0 || Integer.parseInt(_option) + 1 > store.getNrProducts()){
                        System.out.println("Not an option!");
                        continue;
                    }
                    Product p = store.get_mStock().get(Integer.parseInt(_option));
                    client.addProductInCart(p,1);
                    System.out.println("Product " + p.get_mProduct_name() + " was added successfully!");
            }
        }
    }

    public static void main(String args[])
    {
        Product _test_product_1=new Product("Cartofi","Exe.srl",12,2020);
        Product _test_product_2=new Product("Mere","Ferma.srl",5,2021);
        Product _test_product_3=new Product("Pere","Ferma_Bucuresti.srl",6,2021);
        Product _test_product_4=new Product("Rosii","Ferma_Ploiesti.srl",2,2022);

        Store _test_store_1=new Store(_test_product_1,"Complex Vitan","Soseaua Vitan Nr 8.");
        _test_store_1.add_product(_test_product_2);
        _test_store_1.add_product(_test_product_3);

        Store _test_store_2=new Store(_test_product_4, "Complex Titan", "Soseaua Titan nr 1.");

        ArrayList<Store> _stores = new ArrayList<Store>();
        _stores.add(_test_store_1);
        _stores.add(_test_store_2);

        boolean _done = false;
        while(!_done){
            Client _client = Login_prompt();
            System.out.println(_client.toString());
            System.out.println();

            Store _store = Stores_prompt(_client, _stores);
            if(_store == null)
                continue;
            System.out.println(_store.stock_display());

            int res = Final_prompt(_client, _store);
            if (res == 0) {
                System.out.println("Products were bought successfully!");
                _done = true;
            }
        }
    }
}
