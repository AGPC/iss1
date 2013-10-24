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
    
    public boolean consultavendedor(Vendedor vendedor){
        DaoVendedor daoc= new DaoVendedor();
        daoc.getporcampo(vendedor.getNome(),"nome");
        return true;
    }
    public boolean editavendedor(Vendedor vendedor){
        DaoVendedor daoc= new DaoVendedor();
        daoc.update(vendedor);
        return true;    
    
    }
    public boolean removevendedor(Vendedor vendedor){
        DaoVendedor daoc= new DaoVendedor();
        daoc.remove(vendedor.getIdVendedor());
        return true;    
    
    }
}