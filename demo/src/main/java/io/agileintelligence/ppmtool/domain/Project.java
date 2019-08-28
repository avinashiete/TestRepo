package io.agileintelligence.ppmtool.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;


@Entity
public class Project {

@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private Long id;
@NotBlank(message="Project Name is required")
private String projectName;
@NotBlank(message="Project Identifier is required")
@Size(min=4,max=7,message="Please use 4 to 5 character")
@Column(updatable=false,unique=true)
private String projectIdentifer;
@NotBlank(message="Project Description is required")
private String description;
@JsonFormat(shape = JsonFormat.Shape.STRING,pattern="dd-MM-yyyy")
private Date startDate;
@JsonFormat(shape = JsonFormat.Shape.STRING,pattern="dd-MM-yyyy")
private Date endDate;
@JsonFormat(shape = JsonFormat.Shape.STRING,pattern="dd-MM-yyyy")
private Date created_At;
@JsonFormat(shape = JsonFormat.Shape.STRING,pattern="dd-MM-yyyy")
private Date updated_At;



public Project() {
	super();
}



public Long getId() {
	return id;
}



public void setId(Long id) {
	this.id = id;
}



public String getProjectName() {
	return projectName;
}



public void setProjectName(String projectName) {
	this.projectName = projectName;
}



public String getProjectIdentifer() {
	return projectIdentifer;
}



public void setProjectIdentifer(String projectIdentifer) {
	this.projectIdentifer = projectIdentifer;
}



public String getDescription() {
	return description;
}



public void setDescription(String description) {
	this.description = description;
}



public Date getStartDate() {
	return startDate;
}



public void setStartDate(Date startDate) {
	this.startDate = startDate;
}



public Date getEndDate() {
	return endDate;
}



public void setEndDate(Date endDate) {
	this.endDate = endDate;
}



public Date getCreated_At() {
	return created_At;
}



public void setCreated_At(Date created_At) {
	this.created_At = created_At;
}



public Date getUpdated_At() {
	return updated_At;
}



public void setUpdated_At(Date updated_At) {
	this.updated_At = updated_At;
}



@PrePersist
protected void onCreate() {
	this.created_At=new Date();
}

@PreUpdate
protected void onUpdate() {
	this.updated_At=new Date();
}
}
