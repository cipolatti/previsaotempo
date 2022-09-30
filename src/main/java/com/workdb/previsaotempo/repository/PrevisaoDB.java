package com.workdb.previsaotempo.repository;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Previsao")
public class PrevisaoDB implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String cidade;
    private String data;
    private String tempo;
    private String temperatura;
    private String sensacaoTermica;
    private String temperaturaMinima;
    private String temperaturaMaxima;
}
