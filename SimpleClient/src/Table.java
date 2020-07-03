import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.ArrayList;

public class Table extends Application {

    private String out;

    public Table() {
        super();
        out = null;
    }

    public Table(String out) {
        super();
        this.out = out;
    }

    @Override
    public void start(Stage stage) {

        TableView<Out> table = new TableView<Out>();

        // Create column UserName (Data type of String).
        TableColumn<Out, String> outCol
                = new TableColumn<Out, String>("out");

        outCol.setCellValueFactory(new PropertyValueFactory<Out, String>("out"));

        ObservableList<Out> list = getList();
        table.setItems(list);

        table.getColumns().addAll(outCol);

        StackPane root = new StackPane();
        root.setPadding(new Insets(5));
        root.getChildren().add(table);

        stage.setTitle("TableView (o7planning.org)");

        Scene scene = new Scene(root, 100, 300);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }


    private ObservableList<Out> getList() {
        ObservableList<Out> list = FXCollections.observableArrayList();
        ArrayList<String> out = SimpleClient.go();
        for (int i = 0; i < out.size(); i++) {
            String x = String.valueOf(out.get(i));
            Out new_out = new Out(x);
            String s = new_out.getOut();
            list.add(new_out);
        }
        return list;
    }
}