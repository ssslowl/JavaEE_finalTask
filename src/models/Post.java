package models;

public class Post {
    private Integer id;
    private String post_date;
    private Integer category_id;
    private String title;
    private String content;
    private String categoryName;


    public Post(Integer id, String post_date, Integer category_id, String title, String content) {
        this.id = id;
        this.post_date = post_date;
        this.category_id = category_id;
        this.title = title;
        this.content = content;
    }

    public Post() {
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPost_date() {
        return post_date;
    }

    public void setPost_date(String post_date) {
        this.post_date = post_date;
    }

    public Integer getCategory_id() {
        return category_id;
    }

    public void setCategory_id(Integer category_id) {
        this.category_id = category_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }


    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", post_date='" + post_date + '\'' +
                ", category_id=" + category_id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", categoryName='" + categoryName + '\'' +
                '}';
    }
}
