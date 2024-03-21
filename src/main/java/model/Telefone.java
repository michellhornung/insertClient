package model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;

@SuppressWarnings("unused")
@Entity
public class Telefone {
	
	
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    @Pattern(regexp="\\d{10,11}")
	    private String numero;

	    @ManyToOne
	    @JoinColumn(name = "cliente_id")
	    private Cliente cliente;

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getNumero() {
			return numero;
		}

		public void setNumero(String numero) {
			this.numero = numero;
		}

		public Cliente getCliente() {
			return cliente;
		}

		public void setCliente(Cliente cliente) {
			this.cliente = cliente;
		}


}
