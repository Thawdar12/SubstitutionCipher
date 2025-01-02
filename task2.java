// Task two: The substitution cipher

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class task2 {

    // private static StringBuilder keywordBuilder = new StringBuilder();
    // private static StringBuilder atozKey = new StringBuilder();
    

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get the keywork input
        System.out.println("Enter the keyword: ");
        String keyword = scanner.nextLine().toUpperCase();

        // Generating substitution Key
        String subKey = generateSubstitutionKey(keyword);
        // System.out.println(subKey + " " + subKey.length());

        // Generating atoz
        String atoz = generateAtoZString();
        // System.out.println(atoz + " " + atoz.length());

        // Input plaintext file and read it (encrypt)
        System.out.println("\nEnter the file input (to encrypt): ");
        String fileName = scanner.nextLine().toLowerCase();
        String plaintext = readFile(fileName);
        System.out.println("Plaintext inside the file: " + plaintext);

        // Encrypting plaintext
        System.out.println("\nEncrypting the plaintext . . .");
        String encryptedWord = encryption(plaintext, subKey, atoz);
        System.out.println(">Encrypted: " + encryptedWord);

        // Outputfile
        System.out.println("\nSaving it to a file . . .");
        writeFile("ciphertext.txt",encryptedWord);

        // Input plaintext file and read it (decrypt)
        System.out.println("\nEnter the file input (to decrypt): ");
        String fileName2 = scanner.nextLine().toLowerCase();
        String ciphertext = readFile(fileName2);
        System.out.println("Ciphertext inside the file: " + ciphertext);

        // Decrypting ciphertext
        System.out.println("\nDecrypting the ciphertext . . .");
        String decryptedWord = decryption(ciphertext, subKey, atoz);
        System.out.println(">Decrypted: " + decryptedWord);

        // Outputfile
        System.out.println("\nSaving it to a file . . .");
        writeFile("plaintext.txt",decryptedWord);

    }
    
    
    private static String generateSubstitutionKey(String keyword) {
        StringBuilder keywordBuilder = new StringBuilder();

        // remove repeated letters from the  keyword
        for (int i = 0; i < keyword.length(); i++) {
            char currentChar = keyword.charAt(i);
            if (keywordBuilder.indexOf(String.valueOf(currentChar)) == -1) {
                keywordBuilder.append(currentChar);
            }
        }

        // adding the rest alphabet in reverse order
        for (char c = 'Z'; c >= 'A'; c--) {
            if (keywordBuilder.indexOf(String.valueOf(c)) == -1) {
                keywordBuilder.append(c);
            }
        }
        return keywordBuilder.toString();

    }
    
    private static String generateAtoZString() {
        StringBuilder atozKey = new StringBuilder();

        for (char c = 'A'; c <= 'Z'; c++) {
            atozKey.append(c);
        }
        return atozKey.toString();

    }

    private static String encryption(String plaintext, String subkey, String atoz) {
        StringBuilder encrypted = new StringBuilder();
        // StringBuilder atozKey = new StringBuilder(atoz);

        //
        for (int j = 0; j < plaintext.length(); j++) {
            char currentPlainText = plaintext.charAt(j);

            for (int i = 0; i < atoz.length(); i++) {
                char currentChar = atoz.charAt(i);
                if (currentPlainText == currentChar) {
                    encrypted.append(subkey.charAt(i));
                }
            }
        }

        return encrypted.toString();
    }
    
    private static String decryption(String ciphertext, String subkey, String atoz) {
        StringBuilder decrypted = new StringBuilder();
       // StringBuilder atozKey = new StringBuilder(atoz);

       //
       for (int j = 0; j < ciphertext.length(); j++) {
           char currentCipherText = ciphertext.charAt(j);

           for (int i = 0; i < subkey.length(); i++) {
               char currentChar = subkey.charAt(i);
               if (currentCipherText == currentChar) {
                decrypted.append(atoz.charAt(i));
               }
           }
       }

       return decrypted.toString();
   }
    
    private static String readFile(String fileName) {
        BufferedReader reader;
        String plaintext = "";
        try {
            reader = new BufferedReader(new FileReader(fileName));
            String line = reader.readLine();

            if (line != null) {
                plaintext = line;
            }

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return plaintext.toUpperCase();

    }
    
    private static void writeFile(String fileName,String content) {
        try {
            // Convert the string to bytes and write to the file
            Files.write(Paths.get(fileName), content.getBytes());
            System.out.println("Content successfully written to the file.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}