package cn.edu.cqvie.ssm.dao;

import cn.edu.cqvie.ssm.common.dto.QuerySysUserDto;
import cn.edu.cqvie.ssm.common.entity.SysUser;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * 系统用户
 *
 * @author zhengsh
 * @date 2020-10-22
 */
@Mapper
public interface SysUserDao {

    /**
     * 新增用户信息
     *
     * @param entity 用户对象
     * @return 受影响的行数
     */
    @Insert("INSERT INTO `sys_user`(`id`, `login_name`, `user_name`) VALUES (null, #{loginName}, #{userName})")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    int insert(SysUser entity);

    /**
     * 更新用户信息
     *
     * @param entity 用户对象
     * @return 受影响的行数
     */
    @Update("update sys_user set login_name=#{loginName} where id = #{id}")
    int update(SysUser entity);

    /**
     * 通过 id 删除
     *
     * @param ids id 集合
     * @return 受影响的行数
     */
    @Delete({"<script>",
            "delete from sys_user where id in",
            "<foreach collection='array' item='id' open='(' separator=',' close=')'>#{id}</foreach>",
            "</script>"})
    int delete(Long[] ids);

    /**
     * 通过Id 查询
     *
     * @param id 唯一id
     * @return 查询对象
     */
    @Select("select * from sys_user where id = #{id}")
    SysUser findById(Long id);

    /**
     * 查询
     *
     * @param dto 查询
     * @return 查询列表
     */
    @Select("select * from sys_user where login_name like concat('%', #{loginName}, '%')")
    List<SysUser> findAll(QuerySysUserDto dto);
}
