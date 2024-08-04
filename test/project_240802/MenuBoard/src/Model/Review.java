package Model;

public class Review {
	private int videoNo;
	private int reviewNo;
	private String nickName;
	private String content;

	// Getter & Setter
	public int getVideoNo() {
		return videoNo;
	}

	public void setVideoNo(int videoNo) {
		this.videoNo = videoNo;
	}

	public int getReviewNo() {
		return reviewNo;
	}

	public void setReviewNo(int reviewNo) {
		this.reviewNo = reviewNo;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "Review [videoNo=" + videoNo + ", reviewNo=" + reviewNo + ", nickName=" + nickName + ", content="
				+ content + "]";
	}
}
