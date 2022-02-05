package br.com.tech4me.Poltrona.service;

import java.util.List;
import br.com.tech4me.Poltrona.DataTransfer.PoltronaDto;

public interface PoltronaService {
    PoltronaDto criarPoltrona(PoltronaDto poltrona);
    List<PoltronaDto> obterTodos();
    java.util.Optional<PoltronaDto> obterPorId(String id);
    void removerPoltrona(String id);
    PoltronaDto atualizarPoltrona(String id, PoltronaDto poltrona);
    PoltronaDto salvarPoltrona(PoltronaDto poltrona);
    List<PoltronaDto> obterPorIdDono(String id);
}
