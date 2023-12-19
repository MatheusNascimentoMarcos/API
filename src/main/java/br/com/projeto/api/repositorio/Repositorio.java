package br.com.projeto.api.repositorio;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import br.com.projeto.api.modelo.Pessoa;

@Repository
public interface Repositorio extends CrudRepository<Pessoa, Integer>{

    List<Pessoa> findAll();

    Pessoa findByCodigo (int codigo);

    List <Pessoa> findByIdade(int idade);

    List<Pessoa> findByNome(String nome);

    List<Pessoa> findByOrderByNome();

    List<Pessoa> findByOrderByIdadeDesc();
    
}
