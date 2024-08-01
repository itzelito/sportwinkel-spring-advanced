package be.vdab.sportwinkel;

import org.springframework.data.jpa.repository.JpaRepository;

interface ArtikelRepository extends JpaRepository<Artikel, Long> {
}
