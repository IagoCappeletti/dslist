package com.example.dslist.entities;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity //Configura a classe java para que ela seja equivalente a um tabale arelacional.
@Table(name = "tb_game") //Custumizando o nome da tabela do banco.
public class Game {

	@Id //Configurando o ID como chave primária.
	@GeneratedValue(strategy = GenerationType.IDENTITY)	//Seja auto incrementado pelo banco de dados
	private Long id;
	private String title;
	@Column(name  = "game_year") //Mudando o nome desse campo no banco, pois 'year' é palavra reservada em SQL.
	private Integer year;
	private String genre;
	private String platforms;
	private Double score;
	private String imgUrl;
	@Column(columnDefinition = "TEXT") 
	private String shortDescription;
	
	/*Se colocar apenas o 'String' o banco de dados entende que você quer colocar em um campo
	  de até 255 caracteres. Usando uma instrução para que a JPA, quando for gerar o banco gere esse campo 
	  sendo texto e não um campo de 255*/

	@Column(columnDefinition = "TEXT")
	private String longDescription;
	
	public Game() {
	}

	public Game(Long id, String title, Integer year, String genre, String platforms, Double score,String imgUrl,
			String shortDescription, String longDescription) {
		this.id = id;
		this.title = title;
		this.year = year;
		this.genre = genre;
		this.platforms = platforms;
		this.score = score;
		this.imgUrl = imgUrl;
		this.shortDescription = shortDescription;
		this.longDescription = longDescription;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getPlatform() {
		return platforms;
	}

	public void setPlatform(String platform) {
		this.platforms = platform;
	}
	

	public Double getScore() {
		return score;
	}

	public void setScore(Double score) {
		this.score = score;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public String getShortDescription() {
		return shortDescription;
	}

	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}

	public String getLongDescription() {
		return longDescription;
	}

	public void setLongDescription(String longDescription) {
		this.longDescription = longDescription;
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
		Game other = (Game) obj;
		return Objects.equals(id, other.id);
		
	}	
}
