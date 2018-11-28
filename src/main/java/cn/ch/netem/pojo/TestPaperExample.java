package cn.ch.netem.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TestPaperExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TestPaperExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andTestPaperIdIsNull() {
            addCriterion("test_paper_id is null");
            return (Criteria) this;
        }

        public Criteria andTestPaperIdIsNotNull() {
            addCriterion("test_paper_id is not null");
            return (Criteria) this;
        }

        public Criteria andTestPaperIdEqualTo(Integer value) {
            addCriterion("test_paper_id =", value, "testPaperId");
            return (Criteria) this;
        }

        public Criteria andTestPaperIdNotEqualTo(Integer value) {
            addCriterion("test_paper_id <>", value, "testPaperId");
            return (Criteria) this;
        }

        public Criteria andTestPaperIdGreaterThan(Integer value) {
            addCriterion("test_paper_id >", value, "testPaperId");
            return (Criteria) this;
        }

        public Criteria andTestPaperIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("test_paper_id >=", value, "testPaperId");
            return (Criteria) this;
        }

        public Criteria andTestPaperIdLessThan(Integer value) {
            addCriterion("test_paper_id <", value, "testPaperId");
            return (Criteria) this;
        }

        public Criteria andTestPaperIdLessThanOrEqualTo(Integer value) {
            addCriterion("test_paper_id <=", value, "testPaperId");
            return (Criteria) this;
        }

        public Criteria andTestPaperIdIn(List<Integer> values) {
            addCriterion("test_paper_id in", values, "testPaperId");
            return (Criteria) this;
        }

        public Criteria andTestPaperIdNotIn(List<Integer> values) {
            addCriterion("test_paper_id not in", values, "testPaperId");
            return (Criteria) this;
        }

        public Criteria andTestPaperIdBetween(Integer value1, Integer value2) {
            addCriterion("test_paper_id between", value1, value2, "testPaperId");
            return (Criteria) this;
        }

        public Criteria andTestPaperIdNotBetween(Integer value1, Integer value2) {
            addCriterion("test_paper_id not between", value1, value2, "testPaperId");
            return (Criteria) this;
        }

        public Criteria andScoreIsNull() {
            addCriterion("score is null");
            return (Criteria) this;
        }

        public Criteria andScoreIsNotNull() {
            addCriterion("score is not null");
            return (Criteria) this;
        }

        public Criteria andScoreEqualTo(Integer value) {
            addCriterion("score =", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreNotEqualTo(Integer value) {
            addCriterion("score <>", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreGreaterThan(Integer value) {
            addCriterion("score >", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreGreaterThanOrEqualTo(Integer value) {
            addCriterion("score >=", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreLessThan(Integer value) {
            addCriterion("score <", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreLessThanOrEqualTo(Integer value) {
            addCriterion("score <=", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreIn(List<Integer> values) {
            addCriterion("score in", values, "score");
            return (Criteria) this;
        }

        public Criteria andScoreNotIn(List<Integer> values) {
            addCriterion("score not in", values, "score");
            return (Criteria) this;
        }

        public Criteria andScoreBetween(Integer value1, Integer value2) {
            addCriterion("score between", value1, value2, "score");
            return (Criteria) this;
        }

        public Criteria andScoreNotBetween(Integer value1, Integer value2) {
            addCriterion("score not between", value1, value2, "score");
            return (Criteria) this;
        }

        public Criteria andSubjectIdIsNull() {
            addCriterion("subject_id is null");
            return (Criteria) this;
        }

        public Criteria andSubjectIdIsNotNull() {
            addCriterion("subject_id is not null");
            return (Criteria) this;
        }

        public Criteria andSubjectIdEqualTo(Integer value) {
            addCriterion("subject_id =", value, "subjectId");
            return (Criteria) this;
        }

        public Criteria andSubjectIdNotEqualTo(Integer value) {
            addCriterion("subject_id <>", value, "subjectId");
            return (Criteria) this;
        }

        public Criteria andSubjectIdGreaterThan(Integer value) {
            addCriterion("subject_id >", value, "subjectId");
            return (Criteria) this;
        }

        public Criteria andSubjectIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("subject_id >=", value, "subjectId");
            return (Criteria) this;
        }

        public Criteria andSubjectIdLessThan(Integer value) {
            addCriterion("subject_id <", value, "subjectId");
            return (Criteria) this;
        }

        public Criteria andSubjectIdLessThanOrEqualTo(Integer value) {
            addCriterion("subject_id <=", value, "subjectId");
            return (Criteria) this;
        }

        public Criteria andSubjectIdIn(List<Integer> values) {
            addCriterion("subject_id in", values, "subjectId");
            return (Criteria) this;
        }

        public Criteria andSubjectIdNotIn(List<Integer> values) {
            addCriterion("subject_id not in", values, "subjectId");
            return (Criteria) this;
        }

        public Criteria andSubjectIdBetween(Integer value1, Integer value2) {
            addCriterion("subject_id between", value1, value2, "subjectId");
            return (Criteria) this;
        }

        public Criteria andSubjectIdNotBetween(Integer value1, Integer value2) {
            addCriterion("subject_id not between", value1, value2, "subjectId");
            return (Criteria) this;
        }

        public Criteria andTestPaperLevelIsNull() {
            addCriterion("test_paper_level is null");
            return (Criteria) this;
        }

        public Criteria andTestPaperLevelIsNotNull() {
            addCriterion("test_paper_level is not null");
            return (Criteria) this;
        }

        public Criteria andTestPaperLevelEqualTo(Integer value) {
            addCriterion("test_paper_level =", value, "testPaperLevel");
            return (Criteria) this;
        }

        public Criteria andTestPaperLevelNotEqualTo(Integer value) {
            addCriterion("test_paper_level <>", value, "testPaperLevel");
            return (Criteria) this;
        }

        public Criteria andTestPaperLevelGreaterThan(Integer value) {
            addCriterion("test_paper_level >", value, "testPaperLevel");
            return (Criteria) this;
        }

        public Criteria andTestPaperLevelGreaterThanOrEqualTo(Integer value) {
            addCriterion("test_paper_level >=", value, "testPaperLevel");
            return (Criteria) this;
        }

        public Criteria andTestPaperLevelLessThan(Integer value) {
            addCriterion("test_paper_level <", value, "testPaperLevel");
            return (Criteria) this;
        }

        public Criteria andTestPaperLevelLessThanOrEqualTo(Integer value) {
            addCriterion("test_paper_level <=", value, "testPaperLevel");
            return (Criteria) this;
        }

        public Criteria andTestPaperLevelIn(List<Integer> values) {
            addCriterion("test_paper_level in", values, "testPaperLevel");
            return (Criteria) this;
        }

        public Criteria andTestPaperLevelNotIn(List<Integer> values) {
            addCriterion("test_paper_level not in", values, "testPaperLevel");
            return (Criteria) this;
        }

        public Criteria andTestPaperLevelBetween(Integer value1, Integer value2) {
            addCriterion("test_paper_level between", value1, value2, "testPaperLevel");
            return (Criteria) this;
        }

        public Criteria andTestPaperLevelNotBetween(Integer value1, Integer value2) {
            addCriterion("test_paper_level not between", value1, value2, "testPaperLevel");
            return (Criteria) this;
        }

        public Criteria andQuestionQuantityIsNull() {
            addCriterion("question_quantity is null");
            return (Criteria) this;
        }

        public Criteria andQuestionQuantityIsNotNull() {
            addCriterion("question_quantity is not null");
            return (Criteria) this;
        }

        public Criteria andQuestionQuantityEqualTo(Integer value) {
            addCriterion("question_quantity =", value, "questionQuantity");
            return (Criteria) this;
        }

        public Criteria andQuestionQuantityNotEqualTo(Integer value) {
            addCriterion("question_quantity <>", value, "questionQuantity");
            return (Criteria) this;
        }

        public Criteria andQuestionQuantityGreaterThan(Integer value) {
            addCriterion("question_quantity >", value, "questionQuantity");
            return (Criteria) this;
        }

        public Criteria andQuestionQuantityGreaterThanOrEqualTo(Integer value) {
            addCriterion("question_quantity >=", value, "questionQuantity");
            return (Criteria) this;
        }

        public Criteria andQuestionQuantityLessThan(Integer value) {
            addCriterion("question_quantity <", value, "questionQuantity");
            return (Criteria) this;
        }

        public Criteria andQuestionQuantityLessThanOrEqualTo(Integer value) {
            addCriterion("question_quantity <=", value, "questionQuantity");
            return (Criteria) this;
        }

        public Criteria andQuestionQuantityIn(List<Integer> values) {
            addCriterion("question_quantity in", values, "questionQuantity");
            return (Criteria) this;
        }

        public Criteria andQuestionQuantityNotIn(List<Integer> values) {
            addCriterion("question_quantity not in", values, "questionQuantity");
            return (Criteria) this;
        }

        public Criteria andQuestionQuantityBetween(Integer value1, Integer value2) {
            addCriterion("question_quantity between", value1, value2, "questionQuantity");
            return (Criteria) this;
        }

        public Criteria andQuestionQuantityNotBetween(Integer value1, Integer value2) {
            addCriterion("question_quantity not between", value1, value2, "questionQuantity");
            return (Criteria) this;
        }

        public Criteria andLastmodifiydateIsNull() {
            addCriterion("lastmodifiydate is null");
            return (Criteria) this;
        }

        public Criteria andLastmodifiydateIsNotNull() {
            addCriterion("lastmodifiydate is not null");
            return (Criteria) this;
        }

        public Criteria andLastmodifiydateEqualTo(Date value) {
            addCriterion("lastmodifiydate =", value, "lastmodifiydate");
            return (Criteria) this;
        }

        public Criteria andLastmodifiydateNotEqualTo(Date value) {
            addCriterion("lastmodifiydate <>", value, "lastmodifiydate");
            return (Criteria) this;
        }

        public Criteria andLastmodifiydateGreaterThan(Date value) {
            addCriterion("lastmodifiydate >", value, "lastmodifiydate");
            return (Criteria) this;
        }

        public Criteria andLastmodifiydateGreaterThanOrEqualTo(Date value) {
            addCriterion("lastmodifiydate >=", value, "lastmodifiydate");
            return (Criteria) this;
        }

        public Criteria andLastmodifiydateLessThan(Date value) {
            addCriterion("lastmodifiydate <", value, "lastmodifiydate");
            return (Criteria) this;
        }

        public Criteria andLastmodifiydateLessThanOrEqualTo(Date value) {
            addCriterion("lastmodifiydate <=", value, "lastmodifiydate");
            return (Criteria) this;
        }

        public Criteria andLastmodifiydateIn(List<Date> values) {
            addCriterion("lastmodifiydate in", values, "lastmodifiydate");
            return (Criteria) this;
        }

        public Criteria andLastmodifiydateNotIn(List<Date> values) {
            addCriterion("lastmodifiydate not in", values, "lastmodifiydate");
            return (Criteria) this;
        }

        public Criteria andLastmodifiydateBetween(Date value1, Date value2) {
            addCriterion("lastmodifiydate between", value1, value2, "lastmodifiydate");
            return (Criteria) this;
        }

        public Criteria andLastmodifiydateNotBetween(Date value1, Date value2) {
            addCriterion("lastmodifiydate not between", value1, value2, "lastmodifiydate");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}