import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Lofv on 28.11.2016.
 */

public class MainWindow extends Application {

//    Podryad podryad=new Podryad();


    private static int countOfLinks = Podryad.getImgLinks().size();
    private static String regex;
    private static Pattern pattern;
    private static Matcher matcher;
    private static String mainUrl = Podryad.url;


    public static void initUI(Stage stage) {

        regex = mainUrl.toString() + ".*/preview.jpg";
        pattern = Pattern.compile(regex);

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        for (int i = 0; i < 2; i++) {


            matcher = pattern.matcher(Podryad.getImgLinks().get(0));

            while (matcher.find()) {
                System.out.println(matcher.group());
                ImageView imv = new ImageView();
//            Image image3 = new Image(matcher.group(),300,250,true,false);
                imv.setImage(new Image(matcher.group(), 300, 250, true, false));


                grid.getChildren().add(imv);
            }

        }
      /*  for (int i = 0; i < 5; i++) {


            matcher = pattern.matcher(Podryad.getImgLinks().get(i));

            while (matcher.find()) {
                System.out.println(matcher.group());
                ImageView imv = new ImageView();
                Image image = new Image(Main.class.getResourceAsStream(matcher.group()));


                Image image3 = new Image(matcher.group(), 100, 0, false, false);
                imv.setImage(image3);


                grid.getChildren().add(imv);
               *//* ImageView imageView = ImageViewBuilder.create()
                        .image(new Image(matcher.group()))
                        .build();


                Group myGroup = GroupBuilder.create()
                        .children(imageView)
                        .build();

                root.getChildren().add(myGroup);*//*
            }
   *//*
            ImageView imv = new ImageView();
            Image image = new Image(Main.class.getResourceAsStream(img));
            imv.setImage(image);

            final HBox pictureRegion = new HBox();

            pictureRegion.getChildren().add(imv);
            gridpane.add(pictureRegion, 1, 1);


            root.getChildren().add(gridpane);*//*

        }
*/


        Scene scene = new Scene(grid, 300, 250);
        stage.setTitle("FlowPane");
        stage.setScene(scene);
        stage.show();

    }

    @Override
    public void start(Stage stage) throws Exception {

        Parent root = FXMLLoader.load(getClass().getResource("resource/GridPane.fxml"));
        Scene scene = new Scene(root);
        // scene.getStylesheets().add(getClass().getResource());
        stage.setScene(scene);
        stage.show();

        //    initUI(stage);
    }





/*    Group root = new Group();

    String imageSource = "http://yourImageURL";

    ImageView imageView = ImageViewBuilder.create()
            .image(new Image(imageSource))
            .build();

    Group myGroup = GroupBuilder.create()
            .children(imageView)
            .build();

    root.getChildren().add(myGroup);*/
}
