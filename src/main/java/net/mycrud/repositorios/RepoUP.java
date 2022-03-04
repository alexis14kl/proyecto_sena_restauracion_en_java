package net.mycrud.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.mycrud.model.UserProfile;

@Repository
public interface RepoUP extends JpaRepository<UserProfile, Integer> {

}
