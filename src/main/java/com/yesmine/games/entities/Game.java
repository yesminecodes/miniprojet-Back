package com.yesmine.games.entities;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idGame;
    private String nomGame;
    private double prixGame;
    private Date dateCreation;

    @ManyToOne
    @JoinColumn(name="type_id_type")
    private Type type;
    public Game(){
        super();
    }

    public Game(String nomGame, double prixGame, Date dateCreation) {
        this.nomGame = nomGame;
        this.prixGame = prixGame;
        this.dateCreation = dateCreation;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Long getIdGame() {
        return idGame;
    }
    public void setIdGame(Long idGame) {
        this.idGame = idGame;
    }

    public String getNomGame() {
        return nomGame;
    }
    public void setNomGame(String nomGame) {
        this.nomGame = nomGame;
    }

    public double getPrixGame() {
        return prixGame;
    }
    public void setPrixGame(double prixGame) {
        this.prixGame = prixGame;
    }

    public Date getDateCreation() {
        return dateCreation;
    }
    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    public String toString(){
        return "Game [idGame="+idGame+", nomGame="+nomGame+", prixGame="+prixGame+", dateCreation= "+dateCreation+"]";
    }
}