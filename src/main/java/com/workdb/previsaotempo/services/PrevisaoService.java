package com.workdb.previsaotempo.services;

import com.workdb.previsaotempo.model.Previsao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
@Service
public class PrevisaoService {
    @Autowired
    private WebClient webClient;

    public Previsao obterPrevisao(String cidade) {
        Mono<Previsao> monoCidade = this.webClient
                .method(HttpMethod.GET)
                .uri("?q="+cidade+",&appid=629c1ed957b3bf733084c858dc4b1851&units=metric&lang=pt")
                .retrieve()
                .bodyToMono(Previsao.class);
        return monoCidade.block();
    }
}

