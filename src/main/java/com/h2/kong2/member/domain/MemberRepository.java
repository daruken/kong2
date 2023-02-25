package com.h2.kong2.member.domain;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long>, CustomMemberRepository {
    Member getMemberByName(String name);
}
