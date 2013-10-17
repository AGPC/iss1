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
}
