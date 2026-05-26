package nathaliarj03.github.libraryapi.repository;

import nathaliarj03.github.libraryapi.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AutorRepository  extends JpaRepository<Autor, UUID> {
}
