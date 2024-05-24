package com.prjj.prj2spring20240521.mapper.member;

import com.prjj.prj2spring20240521.domain.member.Member;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface MemberMapper {

    @Insert("""
            INSERT INTO member (email, password, member_id)
            VALUES (#{email}, #{password}, #{memberId})
            """)
    public int insert(Member member);

    @Select("""
            SELECT*
            FROM member
            WHERE email = #{email}
            """)
    Member selectByEmail(String email);

    @Select("""
            SELECT*
            FROM member
            WHERE nick_name = #{nickName}
            """)
    Member selectByNickName(String nickName);

    @Select("""
            SELECT id, email, nick_name, inserted
            FROM member
            ORDER BY id DESC
            """)
    List<Member> selectList();

    @Select("""
            SELECT id, email, nick_name, inserted, password
            FROM member
            WHERE id = #{id}
            """)
    Member selectById(Integer id);


    @Delete("""
            DELETE FROM member
            WHERE id = #{id}
            """)
    void deleteById(Integer id);

    @Update("""
            UPDATE member 
            SET
                password = #{password},
                nick_name = #{nickName}
            WHERE id = #{id}
            """)
    int update(Member member);
}
