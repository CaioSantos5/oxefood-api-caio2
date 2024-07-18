package br.com.ifpe.oxefood.api.categoriaproduto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.ifpe.oxefood.modelo.categoriaproduto.CategoriaProduto;
import br.com.ifpe.oxefood.api.categoriaproduto.CategoriaProdutoRequest;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CategoriaProdutoRequest {

   private String descricao;

   public CategoriaProduto build() {

       return CategoriaProduto.builder()
           .descricao(descricao)
           .build();
   }

}
