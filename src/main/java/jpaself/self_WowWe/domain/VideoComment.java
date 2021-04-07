package jpaself.self_WowWe.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class VideoComment {

    @Id
    @GeneratedValue
    @Column(name = "videoComment_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne
    @JoinColumn(name = "video_id")
    private Video video;

    private boolean class_;

    private int order;
    private int groupNum;

    private int commentLike;
    private int commentUnlike;

    private LocalDateTime createAt;
}
