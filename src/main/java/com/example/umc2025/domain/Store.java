package com.example.umc2025.domain;


import com.example.umc2025.domain.enums.StoreOperationState;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@EqualsAndHashCode(of = "id", callSuper = false)
public class Store {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 20, nullable = false)
    private String storeName;

    @Column(length = 10)
    private String location;

    @OneToMany(mappedBy = "store", cascade = CascadeType.ALL)
    private List<Mission> missionList = new ArrayList<>();

    @OneToMany(mappedBy = "store", cascade = CascadeType.ALL)
    private List<Question> questionList = new ArrayList<>();

    @Column(name = "avg_rating")
    private Float avgRating;

    @OneToMany(mappedBy = "store", cascade = CascadeType.ALL)
    private List<Rating> ratingList = new ArrayList<>();

    @Column(length = 10)
    private String storeType;

    @Column(length = 10)
    @Enumerated(EnumType.STRING)
    private StoreOperationState operationState;

    private LocalTime operationTime;

    @Override
    public String toString() {
        return "Store{" +
                "id=" + id +
                ", name='" + storeName + '\'' +
                ", address='" + location + '\'' +
                ", score=" + avgRating +
                '}';
    }

    public float setAvgRating() {
        return (float) ratingList.stream()
                .mapToDouble(Rating::getRate) // rate 값만 추출
                .average()                    // 평균 계산
                .orElse(0.0);
    }
}
