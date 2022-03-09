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
@Table(name = "datosgenerales")
public class DataGeneral {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="iD_Datos_Generales")
    private int iD_Datos_Generales;
   
	@Column(name = "idusuario")
    private Integer idusuario;
   
    @Column(name = "cod_cliente")
    private Integer cod_cliente;
    
    @Column(name = "tipo_documento")
    private String tipo_documento;
    
    @Column(name = "Numero_cc")
    private String Numero_cc;
   
    @Column(name = "direccion")
    private String direccion;
    
    @Column(name = "Telefono")
    private String Telefono;

 

}
