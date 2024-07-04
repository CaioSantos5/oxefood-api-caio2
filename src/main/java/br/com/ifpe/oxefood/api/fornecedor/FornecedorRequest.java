package br.com.ifpe.oxefood.api.fornecedor;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.ifpe.oxefood.modelo.fornecedor.Fornecedor;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FornecedorRequest {

   private String nome;

   private String endereco;

   @JsonFormat(pattern = "dd/MM/yyyy")
   private LocalDate dataFundacao;

   private Double valorMercado;

   private String paginaWeb;

   private String contatoVendedor;

   public Fornecedor build() {

       return Fornecedor.builder()
           .nome(nome)
           .endereco(endereco)
           .dataFundacao(dataFundacao)
           .valorMercado(valorMercado)
           .paginaWeb(paginaWeb)
           .contatoVendedor(contatoVendedor)
           .build();
   }

}