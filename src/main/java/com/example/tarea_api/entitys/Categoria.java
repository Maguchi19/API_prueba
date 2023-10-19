package com.example.tarea_api.entitys;


import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;

@Entity
@Getter @Setter
@Table(name = "tb_categoria")
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idcat")
    private int idCat;

    @Column(name = "nomprecatego")
    private String nombreCat;

    @Column(name = "nivel")
    private int nivel;

    public int getNivel() {
        return nivel;
    }
    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    protected Categoria() {
    }

    public Categoria(String nombreCat, int nivel) {
        this.nombreCat = nombreCat;
        this.nivel = nivel;
    }


}
