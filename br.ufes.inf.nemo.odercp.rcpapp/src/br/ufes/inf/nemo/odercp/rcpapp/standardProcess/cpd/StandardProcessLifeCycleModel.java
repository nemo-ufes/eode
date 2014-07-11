package br.ufes.inf.nemo.odercp.rcpapp.standardProcess.cpd;

import Ode.Conhecimento.Processo.Cdp.KModeloCicloVida;
import Ode.Utilitario.Persistencia.hibernate3.ObjetoPersistente;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @hibernate.class
 *  table="padr_modelociclovidaprocessopadrao"
 *
 */


public class StandardProcessLifeCycleModel extends ObjetoPersistente{
    
    /** Processo Padrão Específico associado */
    private SpecificStandardProcess processosEspecifico;
    /** KModeloCicloVida referente */
    private KModeloCicloVida  kModeloCicloVida;
    /** Combinacoes para o ModeloCicloVida */
    private Set combinacoes;
    

    public StandardProcessLifeCycleModel() {
        this.setCombinacoes(new HashSet());
    }
    
    
    /** Obtém o Processo Padrão Específico.
     *
     * @hibernate.many-to-one
     *   column = "idoprocessoespecificomcv"
     *   not-null = "true"
     *   class = "Ode.processoPadrao.cdp.ProcessoPadraoEspecifico"
     *
     */
    public SpecificStandardProcess getProcessosEspecifico() {
        return processosEspecifico;
    }

    public void setProcessosEspecifico(SpecificStandardProcess parProcessosEspecifico) {
        this.processosEspecifico = parProcessosEspecifico;
    }
    
    
    /** Obtém o KModeloCicloVida refernete a este.
     *
     * @hibernate.many-to-one
     *   column = "idokmodelociclovida"
     *   not-null = "false"
     *   class = "Ode.Conhecimento.Processo.Cdp.KModeloCicloVida"
     *
     */
    public KModeloCicloVida getKModeloCicloVida() {
        return kModeloCicloVida;
    }

    public void setKModeloCicloVida(KModeloCicloVida parKModeloCicloVida) {
        this.kModeloCicloVida = parKModeloCicloVida;
    }
    
    
    /** Obtém as Combinações.
     *
     *@hibernate.set
     *    inverse = "true"
     *    cascade = "all"
     *    lazy = "true"
     *@hibernate.collection-key
     *   column = "idomodelociclovida"
     *@hibernate.collection-one-to-many
     *   class = "Ode.processoPadrao.cdp.CombinacaoPP"
     *
     */
    public Set getCombinacoes() {
        return combinacoes;
    }

    public void setCombinacoes(Set parCombinacoes) {
        this.combinacoes = parCombinacoes;
    }

    
    public String toString(){
        //return this.nome;
        return kModeloCicloVida.toString();
    }

    
}
