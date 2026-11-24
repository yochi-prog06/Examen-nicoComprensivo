package CafeCentral.persistencia;

import java.util.List;
import java.util.ArrayList;


public interface Repositorio<T> {

    void agregarProducto(T elemento);
    T buscarPorCodigo(String codigo);
    List<T> listarTodos();

}
