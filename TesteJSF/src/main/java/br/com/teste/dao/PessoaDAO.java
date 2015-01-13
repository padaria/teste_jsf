package br.com.teste.dao;

import java.util.List;

import org.hibernate.SessionFactory;

import br.com.teste.entity.Pessoa;


public class PessoaDAO implements IPessoaDAO{
	
	private SessionFactory sessionFactory;
	 

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }
 
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addPessoa(Pessoa pessoa) {
        getSessionFactory().getCurrentSession().save(pessoa);
    }

    @Override
    public void deletePessoa(Pessoa pessoa) {
        getSessionFactory().getCurrentSession().delete(pessoa);
    }

    @Override
    public void updatePessoa(Pessoa pessoa) {
        getSessionFactory().getCurrentSession().update(pessoa);
    }

    @Override
    public Pessoa getPessoaById(int id) {
        @SuppressWarnings("rawtypes")
		List list = getSessionFactory().getCurrentSession()
                                            .createQuery("from Pessoa where id=?")
                                            .setParameter(0, id).list();
        return (Pessoa)list.get(0);
    }

    @SuppressWarnings("unchecked")
	@Override
    public List<Pessoa> getPessoas() {
        @SuppressWarnings("rawtypes")
		List list = getSessionFactory().getCurrentSession().createQuery("from Pessoa").list();
        return list;
    }

}
