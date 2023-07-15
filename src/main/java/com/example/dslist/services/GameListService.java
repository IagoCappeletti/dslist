package com.example.dslist.services;

import com.example.dslist.dto.GameListDTO;
import com.example.dslist.entities.GameList;
import com.example.dslist.projections.GameMinProjection;
import com.example.dslist.repositories.GameListRepository;
import com.example.dslist.repositories.GameRepository;
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

	//Fazendo a atualização das pisições da lista dos games no BD
	@Autowired
	private GameRepository gameRepository;

	@Transactional //
	public void move(Long listId, int sourceIndex, int destinationIndex) {
		List<GameMinProjection> list = gameRepository.searchByList(listId);

		GameMinProjection obj = list.remove(sourceIndex);
		list.add(destinationIndex, obj);

		int min = sourceIndex < destinationIndex ? sourceIndex : destinationIndex;
		int max = sourceIndex < destinationIndex ?  destinationIndex : sourceIndex;

		for (int i = min; i <= max; i++ ) {;
			gameListRepository.updateBelongingPosition(listId, list.get(i).getId(),i);
		}

	}

}
