import java.util.*;

public class Agenda
{
    private ArrayList<ItemAgenda> agendamentos;

    public Agenda()
    {
        agendamentos = new ArrayList<ItemAgenda>();
    }

    public void criarNovoAgendamento(int anoAgend, int mesAgend, int diaAgend, int horaAgend, int minAgend, int anoAtend, int mesAtend, int diaAtend, int horaAtend, int minAtend, Vacina vacinaAplicada, Enviador enviador)
    {
        Date dataAgendamento = new Date(anoAgend, mesAgend, diaAgend, horaAgend, minAgend);
        Date dataAtendimento = new Date(anoAtend, mesAtend, diaAtend, horaAtend, minAtend);
        if(verificaDisponibilidade(dataAtendimento))
        {
            ItemAgenda novoItem = new ItemAgenda(dataAgendamento, dataAtendimento, vacinaAplicada, enviador);
            atualizaAgenda(novoItem);
        } else {
            System.out.println("Horário Indisponível!");
        }
    }
    
    public void removerAgendamento(int anoAtend, int mesAtend, int diaAtend, int horaAtend, int minAtend)
    {
        Date dataAtendimento = new Date(anoAtend, mesAtend, diaAtend, horaAtend, minAtend);
        int indice = buscaAgendamento(dataAtendimento);
        if(indice != -1)
        {
            atualizaAgenda(indice);
        } else {
            System.out.println("Agendamento não encontrado!");
        }
    }
    
    private void atualizaAgenda(ItemAgenda novoItem)
    {
        agendamentos.add(novoItem);
    }
    
    private void atualizaAgenda(int indice)
    {
        agendamentos.remove(indice);
    }
    
    public int buscaAgendamento(Date dataAtendimento)
    {
        boolean encontrou = false;
        int indice = 0;
        if(this.agendamentos.isEmpty()) {
            return -1;
        }
    
        for(int i=0;i<this.agendamentos.size();i++) {
            if(this.agendamentos.get(i).getDataAtend() == dataAtendimento) {
                encontrou=true;
                indice = i;
                break;
            }
        }
        
        if(encontrou)
            return indice;
        else
            return -1;
    }
    
    public boolean verificaDisponibilidade(Date dataAtendimento)
    {
        int atendimento = buscaAgendamento(dataAtendimento);
        if (atendimento != -1)
        {
            return false;
        } else {
            return true;
        }
    }
}
