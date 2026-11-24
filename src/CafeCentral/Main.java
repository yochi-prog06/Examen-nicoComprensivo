package CafeCentral;

import CafeCentral.model.Alimento;
import CafeCentral.model.Producto;
import CafeCentral.model.ProductoFactory;
import CafeCentral.ventana.VentanaCafeteria;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {


       ProductoFactory pf;
       pf.crear("B01","Coca Cola","BEBIDA",1000,4);


        VentanaCafeteria ventana = new VentanaCafeteria();
        ventana.setVisible(true);
    }

}
