package projet1;

import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;

public class BruteForceAttack implements PasswordCrackerMode {
    private static final String CHARSET = "abcdefghijklmnopqrstuvwxyz0123456789";
    private static final int MAX_LENGTH = 6;

    public static void main(String[] args) {
        try {
            System.setOut(new PrintStream(System.out, true, "UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        Scanner scanner = new Scanner(System.in);
        System.out.print("Veuillez entrer le mot de passe : ");
        String password = scanner.nextLine();
        scanner.close();

        BruteForceAttack bruteForceAttack = new BruteForceAttack();
        bruteForceAttack.crackPassword(password);
    }

    @Override
    public void crackPassword(String password) {
        System.out.println("Mode Brute Force Attack");
        boolean passwordFound = bruteForceAttack(password);
        if (passwordFound) {
            System.out.println("Le mot de passe a ete trouve: " + password);
        } else {
            System.out.println("Le mot de passe est incorrect.");
        }
    }

    public boolean bruteForceAttack(String password) {
        return generatePasswords("", password);
    }

    public boolean generatePasswords(String base, String password) {
        if (base.equals(password)) {
            System.out.println("Mot de passe trouve : " + password);
            return true;
        }
        if (base.length() >= MAX_LENGTH) {
            return false;
        }
        for (int i = 0; i < CHARSET.length(); i++) {
            String newBase = base + CHARSET.charAt(i);
            if (generatePasswords(newBase, password)) {
                return true;
            }
        }

        return false;
    }
}