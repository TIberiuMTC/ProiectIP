import java.util.Scanner;

import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors

import java.io.BufferedWriter;
import java.io.PrintWriter;
import java.io.FileWriter;   // Import the FileWriter class
import java.io.IOException;  // Import the IOException class to handle errors

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class UserManager {
    public static Client mClient;

    private static String hashThisString(String input)
    {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-1");

            byte[] messageDigest = md.digest(input.getBytes());

            // Convert byte array into signum representation
            BigInteger no = new BigInteger(1, messageDigest);

            // Convert message digest into hex value
            String hashtext = no.toString(16);

            // Add preceding 0s to make it 32 bit
            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }

            return hashtext;
        }

        // For specifying wrong message digest algorithms
        catch (NoSuchAlgorithmException e) {
            System.out.println("No such algorithm exception.");
            return null;
        }
    }

    public static boolean LogIn()
    {
        Scanner credentials_scanner = new Scanner(System.in);

        System.out.print("Username: ");
        String username = credentials_scanner.nextLine();

        System.out.print("Password: ");
        String password = credentials_scanner.nextLine();

        try {
            File fObj = new File("resources/users.txt");
            Scanner myReader = new Scanner(fObj);
            while (myReader.hasNextLine()) {
                String line = myReader.nextLine();
                String[] creds = line.split("\t");
                if(creds[0].equals(username) && creds[1].equals(hashThisString(password))) {
                    mClient = new Client(creds[2], creds[3], Integer.parseInt(creds[4]), creds[0], creds[1]);
                    return true;
                }
            }
            myReader.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        System.out.println("Incorrect credentials!");
        return false;
    }

    private static boolean userExists(String user_name)
    {
        try {
            File fObj = new File("resources/users.txt");
            Scanner myReader = new Scanner(fObj);
            while (myReader.hasNextLine()) {
                String line = myReader.nextLine();
                String[] creds = line.split("\t");
                if(creds[0].equals(user_name))
                    return true;
            }
            myReader.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return false;
    }

    public static boolean Register()
    {
        Scanner credentials_scanner = new Scanner(System.in);

        System.out.print("Nume: ");
        String nume = credentials_scanner.nextLine();

        System.out.print("Prenume: ");
        String prenume = credentials_scanner.nextLine();

        System.out.print("Username: ");
        String username = credentials_scanner.nextLine();

        if(userExists(username)) {
            System.out.println("This username already exists!");
            return false;
        }

        System.out.print("Password: ");
        String password = credentials_scanner.nextLine();

        try {
            FileWriter fw = new FileWriter("resources/users.txt", true);
            fw.write(username + "\t" + hashThisString(password) + "\t" + nume + "\t" + prenume + "\t" + "0\n");
            fw.close();
            mClient = new Client(nume, prenume,0, username, hashThisString(password));
            return true;
        }
        catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        return false;
    }
}
