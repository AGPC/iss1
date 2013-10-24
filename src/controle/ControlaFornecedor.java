/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import dao.DaoFornecedor;
import modelo.Fornecedor;

/**
 *
 * @author Thais
 */
public class ControlaFornecedor {
    public boolean cadastraFornecedor(Fornecedor fornecedor){
        DaoFornecedor daof= new DaoFornecedor();
        daof.insert(fornecedor);
        return true;    
    
    }
    public boolean consultaFornecedor(Fornecedor fornecedor){
        DaoFornecedor daoc= new DaoFornecedor();
        daoc.getporcampo(fornecedor.getNome(),"nome");
        return true;
    }
    public boolean editaFornecedor(Fornecedor fornecedor){
        DaoFornecedor daoc= new DaoFornecedor();
        daoc.update(fornecedor);
        return true;    
    
    }
    public boolean removeCliente(Fornecedor fornecedor){
        DaoFornecedor daoc= new DaoFornecedor();
        daoc.remove(fornecedor.getIdFornecedor());
        return true;    
    
    }
}
