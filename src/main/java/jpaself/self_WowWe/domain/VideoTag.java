package jpaself.self_WowWe.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class VideoTag {

    @Id
    @GeneratedValue
    @Column(name = "video_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "video_id")
    private Video video;

    @Enumerated(EnumType.STRING)
    private Tag tag;

}
