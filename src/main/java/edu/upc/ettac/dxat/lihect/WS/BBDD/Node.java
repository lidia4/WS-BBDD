package edu.upc.ettac.dxat.lihect.WS.BBDD;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;





@Entity
@Table(name="Nodes")

public class Node implements Serializable{
	
//la relación tiene que ser bidireccional para que el id de la compañia salga en la tabla de usuario	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id_node;
	
	private String node_name;
	private String MAC_address;
	private String port_number;
	
	@ManyToOne //relación bidireccional, muchos users pertenecen a una misma compañia
	private Company company;
  
	
	//constructor 
	public Node(String node_name, String MAC_address, String port_number){
    	
    	this.node_name = node_name;
    	this.MAC_address = MAC_address;
    	this.port_number = port_number;
     
    }
	
	//constructor sin argumentos, para recuperar las entidades de la BBDD 
    public Node()
    {
    }
   
	public String getNode_name() {
		return node_name;
	}

	public void setNode_name(String node_name) {
		this.node_name = node_name;
	}

	public String getMAC_address() {
		return MAC_address;
	}

	public void setMAC_address(String mAC_address) {
		MAC_address = mAC_address;
	}

	public String getPort_number() {
		return port_number;
	}

	public void setPort_number(String port_number) {
		this.port_number = port_number;
	}

	
    
     private void setId (long id_node)
    {
        this.id_node = id_node;
    }
     
     
   //se puede recuperar la compañia de un nodo
 	public Company getCompany()
     {
         return company;
     }

 	
     public void setCompany(Company company)
     {
         this.company = company;
     }
   
}
