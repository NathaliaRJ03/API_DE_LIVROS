package nathaliarj03.github.libraryapi.repository;

import nathaliarj03.github.libraryapi.model.Autor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@SpringBootTest
public class AutorRepositoryTest {


    @Autowired
    AutorRepository repository;

    @Test
    public void salvaTeste(){  /// SALVA REGISTRO!
        Autor autor = new Autor();
        autor.setNome("Lucas");
        autor.setDataDeNascimento(LocalDate.of(2000, 12,24));
        autor.setNacionalidade("Japones");

        var autorSalvo = repository.save(autor);
        System.out.println(("Autor Salvo!" + autorSalvo));
    }


    @Test
    public void atualizarTest(){ // ATUALIZAR REGISTRO
        var id = UUID.fromString("11ed5bf0-c2bd-4071-ae1a-003fce2c5d5d");

        Optional<Autor> possivelAutor = repository.findById(id);

        if(possivelAutor.isPresent()){
            Autor autorEncontrado = possivelAutor.get();
            System.out.println("Dados do Autor:");
            System.out.println(autorEncontrado);

            autorEncontrado.setDataDeNascimento(LocalDate.of(2002,11,11));
            repository.save(autorEncontrado);
        }
    }

    @Test
    public void listaTest(){ // LISTA OS AUTORES QUE TEM SALVO NO BANCO. (TIPO SELECT)
        List<Autor> listaAutor = repository.findAll();
        listaAutor.forEach(System.out::println);
    }

    @Test
    public void contarTest(){
        System.out.println("Contagem de autores: " +repository.count());

    }

    @Test
    public void deletarTestByID(){
        var id = UUID.fromString("68d04921-e33c-47b9-b101-62d528682792");
        repository.deleteById(id);
    }

    @Test
    public void deletarTestByObjeto(){
        var id = UUID.fromString("11ed5bf0-c2bd-4071-ae1a-003fce2c5d5d");
        var maria = repository.findById(id).get();
        repository.delete(maria);
    }


}
