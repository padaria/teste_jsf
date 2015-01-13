package br.com.teste.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import org.springframework.dao.DataAccessException;

import br.com.teste.entity.Pessoa;
import br.com.teste.service.IPessoaService;

@ManagedBean(name="pessoaManagedBean")
@RequestScoped
public class PessoaManagedBean implements Serializable{

	private static final long serialVersionUID = 1L;
	private static final String SUCCESS = "success";
    private static final String ERROR   = "error";
    
    @ManagedProperty(value="#{PessoaService}")
    IPessoaService pessoaService;
    
    List<Pessoa> pessoaList;
    
    private String nome;
    private String telefone;
    
    public String addPessoa() {
        try {
            Pessoa pessoa = new Pessoa();
            pessoa.setNome(getNome());
            pessoa.setTelefone(getTelefone());
            getPessoaService().addPessoa(pessoa);
            return SUCCESS;
        } catch (DataAccessException e) {
            e.printStackTrace();
        }   
         
        return ERROR;
    }
     
    /**
     * Reset Fields
     * 
     */
    public void reset() {
        this.setNome("");
        this.setTelefone("");
    }
     
    /**
     * Get Pessoa List
     * 
     * @return List - Pessoa List
     */
    public List<Pessoa> getPessoaList() {
        pessoaList = new ArrayList<Pessoa>();
        pessoaList.addAll(getPessoaService().getPessoas());
        return pessoaList;
    }
     
    /**
     * Get Pessoa Service
     * 
     * @return IPessoaService - Pessoa Service
     */
    public IPessoaService getPessoaService() {
        return pessoaService;
    }
 
    /**
     * Set Pessoa Service
     * 
     * @param IPessoaService - Pessoa Service
     */
    public void setPessoaService(IPessoaService pessoaService) {
        this.pessoaService = pessoaService;
    }
     
    /**
     * Set Pessoa List
     * 
     * @param List - Pessoa List
     */
    public void setPessoaList(List<Pessoa> pessoaList) {
        this.pessoaList = pessoaList;
    }

    /**
     * Get Pessoa Nome
     * 
     * @return String - Pessoa Nome
     */
    public String getNome() {
        return nome;
    }
     
    /**
     * Set Pessoa Nome
     * 
     * @param String - Pessoa Nome
     */
    public void setNome(String nome) {
        this.nome = nome;
    }
     
    /**
     * Get Pessoa Telefone
     * 
     * @return String - Pessoa Telefone
     */
    public String getTelefone() {
        return telefone;
    }
     
    /**
     * Set Pessoa Telefone
     * 
     * @param String - Pessoa Telefone
     */
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

}
