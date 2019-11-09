package com.teamnorth.data;
import javax.persistence.*;
public class Questionnaire{

private Questionnaire() {}

public Questionnaire(Long id, String gender, String age, String hobbies, String motivation,
        String pricing, String category, String holiday,String webPreference, String customized) {
        super();
        this.id = id;
        this.gender = gender;
        this.age = age;
        this.hobbies = hobbies;
        this.motivation = motivation;
        this.pricing = pricing;
        this.category = category;
        this.holiday = holiday;
        this.webPreference = webPreference;
        this.customized = customized;
        }

@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private Long id;

@OneToOne
@JoinColumn(name="users")
private User user;

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
        }