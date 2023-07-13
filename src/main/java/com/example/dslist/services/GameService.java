package com.example.dslist.services;

import java.util.List;

import com.example.dslist.dto.GameDTO;
import com.example.dslist.projections.GameMinProjection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dslist.dto.GameMinDTO;
import com.example.dslist.entities.Game;
import com.example.dslist.repositories.GameRepository;
import org.springframework.transaction.annotation.Transactional;

@Service //Registrando o 'GameService' componente no sistema.
public class GameService {
	
	@Autowired //Injetando uma instância do "GameRepository" no "GameService".
	private GameRepository gameRepository;

	@Transactional(readOnly = true)
	public GameDTO findById(Long id) {
		Game result = gameRepository.findById(id).get();
		return new GameDTO(result);
	}

	/*Chama o gameRepository.findAll que busca t0do mundo do
	banco de dados e devolve um lista de Obj e converti cada Obj para o GameMinDTO.*/
	@Transactional(readOnly = true)
	public List<GameMinDTO> findAll(){
		List<Game> result = gameRepository.findAll();
		return result.stream().map(x -> new GameMinDTO(x)).toList();
	}

	/*Pegando a lista projection, convertendo com a função map para uma list de GameMinDTO*/
	@Transactional(readOnly = true)
	public List<GameMinDTO> findByList(Long listID){
		List<GameMinProjection> result = gameRepository.searchByList(listID);
		return result.stream().map(x -> new GameMinDTO(x)).toList();
	}
}
