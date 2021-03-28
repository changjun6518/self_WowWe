package jpaself.self_WowWe.service;

import jpaself.self_WowWe.domain.Member;
import jpaself.self_WowWe.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    // 회원 가입
    @Transactional
    public Long join(Member member) {
        validateDuplicateMember(member);
        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        //Exception
        List<Member> findEmail = memberRepository.findByEmail(member.getEmail());
        if (!findEmail.isEmpty()) {
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        }
    }

    // 회원 전체 조회
    public List<Member> findMember() {
        return memberRepository.findAll();
    }

    // 한명 조회
    public Member findOne(Long memberId) {
        return memberRepository.findOne(memberId);
    }


}
