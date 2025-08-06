package us.malfeasant.templatefx;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.security.GeneralSecurityException;

import org.tinylog.Logger;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import us.malfeasant.hubconfig.ConnectHub;

/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {
        stage.setTitle("HubConfig");
        var labelIp = new Label("IP Address of Hub:");
        var fieldIp = new TextField();
        var buttonConnect = new Button("Connect");
        buttonConnect.setDefaultButton(true);
        // TODO add a validator to the IP field itself...
        buttonConnect.setOnAction(event -> connect(fieldIp.getText()));

        var grid = new GridPane();
        grid.addRow(0, labelIp, fieldIp, buttonConnect);
        grid.setHgap(10);
        grid.setPadding(new Insets(10));
        stage.setScene(new Scene(grid));

        stage.show();
    }
    public void connect(String ipString) {
        try {
            ConnectHub.connect(InetAddress.getByName(ipString));
        } catch (UnknownHostException e) {
            // TODO Alert?  Status line?  For now, just log it.
            Logger.error(e.getMessage());
        }
    }

    public static void main(String[] args) {
        launch();
    }

}