package br.com.tech4me.primeirorest.compartilhado;

import java.util.List;

public class PessoaDto {
    private String id;
    private String nome;
    private String sobrenome;
    private List<Poltrona> poltrona;
    
    public List<Poltrona> getPoltrona() {
        return poltrona;
    }

    public void setPoltrona(List<Poltrona> poltrona) {
        this.poltrona = poltrona;
    }

    //#region Get / Set
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
    //#endregion
}
