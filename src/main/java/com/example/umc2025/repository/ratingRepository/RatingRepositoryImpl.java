package com.example.umc2025.repository.ratingRepository;

import com.example.umc2025.domain.QRating;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;


@Repository
@RequiredArgsConstructor
public class RatingRepositoryImpl implements RatingRepositoryCustom {

    private final JPAQueryFactory jpaQueryFactory;
    private final QRating rating = QRating.rating;

}
