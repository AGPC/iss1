package dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
 
public class Dao <T>{
 /*cria um gerenciador de entidades, a partir da fábrica de gerenciadores de entidade
 Obs: não utilizar static, pois pode gerar problemas em relacionamentos Many-To-Many */
 private EntityManager em = Persistence.createEntityManagerFactory("UP").createEntityManager();
 //Atributo do tipo classe utilizado no Java Reflection
 private Class classe;
 
 public Dao(Class classe) {
      //faz o atributo classe receber a classe da entidade, que deve ser passada no construtor      
      this.classe = classe;
 }
 
//Método para inserir um registro no banco de dados a partir de um objeto
 public void insert(T entidade){
      em.getTransaction().begin();
      em.persist(entidade);
      em.getTransaction().commit();
 }
 
//Método para atualizar um registro no banco de dados a partir de um objeto
 public void update(T entidade){
      em.getTransaction().begin();
      em.merge(entidade);
      em.getTransaction().commit();
 }
 
//Método para obter um registro no banco de dados a partir de um id
 public T get(int id){
      return (T)em.find(classe, id);
 }
 
 public List<T> getporcampo(String e,String campo){
      return em.createQuery("Select * From" + classe.getSimpleName() + "Where" + campo + " = " + e).getResultList();
 }
 
 public List<T> getporlimite(String e,String campo1,String campo2){
      return em.createQuery("Select * From" + classe.getSimpleName() + "Where (" +e+ ">" + campo1 + ") and (" +e+ "<" +campo2+ ")").getResultList();
 }
 
//Método para remover um registro no banco de dados a partir de um id
 public void remove(int id){
      T entidade = get(id);
      if(entidade!=null){
      em.getTransaction().begin();
      em.remove(entidade);
      em.getTransaction().commit();
 }
 }
 
//Retorna todos os registros no banco de dados da tabela equivalente a entidade passada por parâmetro
 public List<T> list(){
       return em.createQuery("SELECT e FROM " + classe.getSimpleName() + " e").getResultList();
 }
}