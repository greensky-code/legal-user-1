package com.example.legal.entity;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity
@Table(name = "faq")
@Data
@EqualsAndHashCode(exclude = "user")
@ToString(exclude = "user")	
public class FaqEntity {
    @Id
    private UUID id = UUID.randomUUID();
    private String question;
    private String relatedService;
    private String answer;
/*    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @ManyToOne
    private UserEntity user;*/

}
