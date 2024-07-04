package br.com.ifpe.oxefood.modelo.fornecedor;
import java.time.LocalDate;
import org.hibernate.annotations.SQLRestriction;
import br.com.ifpe.oxefood.util.entity.EntidadeAuditavel;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Fornecedor")
@SQLRestriction("habilitado = true")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Fornecedor extends EntidadeAuditavel  {
  
  @Column
   private String nome;

   @Column
   private String endereco;

   @Column
   private LocalDate dataFundacao;

   @Column
   private Double valorMercado;

   @Column
   private String paginaWeb;

   @Column
   private String contatoVendedor;

}
