package nathaliarj03.github.libraryapi.repository;

import nathaliarj03.github.libraryapi.model.Autor;
import nathaliarj03.github.libraryapi.model.GeneroLivro;
import nathaliarj03.github.libraryapi.model.Livro;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@SpringBootTest
 class LivroRepositoryTest {

    @Autowired
    LivroRepository  repositoryLivro;

    @Autowired
    AutorRepository autorRepository;

    @Test
    void salvarTest(){
       Livro livro = new Livro();
       livro.setIsbn("98888-9999");
       livro.setPreco(BigDecimal.valueOf(100));
       livro.setGenero(GeneroLivro.FICCAO);
       livro.setTitulo("NOVO22");
       livro.setDataPublicacao(LocalDate.of(1980, 1, 2));

       Autor autor = autorRepository.findById(UUID.fromString("45ea4006-8530-4112-b769-2313e46b06f4")
       ).orElse(null);

       livro.setAutor(autor);

       repositoryLivro.save(livro);
    }


   /* @Test
   void salvarCascadeTest(){
      Livro livro = new Livro();
      livro.setIsbn("98888-9999");
      livro.setPreco(BigDecimal.valueOf(100));
      livro.setGenero(GeneroLivro.FICCAO);
      livro.setTitulo("NOVO900");
      livro.setDataPublicacao(LocalDate.of(1980, 1, 2));

      Autor autor = new Autor();
      autor.setNome("Bia");
      autor.setDataDeNascimento(LocalDate.of(2000, 12,24));
      autor.setNacionalidade("Japones");

      livro.setAutor(autor);

      repositoryLivro.save(livro);
   } */


   @Test
   void salvarManualTest(){
      Livro livro = new Livro();
      livro.setIsbn("1111111111");
      livro.setPreco(BigDecimal.valueOf(100));
      livro.setGenero(GeneroLivro.MISTERIO);
      livro.setTitulo("Tres");
      livro.setDataPublicacao(LocalDate.of(2080, 11, 22));

      Autor autor = new Autor();
      autor.setNome("Caio");
      autor.setDataDeNascimento(LocalDate.of(2009, 5,30));
      autor.setNacionalidade("Argentino");

      autorRepository.save(autor);

      livro.setAutor(autor);

      repositoryLivro.save(livro);
   }

   @Test
   void atualizarAutordoLivro(){
       UUID id = UUID.fromString("36ba8e8b-0f83-4bbf-806e-296df09b5dcb");
       var livroParaAtualizar = repositoryLivro.findById(id
      ).orElse(null);

       UUID id_autor = UUID.fromString("deb6d082-01f9-4cb5-9983-1338f08dd110");
       Autor maria123 = autorRepository.findById(id_autor).orElse(null);

       livroParaAtualizar.setAutor(maria123);

       repositoryLivro.save(livroParaAtualizar);

   }
   @Test
   void deletar(){
       UUID id = UUID.fromString("36ba8e8b-0f83-4bbf-806e-296df09b5dcb");
       repositoryLivro.deleteById(id);


   }



}
