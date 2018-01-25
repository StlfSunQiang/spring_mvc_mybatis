package com.sust.spring.mapper;

import com.sust.spring.domain.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface UserMapper {


    List<User> findAllUsers();

    @Select("select A.*, B.id as PROFILE_IMAGE_ID, B.file_name as PROFILE_IMAGE_NAME from tbl_user as A,tbl_file B where A.file_id = B.id and A.id = #{id}")
    @ResultMap("com.sust.spring.mapper.UserMapper.UserResult")
    User findById(Long id);

    @Insert("insert into tbl_user values(null,#{name},#{userName},#{password},#{dateOfBirth},null)")
    int createNewUser(User user);

    @Update("update tbl_user set name=#{name},user_name=#{userName},dob=#{dateOfBirth} where id=#{id}")
    int updateUser(User user);

    @Select("select A.*, B.id as PROFILE_IMAGE_ID, B.file_name as PROFILE_IMAGE_NAME from tbl_user as A,tbl_file B where A.file_id = B.id and A.id = #{id}")
    User findWithFileById(Long id);

    //保存图片信息
    int addProfileImage(Long userId, String fileName);
}
