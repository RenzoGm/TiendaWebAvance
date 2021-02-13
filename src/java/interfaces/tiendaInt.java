/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

/**
 *
 * @author Renzo GM
 */
import beans.*;
import java.util.*;
public interface tiendaInt {
    List<Categoria> lisCategoria();
    List<Articulo> lisArticulo(String id);
    Articulo busArt(String id);
    Cliente busCli(String id);
    String grabaFact(String codc,List<Compra>lista);
}
