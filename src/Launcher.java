import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Launcher {

    public static void main(String[] args) {
        Game game = new Game("Test", 1280, 720);
        Method startMethod = null;
        try {
            startMethod = game.getClass().getMethod("start", null);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        try {
            startMethod.invoke(game);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
