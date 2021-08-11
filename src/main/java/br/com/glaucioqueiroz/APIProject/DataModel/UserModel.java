package br.com.glaucioqueiroz.APIProject.DataModel;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name="User")
public class UserModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;
    @Column(unique = true)
    public String login;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    public String password;

}