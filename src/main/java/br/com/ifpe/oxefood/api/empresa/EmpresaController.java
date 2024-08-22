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

import br.com.ifpe.oxefood.modelo.acesso.Usuario;
import br.com.ifpe.oxefood.modelo.acesso.UsuarioService;
import br.com.ifpe.oxefood.modelo.empresa.Empresa;
import br.com.ifpe.oxefood.modelo.empresa.EmpresaService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;

@RestController
@RequestMapping("api/empresa")
@CrossOrigin
public class EmpresaController {

    @Autowired
    private EmpresaService empresaService;

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<Empresa> save(@RequestBody @Valid EmpresaRequest empresaRequest, HttpServletRequest request) {

        Empresa empresa = empresaRequest.build();

        if (empresaRequest.getPerfil() != null && !"".equals(empresaRequest.getPerfil())) {
            if (empresaRequest.getPerfil().equals("EMPRESA_USER")) {
                empresa.getUsuario().getRoles().add(Usuario.ROLE_EMPRESA_USER);
            } else if (empresaRequest.getPerfil().equals("EMPRESA_ADMIN")) {
                empresa.getUsuario().getRoles().add(Usuario.ROLE_EMPRESA_ADMIN);
            }
        }

        Empresa empresaCriada = empresaService.save(empresa, usuarioService.obterUsuarioLogado(request));
        return new ResponseEntity<Empresa>(empresaCriada, HttpStatus.CREATED);
    }

    @GetMapping
    public List<Empresa> listarTodos() {
        return empresaService.listarTodos();
    }

    @GetMapping("/{id}")
    public Empresa obterPorId(@PathVariable Long id) {
        return empresaService.obterPorId(id);
    }

    @PutMapping
    public ResponseEntity<Empresa> update(@PathVariable("id") Long id, @RequestBody EmpresaRequest empresaRequest,
            HttpServletRequest request) {

        empresaService.update(id, empresaRequest.build(), usuarioService.obterUsuarioLogado(request));
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        empresaService.delete(id);
        return ResponseEntity.ok().build();
    }

}