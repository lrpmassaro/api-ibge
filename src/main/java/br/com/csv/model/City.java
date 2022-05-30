package br.com.csv.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
@Data
@ToString
@Entity
@Table(name = "tb_cities")
public class City implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "ibge_id")
	private Long ibgeId;
	private String uf;
	private String name;
	private String capital;
	private String lon;
	private String lat;
	@Column(name = "no_accents")
	private String noAccents;
	@Column(name = "alternative_names")
	private String alternativeNames;
	@Column(name = "micro_region")
	private String microRegion;
	@Column(name = "macro_region")
	private String macroRegion;
}
