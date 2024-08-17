package br.com.ifpe.oxefood.modelo.empresa;

import jakarta.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmpresaService {

    @Autowired
    private EmpresaRepository repository;

    @Transactional
    public Empresa save(Empresa empresa) {

        empresa.setHabilitado(Boolean.TRUE);
        empresa.setVersao(1L);
        empresa.setDataCriacao(LocalDate.now());
        return repository.save(empresa);
    }

    public List<Empresa> listarTodos() {

        return repository.findAll();
    }

    public Empresa obterPorID(Long id) {

        return repository.findById(id).get();
    }

    @Transactional
    public void update(Long id, Empresa empresaAlterado) {

        Empresa empresa = repository.findById(id).get();
        empresa.setSite(empresaAlterado.getSite());
        empresa.setCpf(empresaAlterado.getCpf());
        empresa.setRg(empresaAlterado.getRg());
        empresa.setDataNascimento(empresaAlterado.getDataNascimento());
        empresa.setFoneCelular(empresaAlterado.getFoneCelular());
        empresa.setFoneFixo(empresaAlterado.getFoneFixo());
        empresa.setQtdEntregasRealizadas(empresaAlterado.getQtdEntregasRealizadas());
        empresa.setValorFrete(empresaAlterado.getValorFrete());
        empresa.setEnderecoComplemento(empresaAlterado.getEnderecoComplemento());
        empresa.setAtivo(empresaAlterado.getAtivo());

        entregador.setVersao(entregador.getVersao() + 1);
        repository.save(entregador);
    }

    @Transactional
    public void delete(Long id) {

        Entregador entregador = repository.findById(id).get();
        entregador.setHabilitado(Boolean.FALSE);
        entregador.setVersao(entregador.getVersao() + 1);

        repository.save(entregador);
    }

}
