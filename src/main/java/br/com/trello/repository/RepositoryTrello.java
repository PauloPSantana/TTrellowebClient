package br.com.trello.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.trello.entity.Authentication;


public interface RepositoryTrello extends JpaRepository< Authentication, String> {

}
