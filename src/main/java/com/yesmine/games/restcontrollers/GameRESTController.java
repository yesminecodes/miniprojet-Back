package com.yesmine.games.restcontrollers;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.yesmine.games.entities.Game;
import com.yesmine.games.service.GameService;
@RestController
@RequestMapping("/api")
@CrossOrigin
public class GameRESTController {
    @Autowired
    GameService gameService;
    //@RequestMapping(method = RequestMethod.GET)
    @GetMapping()
    public List<Game> getAllGames() {
        return gameService.getAllGames();
    }
    //@RequestMapping(value="/{id}",method = RequestMethod.GET)
    @GetMapping("/{id}")
    public Game getGameById(@PathVariable("id") Long id) {
        return gameService.getGame(id);
    }
    //@RequestMapping(method = RequestMethod.POST)
    @PostMapping()
    public Game createGame(@RequestBody Game game) {
        return gameService.saveGame(game);
    }
    @PutMapping("/{id}")
    public Game updateGame(@PathVariable("id") Long id, @RequestBody Game game) {
        game.setIdGame(id); // set the ID from the path
        return gameService.updateGame(game);
    }
    //@RequestMapping(value="/{id}",method = RequestMethod.DELETE)
    @DeleteMapping("/{id}")
    public void deleteGame(@PathVariable("id") Long id)
    {
        gameService.deleteGameById(id);
    }
    //@RequestMapping(value="/prodscat/{idType}",method = RequestMethod.GET)
    @GetMapping("/prodscat/{idType}")
    public List<Game> getGamesByTypeId(@PathVariable("idType") Long idType) {
        return gameService.findByTypeIdType(idType);
    }

}