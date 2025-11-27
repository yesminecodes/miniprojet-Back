package com.yesmine.games.service;

import com.yesmine.games.entities.Game;
import com.yesmine.games.entities.Type;

import java.util.List;

public interface GameService {
    Game saveGame(Game p);
    Game updateGame(Game p);
    void deleteGame(Game p);
    void deleteGameById(Long id);
    Game getGame(Long id);
    List<Game> getAllGames();
    List<Game> findByNomGame(String nom);
    List<Game> findByNomGameContains(String nom);
    List<Game> findByNomPrix (String nom, Double prix);
    List<Game> findByType (Type type);
    List<Game> findByTypeIdType(Long id);
    List<Game> findByOrderByNomGameAsc();
    List<Game> trierGamesNomsPrix();

}
