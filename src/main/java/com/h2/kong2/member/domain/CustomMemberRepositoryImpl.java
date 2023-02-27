package com.h2.kong2.member.domain;

import com.h2.kong2.member.domain.dto.MemberDto;
import com.h2.kong2.member.domain.dto.QMemberDto;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.List;

import static com.h2.kong2.member.domain.QMember.member;

public class CustomMemberRepositoryImpl implements CustomMemberRepository {
    private final JPAQueryFactory queryFactory;

    public CustomMemberRepositoryImpl(JPAQueryFactory queryFactory) {
        this.queryFactory = queryFactory;
    }

    @Override
    public Page<MemberDto> findAllMembers(Pageable pageable) {
        List<MemberDto> content = queryFactory.select(new QMemberDto(
                                member.id,
                                member.name,
                                member.email,
                                member.createdDate,
                                member.updatedDate
                        )
                ).from(member)
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();

        Long totalCount = queryFactory.select(member.count())
                .from(member)
                .fetchOne();
        if (totalCount == null) {
            totalCount = 0L;
        }

        return new PageImpl<>(content, pageable, totalCount);
    }

    @Override
    public boolean existsByName(String name) {
        return queryFactory.selectOne()
                .from(member)
                .where(member.name.eq(name))
                .fetchFirst() != null;
    }
}
