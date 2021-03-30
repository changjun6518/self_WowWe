package jpaself.self_WowWe.api;


import jpaself.self_WowWe.domain.Member;
import jpaself.self_WowWe.service.MemberService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.xml.transform.Result;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class MemberApiController {

    private final MemberService memberService;

    @GetMapping("/api/v1/members")
    public List<Member> memberV1() {
       return memberService.findMember();
    }

    @GetMapping("/api/v2/members")
    public Result memberV2() {
        List<Member> findMembers = memberService.findMember();
        List<MemberDto> collect = findMembers.stream()
                .map(member -> new MemberDto(member.getEmail(), member.getNickname()))
                .collect(Collectors.toList());
        return new Result(collect);
    }

    // json 구조
    // optional 안되나?
    @Data
    @AllArgsConstructor
    static class Result<T> {
        private T data;
    }

    @Data
    @AllArgsConstructor
    class MemberDto {
        private String email;
        private String nickname;
    }

    @PostMapping("/api/v1/members")
    public CreateMemberResponse saveMemberV1(@RequestBody @Validated Member member) {
        Long joinId = memberService.join(member);
        return new CreateMemberResponse(joinId);
    }

    // creatememberRequest를 만들면서 받아오는 값도 제한 둘 수 있음
    @PostMapping("/api/v2/members")
    public CreateMemberResponse saveMemberV2(@RequestBody @Validated CreateMemberRequest request) {
        Member member = new Member();
        member.setEmail(request.email);
        member.setNickname(request.nickname);

        Long joinId = memberService.join(member);
        return new CreateMemberResponse(joinId);
    }

    @PutMapping("/api/v2/members/{id}")
    public UpdateMemberResponse updateV2(
            @PathVariable("id") Long id,
            @RequestBody @Validated UpdateMemberRequest request) {

        memberService.update(id, request.nickname);
//        return new UpdateMemberResponse(id, request.nickname);
        Member findOne = memberService.findOne(id);
        return new UpdateMemberResponse(findOne.getId(), findOne.getNickname());
    }


    @Data
    static class CreateMemberResponse {
        private Long id;

        public CreateMemberResponse(Long id) {
            this.id = id;
        }
    }

    @Data
    static class CreateMemberRequest {
        private String email;
        private String nickname;
    }

    @Data
    @AllArgsConstructor
    static class UpdateMemberResponse {
        private Long id;
        private String nickname;

    }

    @Data
    static class UpdateMemberRequest {
        private String nickname;
    }
}
