package com.keyin.golfclubapi.service;

import com.keyin.golfclubapi.model.Member;
import com.keyin.golfclubapi.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MemberService {

    @Autowired
    private MemberRepository memberRepository;

    public Member saveMember(Member member) {
        return memberRepository.save(member);
    }

    public List<Member> getAllMembers() {
        return memberRepository.findAll();
    }

    public Optional<Member> getMemberById(Long id) {
        return memberRepository.findById(id);
    }

    public void deleteMemberById(Long id) {
        if (memberRepository.existsById(id)) {
            memberRepository.deleteById(id);
        } else {
            throw new IllegalArgumentException("Member with ID " + id + " does not exist.");
        }
    }

    public List<Member> searchMembersByName(String name) {
        return memberRepository.findByNameContainingIgnoreCase(name);
    }
}