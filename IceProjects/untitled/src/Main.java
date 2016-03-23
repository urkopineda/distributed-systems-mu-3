/**
 * Created by urko on 22/03/16.
 */
public class Main {

    public void fork() {
        try {
            int a = Integer.parseInt("forkk");
        } catch (Exception e) {
            fork();
        }
    }

    public void extrafork() {
        try {
            fork();
        } catch (StackOverflowError e) {
            System.gc();
            extrafork();
        }
    }

    public static void main(String [] args) {
        Main main = new Main();
        main.extrafork();
    }

}
