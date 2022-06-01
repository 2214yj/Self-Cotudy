package program;

import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Component
public class MemberDao {

    private Map<String, Member> map = new HashMap<>();

    private String loggedInId;

    public void setLoggedInId(String loggedInId) {
        this.loggedInId = loggedInId;
    }

    public String getLoggedInId() {
        return loggedInId;
    }

    public Member selectById(String id) {
        return map.get(id);
    }

    public void insert(Member member) {
        map.put(member.getId(), member);
    }

    public void update(Member member) {
        map.put(member.getId(), member);
    }

    public Map<String, Member> getMap() {
        return map;
    }

    public Collection<Member> selectAll() {
        return map.values();
    }

    public void delete(Member member) {
        map.remove(member.getId());
    }
}
