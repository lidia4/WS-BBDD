package edu.upc.ettac.dxat.lihect.WS.BBDD;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import org.hibernate.annotations.IndexColumn;


@Entity
@Table(name="Companies")

public class Company implements Serializable{
	
//la relación tiene que ser bidireccional para que el id de la compañia salga en la tabla de usuario	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id_company;
	
	private String company_name;
	private String address;
	
	/** tendre un listado de usuarios relacionado a la compañia, le indico que id le estoy compartiendo
	modo de recuperazión de datos lazy, los recupera cuando son necesarios, de esta manera no sobre
	cargamos el sistema**/
	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY,mappedBy="company_id")
	private List<User> usuarios = new ArrayList<User>();
	
	//constructor **** faltan más atributos
	public Company(String company_name, String address){
    	
    	this.company_name = company_name;
    	this.address = address;
     
    }
   
    //constructor sin argumentos, para recuperar las entidades de la BBDD 
    public Company()
    {
    }
       
     private void setId (long id_company)
    {
        this.id_company = id_company;
    }
     
     public String getCompany_name() {
 		return company_name;
 	}

 	public void setCompany_name(String company_name) {
 		this.company_name = company_name;
 	}

 	public String getAddress() {
 		return address;
 	}

 	public void setAddress(String address) {
 		this.address = address;
 	}

 	public List<User> getUsuarios() {
 		return usuarios;
 	}

 	public void setUsuarios(List<User> usuarios) {
 		this.usuarios = usuarios;
 	}

 	//para añadir un usuario que pertenece a una compañia
 	public void addUsuario(User usuario)
 	    {
 	        this.usuarios.add(usuario);
 	    }
    
}
