package com.example.dslist.entities;

import java.util.Objects;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable //Encapsulando dois atributos em uma classe
public class BelongingPK {

	@ManyToOne //Muitos para um
	@JoinColumn(name = "game_id") //Configurando o nome da chave estrangeira
	private Game game;
	
	@ManyToOne //Muitos para um
	@JoinColumn(name = "list_id") //Configurando o nome da chave estrangeira
	private GameList List;
	
	public BelongingPK() {}

	public BelongingPK(Game game, GameList list) {
		this.game = game;
		List = list;
	}
	
	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	public GameList getList() {
		return List;
	}

	public void setList(GameList list) {
		List = list;
	}

	@Override
	public int hashCode() {
		return Objects.hash(List, game);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BelongingPK other = (BelongingPK) obj;
		return Objects.equals(List, other.List) && Objects.equals(game, other.game);
	}

}
