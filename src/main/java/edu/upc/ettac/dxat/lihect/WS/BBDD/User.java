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
	private long id;
	private String role;
  
    
   
    //constructor sin argumentos, para recuperar las entidades de la BBDD 
    public User()
    {
    }
    
    //constructor
    public Cliente(String role){
    	
    	this.role = role;
  
    }
    
     private void setId(long id)
    {
        this.id = id;
    }

    

     
    
}
