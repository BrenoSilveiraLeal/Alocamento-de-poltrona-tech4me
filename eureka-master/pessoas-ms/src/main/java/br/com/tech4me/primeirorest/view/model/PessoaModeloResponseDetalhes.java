package br.com.tech4me.primeirorest.view.model;

import java.util.List;

import br.com.tech4me.primeirorest.compartilhado.Poltrona;

public class PessoaModeloResponseDetalhes {
    private String id;
    private String nome;
    private String sobrenome;
    private List<Poltrona> poltrona;
    
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getSobrenome() {
        return sobrenome;
    }
    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }
    public List<Poltrona> getPoltrona() {
        return poltrona;
    }
    public void setPoltrona(List<Poltrona> poltrona) {
        this.poltrona = poltrona;
    }
    
    
    
}
