package br.com.tech4me.Poltrona.view.model;

import javax.validation.constraints.NotBlank;

public class PoltronaModeloInclusao {
    @NotBlank(message = "Fileira tem que ser preenchida!")
    private String fileira;
    private Integer numero;
    private String dono;
     
   
    public String getFileira() {
        return fileira;
    }
    public void setFileira(String fileira) {
        this.fileira = fileira;
    }
    public Integer getNumero() {
        return numero;
    }
    public void setNumero(Integer numero) {
        this.numero = numero;
    }
    public String getDono() {
        return dono;
    }
    public void setDono(String dono) {
        this.dono = dono;
    }
}
