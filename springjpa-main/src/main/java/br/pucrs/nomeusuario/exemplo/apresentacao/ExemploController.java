package br.pucrs.nomeusuario.exemplo.apresentacao;

import br.pucrs.nomeusuario.exemplo.persistencia.*;

import java.util.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/biblioteca")
public class ExemploController {
    private final IAcervoRepository acervo;
    private final EditoraService editoraService;

    @Autowired
    public ExemploController(IAcervoRepository acervo, EditoraService editoraService) {
        this.acervo = acervo;
        this.editoraService = editoraService;
    }

    @GetMapping("")
    public String getMensagemInicial() {
        return "Aplicacao Spring-Boot funcionando!";
    }

    // --- Endpoints para Editoras ---
    @GetMapping("/editoras")
    public List<Editora> getEditoras() {
        return editoraService.consultarTodasEditoras();
    }

    @GetMapping("/editora/{codigo}")
    public ResponseEntity<Editora> getEditoraPorCodigo(@PathVariable("codigo") long codigo) {
        return editoraService.consultarEditoraPorCodigo(codigo)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/livros")
    public List<Livro> getLivros() {
        return acervo.getLivros();
    }

    @GetMapping("/livroid/{id}")
    public Livro getLivroTitulo(@PathVariable("id") long id) {
        return acervo.getLivroId(id);
    }

}