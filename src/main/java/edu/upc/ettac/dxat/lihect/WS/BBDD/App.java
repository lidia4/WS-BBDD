package edu.upc.ettac.dxat.lihect.WS.BBDD;

/*
 * Copyright [2014] [Lidia Ibern Ortega-Hector Ortiz Rua]*/


import java.util.List;



public class App 
{
    public static void main( String[] args )
    {

    	CRUD crud = new CRUD(); 
    	
  
    /*************** PRIMERO CREAMOS LOS OBJETOS A AÑADIR A LA BBDD************/
    	//Creamos POJO Nodo 
        Node nodo1 = new Node("BCN-MANGO", "00:00:00:00:00:00:00:01", "24"); 
        Node nodo2 = new Node("Valencia-Rebook", "00:00:00:00:00:00:00:02", "32");
        Node nodo3 = new Node("Castellon-Rebook", "00:00:00:00:00:00:00:03", "13");

    	//Creamos POJO Contacto 
        User cliente1 = new User("luis.ortega@gmail.com", "gutie33", 1, "Luis","677899876", "Informatica"); 
        User cliente2 = new User("gemma.sanchez@gmail.com", "6taui",3,"Gema","676554323", "Logistica");
        User cliente3 = new User("javi.fernandez@gmail.com", "fresita",2, "Javi","633456728", "Almacen");
        
        //creamos POJO compañias
    	
    	Company comp1 = new Company("Mango", "C/Sebastia nº 3","Alfredo blasco");
    	Company comp2 = new Company("Rebook", "C/Andalucia nº 8", "Rafaela Guzman");
        
        //al POJO Compañia le añadimos el usuario y al usuario lo asociamos con su compañia
    	//de esta manera los usuarips endrán una referencia con la compañia
    	
    	comp1.addUsuario(cliente1);
    	cliente1.setCompany(comp1);
    	
    	comp2.addUsuario(cliente2);
    	cliente2.setCompany(comp2);
    	
    	// guardamos as compañias
    	
    	crud.create_company(comp1);
    	crud.create_company(comp2);
    	
    	
    	//una vez creada la compañia podemos añadir directamente users 
    	//haciendo un update company añadiendo el user
    	
    	comp2.addUsuario(cliente3);
    	cliente3.setCompany(comp2);
    	crud.update_company(comp2);
         
    	//añadimos nodos a la compañia ya creada: haciendo la relación bidireccional 
    	//y un update de la company
    	
    	comp1.addNodo(nodo1);
    	nodo1.setCompany(comp1);
    	crud.update_company(comp1);
    	
    	comp2.addNodo(nodo2);
    	nodo2.setCompany(comp2);
    	comp2.addNodo(nodo3);
    	nodo3.setCompany(comp2);
    	crud.update_company(comp2);
    	
    	
    
        //devolución de lista de usuarios de una compañia y lo muestro
    	
    	List<User> Lis_user_comp=comp2.getUsuarios();
        System.out.println("Hay " + Lis_user_comp.size() + "contactos en la base de datos:");  

        for(User c : Lis_user_comp) 
        { 
            System.out.println("-> " + c.getMail()); 
        } 
        
        
        //devolución de lista de nodos de una compañia y lo muestro
    	
    	List<Node> Lis_node_comp=comp2.getNodes();
        System.out.println("Hay " + Lis_node_comp.size() + "nodos de la compañia: " +comp2.getCompany_name());  

        for(Node c : Lis_node_comp) 
        { 
            System.out.println("-> " + c.getNode_name()); 
        } 
    	
        
        //devolución de lista del objeto compañia buscado por su nombre
        
        Company compx=crud.read_company("Mango");
        System.out.println("Compañia encpntrada, su dirección es: " + compx.getAddress()); 
        
        //Obtenemos la lista de compañias que hay en la bbdd
        
        List<Company> Lista_Comp = crud.company_list();
        System.out.println("Hay " + Lista_Comp.size() + "empresas en la base de datos:");  

        for(Company c : Lista_Comp) 
        { 
            System.out.println("-> " + c.getAddress()); 
        } 
        
        //buscamos el nombre del nodo por su MAC y puerto
        
       String nombre =crud.read_node(nodo1.getMAC_address(), nodo1.getPort_number());
       System.out.println("El nodo buscado es= "+nombre);
        
       //buscamos el nombre del nodo por su MAC y puerto y nos retorna el nodo para eliminarlo
       	crud.delete_node(crud.read_node2(nodo2.getMAC_address(), nodo2.getPort_number()));
        System.out.println("El nodo eliminado  es= "+nodo2.getNode_name());
       	
        //Modificamos el contacto 2 y lo actualizamos 
        cliente2.setPassword("lolita"); 
        crud.update_user(cliente2); 

        //Recuperamos el password de cliente3 de la base de datos buscando por mail
        User user1=crud.read_user("javi.fernandez@gmail.com");
        System.out.println("Cliente encontrado, su password es: " + user1.getPassword());  

        //Eliminamos un contacto buscando por mail -> el metodo read devuelve el objeto
        crud.delete_user(crud.read_user("luis.ortega@gmail.com"));
        

        //Obtenemos la lista de clientes que quedan en la base de datos y la mostramos 
        List<User> Lista_Users = crud.user_list();
        System.out.println("Hay " + Lista_Users.size() + "contactos en la base de datos:");  

        for(User c : Lista_Users) 
        { 
            System.out.println("-> " + c.getMail()); 
        }
   
        //delete comapny
        //1 delete nodo
        crud.delete_node(nodo1);
        //crud.delete_company(comp1);
    	
    }  
}
