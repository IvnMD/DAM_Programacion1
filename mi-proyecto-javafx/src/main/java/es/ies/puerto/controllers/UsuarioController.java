package es.ies.puerto.controllers;

import javafx.collections.FXCollections;
import es.ies.puerto.models.Usuario;
import javafx.collections.ObservableList;
import es.ies.puerto.services.IUsuarioService;
import es.ies.puerto.services.UsuarioService;
import es.ies.puerto.models.Usuario;
import es.ies.puerto.services.UsuarioService;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ListView;

public class UsuarioController {

    @FXML
    private TextField nombreField;

    @FXML
    private TextField edadField;

    @FXML
    private Label resultadoLabel;

    private IUsuarioService usuarioService;

    @FXML
    private ListView<Usuario> usuariosListView;

    private ObservableList<Usuario> usuariosObservableList = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        usuarioService = new UsuarioService();
        usuariosObservableList = FXCollections.observableArrayList(usuarioService.obtenerTodos());
        usuariosListView.setItems(usuariosObservableList);
    }

    @FXML
    public void mostrarUsuario() {
        try {
            String nombre = nombreField.getText();
            int edad = Integer.parseInt(edadField.getText());
            Usuario usuario = usuarioService.crearUsuario(nombre, edad);
            if (usuario == null) {
                resultadoLabel.setText("Usuario NO añadido");
                return;
            }

            usuariosObservableList.add(usuario);
            resultadoLabel.setText(usuario.toString());
        } catch (NumberFormatException exception) {
            String mensaje = "La edad debe ser un numero valido";
            mostrarError(mensaje);
            edadField.setText(mensaje);
        }
    }

    @FXML
    public void deleteUsuario() {
        Usuario usuarioSeleccionado = usuariosListView.getSelectionModel()
                .getSelectedItem();
        System.out.println("Eliminando usuario");
        boolean eliminado = usuarioService.eliminar((usuarioSeleccionado));
        if (eliminado) {
            usuariosObservableList.remove(usuarioSeleccionado);
            resultadoLabel.setText("Usuario eliminado correctamente");
        } else {
            resultadoLabel.setText("No se ha podido eliminar el usuario");
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