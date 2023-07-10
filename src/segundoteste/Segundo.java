package segundoteste;

import java.util.List;

import exceptions.ConflitoException;
import exceptions.NaoEncontradoException;
import exceptions.RequisicaoRuimException;

import java.util.ArrayList;

public class Segundo {
    private int idAtual = 0;

    private List<Candidato> candidatos = new ArrayList<>();

    public int iniciarProcesso(String nome) {

        if (nome == null || nome.isEmpty()) {
            throw new RequisicaoRuimException("Nome inválido.");
        }

        for (int i = 0; i < candidatos.size(); i++) {
            if (candidatos.get(i).getNome().equals(nome)) {
                throw new ConflitoException("Candidato já participa do processo.");
            }
        }

        Candidato candidato = new Candidato(nome, proximoId());

        this.candidatos.add(candidato);

        return candidato.getId();
    }

    public void marcarEntrevista(int codCandidato) {
        int indexCandidato = encontrarIndexDoCandidato(codCandidato);

        if (candidatos.get(indexCandidato).getStatus() != "Recebido") {
            throw new NaoEncontradoException("Candidato não encontrado");
        }

        candidatos.get(indexCandidato).setStatus("Qualificado");
    }

    public void desqualificarCandidato(int codCandidato) {
        int indexCandidato = encontrarIndexDoCandidato(codCandidato);

        candidatos.remove(indexCandidato);
    }

    public String verificarStatusCandidato(int codCandidato) {
        int indexCandidato = encontrarIndexDoCandidato(codCandidato);

        return candidatos.get(indexCandidato).getStatus();
    }

    public void aprovarCandidato(int codCandidato) {
        int indexCandidato = encontrarIndexDoCandidato(codCandidato);

        if (candidatos.get(indexCandidato).getStatus() != "Qualificado") {
            throw new NaoEncontradoException("Candidato não encontrado");
        }

        candidatos.get(indexCandidato).setStatus("Aprovado");
    }

    public List<String> obterAprovados() {
        List<String> candidatosAprovados = new ArrayList<>();

        for (int i = 0; i < candidatos.size(); i++) {
            if (candidatos.get(i).getStatus() == "Aprovado") {
                candidatosAprovados.add(candidatos.get(i).getNome());
            }
        }

        return candidatosAprovados;
    }

    private int proximoId() {
        this.idAtual++;
        return idAtual;
    }

    private int encontrarIndexDoCandidato(int id) {
        for (int i = 0; i < candidatos.size(); i++) {
            if (candidatos.get(i).getId() == id) {
                return i;
            }
        }

        throw new NaoEncontradoException("Candidato não encontrado");
    }
}