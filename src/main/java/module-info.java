module es.antoniomc.Atriviate {
    requires javafx.controls;
    requires javafx.fxml;
    requires transitive javafx.graphics;
    requires transitive java.sql;
    requires jbcrypt;


    opens es.antoniomc.Atriviate to javafx.fxml;
    exports es.antoniomc.Atriviate;
    
    opens es.antoniomc.Atriviate.controller to javafx.fxml;
    exports es.antoniomc.Atriviate.controller;
    
    opens es.antoniomc.Atriviate.utils to java.sql;
    exports es.antoniomc.Atriviate.utils;
}
