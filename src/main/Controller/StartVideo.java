import javafx.scene.Scene;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

/**
 * Created by Lofv on 28.11.2016.
 */
public class StartVideo {

    public void start(Stage stage,String link) throws Exception {
        WebView webview = new WebView();
//        webview.getEngine().load("http://live.podryad.tv/CAM-1ya-morskaya-8/embed.html");
        webview.getEngine().load(link);
        webview.setPrefSize(640, 390);

        stage.setScene(new Scene(webview));
        stage.show();
    }
}
