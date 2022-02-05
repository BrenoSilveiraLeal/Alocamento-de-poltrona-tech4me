package br.com.tech4me.Poltrona.service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.tech4me.Poltrona.DataTransfer.PoltronaDto;
import br.com.tech4me.Poltrona.model.Poltrona;
import br.com.tech4me.Poltrona.repository.PoltronaRepositorio;

@Service
public class PoltronaServiceImpl implements PoltronaService {
    @Autowired
    private PoltronaRepositorio repo;

    @Override
    public PoltronaDto criarPoltrona(PoltronaDto poltrona) {
        return salvarPoltrona(poltrona);
    }

    @Override
    public List<PoltronaDto> obterTodos() {
        List<Poltrona> poltronas = repo.findAll();

        return poltronas.stream()
            .map(poltrona -> new ModelMapper().map(poltrona, PoltronaDto.class))
            .collect(Collectors.toList());
    }

    @Override
    public Optional<PoltronaDto> obterPorId(String id) {
       Optional<Poltrona> poltrona = repo.findById(id);
       
       if(poltrona.isPresent()) {
           return Optional.of(new ModelMapper().map(poltrona.get(), PoltronaDto.class));
        }
       
           return Optional.empty();
    }


    @Override
    public void removerPoltrona(String id) {
        repo.deleteById(id);
    }

    @Override
    public PoltronaDto atualizarPoltrona(String id, PoltronaDto poltrona) {
        poltrona.setId(id);
        return salvarPoltrona(poltrona);
    }

    @Override
    public PoltronaDto salvarPoltrona(PoltronaDto poltrona) {
        ModelMapper mapper = new ModelMapper();
        Poltrona poltronaExistente = mapper.map(poltrona, Poltrona.class);
        poltronaExistente = repo.save(poltronaExistente);

        return mapper.map(poltronaExistente, PoltronaDto.class);
    }

    @Override
    public List<PoltronaDto> obterPorIdDono(String id) {
        List<Poltrona> poltronas = repo.findByDono(id);

        return poltronas.stream()
            .map(poltrona -> new ModelMapper().map(poltrona, PoltronaDto.class))
            .collect(Collectors.toList());
    }

    
}

