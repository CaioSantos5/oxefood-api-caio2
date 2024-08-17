package br.com.ifpe.oxefood.api.empresa;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.ifpe.oxefood.modelo.acesso.Usuario;
import br.com.ifpe.oxefood.modelo.empresa.Empresa;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmpresaRequest {

   private String site;

   private String cnpj;
  
   private String inscricaoEstadual;
   
   private String nomeEmpresarial;
 
   private String nomeFantasia;
   
   private String fone;

   private String foneAlternativo;

   public Empresa build() {

       return Empresa.builder()
           .site(site)
           .cnpj(cnpj)
           .inscricaoEstadual(inscricaoEstadual)
           .nomeEmpresarial(nomeEmpresarial)
           .nomeFantasia(nomeFantasia)
           .fone(fone)
           .foneAlternativo(foneAlternativo)

           .build();
   }

}

