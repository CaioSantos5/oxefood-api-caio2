package br.com.ifpe.oxefood.modelo.empresa;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ifpe.oxefood.modelo.empresa.Empresa;

public interface EmpresaRepository  extends JpaRepository<Empresa, Long> {
  
}
