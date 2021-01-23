package com.example.legal.entity;

import java.util.List;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity
@Table(name = "service")
@Data
@ToString(exclude = "service")
@EqualsAndHashCode(exclude = "service")
@DynamicUpdate
@DynamicInsert
public class ServiceEntity {
	@Id
    private UUID id = UUID.randomUUID();
    private String title;
    private String categoryId;
    private String subCategoryId;
    private String description;
	@OneToMany(mappedBy = "service", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<RequirementEntity> requirements;
    private String languageId;
    private Integer timeTaken;
    private long price;
    private Integer revision;
    
	public void setSkills(List<RequirementEntity> requirements) {
		for(RequirementEntity requirement : requirements){
			requirement.setService(this);
		}
		this.requirements = requirements;
	}

}
