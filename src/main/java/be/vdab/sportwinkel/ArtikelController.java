package be.vdab.sportwinkel;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
class ArtikelController {
    private final ArtikelService artikelService;

    ArtikelController(ArtikelService artikelService){
        this.artikelService = artikelService;
    }

    @PostMapping("/artikels")
    @ResponseStatus(HttpStatus.CREATED)
    void post(@RequestBody @Valid NieuwArtikel nieuwArtikel){
        artikelService.create(nieuwArtikel);

    }
}
