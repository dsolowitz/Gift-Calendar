package com.teamnorth.data;

import javax.persistence.*;

@Entity
@Table(name = "QUESTIONNAIRE")
public class Questionnaire {

	@SuppressWarnings("unused")
	private Questionnaire() {
	}

	public Questionnaire(Long id, String name, String gender, String age, String hobbies, String motivation, String pricing,
			String category, String holiday, String webPreference, String customized, int daysInAdvance) {
		super();
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.age = age;
		this.hobbies = hobbies;
		this.motivation = motivation;
		this.pricing = pricing;
		this.category = category;
		this.holiday = holiday;
		this.webPreference = webPreference;
		this.customized = customized;
		this.daysInAdvance = daysInAdvance;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "id", updatable = false, nullable = false)
	private Long id;

//	@OneToOne
//	@JoinColumn(name = "users")
//	private User user;
	
	@Column
	private String name;

	@Column
	private String gender;

	@Column
	private String age;

	@Column
	private String hobbies;

	@Column
	private String motivation;

	@Column
	private String pricing;

	@Column
	private String category;

	@Column
	private String holiday;

	@Column
	private String webPreference;

	@Column
	private String customized;
	
	@Column
	private int daysInAdvance;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getHobbies() {
		return hobbies;
	}

	public void setHobbies(String hobbies) {
		this.hobbies = hobbies;
	}

	public String getMotivation() {
		return motivation;
	}

	public void setMotivation(String motivation) {
		this.motivation = motivation;
	}

	public String getPricing() {
		return pricing;
	}

	public void setPricing(String pricing) {
		this.pricing = pricing;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getHoliday() {
		return holiday;
	}

	public void setHoliday(String holiday) {
		this.holiday = holiday;
	}

	public String getWebPreference() {
		return webPreference;
	}

	public void setWebPreference(String webPreference) {
		this.webPreference = webPreference;
	}

	public String getCustomized() {
		return customized;
	}

	public void setCustomized(String customized) {
		this.customized = customized;
	}
	
	public int getDaysInAdvance() {
		return this.daysInAdvance;
	}
	
	public void setDaysInAdvance(int daysInAdvance) {
		this.daysInAdvance = daysInAdvance;
	}
	
	@Override
	public String toString() {
		return "Questionnaire [id=" + id + ", gender=" + gender + ", age=" + age + ", hobbies="
				+ hobbies + ", motivation=" + motivation + ", pricing=" + pricing + ", category=" + category
				+ ", holiday=" + holiday + ", webPreference=" + webPreference + ", customized=" + customized + "]";
	}

}