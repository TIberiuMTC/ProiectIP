import java.util.Scanner;

class main {
    public static void main(String args[]){
        Product _test_product_1=new Product("Cartofi","Exe.srl",12,2020);
        Product _test_product_2=new Product("Mere","Ferma.srl",5,2021);
        Product _test_product_3=new Product("Pere","Ferma_Bucuresti.srl",6,2021);

        System.out.println(_test_product_1.details_returner());
        System.out.println(_test_product_2.details_returner());
        System.out.println(_test_product_3.details_returner());
        System.out.println();

        System.out.println("Options:");
        System.out.println("0. Exit program");
        System.out.println("1. Log in");
        System.out.println("2. Register");
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
                    _done = UserManager.Register();
                    break;
                default:
                    System.out.println("Error: " + _option + " is not an option");
            }
        }

        Client _client = new Client(UserManager.mClient);
        System.out.println(_client.toString());
    }
}
