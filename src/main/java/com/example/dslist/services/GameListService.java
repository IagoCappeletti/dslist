package com.example.dslist.services;

import com.example.dslist.dto.GameListDTO;
import com.example.dslist.dto.GameMinDTO;
import com.example.dslist.entities.Game;
import com.example.dslist.entities.GameList;
import com.example.dslist.repositories.GameListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service //Registrando o 'GameService' componente no sistema.
public class GameListService {
	
	@Autowired //Injetando uma instância do "GameRepository" no "GameService".
	private GameListRepository gameListRepository;

	@Transactional(readOnly = true)
	public List<GameListDTO> findAll(){
		List<GameList> result = gameListRepository.findAll(); //Chama o gameRepository.findAll que busca t0do mundo do
		// banco de dados e devolve um lista de Obj e converti cada Obj para o GameMinDTO.
		return result.stream().map(x -> new GameListDTO(x)).toList();
	}
}
