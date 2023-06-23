package webtech.project.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import webtech.project.entity.Account;

@Repository
public interface AccountRepo extends CrudRepository<Account, Long> {
}
