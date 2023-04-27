module it.unitn.tonini {
    requires javafx.controls;
    requires javafx.fxml;


    opens it.unitn.tonini.main to javafx.fxml;
    exports it.unitn.tonini.main;
}