package net.mycrud.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.mycrud.model.DataGeneral;

@Repository
public interface RepoDataGeneral extends JpaRepository<DataGeneral, Integer> {

}
