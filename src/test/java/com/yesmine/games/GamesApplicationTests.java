package com.yesmine.games;

import com.yesmine.games.entities.Game;
import com.yesmine.games.entities.Type;
import com.yesmine.games.repos.GameRepository;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

@SpringBootTest
class GamesApplicationTests {
    @Autowired
    private GameRepository gameRepository;
    @Test
    public void testCreateGame() {
        Game game = new Game("Valorant",0,new Date());
        gameRepository.save(game);
    }

    @Test
    public void testFindGame()
    {
        Game p = gameRepository.findById(3L).get();
        System.out.println(p);
    }

    @Test
    public void testUpdateGame()
    {
        Game p = gameRepository.findById(3L).get();
        p.setPrixGame(1000.0);
        gameRepository.save(p);
    }

    /*@Test
    public void testDeleteGame()
    {
        gameRepository.deleteById(2L);;
    }*/

    @Test
    public void testListerTousGames()
    {
        List<Game> games = gameRepository.findAll();
        for (Game p : games)
        {
            System.out.println(p);
        }
    }

    @Test
    public void testFindByNomGame() {
        List<Game> p =gameRepository.findByNomGame("Valorant");
        for (Game g : p)
            System.out.println(g);
    }

    @Test
    public void testFindByNomGameContains() {
        List<Game> p =gameRepository.findByNomGameContains("Val");
        for (Game g : p)
            System.out.println(g);
    }

    @Test
    public void testfindByNomPrix()
    {
        List<Game> game = gameRepository.findByNomPrix("Valorant", 10.0);
        for (Game p : game)
        {
            System.out.println(p);
        }
    }
    @Test
    public void testfindByType()
    {
        Type type = new Type();
        type.setIdType(1L);
        List<Game> games = gameRepository.findByType(type);
        for (Game p : games)
        {
            System.out.println(p);
        }
    }

    @Test
    public void findByTypeIdType()
    {
        List<Game> games = gameRepository.findByTypeIdType(1L);
        for (Game p : games)
        {
            System.out.println(p);
        }
    }

    @Test
    public void testfindByOrderByNomGameAsc() {
        List<Game> games = gameRepository.findByOrderByNomGameAsc();
        for (Game p : games)
        {
            System.out.println(p);
        }
    }

    @Test
    public void testTrierGamesNomsPrix()
    {
        List<Game> games = gameRepository.trierGamesNomsPrix();
        for (Game p : games)
        {
            System.out.println(p);
        }
    }


}
