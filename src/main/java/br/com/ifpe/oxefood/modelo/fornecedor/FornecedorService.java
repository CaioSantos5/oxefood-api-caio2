package br.com.ifpe.oxefood.modelo.fornecedor;
import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;

@Service
public class FornecedorService {

   @Autowired
   private FornecedorRepository repository;

   @Transactional
   public Fornecedor save(Fornecedor fornecedor) {

       fornecedor.setHabilitado(Boolean.TRUE);
       fornecedor.setVersao(1L);
       fornecedor.setDataCriacao(LocalDate.now());
       return repository.save(fornecedor);
   }

   public List<Fornecedor> listarTodos() {
  
    return repository.findAll();
    }

    public Fornecedor obterPorID(Long id) {

    return repository.findById(id).get();
    }

    @Transactional
    public void update(Long id, Fornecedor fornecedorAlterado) {
 
        Fornecedor fornecedor = repository.findById(id).get();
        fornecedor.setNome(fornecedorAlterado.getNome());
        fornecedor.setEndereco(fornecedorAlterado.getEndereco());
        fornecedor.setDataFundacao(fornecedorAlterado.getDataFundacao());
        fornecedor.setValorMercado(fornecedorAlterado.getValorMercado());
        fornecedor.setPaginaWeb(fornecedorAlterado.getPaginaWeb());
        fornecedor.setContatoVendedor(fornecedorAlterado.getContatoVendedor());
         
       fornecedor.setVersao(fornecedor.getVersao() + 1);
       repository.save(fornecedor);
   }

   @Transactional
   public void delete(Long id) {

    Fornecedor fornecedor = repository.findById(id).get();
    fornecedor.setHabilitado(Boolean.FALSE);
    fornecedor.setVersao(fornecedor.getVersao() + 1);

       repository.save(fornecedor);
   }

 
}
