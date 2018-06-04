package Teachium.Teachium.domain;

public class Message {
  private String title;
  private String text;

  public Message(String title, String text) {
    // TODO Auto-generated constructor stub
    this.title = title;
    this.text = text;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }

}

