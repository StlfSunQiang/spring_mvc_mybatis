package com.sust.spring.domain;

import java.util.Date;
import java.util.List;

/**
 * 任务类
 */
public class Task {

    private Long id;
    // @Pattern(regexp = "w{2,6}")
    //@NotEmpty
    // @Length(min = 2, max = 6)
    private String name;
    private int priority; // 优先权
    private String status; //任务状态
    private User createdBy;  //创建者
    private Date createdDate;  //创建时间
    private User assignee;  //分配者
    private Date completedDate;  //完成时间
    private String comments; //评论

    public Task() {
    }

    public Task(String name, int priority, String status, User createdBy, Date createdDate, User assignee,
                String comments) {
        super();
        this.name = name;
        this.priority = priority;
        this.status = status;
        this.createdBy = createdBy;
        this.createdDate = createdDate;
        this.assignee = assignee;
        this.comments = comments;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public User getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(User createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public User getAssignee() {
        return assignee;
    }

    public void setAssignee(User assignee) {
        this.assignee = assignee;
    }

    public Date getCompletedDate() {
        return completedDate;
    }

    public void setCompletedDate(Date completedDate) {
        this.completedDate = completedDate;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }


    @Override
    public String toString() {
        return "Task [id=" + id + ", name=" + name + ", priority=" + priority + ", status=" + status + ", createdBy="
                + createdBy + ", createdDate=" + createdDate + ", assignee=" + assignee + ", completedDate="
                + completedDate + ", comments=" + comments + "]";
    }

}
