package user.mgt.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Setter;
import lombok.Getter;


@Getter
@Setter
@Entity
@Table(name = "user_table")
public class User {
	
    @Id        
    private String user_id;
    
    @NotNull
    private String user_pw;

    private String user_email;
   
    private String address;
    
    private String address2;
    
    @NotNull
    private String status;

}
