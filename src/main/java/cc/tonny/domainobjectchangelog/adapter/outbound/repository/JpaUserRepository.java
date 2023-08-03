package cc.tonny.domainobjectchangelog.adapter.outbound.repository;

import cc.tonny.domainobjectchangelog.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.history.RevisionRepository;

import java.util.List;

public interface JpaUserRepository extends JpaRepository<User, Integer>, RevisionRepository<User, Integer, Integer> {

    default List<User> listUsers() {
        return this.findAll();
    }
}
