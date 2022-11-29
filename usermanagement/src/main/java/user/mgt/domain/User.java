package user.mgt.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Setter;
import user.mgt.dto.Role;
import lombok.Getter;


@Getter
@Setter
@Entity
@Table(name = "user_table")
public class User {
	
    @Id        
    private String email;   
    @NotNull
    private String pw;
       
    private String address;
    
    private String address2;
            
    private String status;
    
    @Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private Role role;

}
