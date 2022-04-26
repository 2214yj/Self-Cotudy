package program;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Map;
import java.util.Scanner;

public class Main {
    private static ApplicationContext ctx = null;
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        ctx = new AnnotationConfigApplicationContext(AppContext.class);
        MemberService memberService = ctx.getBean(MemberService.class);

        int num;

        while (true) {
            System.out.println("다음 기능을 사용 가능합니다.");
            System.out.println("1. 회원가입   2. 로그인   3. 암호 재설정   4. 암호 변경   5. 회원정보 조회   6. 회원정보 수정   7. 회원 탈퇴   8. 프로그램 종료");
            System.out.print("사용할 기능의 번호를 입력하세요: ");
            num = sc.nextInt();

            if (num == 8) {   //프로그램 종료
                System.out.println("프로그램을 종료합니다.");
                break;
            }

            switch (num) {
                case 1: //회원가입
                    registerNewMember(memberService);
                    break;

                case 2: //로그인
                    login(memberService);
                    break;

                case 3: //암호 재설정
                    resetPassword(memberService);
                    break;

                case 4: //암호 변경
                    modifyPassword(memberService);
                    break;

                case 5: //회원정보 조회
                    printMember();
                    break;

                case 6: //회원정보 수정
                    modifyMemberInfo(memberService);
                    break;

                case 7: //회원 탈퇴
                    deleteMember(memberService);
                    break;

                default:
                    System.out.println("1~8 사이의 숫자를 입력해주세요.");
                    break;

            }

        }


