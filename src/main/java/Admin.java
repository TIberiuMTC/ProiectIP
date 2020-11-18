import java.util.Scanner;
import java.util.ArrayList;


import java.io.File;
import java.io.FileNotFoundException;

import java.io.FileWriter;
import java.io.IOException;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


public class Admin extends User {
    public Admin(String mUsername, String mPassword) {
        super(mUsername, mPassword);
        isAdmin = true;
    }

    public static boolean DeleteClient(){
        try {
            File fObj = new File("resources/users.txt");
            Scanner myReader = new Scanner(fObj);
            ArrayList<String> users = new ArrayList<>();
            int ok = 0;

            while (myReader.hasNextLine()) {
                String line = myReader.nextLine();
                users.add(line);
                users.add("\n");
            }

            //display
            System.out.print("Users are: \n");
            for(int i = 0; i < users.size(); i++) {
                System.out.print(users.get(i));
            }

            //client name input
            Scanner _scanner = new Scanner(System.in);
            String clientName;
            System.out.print("Client name: ");
            clientName = _scanner.nextLine();

            for (int i = 0; i < users.size();i++) {
                String currentUser = users.get(i);
                String[] devided = currentUser.split("\t");

                if (devided[0].equals(clientName)) {
                    users.remove(i);
                    ok = 1;
                }
            }

            //verify if client exists
            if(ok == 0){
                System.out.println("\nClient doesn't exist!\n");
                return false;
            }

            //write in file users without the one deleted
            FileWriter fw = new FileWriter("resources/users.txt", false);
            for(String str: users) {
                fw.write(str);
            }
            fw.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        return false;
    }

}
