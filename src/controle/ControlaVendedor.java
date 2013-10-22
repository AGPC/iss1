/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import dao.DaoVendedor;
import modelo.Vendedor;

/**
 *
 * @author gui
 */
public class ControlaVendedor {
    public boolean cadastraVendedor(Vendedor Vendedor){
        DaoVendedor daov= new DaoVendedor();
        daov.insert(Vendedor);
        return true;    
    
    }
}