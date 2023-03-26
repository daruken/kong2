package com.h2.kong2.yogurt.domain;

import com.h2.kong2.yogurt.domain.dto.QYogurtDto;
import com.h2.kong2.yogurt.domain.dto.YogurtDto;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.List;

import static com.h2.kong2.yogurt.domain.QYogurt.yogurt;

public class YogurtRepositoryCustomImpl implements YogurtRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    public YogurtRepositoryCustomImpl(JPAQueryFactory queryFactory) {
        this.queryFactory = queryFactory;
    }

    @Override
    public Page<YogurtDto> findYogurtByCondition(Pageable pageable, String condition) {
        List<YogurtDto> content = queryFactory.select(new QYogurtDto(
                        yogurt.id,
                        yogurt.name,
                        yogurt.price
                ))
                .from(yogurt)
                .where(yogurt.name.contains(condition))
                .fetch();

        Long totalCount = queryFactory.select(yogurt.count())
                .from(yogurt)
                .fetchOne();
        if (totalCount == null) {
            totalCount = 0L;
        }

        return new PageImpl<>(content, pageable, totalCount);
    }
}
