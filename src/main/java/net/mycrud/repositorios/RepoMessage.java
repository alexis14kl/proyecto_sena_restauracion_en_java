package net.mycrud.repositorios;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import net.mycrud.model.Message;
@Repository
public interface RepoMessage extends JpaRepository<Message, Integer> {

	@Query(value="SELECT * FROM messages m where m.destinario =:id " , nativeQuery = true)
	List<Message>seachMessages(String id);
}
