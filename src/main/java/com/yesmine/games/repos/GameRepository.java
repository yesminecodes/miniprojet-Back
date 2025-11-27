package com.yesmine.games.repos;

import com.yesmine.games.entities.Game;
import com.yesmine.games.entities.Type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(path="rest")
public interface GameRepository extends JpaRepository<Game,Long> {
    List<Game> findByNomGame (String nomGame);
    List<Game> findByNomGameContains(String nomGame);

    @Query("select p from Game p where p.nomGame like %:nom and p.prixGame > :prix")
    List<Game> findByNomPrix (@Param("nom") String nom, @Param("prix") Double prix);

    @Query("select p from Game p where p.type = ?1")
    List<Game> findByType (Type type);

    List<Game> findByTypeIdType(Long id);

    List<Game> findByOrderByNomGameAsc();

    @Query("select p from Game p order by p.nomGame ASC, p.prixGame DESC")
    List<Game> trierGamesNomsPrix ();
}
