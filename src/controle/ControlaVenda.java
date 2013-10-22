/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import dao.DaoVenda;
import modelo.Venda;

/**
 *
 * @author gui
 */
public class ControlaVenda {
    public boolean cadastraVenda(Venda Venda){
        DaoVenda daov= new DaoVenda();
        daov.insert(Venda);
        return true;    
    
    }
}