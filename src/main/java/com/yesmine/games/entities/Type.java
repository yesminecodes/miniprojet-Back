package com.yesmine.games.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Type {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idType;
    private String nomType;
    private String descriptionType;

    @OneToMany(mappedBy = "type")
    @JsonIgnore // keep this to avoid infinite recursion
    private List<Game> games;


    public Long getIdType(){
        return idType;
    }
    public void setIdType(Long idType){
        this.idType = idType;
    }

    public String getNomType(){
        return nomType;
    }
    public void setNomType(String nomType){
        this.nomType = nomType;
    }

    public String getDescriptionType(){
        return descriptionType;
    }
    public void setDescriptionType(String descriptionType){
        this.descriptionType = descriptionType;
    }
}
