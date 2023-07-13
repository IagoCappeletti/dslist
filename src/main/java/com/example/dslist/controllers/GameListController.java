package com.example.dslist.controllers;

import com.example.dslist.dto.GameListDTO;
import com.example.dslist.services.GameListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController //Confirgurando a classe para ser um controlador
@RequestMapping(value = "/lists") //Configurando o caminho que vai respondido pela minha API
public class GameListController {
	
	@Autowired
	private GameListService gameListService;

	@GetMapping
	public List<GameListDTO> findAll() {
		List<GameListDTO> result = gameListService.findAll();
		return gameListService.findAll();
	}
}
