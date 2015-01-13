package br.com.teste.dao;

import java.util.List;

import br.com.teste.entity.Pessoa;

public interface IPessoaDAO {
	
	public void addPessoa(Pessoa pessoa);

    public void updatePessoa(Pessoa pessoa);

    public void deletePessoa(Pessoa pessoa);

    public Pessoa getPessoaById(int id);

    public List<Pessoa> getPessoas();
}
