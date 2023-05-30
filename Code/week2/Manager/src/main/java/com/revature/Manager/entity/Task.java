package com.revature.Manager.entity;

import jakarta.persistence.*;


@Entity
@Table(name = "tasks")
public class Task {
    @Id
    @SequenceGenerator(name = "tasks_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tasks_id_seq")
    private Long id;
    @Column(name = "task_name", nullable = false)
    private String taskName;
    @Column(name = "description", nullable = false)
    private String description;
    @Column(name = "due_date", nullable = false)
    private String dueDate;
    @Column(name = "status", nullable = false)
    private String status;

    @PrimaryKeyJoinColumn(name = "user_id")
    private Long userId;

    public Task() {
    }

    public Task(String taskName, String description, String dueDate, String status, Long userId) {
        this.taskName = taskName;
        this.description = description;
        this.dueDate = dueDate;
        this.status = status;
        this.userId = userId;
    }




    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", taskName='" + taskName + '\'' +
                ", description='" + description + '\'' +
                ", dueDate='" + dueDate + '\'' +
                ", status='" + status + '\'' +
                '}';
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
