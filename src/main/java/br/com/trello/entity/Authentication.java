package br.com.trello.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.modelmapper.ModelMapper;


import br.com.trello.vo.AuthenticationVO;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
@Entity
@Table(name = "Authentication")
public class Authentication implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name ="ID" )	
	private String id;
	@Column(name ="name" )
	private String name;
;
public static Authentication create(AuthenticationVO authenticationVo) {
	
	return new ModelMapper().map(authenticationVo, Authentication.class);
}
	

}
