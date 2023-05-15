package gui;

import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import testbench.DetailMemorySpaceTestbench;

public class controller{

    @FXML
    void buttonDetails(MouseEvent event){
        DetailMemorySpaceTestbench detail = new DetailMemorySpaceTestbench();
        detail.main();
    }
}