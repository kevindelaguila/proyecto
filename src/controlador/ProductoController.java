package controlador;

import java.awt.HeadlessException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import modelo.Producto;

public class ProductoController implements Initializable {

    @FXML
    private TextField txtId;
    @FXML
    private TextField txtNombre;
    @FXML
    private TextField txtDescripcion;
    @FXML
    private TextField txtPrecio;
    @FXML
    private TableColumn<Producto, Integer> colId;
    @FXML
    private TableColumn<Producto, String> colNombre;
    @FXML
    private TableColumn<Producto, String> colDescripcion;
    @FXML
    private TableColumn<Producto, Integer> colPrecio;
    @FXML
    private Button btnInsertar;
    @FXML
    private Button btnActualizar;
    @FXML
    private Button btnEliminar;
    @FXML
    private TableView<Producto> tabla;
    @FXML
    private TextField txtCantidad;
    @FXML
    private TableColumn<Producto, Integer> colCantidad;
    @FXML
    private Button btnRegresar;
    @FXML
    private Button btnGrid;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        mostrarProductos();
    }

    @FXML
    private void insertar(ActionEvent event) {
        try {
            Producto producto = new Producto(txtNombre.getText(), txtDescripcion.getText(), Integer.parseInt(txtPrecio.getText()), Integer.parseInt(txtCantidad.getText()));
            SesionController.productos.add(producto);
            JOptionPane.showMessageDialog(null, "Producto agregado", "Agregar", JOptionPane.INFORMATION_MESSAGE);
            mostrarProductos();
            limpiarCampos();
        } catch (HeadlessException | NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Invalido", "Error", JOptionPane.ERROR_MESSAGE);
            limpiarCampos();
        }
    }

    @FXML
    private void actualizar(ActionEvent event) {
        int posicion = 0;
        try {
            Producto producto = new Producto(txtNombre.getText(), txtDescripcion.getText(), Integer.parseInt(txtPrecio.getText()), Integer.parseInt(txtCantidad.getText()));
            for (Producto p : SesionController.productos) {
                if (Integer.parseInt(txtId.getText()) == p.getId()) {
                    posicion = SesionController.productos.indexOf(p);
                    break;
                }
            }
            producto.setId(Integer.parseInt(txtId.getText()));
            SesionController.productos.set(posicion, producto);
            Producto.sigIdProducto--;
            JOptionPane.showMessageDialog(null, "Producto modificado", "Modificar", JOptionPane.INFORMATION_MESSAGE);
            mostrarProductos();
            limpiarCampos();
        } catch (HeadlessException | NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Invalido", "Error", JOptionPane.ERROR_MESSAGE);
            limpiarCampos();
        }
    }

    @FXML
    private void eliminar(ActionEvent event) {
        try {
            int posicion = 0;
            for (Producto p : SesionController.productos) {
                if (Integer.parseInt(txtId.getText()) == p.getId()) {
                    posicion = SesionController.productos.indexOf(p);
                    break;
                }
            }
            SesionController.productos.remove(posicion);
            JOptionPane.showMessageDialog(null, "Producto Eliminado", "Eliminado", JOptionPane.INFORMATION_MESSAGE);
            mostrarProductos();
            limpiarCampos();
        } catch (HeadlessException | NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Invalido", "Error", JOptionPane.ERROR_MESSAGE);
            limpiarCampos();
        }
    }

    public ObservableList<Producto> getProductos() {
        ObservableList<Producto> listaProductos = FXCollections.observableArrayList();
        for (Producto producto : SesionController.productos) {
            listaProductos.add(producto);
        }
        return listaProductos;
    }

    public void mostrarProductos() {
        ObservableList<Producto> list = getProductos();
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colDescripcion.setCellValueFactory(new PropertyValueFactory<>("descripcion"));
        colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        colPrecio.setCellValueFactory(new PropertyValueFactory<>("precio"));
        colCantidad.setCellValueFactory(new PropertyValueFactory<>("cantidad"));
        tabla.setItems(list);
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
            Stage myStage = (Stage) this.btnInsertar.getScene().getWindow();
            myStage.close();
        } catch (IOException ex) {
            Logger.getLogger(ClienteController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void click(MouseEvent event) {
        Producto producto = tabla.getSelectionModel().getSelectedItem();
        txtId.setText(String.valueOf(producto.getId()));
        txtNombre.setText(producto.getNombre());
        txtDescripcion.setText(producto.getDescripcion());
        txtPrecio.setText(String.valueOf(producto.getPrecio()));
        txtCantidad.setText(String.valueOf(producto.getCantidad()));
    }

    public void limpiarCampos() {
        txtNombre.setText("");
        txtDescripcion.setText("");
        txtPrecio.setText("");
        txtCantidad.setText("");
        txtId.setText("");
    }

    @FXML
    private void regresar(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/InicioVista.fxml"));
            Parent root = loader.load();
            InicioController controlador = loader.getController();
            Scene scene = new Scene(root);
            Stage stage = new Stage();

            stage.setScene(scene);
            stage.show();

            Stage myStage = (Stage) this.btnRegresar.getScene().getWindow();
            myStage.close();
        } catch (IOException ex) {
            Logger.getLogger(ClienteController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void mostrarP(ActionEvent event) {
        try{
             FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/GridProductoVista.fxml"));
                Parent root = loader.load();
                GridProductoController controlador = loader.getController();
                Scene scene = new Scene(root);
                Stage stage = new Stage();
                stage.setScene(scene);
                stage.show();
                stage.setOnCloseRequest(e -> controlador.closeWindows());
                Stage myStage = (Stage) this.btnGrid.getScene().getWindow();
                myStage.close();
               
         }catch(IOException e){
         }
    }
}
