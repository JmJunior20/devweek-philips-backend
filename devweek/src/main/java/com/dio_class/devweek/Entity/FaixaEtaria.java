package com.dio_class.devweek.Entity;
import javax.persistence.*;

@Entity
public class FaixaEtaria {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(nullable = false, updatable = false)
    private Long id;
    private Integer Faixa_i;
    private Integer Faixa_n;
    private String Descricao;

    public FaixaEtaria(Integer faixa_i, Integer faixa_n, String descricao) {
        this.Faixa_i = faixa_i;
        this.Faixa_n = faixa_n;
        this.Descricao = descricao;
    }

    public FaixaEtaria() {
    }

    public Long getId() {
        return id;
    }

    public Integer getFaixa_i() {
        return Faixa_i;
    }

    public void setFaixa_i(Integer faixa_i) {
        Faixa_i = faixa_i;
    }

    public Integer getFaixa_n() {
        return Faixa_n;
    }

    public void setFaixa_n(Integer faixa_n) {
        Faixa_n = faixa_n;
    }

    public String getDescricao() {
        return Descricao;
    }

    public void setDescricao(String descricao) {
        this.Descricao = descricao;
    }
}
