package be.vdab.sportwinkel;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

import java.math.BigDecimal;

record NieuwArtikel(@NotBlank String naam, @NotNull @PositiveOrZero BigDecimal aankoopprijs,
                    @NotNull @PositiveOrZero BigDecimal verkoopprijs) {
}
