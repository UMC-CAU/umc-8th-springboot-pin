package com.example.umc2025.domain;


import com.example.umc2025.domain.common.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@EqualsAndHashCode(of = "id", callSuper = false)
public class Rating extends BaseEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Integer rate;

    @Column(length = 200)
    private String ratingContent;

//    @ManyToOne(fetch = FetchType.LAZY)
//    private Rating rating;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id", nullable = false)
    private Member member;

    @JoinColumn(name = "store_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Store store;

    public void setStore(Store store) {
        if (this.store != null) {
            store.getRatingList().remove(this);
        }
        this.store = store;
        store.getRatingList().add(this);
        store.setAvgRating();
    }

    public void setMember(Member member) {
        if (this.member != null) {
            member.getRatingList().remove(this);
        }
        this.member = member;
        member.getRatingList().add(this);

    }
}
