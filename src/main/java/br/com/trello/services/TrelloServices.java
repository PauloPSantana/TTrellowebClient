package br.com.trello.services;

import static org.springframework.http.MediaType.APPLICATION_JSON;

import java.io.IOException;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;


import br.com.trello.conf.confTrello;
import br.com.trello.entity.Authentication;
import br.com.trello.repository.RepositoryTrello;
import br.com.trello.vo.AuthenticationVO;
import br.com.trello.vo.BoardTrelloVO;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;



@Service
public class TrelloServices implements confTrello{

	
	   private final WebClient webClient;
	   private final RepositoryTrello repositoryTrello;

	
	   
	   
	  public TrelloServices(WebClient.Builder builder, RepositoryTrello repositoryTrello) {
	        webClient = builder.baseUrl("https://api.trello.com/1/").build();
			this.repositoryTrello = repositoryTrello;

	  }
	    public Mono<BoardTrelloVO> findALocationById(String id) {
	   
	        return webClient
	                .get()
	                .uri("/boards/"+id+"?key="+confTrello.key+"&token="+confTrello.Token)
	                .accept(APPLICATION_JSON)
	                .retrieve()
	                .onStatus(HttpStatus::is4xxClientError,
	                        error -> Mono.error(new RuntimeException("verifique os parâmetros informados")))
	                .bodyToMono(BoardTrelloVO.class);
	    }

	  
    public Flux<AuthenticationVO> ListTrello() throws IOException {
    	Flux<AuthenticationVO> client =webClient
                .get()
                .uri("/members/me/boards/?key="+confTrello.key+"&token="+confTrello.Token)
                .accept(APPLICATION_JSON)
                .retrieve()
                .onStatus(HttpStatus::is4xxClientError,
                        error -> Mono.error(new RuntimeException("verifique os parâmetros informados")))
                .bodyToFlux(AuthenticationVO.class);
    	
    	List<AuthenticationVO> list1 = client.collectList().block();
    	for(AuthenticationVO obj: list1) {
    		AuthenticationVO DesvoRetorno = AuthenticationVO.create(repositoryTrello.save(Authentication.create(obj)));
    	}
    	
    	   return client;

    }
    
}
