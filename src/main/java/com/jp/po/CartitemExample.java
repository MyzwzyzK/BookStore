package com.jp.po;

import java.util.ArrayList;
import java.util.List;

public class CartitemExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CartitemExample() {
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

        public Criteria andCartitemidIsNull() {
            addCriterion("cartitemid is null");
            return (Criteria) this;
        }

        public Criteria andCartitemidIsNotNull() {
            addCriterion("cartitemid is not null");
            return (Criteria) this;
        }

        public Criteria andCartitemidEqualTo(Integer value) {
            addCriterion("cartitemid =", value, "cartitemid");
            return (Criteria) this;
        }

        public Criteria andCartitemidNotEqualTo(Integer value) {
            addCriterion("cartitemid <>", value, "cartitemid");
            return (Criteria) this;
        }

        public Criteria andCartitemidGreaterThan(Integer value) {
            addCriterion("cartitemid >", value, "cartitemid");
            return (Criteria) this;
        }

        public Criteria andCartitemidGreaterThanOrEqualTo(Integer value) {
            addCriterion("cartitemid >=", value, "cartitemid");
            return (Criteria) this;
        }

        public Criteria andCartitemidLessThan(Integer value) {
            addCriterion("cartitemid <", value, "cartitemid");
            return (Criteria) this;
        }

        public Criteria andCartitemidLessThanOrEqualTo(Integer value) {
            addCriterion("cartitemid <=", value, "cartitemid");
            return (Criteria) this;
        }

        public Criteria andCartitemidIn(List<Integer> values) {
            addCriterion("cartitemid in", values, "cartitemid");
            return (Criteria) this;
        }

        public Criteria andCartitemidNotIn(List<Integer> values) {
            addCriterion("cartitemid not in", values, "cartitemid");
            return (Criteria) this;
        }

        public Criteria andCartitemidBetween(Integer value1, Integer value2) {
            addCriterion("cartitemid between", value1, value2, "cartitemid");
            return (Criteria) this;
        }

        public Criteria andCartitemidNotBetween(Integer value1, Integer value2) {
            addCriterion("cartitemid not between", value1, value2, "cartitemid");
            return (Criteria) this;
        }

        public Criteria andLsbnIsNull() {
            addCriterion("lsbn is null");
            return (Criteria) this;
        }

        public Criteria andLsbnIsNotNull() {
            addCriterion("lsbn is not null");
            return (Criteria) this;
        }

        public Criteria andLsbnEqualTo(String value) {
            addCriterion("lsbn =", value, "lsbn");
            return (Criteria) this;
        }

        public Criteria andLsbnNotEqualTo(String value) {
            addCriterion("lsbn <>", value, "lsbn");
            return (Criteria) this;
        }

        public Criteria andLsbnGreaterThan(String value) {
            addCriterion("lsbn >", value, "lsbn");
            return (Criteria) this;
        }

        public Criteria andLsbnGreaterThanOrEqualTo(String value) {
            addCriterion("lsbn >=", value, "lsbn");
            return (Criteria) this;
        }

        public Criteria andLsbnLessThan(String value) {
            addCriterion("lsbn <", value, "lsbn");
            return (Criteria) this;
        }

        public Criteria andLsbnLessThanOrEqualTo(String value) {
            addCriterion("lsbn <=", value, "lsbn");
            return (Criteria) this;
        }

        public Criteria andLsbnLike(String value) {
            addCriterion("lsbn like", value, "lsbn");
            return (Criteria) this;
        }

        public Criteria andLsbnNotLike(String value) {
            addCriterion("lsbn not like", value, "lsbn");
            return (Criteria) this;
        }

        public Criteria andLsbnIn(List<String> values) {
            addCriterion("lsbn in", values, "lsbn");
            return (Criteria) this;
        }

        public Criteria andLsbnNotIn(List<String> values) {
            addCriterion("lsbn not in", values, "lsbn");
            return (Criteria) this;
        }

        public Criteria andLsbnBetween(String value1, String value2) {
            addCriterion("lsbn between", value1, value2, "lsbn");
            return (Criteria) this;
        }

        public Criteria andLsbnNotBetween(String value1, String value2) {
            addCriterion("lsbn not between", value1, value2, "lsbn");
            return (Criteria) this;
        }

        public Criteria andUseridIsNull() {
            addCriterion("userid is null");
            return (Criteria) this;
        }

        public Criteria andUseridIsNotNull() {
            addCriterion("userid is not null");
            return (Criteria) this;
        }

        public Criteria andUseridEqualTo(Integer value) {
            addCriterion("userid =", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotEqualTo(Integer value) {
            addCriterion("userid <>", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThan(Integer value) {
            addCriterion("userid >", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThanOrEqualTo(Integer value) {
            addCriterion("userid >=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThan(Integer value) {
            addCriterion("userid <", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThanOrEqualTo(Integer value) {
            addCriterion("userid <=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridIn(List<Integer> values) {
            addCriterion("userid in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotIn(List<Integer> values) {
            addCriterion("userid not in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridBetween(Integer value1, Integer value2) {
            addCriterion("userid between", value1, value2, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotBetween(Integer value1, Integer value2) {
            addCriterion("userid not between", value1, value2, "userid");
            return (Criteria) this;
        }

        public Criteria andNumIsNull() {
            addCriterion("num is null");
            return (Criteria) this;
        }

        public Criteria andNumIsNotNull() {
            addCriterion("num is not null");
            return (Criteria) this;
        }

        public Criteria andNumEqualTo(Integer value) {
            addCriterion("num =", value, "num");
            return (Criteria) this;
        }

        public Criteria andNumNotEqualTo(Integer value) {
            addCriterion("num <>", value, "num");
            return (Criteria) this;
        }

        public Criteria andNumGreaterThan(Integer value) {
            addCriterion("num >", value, "num");
            return (Criteria) this;
        }

        public Criteria andNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("num >=", value, "num");
            return (Criteria) this;
        }

        public Criteria andNumLessThan(Integer value) {
            addCriterion("num <", value, "num");
            return (Criteria) this;
        }

        public Criteria andNumLessThanOrEqualTo(Integer value) {
            addCriterion("num <=", value, "num");
            return (Criteria) this;
        }

        public Criteria andNumIn(List<Integer> values) {
            addCriterion("num in", values, "num");
            return (Criteria) this;
        }

        public Criteria andNumNotIn(List<Integer> values) {
            addCriterion("num not in", values, "num");
            return (Criteria) this;
        }

        public Criteria andNumBetween(Integer value1, Integer value2) {
            addCriterion("num between", value1, value2, "num");
            return (Criteria) this;
        }

        public Criteria andNumNotBetween(Integer value1, Integer value2) {
            addCriterion("num not between", value1, value2, "num");
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