package br.com.trello.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "BoardTrello")
public class BoardTrello implements Serializable{
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name ="ID" )
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
