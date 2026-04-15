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

    private Long idCategoria;
    
    private String codigo;

    @NotNull(message = "O Nome é de preenchimento obrigatório")
    @NotEmpty(message = "O Nome é de preenchimento obrigatório")
    @Length(max = 50, message = "O Nome deverá ter no máximo {max} caracteres")
    private String titulo;

  
    private String descricao;

    @NotBlank(message = "O valor é de preenchimento obrigatório")
    private Double valorUnitario;

    @NotBlank(message = "O tempo mínimo é de preenchimento obrigatório")
    private Integer tempoDeEntregaMinimo;

    @NotBlank(message = "O tempo máximo é de preenchimento obrigatório")
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
