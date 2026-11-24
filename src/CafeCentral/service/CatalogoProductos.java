package CafeCentral.service;

import CafeCentral.model.Producto;
import CafeCentral.persistencia.Repositorio;

import java.util.List;

public class CatalogoProductos implements Repositorio<Producto> {

    @Override
    public void agregarProducto(Producto elemento){

    }

    @Override
    public Producto buscarPorCodigo(String codigo) {

    }

    @Override
    public List<Producto> listarTodos() {
        return List<Producto>;
    }
}
