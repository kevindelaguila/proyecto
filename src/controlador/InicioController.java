
package controlador;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import modelo.Cliente;
import modelo.Producto;


public class InicioController implements Initializable {

    @FXML
    private Button btnCliente;
    @FXML
    private Button btnProducto;
    @FXML
    private Button btnOrden;
    @FXML
    private Button btnSalir;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    
    @FXML
    private void gestionCliente(ActionEvent event) {    
         try{
             FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/ClientVista.fxml"));
                Parent root = loader.load();
                ClienteController controlador = loader.getController();
                Scene scene = new Scene(root);
                Stage stage = new Stage();    
                stage.setScene(scene);
                stage.show();
                stage.setOnCloseRequest(e -> controlador.closeWindows());
                Stage myStage = (Stage) this.btnCliente.getScene().getWindow();
                myStage.close();
                for(Cliente cliente: SesionController.clientes){
                    System.out.println(cliente.toString());
                }
                System.out.println("");
                for(Producto producto: SesionController.productos){
                    System.out.println(producto.toString());
                }
         }catch(IOException e){
         }        
    }

    @FXML
    private void gestioProducto(ActionEvent event) {
         try{
             FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/ProductoVista.fxml"));
                Parent root = loader.load();
                ProductoController controlador = loader.getController();
                Scene scene = new Scene(root);
                Stage stage = new Stage();
                stage.setScene(scene);
                stage.show();
                stage.setOnCloseRequest(e -> controlador.closeWindows());
                Stage myStage = (Stage) this.btnCliente.getScene().getWindow();
                myStage.close();
                for(Cliente cliente: SesionController.clientes){
                    System.out.println(cliente.toString());
                }
         }catch(IOException e){
         }
    }

    @FXML
    private void gestionOrden(ActionEvent event) {
        try{
             FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/OrdenVista.fxml"));
                Parent root = loader.load();
                OrdenController controlador = loader.getController();
                Scene scene = new Scene(root);
                Stage stage = new Stage();
                stage.setScene(scene);
                stage.show();
                stage.setOnCloseRequest(e -> controlador.closeWindows());
                Stage myStage = (Stage) this.btnCliente.getScene().getWindow();
                myStage.close();
                for(Cliente cliente: SesionController.clientes){
                    System.out.println(cliente.toString());
                }
         }catch(IOException e){
         }
    }
    @FXML
    public void gestionSalir(ActionEvent event) {
          try{
             FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/SesionVista.fxml"));
                Parent root = loader.load();
                SesionController controlador = loader.getController();
                Scene scene = new Scene(root);
                Stage stage = new Stage();
               
                stage.setScene(scene);
                stage.show();
                
                Stage myStage = (Stage) this.btnSalir.getScene().getWindow();
                myStage.close();
         }catch(IOException e){        
         }
    }
    public void closeWindows(){   
    }
}
