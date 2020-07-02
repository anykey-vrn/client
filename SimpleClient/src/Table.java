import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.util.ArrayList;

public class Table extends Application {

    private ObservableList<Out> Data = FXCollections.observableArrayList();

    @FXML
    private TableView<Out> out;

    @FXML
    private TableColumn<Out, String> outCol;

    @FXML
    private void initialize() {
        initData();

        outCol.setCellValueFactory(new PropertyValueFactory<>("out"));
        // заполняем таблицу данными
        out.setItems(Data);
    }
    private void initData() {
        ArrayList<String> array = SimpleClient.go();
        for (int a=0; a<array.size(); a++){
            Data.add(new Out( 1 ));
        }
    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {

    }
}
