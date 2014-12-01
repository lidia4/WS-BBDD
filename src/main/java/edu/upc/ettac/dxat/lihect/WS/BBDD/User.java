package edu.upc.ettac.dxat.lihect.WS.BBDD;

import java.io.Serializable;

import javax.persistence.*;



@Entity
@Table(name="users")
public class User implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id_user;
	private int role;
	private String login;
	private String password;
	private String name;
	private String mail;
	private String phone;
	private String department;
	
	@ManyToOne //relación bidireccional, muchos users pertenecen a una misma compañia
	private Company company;
  
	//constructor 
	
    public User(String login, String password,int role, String name,String phone, String department){
    	
    	this.role = role;
    	this.login = login;
    	this.password =password;
    	this.name = name;
    	this.mail = login;
    	this.phone =phone;
    	this.department =department;
  
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
        this.id_user = id_user;
    }
	
	//se puede recuperar la compañia de un usuario
	public Company getCompany()
    {
        return company;
    }

	
    public void setCompany(Company company)
    {
        this.company = company;
    }
    
}
