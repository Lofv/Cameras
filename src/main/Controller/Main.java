import javafx.application.Application;

/**
 * Created by Lofv on 25.11.2016.
 */
public class Main {

    public static void main(String[] args) {
        Podryad podryad = new Podryad();
        podryad.podryadCamers();

        Application.launch(MainWindow.class, args);
    }


}
