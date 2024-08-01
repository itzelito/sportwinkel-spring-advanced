package be.vdab.sportwinkel;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Service
@Transactional(readOnly = true)
class ArtikelService {
    private final ArtikelRepository artikelRepository;
    private final AmqpTemplate template;

     ArtikelService(ArtikelRepository artikelRepository, AmqpTemplate template) {
        this.artikelRepository = artikelRepository;
        this.template = template;
    }
    @Transactional
    void create(NieuwArtikel nieuwArtikel){
         var artikel= new Artikel(nieuwArtikel.naam(), nieuwArtikel.aankoopprijs(), nieuwArtikel.verkoopprijs());
         artikelRepository.save(artikel);
         template.convertAndSend("sportartikels", null, new ArtikelGemaakt(artikel));

    }
}
