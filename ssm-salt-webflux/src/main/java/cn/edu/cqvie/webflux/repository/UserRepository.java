package cn.edu.cqvie.webflux.repository;

import cn.edu.cqvie.webflux.domain.User;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

/**
 * 用户信息持久化
 *
 * @author zhengsh
 * @date 2020-12-07
 */
@Repository
public interface UserRepository extends R2dbcRepository<User, Long> {

    /**
     * 通过id 查询对象信息
     * @param id 唯一主键id
     * @return 对象信息
     */
    @Query("SELECT * FROM user u WHERE u.id = ? LIMIT 1")
    Mono<User> findById(Long id);

}
