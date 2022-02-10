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
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;



@Service
public class TrelloServices implements confTrello{

	
	   private final WebClient webClient;
	   private final RepositoryTrello repositoryTrello;

	
	   
	   
	  public TrelloServices(WebClient.Builder builder, RepositoryTrello repositoryTrello) {
	        webClient = builder.baseUrl("https://api.trello.com/1/members/me/boards?").build();
			this.repositoryTrello = repositoryTrello;

	  }


	  
    public Flux<AuthenticationVO> ListTrello() throws IOException {
    	Flux<AuthenticationVO> t =webClient
                .get()
                .uri("?key="+confTrello.key+"&token="+confTrello.Token)
                .accept(APPLICATION_JSON)
                .retrieve()
                .onStatus(HttpStatus::is4xxClientError,
                        error -> Mono.error(new RuntimeException("verifique os parâmetros informados")))
                .bodyToFlux(AuthenticationVO.class);
    	
    	List<AuthenticationVO> list1 = t.collectList().block();
    	for(AuthenticationVO obj: list1) {
    		System.out.println(obj.getName());
    		System.out.println(obj.getId());
    		AuthenticationVO DesvoRetorno = AuthenticationVO.create(repositoryTrello.save(Authentication.create(obj)));
    	}
    	
    	   return t;

        	

    }
    

 
}
