module gestionnotas.edu.gestionnotas {
    requires javafx.controls;
    requires javafx.fxml;


    opens gestionnotas.edu.gestionnotas to javafx.fxml;
    exports gestionnotas.edu.gestionnotas;
}