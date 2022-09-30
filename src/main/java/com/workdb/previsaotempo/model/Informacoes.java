package com.workdb.previsaotempo.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Informacoes {

    @JsonAlias("main")
    private Principal principal;
    @JsonAlias("weather")
    private List<Tempo> tempo;
    @JsonAlias("dt_txt")
    private String data;
}
