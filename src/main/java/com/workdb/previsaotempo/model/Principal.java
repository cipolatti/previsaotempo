package com.workdb.previsaotempo.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Principal {

    @JsonAlias("temp")
    private Double temperatura;
    @JsonAlias("feels_like")
    private Double sensacao;
    private Double temp_min;
    private Double temp_max;
}
