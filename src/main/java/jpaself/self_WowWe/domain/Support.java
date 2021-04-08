package jpaself.self_WowWe.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Support {

    @Id
    @GeneratedValue
    @Column(name = "support_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne
    @JoinColumn(name = "video_id")
    private Video video;

    private int price;

    private LocalDateTime createAt;
}
