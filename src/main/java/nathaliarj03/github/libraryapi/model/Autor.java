package nathaliarj03.github.libraryapi.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "autor", schema = "public") // tabela do banco de dados.
@Getter
@Setter
@ToString
public class Autor {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.UUID) // gera um identificador único.
    private UUID id;

    @Column(name = "nome",length = 100, nullable = false) // quantos caracteres aceita.
    private String nome;

    @Column(name = "data_nascimento", nullable = false)
    private LocalDate dataDeNascimento;

    @Column(name = "nacionalidade", length = 50, nullable = false)
    private String nacionalidade;

    //somente um mapeamento.
    // @OneToMany(mappedBy = "autor") // um autor para muitos livros.

    @Transient  // (IGNORA ESSA COLUNA)
    private List<Livro> livros;




    /*
    @Deprecated  // NAO É RECOMENDAVEL USAR.
    public Autor(){

        // para uso do framework.
    }

    /*
    public Autor(String nome, LocalDate dataDeNascimento, String nacionalidade) {
        this.nome = nome;
        this.dataDeNascimento = dataDeNascimento;
        this.nacionalidade = nacionalidade;
    } */
}
