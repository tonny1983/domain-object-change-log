package cc.tonny.domainobjectchangelog.adapter.outbound.repository;

import cc.tonny.domainobjectchangelog.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface MyBatisUserRepository {

    @Select("select * from user where account = #{account} limit 1")
    User selectByAccount(String account);


    int insert(User user);
}
