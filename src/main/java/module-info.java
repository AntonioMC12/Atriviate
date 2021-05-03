module es.antoniomc.Atriviate {
    requires javafx.controls;
    requires javafx.fxml;

    opens es.antoniomc.Atriviate to javafx.fxml;
    exports es.antoniomc.Atriviate;
    
    opens es.antoniomc.Atriviate.controller to javafx.fxml;
    exports es.antoniomc.Atriviate.controller;
}
