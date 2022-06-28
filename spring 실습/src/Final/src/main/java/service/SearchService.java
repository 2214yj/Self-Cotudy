package service;

import dao.MemberDao;
import dao.SearchDao;
import spring.*;

import java.util.List;

public class SearchService {

    private SearchDao searchDao;
    private MemberDao memberDao;

    public SearchService(SearchDao searchDao, MemberDao memberDao) {
        this.searchDao = searchDao;
        this.memberDao = memberDao;
    }

    public List<SearchProductDto> searchProduct(String keyword, String option, String column) {
        try {
            List<SearchProductDto> result = searchDao.selectByProduct(keyword, option, column);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            throw new DatabaseException("검색 오류");
        }
    }

    public DetailProduct searchDetailProduct(int id) {
        try {
            DetailProduct result = searchDao.selectById(id);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            throw new DatabaseException("상세 검색 오류");
        }
    }

    public void buyProduct(int id, String userid) {
        try {
            int user = searchDao.selectBymemId(userid);
            int count1 = searchDao.newBuying(id, user);
            int count2 = searchDao.updateBuyingCount(id);
            if ((count1 == 0) || (count2 == 0))
                throw new DatabaseException("상품 구매 동작 중 오류");
        } catch (Exception e) {
            e.printStackTrace();
            throw new DatabaseException("상품 구매 오류");
        }
    }

    public List<SearchProductDto> searchAllProduct(String option, String column) {
        try {
            List<SearchProductDto> result = searchDao.selectAllProduct(option, column);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            throw new DatabaseException("전체 조회 오류");
        }
    }

    public List<SearchBuyingProductDto> searchBuyList(String keyword, String option, String column, String startDate, String endDate,String userId) {
        try {
            List<SearchBuyingProductDto> result = searchDao.selectBuyList(keyword, option, column, startDate, endDate, userId);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            throw new DatabaseException("전체 조회 오류");
        }
    }
}
