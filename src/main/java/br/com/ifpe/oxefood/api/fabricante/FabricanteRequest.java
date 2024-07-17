package br.com.ifpe.oxefood.api.fabricante;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.ifpe.oxefood.modelo.fabricante.Fabricante;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FabricanteRequest {

   private String nome;

   private String endereco;

   private Double valorMercado;

   private String paginaWeb;

   private Integer qtdFuncionarios;
   
   @JsonFormat(pattern = "dd/MM/yyyy")
   private LocalDate inicioContrato;

   public Fabricante build() {

       return Fabricante.builder()
           .nome(nome)
           .endereco(endereco)
           .valorMercado(valorMercado)
           .paginaWeb(paginaWeb)
           .qtdFuncionarios(qtdFuncionarios)
           .inicioContrato(inicioContrato)
           .build();
   }

}
