package Core;

public class LoginRules {
    public static boolean run(boolean... logics) {
        for (boolean logic : logics) {
            if (!logic) {
                return false;
            }
        }
        return true;
    }
}
