package edu.upc.ettac.dxat.lihect.WS.BBDD;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="users")
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id_user;
	private int role;
	private String mail;
	private String password;
	//private id_company;
  
	//constructor
    public User(String mail, String password,int role){
    	
    	this.role = role;
    	this.mail = mail;
    	this.password =password;
  
    }
   
    //constructor sin argumentos, para recuperar las entidades de la BBDD 
    public User()
    {
    }
    
    public int getRole() {
		return role;
	}

	public void setRole(int role) {
		this.role = role;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

    
     private void setId(long id_user)
    {
        this.id_user = id_user;
    }
 	public long getId_user() {
		return id_user;
	}


    

     
    
}
