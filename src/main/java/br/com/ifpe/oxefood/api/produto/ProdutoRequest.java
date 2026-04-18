package br.com.ifpe.oxefood.api.produto;

import org.hibernate.validator.constraints.Length;

import br.com.ifpe.oxefood.modelo.produto.Produto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProdutoRequest {

    @NotNull(message = "A Categoria é de preenchimento obrigatório")
    private Long idCategoria;
    
    @NotBlank(message = "O Código é de preenchimento obrigatório")
    private String codigo;

    @NotNull(message = "O Título é de preenchimento obrigatório")
    @NotEmpty(message = "O Título é de preenchimento obrigatório")
    @Length(max = 50, message = "O Título deverá ter no máximo {max} caracteres")
    private String titulo;

  
    private String descricao;

    @NotNull(message = "O Valor é de preenchimento obrigatório")
    private Double valorUnitario;

    private Integer tempoDeEntregaMinimo;

    private Integer tempoDeEntregaMaximo;

    public Produto build() {

       return Produto.builder()
           .codigo(codigo)
           .titulo(titulo)
           .descricao(descricao)
           .valorUnitario(valorUnitario)
           .tempoDeEntregaMinimo(tempoDeEntregaMinimo)
           .tempoDeEntregaMaximo(tempoDeEntregaMaximo)
           .build();
   }

}
