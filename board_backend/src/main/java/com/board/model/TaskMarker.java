package com.board.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "task_marker")
public class TaskMarker {
    private Long id;

    private String name;

    @OneToMany(mappedBy = "taskMarker", cascade = CascadeType.ALL)
    private List<Task> tasks;
}
