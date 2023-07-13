package com.example.dslist.entities;

import jakarta.persistence.*;

import java.util.Objects;

@Entity //Configura a classe java para que ela seja equivalente a um tabale arelacional.
@Table(name = "tb_game_list") //Custumizando o nome da tabela do banco.
public class GameList {

	@Id //Configurando o ID como chave primária.
	@GeneratedValue(strategy = GenerationType.IDENTITY)	//Seja auto incrementado pelo banco de dados
	private Long id;
	private String name;
	
	public GameList() {}

	public GameList(Long id, String name) {
		this.id = id;
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GameList other = (GameList) obj;
		return Objects.equals(id, other.id);
	}
		
}
