import br.com.mxtheuz.screens.Screens;

public class Main {
    public static void main(String[] args) {
        Screens screens = new Screens();
        screens.initScreen();
        while (true) {
            screens.options();
        }
    }
}