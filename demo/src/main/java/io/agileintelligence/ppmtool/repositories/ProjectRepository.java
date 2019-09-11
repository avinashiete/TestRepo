package io.agileintelligence.ppmtool.repositories;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import io.agileintelligence.ppmtool.domain.Project;
import java.lang.String;
import java.util.List;


@Repository
public interface ProjectRepository extends CrudRepository<Project, Long> {

	Iterable<Project> findAll();
	Project findByProjectIdentifer(String projectidentifer);
	
	

	

}
