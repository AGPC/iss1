/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import dao.DaoProduto;
import modelo.Produto;

/**
 *
 * @author gui
 */
public class ControlaProduto {
    public boolean cadastraProduto(Produto Produto){
        DaoProduto daop= new DaoProduto();
        daop.insert(Produto);
        return true;    
    
    }
}
