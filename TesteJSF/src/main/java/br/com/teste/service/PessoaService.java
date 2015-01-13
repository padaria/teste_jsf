package br.com.teste.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import br.com.teste.dao.IPessoaDAO;
import br.com.teste.entity.Pessoa;

@Transactional(readOnly = true)
public class PessoaService implements IPessoaService{
	
	IPessoaDAO pessoaDAO;
    
    /**
     * Add Pessoa
     * 
     * @param  Pessoa pessoa
     */
    @Transactional(readOnly = false)
    @Override
    public void addPessoa(Pessoa pessoa) {
        getPessoaDAO().addPessoa(pessoa);
    }
 
    /**
     * Delete Pessoa
     * 
     * @param  Pessoa pessoa
     */
    @Transactional(readOnly = false)
    @Override
    public void deletePessoa(Pessoa pessoa) {
        getPessoaDAO().deletePessoa(pessoa);
    }
     
    /**
     * Update Pessoa
     * 
     * @param  Pessoa pessoa
     */
    @Transactional(readOnly = false)
    @Override
    public void updatePessoa(Pessoa pessoa) {
        getPessoaDAO().updatePessoa(pessoa);
    }
     
    /**
     * Get Pessoa
     * 
     * @param  int Pessoa Id
     */
    @Override
    public Pessoa getPessoaById(int id) {
        return getPessoaDAO().getPessoaById(id);
    }
 
    /**
     * Get Pessoa List
     * 
     */
    @Override
    public List<Pessoa> getPessoas() {    
        return getPessoaDAO().getPessoas();
    }
 
    /**
     * Get Pessoa DAO
     * 
     * @return IPessoaDAO - Pessoa DAO
     */
    public IPessoaDAO getPessoaDAO() {
        return pessoaDAO;
    }
 
    /**
     * Set Pessoa DAO
     * 
     * @param IPessoaDAO - Pessoa DAO
     */
    public void setPessoaDAO(IPessoaDAO pessoaDAO) {
        this.pessoaDAO = pessoaDAO;
    }
}
