package com.tw.model;

import org.hibernate.annotations.Where;

import com.tw.generics.AbstractPersistable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "category")
@Where(clause = "deleted=false")
public class Category  extends AbstractPersistable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4294751319200495576L;

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "category_name")
	public String categoryName;

	@Column(name = "category_code")
	public String categoryCode;

	@Column(name = "status")
	private int status = 1;

}
