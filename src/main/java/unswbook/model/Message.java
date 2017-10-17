package unswbook.model;

public class Message {

	//User
	private Integer userid;
	private String username;
	//Message
	private Integer id;
	private String photo;
	private String text;
	private String image;
	private String time;
	//Like
	private Integer likes;
	private Integer isliked;
	//bully words
	private String bullywords;
	public Integer getId() {
		return id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public Integer getLikes() {
		return likes;
	}
	public void setLikes(Integer likes) {
		this.likes = likes;
	}
	public Integer getIsliked() {
		return isliked;
	}
	public void setIsliked(Integer isliked) {
		this.isliked = isliked;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getUserid() {
		return userid;
	}
	public void setUserid(Integer userid) {
		this.userid = userid;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getBullywords() {
		return bullywords;
	}
	public void setBullywords(String bullywords) {
		this.bullywords = bullywords;
	}
}
