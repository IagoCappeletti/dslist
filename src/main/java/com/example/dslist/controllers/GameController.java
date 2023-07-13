package com.example.dslist.controllers;

import java.util.List;

import com.example.dslist.dto.GameDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dslist.dto.GameMinDTO;
import com.example.dslist.services.GameService;

@RestController //Confirgurando a classe para ser um controlador
@RequestMapping(value = "/games") //Configurando o caminho que vai respondido pela minha API
public class GameController {
	
	@Autowired
	private GameService gameService;

	@GetMapping(value = "/{id}")
	public GameDTO findById(@PathVariable Long id) {
		return gameService.findById(id);
	}

	@GetMapping
	public List<GameMinDTO> findAll() {
		return gameService.findAll();
	}
}
