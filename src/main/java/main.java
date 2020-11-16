class main {
    public static void main(String args[]){
        Product _test_product_1=new Product("Cartofi","Exe.srl",12,2020);
        Product _test_product_2=new Product("Mere","Ferma.srl",5,2021);
        Product _test_product_3=new Product("Pere","Ferma_Bucuresti.srl",6,2021);

        System.out.println(_test_product_1.details_returner());
        System.out.println(_test_product_2.details_returner());
        System.out.println(_test_product_3.details_returner());
    }
}
