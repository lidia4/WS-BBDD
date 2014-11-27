package edu.upc.ettac.dxat.lihect.WS.BBDD;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;



public class CRUD {

	//atributos para mantener la referencia de la sesion de la bbdd y la transaccion
	private Session sesion;
	private Transaction tx;
	
	//metodo para iniciar la sesion
	private void iniciaOperacion() throws HibernateException
	{
		
		//Creamos conexión BBDD e inicamos una sesion
	    sesion = HibernateUtil.getSessionFactory().openSession();
	    //iniciamos transaccion
	    tx = sesion.beginTransaction();
	}
	
	private void manejaExcepcion(HibernateException he) throws HibernateException
	{
		//si hay un error se dehace la transaccion y nos muestra el error
	    tx.rollback();
	    throw new HibernateException("Ocurrió un error en la capa de acceso a datos", he);
	}
	
	
	
/*************************** CRUD USER ************************************/
	
	//Inserta nuevo usuario devolviendo el id de la tabla
	
	public long create_user(User user)
	{ 
	    long id = 0; //id de la tabla user (único) 

	    try 
	    { 
	        iniciaOperacion(); 
	        id = (Long)sesion.save(user); //metodo para guardar cliente (del objeto hibernate.sesion) 
	        tx.commit(); 
	    }catch(HibernateException he) 
	    { 
	        manejaExcepcion(he);
	        throw he; 
	    }finally 
	    { 
	        sesion.close(); 
	    }  
	    return id; 
	}

	
	//actualizacion de User
	
	public void update_user(User user) throws HibernateException 
	{ 
	    try 
	    { 
	        iniciaOperacion(); 
	        sesion.update(user); //metodo update de objeto sesion
	        tx.commit();
	    }catch (HibernateException he) 
	    { 
	        manejaExcepcion(he); 
	        throw he; 
	    }finally 
	    { 
	        sesion.close(); 
	    } 
	}
	
	//buscar usuario por el correo electronico (identificacion única de user)
	
	public User read_user(String mail) throws HibernateException
	{ 
		User user = null;  
		String i=null;
		long id_user=0;
	    try 
	    { 
	       iniciaOperacion(); //unique result me devuelve el objeto encontrado con dicho correo electronico
	       
	       i=  sesion.createQuery("SELECT u.id_user FROM User u WHERE u.mail ='"+mail+"'").uniqueResult().toString();
	       //una vez encontrado el id del user puedo buscarlo
	       id_user= Integer.parseInt(i);
	       user = (User) sesion.get(User.class, id_user); 
	     
	    } finally 
	    { 
	        sesion.close(); 
	    }  
	    return user; 
	}
	
	
	
	//eliminamos cliente
	
	public void delete_user(User user) throws HibernateException 
    { 
        try 
        { 
            iniciaOperacion(); 
            sesion.delete(user); //le pasamos todo el objeto a eliminar
            tx.commit(); 
        } catch (HibernateException he) 
        { 
            manejaExcepcion(he); 
            throw he; 
        } finally 
        { 
            sesion.close(); 
        } 
    }  

	//retorna toda la lista de usuarios
	
	public List<User> user_list() throws HibernateException 
	{ 
		List <User> Lista_usuarios = null;  
	    
	    try 
	    { 
	        iniciaOperacion(); //IMPORTANTE la query: se pide la clase realmnete Cliente! no la tabla que se ha creado
	        Lista_usuarios=  sesion.createQuery("FROM User").list(); //creamos consulta de la tabla clientes (en plural)!
	    }finally 
	    { 
	        sesion.close(); 
	    }  
	    return Lista_usuarios; 
	}
	
	
	/********************************CRUD COMPANY*******************/
	
	// Añade una nueva compañia  devolviendo el id de la tabla
	public long create_company(Company company)
	{ 
	    long id = 0; //id de la tabla company) 

	    try 
	    { 
	        iniciaOperacion(); 
	        sesion.persist(company); //metodo para guardar cliente (del objeto hibernate.sesion) 
	        
	        //sesion.persist(persona1);?
	        //sesion.persist(persona2);?
	        
	        tx.commit(); 
	    }catch(HibernateException he) 
	    { 
	        manejaExcepcion(he);
	        throw he; 
	    }finally 
	    { 
	        sesion.close(); 
	    }  
	    return id; 
	    
	  //actualizacion de company
	   /** public void update_company(Company company1) throws HibernateException 
		{ 
		    try 
		    { 
		        iniciaOperacion(); 
		        sesion.update(company1); //metodo update de objeto sesion
		        tx.commit();
		    }catch (HibernateException he) 
		    { 
		        manejaExcepcion(he); 
		        throw he; 
		    }finally 
		    { 
		        sesion.close(); 
		    } 
		}*/
	    
	  //eliminamos compañia
		
		public void del_company(Company company1) throws HibernateException 
	    { 
	        try 
	        { 
	            iniciaOperacion(); 
	            sesion.delete(company1); //le pasamos todo el objeto a eliminar
	            tx.commit(); 
	        } catch (HibernateException he) 
	        { 
	            manejaExcepcion(he); 
	            throw he; 
	        } finally 
	        { 
	            sesion.close(); 
	        } 
	    }  

	    
	
	    
	}

	

 

  
	
	
}