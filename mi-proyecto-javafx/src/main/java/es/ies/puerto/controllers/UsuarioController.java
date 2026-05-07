package es.ies.puerto.controllers;

// import es.ies.puerto.models.Usuario;
// import es.ies.puerto.services.UsuarioService;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class UsuarioController {

    @FXML
    private TextField nombreField;

    @FXML
    private TextField edadField;

    @FXML
    private Label resultadoLabel;

    // private UsuarioService usuarioService;

    @FXML
    public void initialize() {
        // usuarioService = new UsuarioService();
    }

    @FXML
    public void mostrarUsuario() {
        try {
            String nombre = nombreField.getText();
            System.out.println("Nombre introducido: " + nombre);
            int edad = Integer.parseInt(edadField.getText());
            System.out.println("Edad introducida: " + edad);

            // Usuario usuario = usuarioService.crearUsuario(nombre, edad);
            // resultadoLabel.setText(usuario.toString());
        } catch (NumberFormatException exception) {
            String mensaje = "La edad debe ser un numero valido";
            mostrarError(mensaje);
            edadField.setText(mensaje);
        }
    }

    private void mostrarError(String mensaje) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText("Dato no válido");
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
}