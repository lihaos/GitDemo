package cn.ch.netem.pojo;

import java.io.Serializable;

public class UserTestPaperQuestion  implements Serializable{
    private Integer id;

    private Integer questionId;

    private Integer userTestPaperId;

    private Integer answerId;

    private Integer istrue;
    
    private Question question;
    

    
    public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}


	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Integer questionId) {
        this.questionId = questionId;
    }

    public Integer getUserTestPaperId() {
        return userTestPaperId;
    }

    public void setUserTestPaperId(Integer userTestPaperId) {
        this.userTestPaperId = userTestPaperId;
    }



	public Integer getAnswerId() {
		return answerId;
	}

	public void setAnswerId(Integer answerId) {
		this.answerId = answerId;
	}

	public Integer getIstrue() {
        return istrue;
    }

    public void setIstrue(Integer istrue) {
        this.istrue = istrue;
    }
}