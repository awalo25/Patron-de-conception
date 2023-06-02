package projet1;

import java.util.Scanner;

public class PasswordCracker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Password Cracker ===");
        System.out.println("Modes disponibles :");
        System.out.println("1. Hash Dictionary Cracker");
        System.out.println("2. Brute Force Attack");
        System.out.println("3. Dictionary Attack");
        System.out.print("Choisissez le mode de craquage : ");
        int mode = 0;
        try {
            mode = scanner.nextInt();
        } catch (Exception e) {
            System.out.println("Entrée invalide !");
            return;
        }
        scanner.nextLine();

        PasswordCrackerFactory factory = new PasswordCrackerFactory();
        PasswordCrackerMode passwordCracker = factory.createPasswordCracker(mode);

        if (passwordCracker != null) {
            System.out.print("Veuillez entrer le mot de passe : ");
            String password = scanner.nextLine();
            passwordCracker.crackPassword(password);
        } else {
            System.out.println("Mode invalide !");
        }
    }
}
