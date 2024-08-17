package br.com.ifpe.oxefood.api.empresa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ifpe.oxefood.modelo.empresa.Empresa;
import br.com.ifpe.oxefood.modelo.empresa.EmpresaService;
import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/api/entregador")
@CrossOrigin

public class EmpresaController {

    @Autowired
    private EmpresaService empresaService;

        @Operation(
       summary = "Serviço responsável por salvar um entregador no sistema.",
       description = "Exemplo de descrição de um endpoint responsável por inserir um entregador no sistema."
       )

    @PostMapping
    public ResponseEntity<Empresa> save(@RequestBody EmpresaRequest request) {

        Empresa empresa = empresaService.save(request.build());
        return new ResponseEntity<Empresa>(empresa, HttpStatus.CREATED);
    }

    @Operation(
        summary = "Serviço responsável por listar os entregadores.",
        description = "Exemplo de descrição de um endpoint responsável por inserir um cliente no sistema."
        )

    @GetMapping
    public List<Empresa> listarTodos() {
        return empresaService.listarTodos();
    }

    @GetMapping("/{id}")
    public Empresa obterPorID(@PathVariable Long id) {
        return empresaService.obterPorID(id);
    }

    @Operation(
        summary = "Serviço responsável por alterar as informações dos entregadores."
        )

     @PutMapping("/{id}")
    public ResponseEntity<Empresa> update(@PathVariable("id") Long id, @RequestBody EmpresaRequest request) {

    empresaService.update(id, request.build());
       return ResponseEntity.ok().build();
 }

    
 @Operation(
    summary = "Serviço responsável por deletar os dados do entregador.",
    description = "Exemplo de descrição de um endpoint responsável por excluir um entregador."
    )

     @DeleteMapping("/{id}")
   public ResponseEntity<Void> delete(@PathVariable Long id) {

       empresaService.delete(id);
       return ResponseEntity.ok().build();
   }



}

