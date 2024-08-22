package br.com.ifpe.oxefood.modelo.empresa;

import jakarta.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ifpe.oxefood.modelo.acesso.Usuario;
import br.com.ifpe.oxefood.modelo.acesso.UsuarioService;

@Service
public class EmpresaService {

    @Autowired
    private EmpresaRepository repository;

    @Autowired
    private UsuarioService usuarioService;

    @Transactional
    public Empresa save(Empresa empresa, Usuario usuarioLogado) {

        usuarioService.save(empresa.getUsuario());

        empresa.setHabilitado(Boolean.TRUE);
        empresa.setVersao(1L);
        empresa.setDataCriacao(LocalDate.now());
        empresa.setCriadoPor(usuarioLogado);

        return repository.save(empresa);

    }

    public List<Empresa> listarTodos() {

        return repository.findAll();
    }

    public Empresa obterPorId(Long id) {

        return repository.findById(id).get();
    }

    @Transactional
    public void update(Long id, Empresa empresaAlterada, Usuario usuarioLogado) {
        Empresa empresa = repository.findById(id).get();
        empresa.setCnpj(empresaAlterada.getCnpj());
        empresa.setSite(empresaAlterada.getSite());
        empresa.setInscricaoEstadual(empresaAlterada.getInscricaoEstadual());
        empresa.setNomeEmpresarial(empresaAlterada.getNomeEmpresarial());
        empresa.setNomeFantasia(empresaAlterada.getNomeFantasia());
        empresa.setFone(empresaAlterada.getFone());
        empresa.setFoneAlternativo(empresaAlterada.getFoneAlternativo());

        empresa.setVersao(empresa.getVersao() + 1);
        empresa.setDataUltimaModificacao(LocalDate.now());
        empresa.setUltimaModificacaoPor(usuarioLogado);

        repository.save(empresa);
    }

    @Transactional
    public void delete(Long id) {
        Empresa empresa = repository.findById(id).get();
        empresa.setHabilitado(Boolean.FALSE);
        empresa.setVersao(empresa.getVersao() + 1);

        repository.save(empresa);
    }

}
