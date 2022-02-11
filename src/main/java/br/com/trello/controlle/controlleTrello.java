package br.com.trello.controlle;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.trello.entity.Authentication;
import br.com.trello.services.TrelloServices;
import br.com.trello.vo.AuthenticationVO;
import br.com.trello.vo.BoardTrelloVO;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/webclient")
public class controlleTrello {
	
	@Autowired
	private TrelloServices services;
	

//
//	    @GetMapping("/character/{id}")
//	    @ResponseStatus(HttpStatus.OK)
//	    public Mono<Authentication> getCharacterById(@PathVariable String id) {
//	        return services.findACharacterById(id);
//
//	    }
//
//
//	    @GetMapping("/location/{id}")
//	    @ResponseStatus(HttpStatus.OK)
//	    public Mono<LocationResponse> getLocationById(@PathVariable String id) {
//	        return rickAndMortyClient.findALocationById(id);
//
//	    }
//
//
	    @GetMapping("/trello/{id}")
	    @ResponseStatus(HttpStatus.OK)
	    public Mono<BoardTrelloVO> findALocationById(@PathVariable String id) {
	        return services.findALocationById(id);

	    }


	    @GetMapping("/trello")
	    @ResponseStatus(HttpStatus.OK)
	    public Flux<AuthenticationVO> ListTrello()  throws IOException {   
	        return services.ListTrello();

	    }
	    
	 
	

}
