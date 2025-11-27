package com.yesmine.games.service;

import com.yesmine.games.entities.Game;
import com.yesmine.games.entities.Type;
import com.yesmine.games.repos.GameRepository;
import com.yesmine.games.repos.TypeRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GameServiceImpl implements GameService {

    @Autowired
    private GameRepository gameRepository;

    @Autowired
    private TypeRepository typeRepository;

    @Override
    public Game saveGame(Game game) {
        // Ensure type is managed before saving
        if (game.getType() != null && game.getType().getIdType() != null) {
            Type managedType = typeRepository.findById(game.getType().getIdType())
                    .orElseThrow(() -> new RuntimeException("Type not found"));
            game.setType(managedType);
        }
        return gameRepository.save(game);
    }

    @Override
    public Game updateGame(Game game) {
        // Fetch existing game to ensure it exists
        Game existingGame = gameRepository.findById(game.getIdGame())
                .orElseThrow(() -> new RuntimeException("Game not found"));

        // Update fields
        existingGame.setNomGame(game.getNomGame());
        existingGame.setPrixGame(game.getPrixGame());
        existingGame.setDateCreation(game.getDateCreation());

        // Update type if provided
        if (game.getType() != null && game.getType().getIdType() != null) {
            Type managedType = typeRepository.findById(game.getType().getIdType())
                    .orElseThrow(() -> new RuntimeException("Type not found"));
            existingGame.setType(managedType);
        } else {
            existingGame.setType(null); // clear type if null
        }

        return gameRepository.save(existingGame);
    }

    @Override
    public void deleteGame(Game game) {
        gameRepository.delete(game);
    }

    @Override
    public void deleteGameById(Long id) {
        gameRepository.deleteById(id);
    }

    @Override
    public Game getGame(Long id) {
        return gameRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Game not found"));
    }

    @Override
    public List<Game> getAllGames() {
        return gameRepository.findAll();
    }

    @Override
    public List<Game> findByNomGame(String nom) {
        return gameRepository.findByNomGame(nom);
    }

    @Override
    public List<Game> findByNomGameContains(String nom) {
        return gameRepository.findByNomGameContains(nom);
    }

    @Override
    public List<Game> findByNomPrix(String nom, Double prix) {
        return gameRepository.findByNomPrix(nom, prix);
    }

    @Override
    public List<Game> findByType(Type type) {
        return gameRepository.findByType(type);
    }

    @Override
    public List<Game> findByTypeIdType(Long id) {
        return gameRepository.findByTypeIdType(id);
    }

    @Override
    public List<Game> findByOrderByNomGameAsc() {
        return gameRepository.findByOrderByNomGameAsc();
    }

    @Override
    public List<Game> trierGamesNomsPrix() {
        return gameRepository.trierGamesNomsPrix();
    }
}
