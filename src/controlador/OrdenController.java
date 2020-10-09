package controlador;

import java.awt.HeadlessException;
import java.io.IOException;
import java.net.URL;
import java.util.Date;
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
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import modelo.Cliente;
import modelo.ItemOrden;
import modelo.Orden;
import modelo.Producto;

public class OrdenController implements Initializable {

    ObservableList cli = FXCollections.observableArrayList();
    ObservableList pro = FXCollections.observableArrayList();
    ObservableList env = FXCollections.observableArrayList();
    ObservableList estado = FXCollections.observableArrayList();
    ObservableList dias = FXCollections.observableArrayList();

    @FXML
    private TableView<Orden> tabla;
    @FXML
    private TableColumn<?, ?> colId;
    @FXML
    private Button btnInsertar;
    @FXML
    private Button btnActualizar;
    @FXML
    private Button btnEliminar;
    @FXML
    private TableColumn<Orden, Date> colFecha;
    @FXML
    private TableColumn<Orden, Double> colPrecioEnvio;
    @FXML
    private TableColumn<Orden, String> colEstado;
    @FXML
    private TableColumn<Orden, Double> colTotal;
    @FXML
    private ChoiceBox<Cliente> chCliente;
    @FXML
    private ChoiceBox<Producto> chProducto1;
    @FXML
    private ChoiceBox<Producto> chProducto2;
    @FXML
    private TextField txtPrecio;
    @FXML
    private ChoiceBox<String> chTipoEnvio;
    @FXML
    private ChoiceBox<String> chEstado;
    @FXML
    private ChoiceBox<Integer> chDiasEntrega;
    @FXML
    private Button regresar;
    @FXML
    private TextField txtcantidad1;
    @FXML
    private TextField txtCantidad2;
    @FXML
    private Button btnDetalles;
    @FXML
    private TextField txtId;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cargarDatosClientes();
        cargarDatosProductos();
        cargarDatosEnvio();
        cargarDatosDias();
        cargarDatosEstado();
        mostrarOrdenes();
    }

    @FXML
    
    
    private void insertar(ActionEvent event) {
        try{
        Orden orden = new Orden(new Date());
        orden.setCliente(chCliente.getValue());
        ItemOrden item1 = new ItemOrden(10000+orden.getId(), Integer.parseInt(txtcantidad1.getText()), chProducto1.getValue());
        ItemOrden item2 = new ItemOrden(20000+orden.getId(), Integer.parseInt(txtCantidad2.getText()), chProducto2.getValue());
            if ((chProducto1.getValue().getCantidad() < Integer.parseInt(txtcantidad1.getText()))
                    || chProducto2.getValue().getCantidad() < Integer.parseInt(txtCantidad2.getText())) {
                JOptionPane.showMessageDialog(null, "Ingrese una cantidad disponible", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                chProducto1.getValue().setCantidad(chProducto1.getValue().getCantidad() - Integer.parseInt(txtcantidad1.getText()));
                orden.setItem1(item1);
                orden.setItem2(item2);
                orden.setPrecioEnvio(Double.parseDouble(txtPrecio.getText()));
                orden.setTipoEnvio(chTipoEnvio.getValue());
                orden.setEstado(chEstado.getValue());
                orden.setDiasEnvio(chDiasEntrega.getValue());
                orden.getTotalOrden();
                SesionController.ordenes.add(orden);
                JOptionPane.showMessageDialog(null, "Orden Agregada", "Agregar", JOptionPane.INFORMATION_MESSAGE);
                mostrarOrdenes();
                limpiarCampos();
            }
        
        }catch(Exception e){
        JOptionPane.showMessageDialog(null, "Invalido", "Error", JOptionPane.ERROR_MESSAGE);
        limpiarCampos();
        }
    }

     @FXML
    private void actualizar(ActionEvent event) {
        int posicion = 0;
        try {
                    
        Orden orden = new Orden(new Date());
        orden.setCliente(chCliente.getValue());
        ItemOrden item1 = new ItemOrden(10000+orden.getId(), Integer.parseInt(txtcantidad1.getText()), chProducto1.getValue());
        ItemOrden item2 = new ItemOrden(20000+orden.getId(), Integer.parseInt(txtCantidad2.getText()), chProducto2.getValue());
         if( (chProducto1.getValue().getCantidad() < Integer.parseInt(txtcantidad1.getText()))||(chProducto2.getValue().getCantidad() < Integer.parseInt(txtCantidad2.getText()))  ){
             JOptionPane.showMessageDialog(null, "Ingrese una cantidad disponible", "Error", JOptionPane.ERROR_MESSAGE);
        }else{
        chProducto1.getValue().setCantidad(chProducto1.getValue().getCantidad()- Integer.parseInt(txtcantidad1.getText()));
        orden.setItem1(item1);
        orden.setItem2(item2);
        orden.setPrecioEnvio(Double.parseDouble(txtPrecio.getText()));
        orden.setTipoEnvio(chTipoEnvio.getValue());
        orden.setEstado(chEstado.getValue());
        orden.setDiasEnvio(chDiasEntrega.getValue());
        orden.getTotalOrden();
        for (Orden o : SesionController.ordenes) {
                if (Integer.parseInt(txtId.getText()) == o.getId()) {
                    posicion = SesionController.ordenes.indexOf(o);
                    break;
                }
            }
            orden.setId(Integer.parseInt(txtId.getText()));
            SesionController.ordenes.set(posicion, orden);
            Orden.sigIdOrden --;
            JOptionPane.showMessageDialog(null, "Orden modificada", "Modificar", JOptionPane.INFORMATION_MESSAGE);
            mostrarOrdenes();
            limpiarCampos();
        }
        } catch (HeadlessException | NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Invalido", "Error", JOptionPane.ERROR_MESSAGE);
            limpiarCampos();
        }
        
        
    }
    
    
    
    
    
    @FXML
    private void click(MouseEvent event) {
        Orden orden = tabla.getSelectionModel().getSelectedItem();
        
        txtCantidad2.setText(String.valueOf(orden.getItem2().getCantidad()));
        txtId.setText(String.valueOf(orden.getId()));
        txtPrecio.setText(String.valueOf(orden.getPrecioEnvio()));
        txtcantidad1.setText(String.valueOf(orden.getItem1().getCantidad()));
        chCliente.setValue(orden.getCliente());
        chDiasEntrega.setValue(orden.getDiasEnvio());
        chEstado.setValue(orden.getEstado());
        chProducto1.setValue(orden.getItem1().getProducto());
        chProducto2.setValue(orden.getItem2().getProducto());
        chTipoEnvio.setValue(orden.getTipoEnvio());
        
    }

   

    @FXML
    private void eliminar(ActionEvent event) {
        
         try {
            int posicion = 0;
            for (Orden o : SesionController.ordenes) {
                if (Integer.parseInt(txtId.getText()) == o.getId()) {
                    posicion = SesionController.ordenes.indexOf(o);
                    break;
                }
            }
            SesionController.ordenes.remove(posicion);
            JOptionPane.showMessageDialog(null, "Orden Eliminada", "Eliminar", JOptionPane.INFORMATION_MESSAGE);
            mostrarOrdenes();
            limpiarCampos();
        } catch (HeadlessException | NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Invalido", "Error", JOptionPane.ERROR_MESSAGE);
            limpiarCampos();
        }
        
        
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
    private void nuevo(ActionEvent event) {
        limpiarCampos();
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

            Stage myStage = (Stage) this.regresar.getScene().getWindow();
            myStage.close();
        } catch (IOException ex) {
            Logger.getLogger(ClienteController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void cargarDatosClientes() {
        cli.remove(cli);
        for (Cliente c : SesionController.clientes) {
            cli.add(c);
        }
        chCliente.getItems().addAll(cli);
    }

    private void cargarDatosProductos() {
        pro.remove(pro);
        for (Producto p : SesionController.productos) {
            pro.add(p);
        }
        chProducto1.getItems().addAll(pro);
        chProducto2.getItems().addAll(pro);
    }

    private void cargarDatosEnvio() {
        env.remove(env);
        String datos1 = "Capital";
        String datos2 = "Departamento";
        String datos3 = "Extranjero";
        env.addAll(datos1, datos2, datos3);
        chTipoEnvio.getItems().addAll(env);
    }

    private void cargarDatosEstado() {
        estado.remove(estado);
        String opc1 = "Entregada";
        String opc2 = "En proceso";
        String opc3 = "Orden cancelada";
        String opc4 = "Pendiente";
        estado.addAll(opc1, opc2, opc3, opc4);
        chEstado.getItems().addAll(estado);
    }

    private void cargarDatosDias() {
        dias.remove(dias);
        int dia1 = 1;
        int dia2 = 2;
        int dia3 = 3;
        int dia4 = 4;
        int dia5 = 5;
        int dia6 = 6;
        int dia7 = 7;
        dias.addAll(dia1, dia2, dia3, dia4, dia5, dia6, dia7);
        chDiasEntrega.getItems().addAll(dias);
    }

    public ObservableList<Orden> getOrdenes() {
        ObservableList<Orden> listaOrdenes = FXCollections.observableArrayList();
        for (Orden orden : SesionController.ordenes) {
            listaOrdenes.add(orden);
        }
        return listaOrdenes;
    }

    public void mostrarOrdenes() {
        ObservableList<Orden> list = getOrdenes();
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colFecha.setCellValueFactory(new PropertyValueFactory<>("fechaOrden"));
        colPrecioEnvio.setCellValueFactory(new PropertyValueFactory<>("precioEnvio"));
        colEstado.setCellValueFactory(new PropertyValueFactory<>("estado"));
        colTotal.setCellValueFactory(new PropertyValueFactory<>("total"));
        tabla.setItems(list);
    }

    @FXML
    private void mas(ActionEvent event) {
        try{
             FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/GridOrdenVista.fxml"));
                Parent root = loader.load();
                GridOrdenController controlador = loader.getController();
                Scene scene = new Scene(root);
                Stage stage = new Stage();
                stage.setScene(scene);
                stage.show();
                stage.setOnCloseRequest(e -> controlador.closeWindows());
                Stage myStage = (Stage) this.btnDetalles.getScene().getWindow();
                myStage.close();
                for(Cliente cliente: SesionController.clientes){
                    System.out.println(cliente.toString());
                }
         }catch(IOException e){
         }
    }

    private void limpiarCampos() {
        txtCantidad2.setText("");
        txtId.setText("");
        txtPrecio.setText("");
        txtcantidad1.setText("");
        chCliente.setValue(null);
        chDiasEntrega.setValue(null);
        chEstado.setValue(null);
        chProducto1.setValue(null);
        chProducto2.setValue(null);
        chTipoEnvio.setValue(null);
        
    }

}
