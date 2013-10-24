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
    public boolean consultaproddescricao(Produto produto){
        DaoProduto daoc= new DaoProduto();
        daoc.getporcampo(produto.getDescricao(),"descricao");
        return true;
    }
    public boolean consultaprodmarca(Produto produto){
        DaoProduto daoc= new DaoProduto();
        daoc.getporcampo(produto.getMarca(),"marca");
        return true;
    }
    public boolean editaproduto(Produto produto){
        DaoProduto daoc= new DaoProduto();
        daoc.update(produto);
        return true;    
    
    }
    public boolean removeCliente(Produto produto){
        DaoProduto daoc= new DaoProduto();
        daoc.remove(produto.getIdProduto());
        return true;    
    
    }
    
}
