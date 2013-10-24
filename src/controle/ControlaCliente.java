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
    public boolean cadastraCliente(Cliente cliente){
        DaoCliente daoc= new DaoCliente();
        daoc.insert(cliente);
        return true;    
    
    }
    public boolean consultaCliente(Cliente cliente){
        DaoCliente daoc= new DaoCliente();
        daoc.getporcampo(cliente.getNome(),"nome");
        return true;
    }
    public boolean editaCliente(Cliente cliente){
        DaoCliente daoc= new DaoCliente();
        daoc.update(cliente);
        return true;    
    
    }
    public boolean removeCliente(Cliente cliente){
        DaoCliente daoc= new DaoCliente();
        daoc.remove(cliente.getIdCliente());
        return true;    
    
    }
}
