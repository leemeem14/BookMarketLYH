package kr.ac.kopo.smcmfmf.bookmarket;

import kr.ac.kopo.smcmfmf.bookmarket.domain.Member;
import kr.ac.kopo.smcmfmf.bookmarket.domain.Role;
import kr.ac.kopo.smcmfmf.bookmarket.service.MemberService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class BookMarketApplication {

    public static void main(String[] args) {
        SpringApplication.run(BookMarketApplication.class, args);
    }

//    public CommandLineRunner run(MemberService memberService) throws Exception {
//        return (String[] args) -> {
//            Member member = new Member();
//
//            member.setMemberId("admin12");
//            member.setName("관리자");
//            member.setPhone("");
//            member.setEmail("");
//            member.setAddress("");
//            String password = new BCryptPasswordEncoder().encode("12345678");
//            member.setPassword(password);
//            member.setRole(Role.ADMIN);
//
//            memberService.saveMember(member);
//
//        };
//    }

}
