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
     * @param user
     */
    @Insert("INSERT INTO `sys_user`(`id`, `username`) VALUES (null, #{username})")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    int insert(SysUser user);

    /**
     * @param user
     */
    @Update("update sys_user set username=#{username} where id = #{id}")
    int update(SysUser user);

    /**
     * @param ids
     */
    @Delete({"<script>",
            "delete from sys_user where id in",
            "<foreach collection='array' item='id' open='(' separator=',' close=')'>#{id}</foreach>",
            "</script>"})
    int delete(Long[] ids);

    /**
     * @param id
     * @return
     */
    @Select("select * from sys_user where id = #{id}")
    SysUser findById(Long id);

    @Select("select * from sys_user where username like concat('%', #{username}, '%')")
    List<SysUser> findAll(QuerySysUserDto queryDto);
}
