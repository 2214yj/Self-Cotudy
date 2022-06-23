package dao;

import org.springframework.jdbc.core.JdbcTemplate;
import spring.DateFormatException;
import spring.DetailProduct;
import spring.SearchBuyingProductDto;
import spring.SearchProductDto;

import javax.sql.DataSource;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

public class SearchDao {

    private JdbcTemplate jdbcTemplate;

    public SearchDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public List<SearchProductDto> selectByProduct(String keyword, String option, String column) {
        String SQL = "select id, name, price, category from product where name like ? order by " + column + " " + option;
        List<SearchProductDto> result = jdbcTemplate.query(SQL,
                (rs, rowNum) -> new SearchProductDto(
                        rs.getInt("id"),
                        rs.getString("category"),
                        rs.getString("name"),
                        rs.getInt("price")), '%' + keyword + '%');

        return result;
    }

    public DetailProduct selectById(int id) {
        String SQL = "select * from product where id = ?";
        List<DetailProduct> result = jdbcTemplate.query(SQL,
                (rs, rowNum) -> new DetailProduct(
                        rs.getInt("id"),
                        rs.getString("category"),
                        rs.getString("name"),
                        rs.getInt("price"),
                        rs.getInt("buying_count"),
                        rs.getString("photo"),
                        rs.getString("reg_time")
                ), id);
        return result.isEmpty() ? null : result.get(0);
    }

    public int newBuying(int id, int userid) {
        String SQL = "insert into mem_prod(prod_id,mem_id,reg_time) values(?,?,?)";
        Object[] params = new Object[]{id, userid, LocalDate.now()};
        int result = jdbcTemplate.update(SQL, params);
        return result;
    }

    public int updateBuyingCount(int id) {
        String SQL = "update product set buying_count = buying_count+1 where id = ?";
        int result = jdbcTemplate.update(SQL, id);
        return result;
    }

    public int selectBymemId(String userid) {
        String SQL = "select memid from member where id=?";
        return jdbcTemplate.queryForObject(SQL, int.class, userid);
    }

    public List<SearchProductDto> selectAllProduct(String option, String column) {
        String SQL = "select id, name, price, category from product order by " + column + " " + option;
        List<SearchProductDto> result = jdbcTemplate.query(SQL,
                (rs, rowNum) -> new SearchProductDto(
                        rs.getInt("id"),
                        rs.getString("category"),
                        rs.getString("name"),
                        rs.getInt("price")));

        return result;
    }

    public List<SearchBuyingProductDto> selectBuyList(String keyword, String option, String column, String startDate, String endDate, String userId) {
        String SQL = "select memid from Member where id = ?";
        int id = jdbcTemplate.queryForObject(SQL,int.class, userId);
        if (Objects.equals(startDate, "") && (Objects.equals(endDate, ""))) {
            SQL = "select p.id, p.name, p.price, p.category, mp.reg_time from product p join mem_prod mp on p.id = mp.prod_id where mp.mem_id = ? and p.name like ? order by " + column + " " + option;
            Object[] params = new Object[]{id,'%' + keyword + '%'};
            List<SearchBuyingProductDto> result = jdbcTemplate.query(SQL,
                    (rs, rowNum) -> new SearchBuyingProductDto(
                            rs.getInt("id"),
                            rs.getString("category"),
                            rs.getString("name"),
                            rs.getInt("price"),
                            rs.getDate("reg_time")), params);
            return result;
        } else {
            SQL = "select p.id, p.name, p.price, p.category, mp.reg_time from product p join mem_prod mp on p.id = mp.prod_id where mp.mem_id = ? and p.name like ? and date(mp.reg_time) between ? and ? order by " + column + " " + option;
            Object[] params = new Object[]{id,'%' + keyword + '%', startDate, endDate};
            List<SearchBuyingProductDto> result = jdbcTemplate.query(SQL,
                    (rs, rowNum) -> new SearchBuyingProductDto(
                            rs.getInt("id"),
                            rs.getString("category"),
                            rs.getString("name"),
                            rs.getInt("price"),
                            rs.getDate("reg_time")), params);
            return result;
        }
    }
}
