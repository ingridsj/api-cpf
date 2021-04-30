package br.com.ApiCpf.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.br.CPF;

@Entity
@Table(name = "TB_Cadastro")
public class Cadastro {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "Nome não pode ser branco")
	@NotNull(message = "Nome não pode ser vazio")
	private String Nome;
	
	@NotBlank(message = "Nascimento não pode ser branco")
	@NotNull(message = "Nascimento não pode ser vazio")
	private String Nascimento;
	
	@NotBlank(message = "Cpf não pode ser branco")
	@NotNull(message = "Cpf não pode ser vazio")
	@Column(unique = true)
	@Size(max = 11)
	@CPF(message = "Cpf inválido")
	private String Cpf;
	
	@NotBlank(message = "Email não pode ser branco")
	@NotNull(message = "Email não pode ser vazio")
	@Email(message = "Email inválido")
	private String Email;
	
	private LocalDateTime CriadoEm = LocalDateTime.now();

	public Cadastro(
			@NotBlank(message = "Nome não pode ser branco") @NotNull(message = "Nome não pode ser vazio") String nome,
			@NotBlank(message = "Nascimento não pode ser branco") @NotNull(message = "Nascimento não pode ser vazio") String nascimento,
			@NotBlank(message = "Cpf não pode ser branco") @NotNull(message = "Cpf não pode ser vazio") @Size(max = 11) @CPF(message = "Cpf inválido") String cpf,
			@NotBlank(message = "Email não pode ser branco") @NotNull(message = "Email não pode ser vazio") @javax.validation.constraints.Email(message = "Email inválido") String email) {
		this.Nome = nome;
		this.Nascimento = nascimento;
		this.Cpf = cpf;
		this.Email = email;
	}

	public Long getId() {
		return id;
	}

	public String getEmail() {
		return Email;
	}

	public String getNome() {
		return Nome;
	}

	public String getNascimento() {
		return Nascimento;
	}

	public String getCpf() {
		return Cpf;
	}

	public LocalDateTime getCriadoEm() {
		return CriadoEm;
	}
}
