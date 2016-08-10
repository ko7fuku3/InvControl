package jp.koshiro.entry;

import java.io.Serializable;

public class User implements Serializable{

	private String mbid;
	private String name;
	private String phonetic;
	private String sex;
	private String password;

	public User() {}

	public User(String mbid, String name, String phonetic, String sex, String password) {

		this.mbid = mbid;
		this.name = name;
		this.phonetic = phonetic;
		this.sex = sex;
		this.password = password;

	}

	public String getMbid() {
		return mbid;
	}

	public String getName() {
		return name;
	}

	public String getPhonetic() {
		return phonetic;
	}

	public String getSex() {
		return sex;
	}

	public String getPassword() {
		return password;
	}

}
