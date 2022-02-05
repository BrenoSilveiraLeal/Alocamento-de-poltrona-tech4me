package br.com.tech4me.Poltrona.view.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.tech4me.Poltrona.DataTransfer.PoltronaDto;
import br.com.tech4me.Poltrona.service.PoltronaService;
import br.com.tech4me.Poltrona.view.model.PoltronaModeloAlteracao;
import br.com.tech4me.Poltrona.view.model.PoltronaModeloInclusao;
import br.com.tech4me.Poltrona.view.model.PoltronaModeloResponse;


@RestController
@RequestMapping("/api/poltronas")
public class PoltronaController {
    @Autowired
    private PoltronaService service;
    
    @GetMapping(value = "/status")
    public String statusServico(@Value("${local.server.port}") String porta) {
        return String.format("Serviço já está em andamento na porta %s", porta);
    }

    @PostMapping
    public ResponseEntity<PoltronaModeloResponse> criarPoltrona(@RequestBody @Valid PoltronaModeloInclusao Poltrona) {
        ModelMapper mapper = new ModelMapper();
        PoltronaDto dto = mapper.map( Poltrona, PoltronaDto.class);
        dto = service.criarPoltrona(dto);
        return new ResponseEntity<>(mapper.map(dto, PoltronaModeloResponse.class), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<PoltronaModeloResponse>> obterTodos() {
        List<PoltronaDto> dtos = service.obterTodos();
        
        
        if(dtos.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        ModelMapper mapper = new ModelMapper();
        List<PoltronaModeloResponse> resp = dtos.stream()
                      .map(dto -> mapper.map(dto, PoltronaModeloResponse.class))
                      .collect(Collectors.toList());

        return new ResponseEntity<>(resp, HttpStatus.OK);               
    }

    @GetMapping(value ="/{id}")
    public ResponseEntity<PoltronaModeloResponse> obterPorId(@PathVariable String id) {
        Optional<PoltronaDto> Poltrona = service.obterPorId(id);

        if(Poltrona.isPresent()) {
          
            return new ResponseEntity<>(
                new ModelMapper().map(Poltrona.get(), PoltronaModeloResponse.class),
                HttpStatus.OK
            );
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    
    }


    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> removerPoltrona(@PathVariable String id) {
        service.removerPoltrona(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }
        
    @PutMapping(value = "/{id}")
    public ResponseEntity<PoltronaModeloResponse> atualizarPoltrona(@PathVariable String id,
        @Valid @RequestBody PoltronaModeloAlteracao Poltrona) {
        ModelMapper mapper = new  ModelMapper();
        PoltronaDto dto = mapper.map(Poltrona, PoltronaDto.class);
        dto = service.atualizarPoltrona(id, dto);
        
        return new ResponseEntity<>(mapper.map(dto, PoltronaModeloResponse.class), HttpStatus.OK);
    
    }

    @GetMapping(value ="/pessoas/{id}")
    public ResponseEntity<List<PoltronaModeloResponse>> obterPorIdDono(@PathVariable String id) {
        List<PoltronaDto> poltronaDto = service.obterPorIdDono(id);
        
        List<PoltronaModeloResponse> poltronaModeloResponse = poltronaDto.stream()
        .map(c -> new ModelMapper().map(c, PoltronaModeloResponse.class))
        .collect(Collectors.toList());
        
      
        return new ResponseEntity<>(poltronaModeloResponse, HttpStatus.OK);
    }



}
