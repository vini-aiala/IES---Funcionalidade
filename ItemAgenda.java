import java.util.*;

public class ItemAgenda
{
    // variáveis de instância - substitua o exemplo abaixo pelo seu próprio
    private Date dataAgendamento, dataAtendimento;
    private Vacina vacinaAplicada;
    private Enviador enviador;

    /**
     * Construtor para objetos da classe ItemAgenda
     */
    public ItemAgenda(Date dataAgendamento, Date dataAtendimento, Vacina vacinaAplicada, Enviador enviador)
    {
        
        this.dataAgendamento = dataAgendamento;
        this.dataAtendimento = dataAtendimento;
        this.vacinaAplicada = vacinaAplicada;
        this.enviador = enviador;
        this.enviador.enviaEmail(dataAtendimento);
        
    }
    
    public void setDataAgen(Date novaDataAgen)
    {
        dataAgendamento = novaDataAgen;
        this.enviador.enviaEmail(dataAtendimento);
    }
    
    public void setDataAtend(Date novaDataAtend)
    {
        dataAtendimento = novaDataAtend;
        this.enviador.enviaEmail(dataAtendimento);
    }
    
    public void setVacinaAplicada(Vacina novaVacinaAplicada)
    {
        vacinaAplicada = novaVacinaAplicada;
    }
    
    public Date getDataAgen()
    {
        System.out.println("A data do Agendamento é " + dataAgendamento);
        return dataAgendamento;
    }
    
    public Date getDataAtend()
    {
        System.out.println("A data do Atendimento é " + dataAtendimento);
        return dataAtendimento;
    }
    
    public Vacina getVacinaAplicada()
    {
        return vacinaAplicada;
    }
}
