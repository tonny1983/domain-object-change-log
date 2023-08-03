package cc.tonny.domainobjectchangelog.adapter.outbound.repository.mybatis;

import cc.tonny.domainobjectchangelog.adapter.outbound.repository.JpaUserRepository;
import cc.tonny.domainobjectchangelog.adapter.outbound.repository.MyBatisUserRepository;
import cc.tonny.domainobjectchangelog.domain.User;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.OffsetDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


@SpringBootTest
public class MyBatisUserRepositoryTest {
    @Resource
    private MyBatisUserRepository myBatisUserRepository;
    @Resource
    private JpaUserRepository userRepository;

    @Test
    void shouldSelectByAccountUsingSQL() {
        var user = new User();
        user.setAccount("abc@test.com");
        user.setPassword("111");
        user.setName("aaa");
        user.setCreateTime(OffsetDateTime.now());
        userRepository.save(user);

        var result = myBatisUserRepository.selectByAccount(user.getAccount());
        assertNotNull(result);
    }

    @Test
    void shouldSaveUserUsingMyBatis() {
        User user = new User();
        user.setAccount("bcd@test.com");
        user.setPassword("222");
        user.setName("bbb");
        user.setCreateTime(OffsetDateTime.now());
        int row = myBatisUserRepository.insert(user);
        assertEquals(1, row);
        assertNotNull(user.getId());
    }
}
