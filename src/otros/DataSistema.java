package otros;

import java.util.Date;
import modelo.Cliente;
import modelo.Empresa;
import modelo.Individual;
import modelo.ItemOrden;
import modelo.Orden;
import modelo.Producto;
import modelo.Usuario;

public class DataSistema {

    public static Cliente[] todos = new Cliente[8];
    public static Producto[] productos = new Producto[8];
    public static Usuario[] usuarios = new Usuario[2];
    public static Orden[] orden = new Orden[8];

    public static void clientes() {

        Individual in1 = new Individual("513540101", "Kevin", "Ciudad de Guatemala", "15489562", "individual");
        Individual in2 = new Individual("351650101", "Josue", "Ciudad de Guatemala", "25361478", "individual");
        Individual in3 = new Individual("684350101", "Juan", "Ciudad de Guatemala", "89748562", "individual");
        Individual in4 = new Individual("135490101", "Jose", "Ciudad de Guatemala", "12789635", "individual");

        Empresa em1 = new Empresa("24241551", 20, "Productos del Aire", "Ciudad de Guatemala", "45123656", "empresa");
        Empresa em2 = new Empresa("24247895", 15, "Platino S.A", "Ciudad de Guatemala", "25789632", "empresa");
        Empresa em3 = new Empresa("24248536", 10, "Mixto Listo", "Ciudad de Guatemala", "14785495", "empresa");
        Empresa em4 = new Empresa("24248596", 15, "24/7", "Ciudad de Guatemala", "36148525", "empresa");

        todos[0] = in1;
        todos[1] = in2;
        todos[2] = in3;
        todos[3] = in4;
        todos[4] = em1;
        todos[5] = em2;
        todos[6] = em3;
        todos[7] = em4;

    }

    public static void productos() {
        Producto p1 = new Producto("Caja de cambios", "Se encarga de dar movimiento al motor segun velocidad ingresada", 5000, 2);
        Producto p2 = new Producto("Culata", "Se encarga de mantener a temperatura el motor ", 2000, 1);
        Producto p3 = new Producto("Amortiguadores", "Se encarga de dar estabilidad al automobil", 3000, 4);
        Producto p4 = new Producto("Bateria", "Se encarga de dar corriente al automobil", 1500, 3);
        Producto p5 = new Producto("Filtro de aceite", "Se encarga de filtrar el aceite al motor", 200, 3);
        Producto p6 = new Producto("Bomba de gasolina", "Se encarga de darle la gasolina necesaria al motor", 3000, 2);
        Producto p7 = new Producto("Radiador", "Purifica y mantiene estable la temperatura del auto", 1000, 2);
        Producto p8 = new Producto("Mordasa", "Es la encargada de dar buen control de frenos", 500, 4);

        productos[0] = p1;
        productos[1] = p2;
        productos[2] = p3;
        productos[3] = p4;
        productos[4] = p5;
        productos[5] = p6;
        productos[6] = p7;
        productos[7] = p8;
    }

    public static void usuarios() {

        Usuario user1 = new Usuario("ingenieria", "sistemas");
        Usuario user2 = new Usuario("ingenieria", "sistemas");
        usuarios[0] = user1;
        usuarios[1] = user2;
    }

