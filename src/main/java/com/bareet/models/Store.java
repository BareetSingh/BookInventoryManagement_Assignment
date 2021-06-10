package com.bareet.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Entity
@NoArgsConstructor
@Setter
@Getter
public class Store {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long storeId;
	private String storeName;

	@OneToMany(cascade = CascadeType.ALL)
	private List<Book> books;

	}
