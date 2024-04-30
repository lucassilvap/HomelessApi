package com.apimoradoresderua.homeless.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.apimoradoresderua.homeless.entity.HomelessPersonEntity;

@Repository
public interface HomelessRepository extends CrudRepository<HomelessPersonEntity, Long>, JpaSpecificationExecutor<HomelessPersonEntity>{
	
	Optional<HomelessPersonEntity> findByNameIgnoreCase(String name);
	Optional<HomelessPersonEntity> findById(Long id);
}
