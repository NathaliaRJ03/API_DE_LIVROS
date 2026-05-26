package nathaliarj03.github.libraryapi.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "livro" , schema = "public")
@Data


@AllArgsConstructor // CONSTRUTOR COM TODOS OS ARGUMENTOS.
public class Livro {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.UUID) // gera um identificador unico.
    private UUID id;

    @Column(name = "isbn" , length = 20, nullable = false)
    private String isbn;

    @Column(name = "titulo", length = 150)
    private String titulo;

    @Column(name = "data_publicacao")
    private LocalDate dataPublicacao;

    @Enumerated(EnumType.STRING) // como será salvo no banco de dados.
    @Column(name = "genero", length = 30, nullable = false)
    private GeneroLivro genero;

    @Column(name = "preco" , precision = 18 , scale = 2)
    private BigDecimal preco;

    //TIPO DE RELACIONAMENTO
    @ManyToOne  // UM AUTOR PODE TER UM OU MAIS DE UM LIVROS. (MUITOS PARA UM (AUTOR))
    @JoinColumn(name = "id_autor")
    private Autor autor;





}
