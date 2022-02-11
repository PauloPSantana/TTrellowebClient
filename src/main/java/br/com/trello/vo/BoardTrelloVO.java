package br.com.trello.vo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BoardTrelloVO {
	
	   private String id;
	    private String name;
	    private String  desc;
	    private String descData;
	    private Boolean closed;
	    private String  idOrganization;
	    private String idEnterprise;
	    private Boolean  pinned;
	    private String url;
	    private String shortUrl;

}
