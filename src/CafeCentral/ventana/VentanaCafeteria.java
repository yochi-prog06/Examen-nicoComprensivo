package CafeCentral.ventana;

import javax.swing.*;
import java.awt.event.ActionListener;

public class VentanaCafeteria extends JFrame {
    private JButton btnRegistrarProducto;
    private JButton btnBuscarProducto;
    private JButton btnListarProductos;
    private JLabel lblCodigo;
    private JLabel lblNombre;
    private JLabel lblPrecioBase;
    private JLabel lblTipo;
    private JLabel lblCantidad;
    private JTextField txtCodigo;
    private JTextField txtNombre;
    private JTextField txtPrecioBase;
    private JTextField txtTipo;
    private JTextField txtCantidad;

    public VentanaCafeteria() {
        setTitle("Cafetería");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        JFrame Principal = new JFrame("CafeCentral");
        JPanel panel = new JPanel();



        btnRegistrarProducto = new JButton("Registrar Producto");
        btnRegistrarProducto.setBounds(100, 50, 200, 30);
        add(btnRegistrarProducto);

        btnBuscarProducto = new JButton("Buscar Producto");
        btnBuscarProducto.setBounds(100, 100, 200, 30);
        add(btnBuscarProducto);

        btnListarProductos = new JButton("Listar Productos");
        btnListarProductos.setBounds(100, 150, 200, 30);
        add(btnListarProductos);

        // Initialize labels
        lblCodigo = new JLabel("Código:");
        lblCodigo.setBounds(10, 200, 100, 20);
        add(lblCodigo);

        lblNombre = new JLabel("Nombre:");
        lblNombre.setBounds(10, 230, 100, 20);
        add(lblNombre);

        lblPrecioBase = new JLabel("Precio Base:");
        lblPrecioBase.setBounds(10, 260, 100, 20);
        add(lblPrecioBase);

        lblTipo = new JLabel("Tipo:");
        lblTipo.setBounds(10, 290, 100, 20);
        add(lblTipo);

        lblCantidad = new JLabel("Cantidad:");
        lblCantidad.setBounds(10, 320, 100, 20);
        add(lblCantidad);

        // Initialize text fields
        txtCodigo = new JTextField();
        txtCodigo.setBounds(120, 200, 180, 20);
        add(txtCodigo);

        txtNombre = new JTextField();
        txtNombre.setBounds(120, 230, 180, 20);
        add(txtNombre);

        txtPrecioBase = new JTextField();
        txtPrecioBase.setBounds(120, 260, 180, 20);
        add(txtPrecioBase);

        txtTipo = new JTextField();
        txtTipo.setBounds(120, 290, 180, 20);
        add(txtTipo);

        txtCantidad = new JTextField();
        txtCantidad.setBounds(120, 320, 180, 20);
        add(txtCantidad);

        btnRegistrarProducto.addActionListener(e -> {
            new JOptionPane().showMessageDialog(this, "Funcionalidad de registrar producto no implementada aún.");
        });

        btnListarProductos.addActionListener(e -> {
            new JOptionPane().showMessageDialog(this, "Funcionalidad de listar productos no implementada aún.");
        });

        btnBuscarProducto.addActionListener(e -> {
            new JOptionPane().showMessageDialog(this, "Funcionalidad de buscar producto no implementada aún.");
        });
    }


}
