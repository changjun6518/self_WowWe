package jpaself.self_WowWe.domain;

import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
public class VideoLike {
    @Id
    @GeneratedValue
    @Column(name = "videoLike_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "video_id")
    private Video video;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;
}