        MemberDao memberDao = (MemberDao) ctx.getBean("MemberDao.class");
        Map<String, Member> map2 = memberDao.getMap();
        for (Map.Entry<String, Member> entrySet : map2.entrySet()) {
            System.out.println(entrySet.getKey() + " : " + entrySet.getValue().getPassword());
        }


    }

    private static void registerNewMember(MemberService memberService) {
        Validator validator = ctx.getBean(Validator.class);

        System.out.println("---------- 회원가입 ----------");
        RegisterRequest req = new RegisterRequest();
        System.out.print("이름: ");
        req.setName(sc.next());
        System.out.print("전화번호: ");
        String str = sc.next();
        if (validator.validateHP(str)) {
            req.setHp(str);
        } else {
            System.out.println("HP는 xxx-xxxx-xxxx 형태여야 합니다.\n");
            return;
        }
        System.out.print("이메일: ");
        str = sc.next();
        if (validator.validateEmail(str)) {
            req.setEmail(str);
        } else {
            System.out.println("email은 xxx@xxx.xxx 형태여야 합니다.\n");
            return;
        }
        System.out.print("아이디: ");
        str = sc.next();
        if (validator.validateId(str)) {
            req.setId(str);
        } else {
            System.out.println("id의 길이는 4 이상, 8 이하만 가능합니다. 또한 영어와 숫자 및 특수기호(._!@#$%^&*())만 사용 가능합니다.\n");
            return;
        }
        System.out.print("비밀번호: ");
        req.setPassword(sc.next());
        System.out.print("비밀번호 재확인: ");
        req.setConfirmPassword(sc.next());

        if (!req.isPasswordEqualToConfirmPassword()) {
            System.out.println("비밀번호와 비밀번호 확인이 일치하지 않습니다.\n");
            return;
        }

        try {
            memberService.register(req);
            System.out.println("등록했습니다.\n");
        } catch (DuplicateMemberException e) {
            System.out.println("이미 존재하는 이메일입니다.\n");
        }
    }

    private static String login(MemberService memberService) {

        System.out.println("---------- 로그인 ----------");
        System.out.print("id: ");
        String id = sc.next();
        System.out.print("password: ");
        String password = sc.next();

        try {
            memberService.login(id, password);
            System.out.println("로그인에 성공했습니다.\n");
            return id;
        } catch (WrongIdPasswordException | MemberNotFoundException e) {
            System.out.println("로그인에 실패했습니다.\n");
            return null;
        }
    }

    private static void resetPassword(MemberService memberService) {

        System.out.println("---------- 암호 재설정 ----------");
        System.out.print("id: ");
        String id = sc.next();
        System.out.print("이름: ");
        String name = sc.next();
        System.out.print("이메일: ");
        String email = sc.next();

        try {
            String oldPassword = memberService.resetPassword(id, name, email);
            System.out.println("사용자 정보가 일치합니다. 비밀번호를 재설정할 수 있습니다.");
            System.out.print("새 비밀번호를 입력해주세요: ");
            String newPassword = sc.next();
            memberService.changePassword(id, oldPassword, newPassword);
            System.out.println("비밀번호가 재설정되었습니다.\n");
        } catch (MemberNotFoundException e) {
            System.out.println("암호를 재설정할 수 없습니다.\n");
        }
    }

    private static void modifyPassword(MemberService memberService) {

        System.out.println("---------- 암호 변경 ----------");
        System.out.print("id: ");
        String id = sc.next();
        System.out.print("password: ");
        String oldPassword = sc.next();
        System.out.print("new password: ");
        String newPassword = sc.next();
        try {
            memberService.changePassword(id, oldPassword, newPassword);
            System.out.println("암호가 변경되었습니다.\n");
        } catch (MemberNotFoundException e) {
            System.out.println("암호를 변경할 수 없습니다.\n");
        }
    }

    private static void printMember() {
        System.out.println("---------- 회원정보 조회 ----------");
        System.out.println("특정 회원정보 조회는 1, 전체 회원정보 조회는 2를 입력하십시오.");
        int n = sc.nextInt();
        if (n == 1) {
            printMemberInfo();
        } else if (n == 2) {
            printMemberList();
        } else {
            System.out.println("회원정보 조회에 실패했습니다. \n");
        }
    }

    private static void printMemberInfo() {
        System.out.print("조회할 회원의 id를 입력하세요: ");
        String id = sc.next();
        try {
            MemberInfoPrinter infoPrinter = ctx.getBean("infoPrinter", MemberInfoPrinter.class);
            infoPrinter.printMemberInfo(id);
            System.out.println("회원정보 조회를 종료합니다. \n");
        } catch (MemberNotFoundException e) {
            System.out.println("해당 id를 갖는 회원이 존재하지 않습니다. \n");
        }
    }

    private static void printMemberList() {
        try {
            MemberListPrinter listPrinter = ctx.getBean("listPrinter", MemberListPrinter.class);
            listPrinter.printMemberList();
            System.out.println("전체 회원정보 조회를 종료합니다. \n");
        } catch (MemberNotFoundException e) {
            System.out.println("회원이 존재하지 않습니다. \n");
        }
    }

    private static void modifyMemberInfo(MemberService memberService) {
        Validator validator = ctx.getBean(Validator.class);

        System.out.println("---------- 회원정보 수정 ----------");
        RegisterRequest req = new RegisterRequest();

        if (memberService.getLoggedInId() == null) {
            System.out.println("로그인 후에 회원정보를 수정할 수 있습니다.");
            String id = login(memberService);
            if (id == null) {
                System.out.println("로그인 실패로 회원정보를 수정할 수 없습니다.");
                return;
            }
        }

        req.setId(memberService.getLoggedInId());
        sc.nextLine();
        System.out.print("이름: ");
        req.setName(sc.nextLine());
        System.out.print("전화번호: ");
        String str = sc.nextLine();
        if (str.isBlank() || validator.validateHP(str)) {
            req.setHp(str);
        } else {
            System.out.println("HP는 xxx-xxxx-xxxx 형태여야 합니다.\n");
            return;
        }
        System.out.print("이메일: ");
        str = sc.nextLine();
        if (str.isBlank() || validator.validateEmail(str)) {
            req.setEmail(str);
        } else {
            System.out.println("email은 xxx@xxx.xxx 형태여야 합니다.\n");
            return;
        }

        try {
            memberService.changeMemberInfo(req);
            System.out.println("회원정보 수정이 완료되었습니다.\n");
        } catch (MemberNotFoundException e) {
            System.out.println("회원정보 수정에 실패했습니다.\n");
        }
    }

    private static void deleteMember(MemberService memberService) {
        System.out.println("---------- 회원탈퇴 ----------");

        if (memberService.getLoggedInId() == null) {
            System.out.println("로그인 후에 회원탈퇴를 할 수 있습니다.");
            String id = login(memberService);
            if (id == null) {
                System.out.println("로그인 실패로 회원탈퇴를 할 수 없습니다.");
                return;
            }
        }

        try {
            memberService.deleteMemberInfo(memberService.getLoggedInId());
            System.out.println("회원탈퇴가 완료되었습니다.");
        } catch (MemberNotFoundException e) {
            System.out.println("회원탈퇴에 실패했습니다.");
        }


    }

}
