package cn.edu.cqvie.webflux.service.impl;

import cn.edu.cqvie.webflux.domain.User;
import cn.edu.cqvie.webflux.repository.UserRepository;
import cn.edu.cqvie.webflux.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * 用户信息管理
 *
 * @author zhengsh
 * @date 2020-11-07
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repository;

    /**
     * 新增或更新
     *
     * @param user 用户信息
     * @return 受影响的行数
     */
    @Override
    public Mono<User> save(User user) {
        return repository.save(user);
    }

    /**
     * 通过id删除
     *
     * @param id 主键 id
     * @return 受影响行数
     */
    @Override
    public Mono<Void> deleteById(Long id) {
        return repository.deleteById(id);
    }

    /**
     * 通过id查询信息
     *
     * @param id 主键 id
     * @return 用户信息
     */
    @Override
    public Mono<User> findById(Long id) {
        return repository.findById(id);
    }

    /**
     * 查询全部
     *
     * @param id 主键 id
     * @return 用户信息列表
     */
    @Override
    public Flux<User> findAll(Long id) {
        return repository.findAll();
    }
}
