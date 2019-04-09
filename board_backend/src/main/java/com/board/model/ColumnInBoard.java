package com.board.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Max;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "column_in_board")
public class ColumnInBoard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Max(15)
    private Integer number;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "board_id")
    private Board board;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "column_status_id")
    private ColumnStatus columnStatus;

    @OneToMany(mappedBy = "columnInBoard", cascade = CascadeType.ALL)
    private List<Task> tasks;
}
