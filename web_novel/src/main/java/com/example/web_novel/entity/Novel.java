package com.example.web_novel.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@Entity
@Table(name = "novel")
public class Novel {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false)
  private Long id;

  private String title;

  private String author;

  @OneToMany(fetch = FetchType.EAGER, mappedBy = "novel")
  private List<Content> contentList = new java.util.ArrayList<>();

  public void setContentList(List<Content> contentList) {
    this.contentList = contentList;
  }

}
