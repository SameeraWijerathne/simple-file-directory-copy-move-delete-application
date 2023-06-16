package lk.wsrp.sameera.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;
import javafx.stage.DirectoryChooser;

import javax.swing.*;
import java.io.File;

public class MainViewController {

    @FXML
    private Button btnCopy;

    @FXML
    private Button btnDelete;

    @FXML
    private Button btnDestinationBrowse;

    @FXML
    private Button btnMove;

    @FXML
    private Button btnSourceBrowse;

    @FXML
    private Label lblPercentage;

    @FXML
    private ProgressBar prgBar;

    @FXML
    private TextField txtDestination;
    private File sourceFile;
    private File targetFolder;

    @FXML
    private TextField txtSource;
    public void initialize() {
        btnCopy.setDisable(true);
        btnMove.setDisable(true);
        btnDelete.setDisable(true);

        txtSource.setEditable(false);
        txtDestination.setEditable(false);
    }

    @FXML
    void btnSourceBrowseOnAction(ActionEvent event) {
        JFileChooser chooser = new JFileChooser();
        chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        chooser.setDialogTitle("Select a file or directory");
        chooser.showOpenDialog(null);
        sourceFile = chooser.getSelectedFile();
        enableButtons();
        if (sourceFile == null) return;
        txtSource.setText(chooser.getSelectedFile().toString());
        System.out.println(sourceFile.getParentFile().length());
    }

    @FXML
    void btnDestinationBrowseOnAction(ActionEvent event) {
        DirectoryChooser directoryChooser = new DirectoryChooser();
        directoryChooser.setTitle("Select the destination folder");
        targetFolder = directoryChooser.showDialog(btnDestinationBrowse.getScene().getWindow());
        enableButtons();
        if (targetFolder == null) return;
        txtDestination.setText(targetFolder.getAbsolutePath());
    }

    private void enableButtons() {
        Button[] buttons = {btnCopy, btnMove};
        for (Button button : buttons) {
            button.setDisable(sourceFile == null || targetFolder == null ||
                    sourceFile.getParentFile().equals(targetFolder));
        }
        btnDelete.setDisable(sourceFile == null);
    }

    @FXML
    void btnCopyOnAction(ActionEvent event) {

    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {

    }

    @FXML
    void btnMoveOnAction(ActionEvent event) {

    }
}
