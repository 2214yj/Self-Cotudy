package dao;


import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import spring.Info;
import spring.LoginInfo;
import spring.UserInfo;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class MemberDao {
    private JdbcTemplate jdbcTemplate;
    private RowMapper<UserInfo> memRowMapper =
            new RowMapper<UserInfo>() {
                @Override
                public UserInfo mapRow(ResultSet rs, int rowNum)
                        throws SQLException {
                    UserInfo userInfo = new UserInfo(rs.getString("ID"),
                            rs.getString("PASSWORD"),
                            rs.getString("ADDRESS"),
                            rs.getString("EMAIL"),
                            rs.getString("PHONE"),
                            rs.getString("BIRTHDAY"));
                    return userInfo;
                }
            };

    public MemberDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }


    public UserInfo selectById(String userId) {
        String SQL = "select * from Member where id = ?";
        List<UserInfo> users = jdbcTemplate.query(SQL, memRowMapper, userId);
        return users.isEmpty() ? null : users.get(0);
    }

    public int delete(LoginInfo loginInfo) {
        String SQL = "delete from member where id = ?";
        return jdbcTemplate.update(SQL, loginInfo.getUserid());
    }

    public int modify(String userid, Info info) {
        String SQL = "update member set address = ?, email = ?, phone = ?, birthday = ? where id = ?";
        Object[] params = new Object[]{info.getAddr(), info.getEmail(), info.getTel(), info.getBirthday(), userid};
        return jdbcTemplate.update(SQL, params);
    }

    public int insert(UserInfo userInfo) {
        String SQL = "insert into member(id,email,address,phone,password,birthday) values(?,?,?,?,?,?)";
        Object[] params = new Object[]{userInfo.getUserid(),userInfo.getEmail(),userInfo.getAddr(),
                userInfo.getTel(),userInfo.getPwd(),userInfo.getBirthday()};
        return jdbcTemplate.update(SQL,params);
    }
}
