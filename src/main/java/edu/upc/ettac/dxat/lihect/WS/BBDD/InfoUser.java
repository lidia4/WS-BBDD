package edu.upc.ettac.dxat.lihect.WS.BBDD;

import java.io.Serializable;
import javax.persistence.*;



@Entity
@Table(name="infousers")
public class InfoUser implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	private String name;
	private String mail;
	private String phone;
	private String department;
  
	@OneToOne(cascade={CascadeType.PERSIST, CascadeType.REMOVE}) 
	//cascada hace que si se elimina de una fila se elimine de la otra table
	//si se añade se añade en ambas
	//queremos que se ralizen las acciones en cascada de guardar y eliminar
    
	private User User; 
	
	
	//constructor no se necesita, todo estará relacionado
	/*
    public InfoUser(String name, String mail, String phone,String department){
    	
    	this.name = name;
    	this.mail = mail;
    	this.phone =phone;
    	this.department =department;
  
    }*/
    
    public User getUser() 
    { 
        return User; 
    }  

    public void setUser(User User) 
    { 
        this.User = User; 
    }  
    //constructor sin argumentos, para recuperar las entidades de la BBDD 
    public InfoUser()
    {
    }
   
     public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	private void setId(long id_user)
    {
        this.id = id_user;
    }   
    
}
