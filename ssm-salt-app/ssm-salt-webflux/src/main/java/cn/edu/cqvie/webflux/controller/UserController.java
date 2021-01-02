package cn.edu.cqvie.webflux.controller;


import cn.edu.cqvie.webflux.domain.User;
import cn.edu.cqvie.webflux.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

/**
 * 用户信息管理
 *
 * @author zhengsh
 * @date 2020-12-07
 */
@RestController
public class UserController {

    @Autowired
    private UserService userService;


    /**
     * 查询用户信息
     *
     * @param id
     * @return
     */
    @GetMapping(path = "/user/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<User> getUser(@PathVariable("id") Long id) {
        return userService.findById(id);
    }

    /**
     * 修改用户信心
     *
     * @param id   用户id
     * @param user 需要修改的信息
     * @return 修改后的信息
     */
    @PutMapping("/user/{id}")
    public Mono<User> update(@PathVariable("id") Long id, @RequestBody User user) {
        return this.userService.findById(id)
                .map(u -> {
                    u.setBirthday(user.getBirthday());
                    u.setName(user.getName());
                    //性别只能首次设置，设置后不可修改
                    if (u.getSex() == null) {
                        u.setSex(user.getSex());
                    }
                    return u;
                }).flatMap(this.userService::save);

    }

    /**
     * 删除用户信息
     *
     * @param id 唯一主键ID
     * @return 删除后的结果
     */
    @DeleteMapping("/user/{id}")
    public Mono<Void> delete(@PathVariable("id") Long id) {
        return this.userService.deleteById(id);
    }

    /**
     * 保存用户信息
     *
     * @param user 用户信息
     * @return 用户信息
     */
    @PostMapping("/user")
    public Mono<User> save(@RequestBody User user) {
        return userService.save(user);
    }
}
