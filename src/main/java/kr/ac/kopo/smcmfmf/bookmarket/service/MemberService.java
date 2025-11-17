package kr.ac.kopo.smcmfmf.bookmarket.service;

import jakarta.transaction.Transactional;
import kr.ac.kopo.smcmfmf.bookmarket.domain.Member;
import kr.ac.kopo.smcmfmf.bookmarket.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@Transactional
@RequiredArgsConstructor
public class MemberService implements UserDetailsService {
    private final MemberRepository memberRepository;

//회원 정보 저장
    public Member saveMember(Member member) {
        validateDuplicateMember(member);
        return memberRepository.save(member);
    }
// 특정 멤버 ID를 가진 member entity만 반환
    public Member getMemberByMemberId(String memberId) {
        return memberRepository.findByMemberId(memberId);
    }

// 회원정보 삭제

    public void deleteMember(String memberId) {
    Member member = memberRepository.findByMemberId(memberId);
    memberRepository.deleteById(member.getNum());
    }


    private void validateDuplicateMember(Member member) {
        Member findMember = memberRepository.findByMemberId(member.getMemberId());
        if (findMember != null){
            throw new IllegalStateException("duplicated member found");
        }
    }

    @Override
    public UserDetails loadUserByUsername(String memberId) throws UsernameNotFoundException {
        Member member = memberRepository.findByMemberId(memberId);
        if (member != null) {
            throw new UsernameNotFoundException("user not found");
        }
        UserDetails userDetails =User.builder()
                .username(member.getMemberId())
                .password(member.getPassword())
                .roles(member.getRole().toString())
                .build();
        return userDetails;
    }
}
