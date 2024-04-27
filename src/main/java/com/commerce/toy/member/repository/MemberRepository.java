package com.commerce.toy.member.repository;

import com.commerce.toy.member.entity.Member;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long>, PagingAndSortingRepository<Member, Long> {
    Page<Member> findAll(Pageable pageable);
    Optional<Member> findByMemberLoginId(String memberLoginId);
}
