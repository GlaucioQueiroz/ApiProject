package br.com.glaucioqueiroz.APIProject.ViewModel;
;
import lombok.Data;
import org.hibernate.validator.constraints.br.CPF;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Data
public class CustomerViewModel {
    private String cpf;
    private String nome;
//    public List<AddressViewModel> endereco;
    private String logradouro;
    private String bairro;
    private String numero;
    private String complemento;
    private String cep;
    private String cidade;
    private String estado;
}
