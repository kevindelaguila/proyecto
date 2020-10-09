package controlador;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

public class ClienteController implements Initializable {

    private Button btnRegistrar;
    @FXML
    private Button btnAtras;
    @FXML
    private Button btnEmpresas;
    @FXML
    private Button btnIndividual;
    @FXML
    private Button btnconsultar;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    public void closeWindows() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/InicioVista.fxml"));
            Parent root = loader.load();
            InicioController controlador = loader.getController();
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
            Stage myStage = (Stage) this.btnAtras.getScene().getWindow();
            myStage.close();
        } catch (IOException ex) {
            Logger.getLogger(ClienteController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
   
    @FXML
    private void atras(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/InicioVista.fxml"));
            Parent root = loader.load();
            InicioController controlador = loader.getController();
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
            Stage myStage = (Stage) this.btnAtras.getScene().getWindow();
            myStage.close();
        } catch (IOException ex) {
            Logger.getLogger(ClienteController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void gEmpresas(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/EmpVista.fxml"));
            Parent root = loader.load();
            EmpController controlador = loader.getController();
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
            stage.setOnCloseRequest(e -> controlador.closeWindows());
            Stage myStage = (Stage) this.btnAtras.getScene().getWindow();
            myStage.close();
        } catch (IOException e) {

        }
    }

    @FXML
    private void gIndividual(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/IndVista.fxml"));
            Parent root = loader.load();
            IndController controlador = loader.getController();
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
            stage.setOnCloseRequest(e -> controlador.closeWindows());
            Stage myStage = (Stage) this.btnAtras.getScene().getWindow();
            myStage.close();
        } catch (IOException e) {
        }
    }

    @FXML
    private void consultar(ActionEvent event) {
        int seleccion = JOptionPane.showOptionDialog(null, "Reportes Clientes",
                "Cliente", JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE, null, new Object[]{"Empresa", "Individual", "Todos"}, "Empresa");
        if (seleccion == 0) {
            SesionController.tipoConsulta = "empresa";
        }
        if (seleccion == 1) {
            SesionController.tipoConsulta = "individual";
        }
        if (seleccion == 2) {
            SesionController.tipoConsulta = "todos";
        }
        if (seleccion != -1) {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/GridClienteVista.fxml"));
                Parent root = loader.load();
                GridClienteController controlador = loader.getController();
                Scene scene = new Scene(root);
                Stage stage = new Stage();
                stage.setScene(scene);
                stage.show();
                stage.setOnCloseRequest(e -> controlador.closeWindows());
                Stage myStage = (Stage) this.btnAtras.getScene().getWindow();
                myStage.close();
            } catch (IOException e) {

            }
        }
    }
}
