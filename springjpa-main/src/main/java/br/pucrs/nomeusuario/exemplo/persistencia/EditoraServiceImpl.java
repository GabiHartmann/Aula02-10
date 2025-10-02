package br.pucrs.nomeusuario.exemplo.persistencia;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EditoraServiceImpl implements EditoraService {
    private final EditoraRepository editoraRepository;

    @Autowired
    public EditoraServiceImpl(EditoraRepository editoraRepository) {
        this.editoraRepository = editoraRepository;
    }

    @Override
    public List<Editora> consultarTodasEditoras() {
        return editoraRepository.findAll();
    }

    @Override
    public Optional<Editora> consultarEditoraPorCodigo(long codigo) {
        return editoraRepository.findById(codigo);
    }
}
