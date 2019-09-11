package io.agileintelligence.ppmtool.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.agileintelligence.ppmtool.domain.Project;
import io.agileintelligence.ppmtool.exception.ProjectIdException;
import io.agileintelligence.ppmtool.repositories.ProjectRepository;

@Service
public class ProjectService {
	
	@Autowired
	private ProjectRepository projectRepository;
	
	public Project saveOrUpdateProject(Project project) {
		try {
			project.setProjectIdentifer(project.getProjectIdentifer().toUpperCase());
		return projectRepository.save(project);
	}catch(Exception e) {
		throw new ProjectIdException("Project Id'"+project.getProjectIdentifer().toUpperCase()+"' already Exist");
		
	}
	}
	
	public Project findByProjectIdentifer(String projectidentifer) {
		 Project project=projectRepository.findByProjectIdentifer(projectidentifer.toUpperCase());
		 if(project==null) {
			 throw new ProjectIdException("Project Id'"+projectidentifer.toUpperCase()+"' doesnt exist");
		 }
		 return project;
	}
	
	public Iterable<Project> findAllProjects() {
		return projectRepository.findAll();
		
	}
	
	public void deleteProjectByIdentifier(String projectidentifer) {
		 Project project=projectRepository.findByProjectIdentifer(projectidentifer.toUpperCase());
		 if(project==null) {
			 throw new ProjectIdException("Project Id'"+projectidentifer.toUpperCase()+"' doesnt exist");

		 }
			 
		 projectRepository.delete(project);
		 
		
	}

}
