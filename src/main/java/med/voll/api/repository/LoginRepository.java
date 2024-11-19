package med.voll.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import med.voll.api.domain.users.LoginUsers;

public interface LoginRepository extends JpaRepository<LoginUsers, Long> {

    UserDetails findByLogin(String username);

}
