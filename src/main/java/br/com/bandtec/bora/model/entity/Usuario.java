package br.com.bandtec.bora.model.entity;

import java.util.Collection;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

@Data
@Entity
@Table(name = "tbd_usuario")
public class Usuario implements UserDetails {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_usuario")
	@JsonIgnore
	private Long idUsuario;

	@Size(min = 2)
	private String nome;

	@Column(unique = true, length = 50)
	@Size(min = 5)
	private String apelido;

	@Email
	private String email;

	@NotEmpty
	private String celular;

	@NotEmpty
	@Size(min = 5)
	private String senha;

//	@JsonManagedReference
//	@OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval = true)
//	@JsonIgnoreProperties
//	private List<UsuarioEvento> todosEventos;

	
	public Usuario() {
	}

	public Usuario(Long idUsuario, @Size(min = 2) String nome, @Size(min = 5) String apelido,
			@Email @NotEmpty String email, @NotEmpty String celular, @NotEmpty @Size(min = 5) String senha) {
		this.idUsuario = idUsuario;
		this.nome = nome;
		this.apelido = apelido;
		this.email = email;
		this.celular = celular;
		this.senha = senha;
	}

	public Usuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}
	
//	public List<UsuarioEvento> getTodosEventos() {
//		return todosEventos;
//	}

	@JsonIgnore
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}

	@JsonIgnore
	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return new BCryptPasswordEncoder().encode(senha);
	}

	@JsonIgnore
	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return this.apelido;
	}
	
	@JsonIgnore
	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@JsonIgnore
	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@JsonIgnore
	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@JsonIgnore
	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
}