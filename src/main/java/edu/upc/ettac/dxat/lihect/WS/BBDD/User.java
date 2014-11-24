package edu.upc.ettac.dxat.lihect.WS.BBDD;

import java.io.Serializable;

import javax.persistence.*;



@Entity
@Table(name="users")
public class User implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	private int role;
	private String login;
	private String password;
	//private id_company;
  
	//constructor no se necesita ya que todo estará relacionado
	/*
    public User(String mail, String password,int role){
    	
    	this.role = role;
    	this.mail = mail;
    	this.password =password;
  
    }
   */
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

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

    
     private void setId(long id_user)
    {
        this.id = id_user;
    }
 	public long getId_user() {
		return id;
	}


    

     
    
}
