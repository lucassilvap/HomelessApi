package com.apimoradoresderua.homeless.repository;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.apimoradoresderua.homeless.entity.ParentsTelephone;

@Repository
public interface ParentesTelephoneRepository extends CrudRepository<ParentsTelephone, Long>, 
JpaSpecificationExecutor<ParentsTelephone>{
	
	Optional<ParentsTelephone> findByid(Long id);
}
