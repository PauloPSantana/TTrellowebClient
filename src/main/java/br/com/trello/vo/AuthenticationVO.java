package br.com.trello.vo;



import org.modelmapper.ModelMapper;

import br.com.trello.entity.Authentication;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthenticationVO {

	private String id;
	private String name;

	public static AuthenticationVO create(Authentication authentication) {
		
		return new ModelMapper().map(authentication, AuthenticationVO.class);
	}
	
}
