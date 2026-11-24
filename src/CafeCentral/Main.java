package CafeCentral;

import CafeCentral.model.Alimento;
import CafeCentral.model.Producto;
import CafeCentral.ventana.VentanaCafeteria;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {


        List<Alimento> productos = new ArrayList<>();
        productos = new Alimento("A01","Coca Cola", 1000, 5);


        VentanaCafeteria ventana = new VentanaCafeteria();
        ventana.setVisible(true);
    }

}