    public static void ordenes() {

        Orden orden1 = new Orden(new Date());
        orden1.setCliente(todos[0]);
        ItemOrden item1 = new ItemOrden(100 + orden1.getId(), 3, productos[0]);
        ItemOrden item2 = new ItemOrden(200 + orden1.getId(), 4, productos[1]);
        orden1.setItem1(item1);
        orden1.setItem2(item2);
        orden1.setPrecioEnvio(10000);
        orden1.setTipoEnvio("Urgente");
        orden1.setEstado("Pendiente");
        orden1.setDiasEnvio(5);
        orden1.getTotalOrden();

        Orden orden2 = new Orden(new Date());
        orden2.setCliente(todos[1]);
        ItemOrden item3 = new ItemOrden(100 + orden2.getId(), 3, productos[0]);
        ItemOrden item4 = new ItemOrden(200 + orden2.getId(), 4, productos[1]);
        orden2.setItem1(item3);
        orden2.setItem2(item4);
        orden2.setPrecioEnvio(10000);
        orden2.setTipoEnvio("Urgente");
        orden2.setEstado("Pendiente");
        orden2.setDiasEnvio(5);
        orden2.getTotalOrden();

       
        Orden orden3 = new Orden(new Date());
        orden3.setCliente(todos[2]);
        ItemOrden item5 = new ItemOrden(100 + orden3.getId(), 3, productos[4]);
        ItemOrden item6 = new ItemOrden(200 + orden3.getId(), 4, productos[5]);
        orden3.setItem1(item3);
        orden3.setItem2(item4);
        orden3.setPrecioEnvio(10000);
        orden3.setTipoEnvio("Urgente");
        orden3.setEstado("Pendiente");
        orden3.setDiasEnvio(5);
        orden3.getTotalOrden();

         
        Orden orden4 = new Orden(new Date());
        orden4.setCliente(todos[3]);
        ItemOrden item7 = new ItemOrden(100 + orden4.getId(), 3, productos[6]);
        ItemOrden item8 = new ItemOrden(200 + orden4.getId(), 4, productos[7]);
        orden4.setItem1(item7);
        orden4.setItem2(item8);
        orden4.setPrecioEnvio(10000);
        orden4.setTipoEnvio("Urgente");
        orden4.setEstado("Pendiente");
        orden4.setDiasEnvio(5);
        orden4.getTotalOrden();

     
        Orden orden5 = new Orden(new Date());
        orden5.setCliente(todos[4]);
        ItemOrden item9 = new ItemOrden(100 + orden5.getId(), 3, productos[1]);
        ItemOrden item10 = new ItemOrden(200 + orden5.getId(), 4, productos[2]);
        orden5.setItem1(item9);
        orden5.setItem2(item10);
        orden5.setPrecioEnvio(10000);
        orden5.setTipoEnvio("Urgente");
        orden5.setEstado("Pendiente");
        orden5.setDiasEnvio(5);
        orden5.getTotalOrden();

        
        Orden orden6 = new Orden(new Date());
        orden6.setCliente(todos[5]);
        ItemOrden item11 = new ItemOrden(100 + orden6.getId(), 3, productos[3]);
        ItemOrden item12 = new ItemOrden(200 + orden6.getId(), 4, productos[4]);
        orden6.setItem1(item11);
        orden6.setItem2(item12);
        orden6.setPrecioEnvio(10000);
        orden6.setTipoEnvio("Urgente");
        orden6.setEstado("Pendiente");
        orden6.setDiasEnvio(5);
        orden6.getTotalOrden();

       
        Orden orden7 = new Orden(new Date());
        orden7.setCliente(todos[6]);
        ItemOrden item13 = new ItemOrden(100 + orden3.getId(), 3, productos[5]);
        ItemOrden item14 = new ItemOrden(200 + orden3.getId(), 4, productos[6]);
        orden7.setItem1(item13);
        orden7.setItem2(item14);
        orden7.setPrecioEnvio(10000);
        orden7.setTipoEnvio("Urgente");
        orden7.setEstado("Pendiente");
        orden7.setDiasEnvio(5);
        orden7.getTotalOrden();

        Orden orden8 = new Orden(new Date());
        orden8.setCliente(todos[7]);
        ItemOrden item15 = new ItemOrden(100 + orden3.getId(), 3, productos[7]);
        ItemOrden item16 = new ItemOrden(200 + orden3.getId(), 4, productos[0]);
        orden8.setItem1(item15);
        orden8.setItem2(item16);
        orden8.setPrecioEnvio(10000);
        orden8.setTipoEnvio("Urgente");
        orden8.setEstado("Pendiente");
        orden8.setDiasEnvio(5);
        orden8.getTotalOrden();

        orden[0] = orden1;
        orden[1] = orden2;
        orden[2] = orden3;
        orden[3] = orden4;
        orden[4] = orden5;
        orden[5] = orden6;
        orden[6] = orden7;
        orden[7] = orden8;
    }
}
