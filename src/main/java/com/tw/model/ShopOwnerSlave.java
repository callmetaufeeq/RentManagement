
package com.tw.model;

import java.sql.Date;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import org.hibernate.annotations.Where;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.tw.generics.AbstractPersistable;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "shop_owner_slave")
@Where(clause = "deleted=false")
public class ShopOwnerSlave extends AbstractPersistable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6463053553098083997L;

	@Column(name = "for_work")
	private String forWork;

	@Column(name = "status")
	private int status = 1;

	@Column(name = "date")
	private Date date;

	@Column(name = "year")
	private Date year;

	@ManyToOne(fetch = FetchType.LAZY, cascade = { CascadeType.ALL })
	@JoinColumn(name = "shop_id")
	//@JsonIgnore
	@NotFound(action = NotFoundAction.IGNORE)
	private Shop shop;

	@ManyToOne(fetch = FetchType.LAZY, cascade = { CascadeType.ALL })
	@JoinColumn(name = "shop_owner_id")
	@JsonIgnore
	@NotFound(action = NotFoundAction.IGNORE)
	private ShopOwner shopOwner;

}
