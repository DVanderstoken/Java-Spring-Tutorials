package com.fms.tutotrials.jpa.auditing.model;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

import org.hibernate.annotations.SoftDelete;
import org.hibernate.annotations.SoftDeleteType;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import com.fms.tutotrials.jpa.auditing.utils.SoftDeleteInstantConverter;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@MappedSuperclass
@SoftDelete(strategy = SoftDeleteType.DELETED, columnName = "DELETED_ON", converter = SoftDeleteInstantConverter.class)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class AuditableEntity implements Serializable{

	@Serial
	private static final long serialVersionUID = 3458464768463969629L;

	@CreatedDate
	@Column(name = "CREATED_ON", insertable = true, updatable = false)
	protected LocalDateTime createdOn;
	
	@LastModifiedDate
	@Column(name = "LAST_UPDATED_ON", insertable = false, updatable = true)
	protected LocalDateTime lastUpdatedOn;
	
	@Column(name = "DELETED_ON", insertable = false, updatable = false)
	protected LocalDateTime deletedOn;
	
}
