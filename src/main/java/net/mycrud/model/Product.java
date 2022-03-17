package net.mycrud.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="productos")
public class Product {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_product")
	private int id_product;
	
	@Column(name="nombreproducto")
	private String nombreproducto;
	
	@Column(name="precio_x_cantidad")
	private String precio_x_cantidad;
	
	@Column(name="imagen")
	private String imagen;
	
    @Column(name="cantidad")
    private String cantidad;
    
    @Column(name="material")
    private String material;
    
    @Column(name="precio_X_unidad")
    private String precio_X_unidad;

}
