package br.pucrs.nomeusuario.exemplo.persistencia;

import java.util.List;
import java.util.Optional;

public interface EditoraService {
    List<Editora> consultarTodasEditoras();
    Optional<Editora> consultarEditoraPorCodigo(long codigo);
}
