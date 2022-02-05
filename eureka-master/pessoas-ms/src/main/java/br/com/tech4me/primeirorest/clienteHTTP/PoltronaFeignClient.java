package br.com.tech4me.primeirorest.clienteHTTP;

import java.util.ArrayList;
import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.tech4me.primeirorest.compartilhado.Poltrona;

@FeignClient(name= "poltronas-ms", fallback = PoltronaFeignClientFallback.class)
public interface PoltronaFeignClient {
    @GetMapping(path = "/api/poltrona/{dono}/lista")
    List<Poltrona> obterPoltrona(@PathVariable String dono);   
}

@Component
class PoltronaFeignClientFallback implements PoltronaFeignClient {

    @Override
    public List<Poltrona> obterPoltrona(String dono) {
        return new ArrayList<>();
    }

}
