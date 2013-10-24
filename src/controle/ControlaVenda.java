/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import dao.DaoVenda;
import java.util.Date;
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
    public boolean consultavendacli(Venda venda){
        DaoVenda daoc= new DaoVenda();
        daoc.getporcampo(venda.getClienteidCliente().getNome(),"nome");
        return true;
    }
    public boolean consultavendavend(Venda venda){
        DaoVenda daoc= new DaoVenda();
        daoc.getporcampo(venda.getVendedoridVendedor().getNome(),"nome");
        return true;
    }
    public boolean consultavendaData(Venda venda,Date data1,Date data2){
        DaoVenda daoc= new DaoVenda();
        daoc.getporlimite(venda.getData().toString(),data1.toString(),data2.toString());
        return true;
    }
    public boolean editavenda(Venda venda){
        DaoVenda daoc= new DaoVenda();
        daoc.update(venda);
        return true;    
    
    }
    public boolean removevenda(Venda venda){
        DaoVenda daoc= new DaoVenda();
        daoc.remove(venda.getIdVenda());
        return true;    
    
    }
}