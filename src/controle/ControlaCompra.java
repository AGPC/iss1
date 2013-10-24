/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import dao.DaoCompra;
import java.util.Date;
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
    public boolean consultaCompraForn(Compra compra){
        DaoCompra daoc= new DaoCompra();
        daoc.getporcampo(compra.getFornecedoridFornecedor().getNome(),"nome");
        return true;
    }
    public boolean consultaCompraData(Compra compra,Date data1,Date data2){
        DaoCompra daoc= new DaoCompra();
        daoc.getporlimite(compra.getData().toString(),data1.toString(),data2.toString());
        return true;
    }
    public boolean editaCompra(Compra Compra){
        DaoCompra daoc= new DaoCompra();
        daoc.update(Compra);
        return true;    
    
    }
    public boolean removeCompra(Compra Compra){
        DaoCompra daoc= new DaoCompra();
        daoc.remove(Compra.getIdCompra());
        return true;    
    
    }
}
