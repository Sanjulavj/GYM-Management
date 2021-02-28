package sample;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class GUI extends Application {
    Stage stage;
    Scene scene;

    @Override
    public void start(Stage primaryStage) {
        stage = primaryStage;
        //Adding a border pane
        BorderPane layout = new BorderPane();
        //adding center and top elements to border pane
        layout.setTop(addTop());
        layout.setCenter(addCenter());
        scene = new Scene(layout, 655, 530);
        layout.setStyle("-fx-background-color:#ffffb3;-fx-font-family:Arial");
        stage.setScene(scene);
        stage.setTitle("GYM Management System");
        stage.show();

    }


    //adding top bar of the scene
    public HBox addTop() {
        HBox hbox = new HBox();
        hbox.setPadding(new Insets(10, 15, 10, 245));
        hbox.setStyle("-fx-background-color: #01233f;");
        //adding an image to top bar
        Image imgLogo = new Image("sample/logoNew.png");
        ImageView logoImage = new ImageView(imgLogo);
        logoImage.setFitWidth(160);
        logoImage.setFitHeight(55);
        hbox.getChildren().addAll(logoImage);
        return hbox;
    }

    //adding content to grid pane
    public GridPane addCenter() {
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(1, 20, 20, 20));
        Text txt1 = new Text("Search for:");
        txt1.setFill(Color.web("rgb(0, 61, 89)"));
        TextField txtFld1 = new TextField();

        MyGymManager myGymManager = new MyGymManager();
        TableView<DisplayList> table = new TableView<DisplayList>(myGymManager.tableData());
        table.setStyle("-fx-font-family:Arial;-fx-border-color:#003d59");

        //adding a table
        TableColumn col1 = new TableColumn(("ID"));
        col1.setPrefWidth(70);
        col1.setCellValueFactory(new PropertyValueFactory<>("membershipNumber"));
        table.getColumns().add(col1);

        TableColumn col2 = new TableColumn(("Name"));
        col2.setPrefWidth(120);
        col2.setCellValueFactory(new PropertyValueFactory<>("name"));
        table.getColumns().add(col2);

        TableColumn col3 = new TableColumn(("Date"));
        col3.setPrefWidth(100);
        col3.setCellValueFactory(new PropertyValueFactory<>("Date"));
        table.getColumns().add(col3);

        TableColumn col4 = new TableColumn(("Type"));
        col4.setPrefWidth(70);
        col4.setCellValueFactory(new PropertyValueFactory<>("Type"));
        table.getColumns().add(col4);

        TableColumn col5 = new TableColumn(("School"));
        col5.setPrefWidth(100);
        col5.setCellValueFactory(new PropertyValueFactory<>("School"));
        table.getColumns().add(col5);

        TableColumn col6 = new TableColumn(("Age"));
        col6.setPrefWidth(50);
        col6.setCellValueFactory(new PropertyValueFactory<>("age"));
        table.getColumns().add(col6);

        TableColumn col7 = new TableColumn(("Contact Num"));
        col7.setPrefWidth(100);
        col7.setCellValueFactory(new PropertyValueFactory<>("ContactNum"));
        table.getColumns().add(col7);


        myGymManager.tableSearch(myGymManager.tableData(), txtFld1, table);

        grid.add(txt1, 0, 3);
        grid.add(txtFld1, 1, 3);
        grid.add(table, 0, 4, 5, 1);

        return grid;

    }

    public static void main(String[] args) {
        launch(args);

    }
}
