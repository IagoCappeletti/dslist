package com.example.dslist.entities;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.util.Objects;

@Entity //Configura a classe java para que ela seja equivalente a um tabale arelacional.
@Table(name = "tb_belonging") //Custumizando o nome da tabela do banco.
public class Belonging {

	@EmbeddedId
	private BelongingPK id = new BelongingPK();
	private Integer position;
	
	public Belonging() {
	}

	public Belonging(Game game, GameList list, Integer position) {
		this.id.setGame(game);
		id.setList(list);
		this.position = position;
	}

	public BelongingPK getId() {
		return id;
	}

	public void setId(BelongingPK id) {
		this.id = id;
	}

	public Integer getPosition() {
		return position;
	}

	public void setPosition(Integer position) {
		this.position = position;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Belonging belonging)) return false;
		return Objects.equals(getId(), belonging.getId());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getId());
	}
}
