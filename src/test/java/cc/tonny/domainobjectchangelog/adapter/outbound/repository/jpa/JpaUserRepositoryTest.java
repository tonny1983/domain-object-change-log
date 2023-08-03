package cc.tonny.domainobjectchangelog.adapter.outbound.repository.jpa;

import cc.tonny.domainobjectchangelog.adapter.outbound.repository.JpaUserRepository;
import cc.tonny.domainobjectchangelog.domain.User;
import jakarta.annotation.Resource;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.OffsetDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@Log4j2
public class JpaUserRepositoryTest {
    @Resource
    private JpaUserRepository repository;

    @Test
    void shouldSaveUserUsingJPA() {
        var user = new User();
        user.setAccount("cde@test.com");
        user.setPassword("333");
        user.setName("ccc");
        user.setCreateTime(OffsetDateTime.now());
        var result = repository.save(user);

        assertNotNull(result.getId());
    }

    @Test
    void shouldModifyUserUsingJPA() {
        var user = new User();
        user.setAccount("def@test.com");
        user.setPassword("444");
        user.setName("ddd");
        user.setCreateTime(OffsetDateTime.now());
        var result = repository.save(user);

        assertNotNull(result.getId());

        result.setAccount("efg@test.com");
        var result2 = repository.save(result);

        assertEquals(result2.getAccount(), result.getAccount());

        var revisions = repository.findRevisions(result.getId());
        assertEquals(2, revisions.stream().count());

        revisions.forEach(log::info);
    }


}
