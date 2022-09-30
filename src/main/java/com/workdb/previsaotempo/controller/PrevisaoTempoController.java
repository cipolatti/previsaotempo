package com.workdb.previsaotempo.controller;

import com.workdb.previsaotempo.model.Previsao;
import com.workdb.previsaotempo.repository.PrevisaoDB;
import com.workdb.previsaotempo.repository.PrevisaoRepository;
import com.workdb.previsaotempo.services.PrevisaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/previsao")
public class PrevisaoTempoController {
    @Autowired
    private PrevisaoService previsaoService;

    @Autowired
    PrevisaoRepository previsaoRepository;

    @GetMapping(value = "/{cidade}")
    public StringBuilder obterCidade(@PathVariable String cidade) {
        StringBuilder previsaoEstruturada = new StringBuilder("");
        if(cidade != null) {
            Previsao previsao = this.previsaoService.obterPrevisao(cidade);
            previsaoEstruturada = this.montarPrevisao(previsao, cidade);
        }
        return previsaoEstruturada;
    }

    private StringBuilder montarPrevisao(Previsao previsao, String cidade) {
        if(cidade != null && !cidade.isEmpty()){
            StringBuilder retorno = new StringBuilder("Cidade: " + cidade + "\n");
            if(previsao != null && !previsao.getLista().isEmpty()) {
                for (int i = 0; previsao.getQuantidadeRegistros() != i; i++) {

                    String data = this.formatarData(previsao.getLista().get(i).getData());
                    String tempo = previsao.getLista().get(i).getTempo().get(0).getPrevisao();
                    String temperatura = String.valueOf(previsao.getLista().get(i).getPrincipal().getTemperatura());
                    String sensacaoTermica = String.valueOf(previsao.getLista().get(i).getPrincipal().getSensacao());
                    String temperaturaMinima = String.valueOf(previsao.getLista().get(i).getPrincipal().getTemp_min());
                    String temperaturaMaxima = String.valueOf(previsao.getLista().get(i).getPrincipal().getTemp_max());

                    retorno.append("\n");
                    retorno.append(" Data: ").append(data).append("\n");
                    retorno.append(" Tempo: ").append(tempo).append("\n");
                    retorno.append(" Temperatura: ").append(temperatura).append("\n");
                    retorno.append(" Sensação Térmica: ").append(sensacaoTermica).append("\n");
                    retorno.append(" Temperatura Mínima: ").append(temperaturaMinima).append("\n");
                    retorno.append(" Temperatura Máxima: ").append(temperaturaMaxima).append("\n");
                    retorno.append("\n");
                    retorno.append(" ############################# \n");
                    this.salvarPrevisao(temperatura, sensacaoTermica, temperaturaMinima, temperaturaMaxima, cidade, data, tempo);
                }
            }
        return retorno;
        }
        return null;
    }

    private void salvarPrevisao(String temperatura, String sensacaoTermica, String temperaturaMinima, String temperaturaMaxima, String cidade, String data, String tempo) {
        PrevisaoDB previsaoDB = new PrevisaoDB();
        previsaoDB.setCidade(cidade);
        previsaoDB.setData(data);
        previsaoDB.setTempo(tempo);
        previsaoDB.setTemperatura(temperatura);
        previsaoDB.setSensacaoTermica(sensacaoTermica);
        previsaoDB.setTemperaturaMinima(temperaturaMinima);
        previsaoDB.setTemperaturaMaxima(temperaturaMaxima);
        previsaoRepository.save(previsaoDB);
    }

    @GetMapping("/listar-previsoes")
    public List<PrevisaoDB> listarPrevisoes() {
        return this.previsaoRepository.findAll();
    }

    private String formatarData(String data) {
        String dataFormatada = "";
        String dia = data.substring(8,10);
        String mes = data.substring(5,7);
        String ano = data.substring(0,4);
        String horario = data.substring(11,19);
        dataFormatada = dia + "/" + mes + "/" + ano + " " + horario;
        return dataFormatada;
    }
}
