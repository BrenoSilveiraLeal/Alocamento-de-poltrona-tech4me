package br.com.tech4me.primeirorest.compartilhado;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import org.springframework.data.annotation.Id;

public class Poltrona {
    @Id
    private String id;
    private String dono;
    private String fileira;
    private Integer numero;
    @JsonFormat(pattern="yyyy-MM-dd hh:mm")
    private LocalDateTime reserva;
    
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getDono() {
        return dono;
    }
    public void setDono(String dono) {
        this.dono = dono;
    }
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
    public LocalDateTime getReserva() {
        return reserva;
    }
    public void setReserva(LocalDateTime reserva) {
        this.reserva = reserva;
    } 

}