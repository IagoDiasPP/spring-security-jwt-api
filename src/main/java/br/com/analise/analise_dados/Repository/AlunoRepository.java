package br.com.analise.analise_dados.Repository;

import br.com.analise.analise_dados.Model.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AlunoRepository extends JpaRepository <Aluno, Integer>{

    Optional<Aluno> findByName(String name);

    Optional<Aluno> findByEmail(String email);

}
