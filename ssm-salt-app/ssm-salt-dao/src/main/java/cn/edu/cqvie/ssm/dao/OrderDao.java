package cn.edu.cqvie.ssm.dao;

import cn.edu.cqvie.ssm.common.entity.SysUser;
import cn.edu.cqvie.ssm.common.model.OrderModel;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;

@Mapper
public interface OrderDao {

    @Insert("INSERT INTO `sys_user`(`id`, `login_name`, `user_name`) VALUES (null, #{loginName}, #{userName})")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    int insert(OrderModel entity);


    @Insert("INSERT INTO `sys_user`(`id`, `login_name`, `user_name`) VALUES (null, #{loginName}, #{userName})")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    int update(OrderModel entity);



    @Insert("INSERT INTO `sys_user`(`id`, `login_name`, `user_name`) VALUES (null, #{loginName}, #{userName})")
    OrderModel query(OrderModel entity);
}
