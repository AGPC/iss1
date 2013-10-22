/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import dao.DaoCompra;
import modelo.Compra;

/**
 *
 * @author gui
 */
public class ControlaCompra {
    public boolean cadastraCompra(Compra Compra){
        DaoCompra daoc= new DaoCompra();
        daoc.insert(Compra);
        return true;    
    
    }
}
