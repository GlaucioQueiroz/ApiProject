package br.com.glaucioqueiroz.APIProject.ViewModel;

import br.com.glaucioqueiroz.APIProject.DataModel.CustomerModel;
import lombok.Data;

import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

@Data
public class AddressViewModel {
    public String logradouro;
    public String bairro;
    public String numero;
    public String complemento;
    public String cep;
    public String cidade;
    public String estado;
}
