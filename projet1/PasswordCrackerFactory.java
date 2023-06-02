package projet1;

public class PasswordCrackerFactory {
    public PasswordCrackerMode createPasswordCracker(int mode) {
        switch (mode) {
            case 1:
                return new DictionaryHashCracker();
            case 2:
                return new BruteForceAttack();
            case 3:
                return new DictionaryAttack();
            default:
                return null;
        }
    }
}
