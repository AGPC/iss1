/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import dao.DaoCliente;
import modelo.Cliente;

/**
 *
 * @author gui
 */
public class ControlaCliente {
    public boolean cadastraCliente(Cliente Cliente){
        DaoCliente daoc= new DaoCliente();
        daoc.insert(Cliente);
        return true;    
    
    }
}
