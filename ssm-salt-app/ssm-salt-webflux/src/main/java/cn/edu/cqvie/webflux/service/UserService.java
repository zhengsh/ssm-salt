package cn.edu.cqvie.webflux.service;

import cn.edu.cqvie.webflux.domain.User;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * 用户信息管理
 *
 * @author zhengsh
 * @date 2020-12-07
 */
public interface UserService {

    /**
     * 新增或更新
     * @param user 用户信息
     * @return 受影响的行数
     */
    Mono<User> save(User user);

    /**
     * 通过id删除
     * @param id 主键 id
     * @return 受影响行数
     */
    Mono<Void> deleteById(Long id);

    /**
     * 通过id查询信息
     * @param id 主键 id
     * @return 用户信息
     */
    Mono<User> findById(Long id);

    /**
     * 查询全部
     * @param id 主键 id
     * @return 用户信息列表
     */
    Flux<User> findAll(Long id);
}
