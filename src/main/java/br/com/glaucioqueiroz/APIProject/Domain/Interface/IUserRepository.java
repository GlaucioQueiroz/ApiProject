package br.com.glaucioqueiroz.APIProject.Domain.Interface;

import br.com.glaucioqueiroz.APIProject.DataModel.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IUserRepository extends JpaRepository<UserModel, Integer> {

    public Optional<UserModel> findByLogin(String login);

}