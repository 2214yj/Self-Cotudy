package Spring;

import controller.SearchRequest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class MemberDao {
    private JdbcTemplate jdbcTemplate;

    public MemberDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public Member selectByEmail(String email) {
        List<Member> results = jdbcTemplate.query(
                "select * from MEMBER where EMAIL = ?",
                new RowMapper<Member>() {
                    @Override
                    public Member mapRow(ResultSet rs, int rowNum) throws SQLException {
                        Member member = new Member(
                                rs.getString("ID"),
                                rs.getString("NAME"),
                                rs.getString("EMAIL"),
                                rs.getString("ADDRESS"),
                                rs.getString("PHONE"));
                        return member;
                    }
                }, email);
        return results.isEmpty() ? null : results.get(0);
    }

    public void insert(Member member) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection con)
                    throws SQLException {
                // 파라미터로 전달받은 Connection을 이용해서 PreparedStatement 생성
                PreparedStatement pstmt = con.prepareStatement(
                        "insert into MEMBER (ID,NAME,EMAIL,ADDRESS,PHONE) " +
                                "values (?, ?, ?, ?, ?)",
                        new String[]{"ID"});
                // 인덱스 파라미터 값 설정
                pstmt.setString(1,member.getId());
                pstmt.setString(2,member.getName());
                pstmt.setString(3, member.getEmail());
                pstmt.setString(4, member.getAddress());
                pstmt.setString(5, member.getHp());
                // 생성한 PreparedStatement 객체 리턴
                return pstmt;
            }
        }, keyHolder);
        Number keyValue = keyHolder.getKey();
        member.setId(String.valueOf(keyValue));
    }

    public Member selectById(String id) {
        List<Member> results = jdbcTemplate.query(
                "select * from MEMBER where ID = ?",
                new RowMapper<Member>() {
                    @Override
                    public Member mapRow(ResultSet rs, int rowNum) throws SQLException {
                        Member member = new Member(
                                rs.getString("ID"),
                                rs.getString("NAME"),
                                rs.getString("EMAIL"),
                                rs.getString("ADDRESS"),
                                rs.getString("PHONE"));
                        return member;
                    }
                }, id);
        return results.isEmpty() ? null : results.get(0);
    }

    public Member selectByHp(String hp) {
        List<Member> results = jdbcTemplate.query(
                "select * from MEMBER where PHONE = ?",
                new RowMapper<Member>() {
                    @Override
                    public Member mapRow(ResultSet rs, int rowNum) throws SQLException {
                        Member member = new Member(
                                rs.getString("ID"),
                                rs.getString("NAME"),
                                rs.getString("EMAIL"),
                                rs.getString("ADDRESS"),
                                rs.getString("PHONE"));
                        return member;
                    }
                }, hp);
        return results.isEmpty() ? null : results.get(0);
    }

    public Member selectByRequest(SearchRequest request) {
        System.out.println(request.getKey());
        System.out.println(request.getKeyword());
        String sql;
        if(request.getKey().equals("id")){
            sql = "select * from MEMBER where ID = ?";
        }else if(request.getKey().equals("email")){
            sql = "select * from MEMBER where EMAIL = ?";
        }else{
            sql = "select * from MEMBER where PHONE = ?";
        }
        List<Member> results = jdbcTemplate.query(
                sql,
                new RowMapper<Member>() {
                    @Override
                    public Member mapRow(ResultSet rs, int rowNum) throws SQLException {
                        Member member = new Member(
                                rs.getString("ID"),
                                rs.getString("NAME"),
                                rs.getString("EMAIL"),
                                rs.getString("ADDRESS"),
                                rs.getString("PHONE"));
                        return member;
                    }
                }, request.getKeyword());
        return results.isEmpty() ? null : results.get(0);
    }
}
