package com.workdb.previsaotempo.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Previsao {

    @JsonAlias("cnt")
    private int quantidadeRegistros;
    @JsonAlias("list")
    private List<Informacoes> lista;
}
