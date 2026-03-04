package com.fms.tutotrials.jpa.auditing.model;

import java.io.Serial;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString(callSuper = true)
@Table(name = "PRODUCT")
public class Product extends AuditableEntity {

	@Serial
	private static final long serialVersionUID = 7333511899455763310L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_PRODUCT_GENERATOR")
	@SequenceGenerator(name = "SEQ_PRODUCT_GENERATOR", sequenceName = "SEQ_PRODUCT")
	@Column(name = "ID")
	private long id;

	@Column(name = "NAME")
	private String name;

	@OneToMany
	@JoinTable(name = "PRODUCT_PARTS", 
	           joinColumns = { @JoinColumn(name = "PRODUCT_ID") }, 
	           inverseJoinColumns = {@JoinColumn(name = "PART_ID") })
	private Set<Part> parts;

}
