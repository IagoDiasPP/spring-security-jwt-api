package br.com.analise.analise_dados.Repository;

import br.com.analise.analise_dados.Model.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RolesRepository extends JpaRepository<RoleEntity, Integer> {

    Optional<RoleEntity> findByName(String name);
}
