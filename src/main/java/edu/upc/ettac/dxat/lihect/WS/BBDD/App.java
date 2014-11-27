package edu.upc.ettac.dxat.lihect.WS.BBDD;

/*
 * Copyright [2014] [Lidia Ibern Ortega-Hector Ortiz Rua]*/


import java.util.List;

public class App 
{
    public static void main( String[] args )
    {

    	CRUD crud = new CRUD(); 
    	  
     Com
        //Creamos tes instancias de Contacto 
        User cliente1 = new User("luis.ortega@gmail.com", "gutie33", 1, "Luis","677899876", "Informatica"); 
        User cliente2 = new User("gemma.sanchez@gmail.com", "6taui",3,"Gema","676554323", "Logistica");
        User cliente3 = new User("javi.fernandez@gmail.com", "fresita",2, "Javi","633456728", "Almacen");

        //Guardamos las tres instancias, guardamos el id del contacto1 para usarlo posteriormente 
        crud.create_user(cliente1); 
        crud.create_user(cliente2);  
        crud.create_user(cliente3); 

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
    	
    }
}
