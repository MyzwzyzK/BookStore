package com.jp.po;

import java.util.ArrayList;
import java.util.List;

public class BookExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BookExample() {
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

        public Criteria andOrderbyIsNull() {
            addCriterion("orderBy is null");
            return (Criteria) this;
        }

        public Criteria andOrderbyIsNotNull() {
            addCriterion("orderBy is not null");
            return (Criteria) this;
        }

        public Criteria andOrderbyEqualTo(Integer value) {
            addCriterion("orderBy =", value, "orderby");
            return (Criteria) this;
        }

        public Criteria andOrderbyNotEqualTo(Integer value) {
            addCriterion("orderBy <>", value, "orderby");
            return (Criteria) this;
        }

        public Criteria andOrderbyGreaterThan(Integer value) {
            addCriterion("orderBy >", value, "orderby");
            return (Criteria) this;
        }

        public Criteria andOrderbyGreaterThanOrEqualTo(Integer value) {
            addCriterion("orderBy >=", value, "orderby");
            return (Criteria) this;
        }

        public Criteria andOrderbyLessThan(Integer value) {
            addCriterion("orderBy <", value, "orderby");
            return (Criteria) this;
        }

        public Criteria andOrderbyLessThanOrEqualTo(Integer value) {
            addCriterion("orderBy <=", value, "orderby");
            return (Criteria) this;
        }

        public Criteria andOrderbyIn(List<Integer> values) {
            addCriterion("orderBy in", values, "orderby");
            return (Criteria) this;
        }

        public Criteria andOrderbyNotIn(List<Integer> values) {
            addCriterion("orderBy not in", values, "orderby");
            return (Criteria) this;
        }

        public Criteria andOrderbyBetween(Integer value1, Integer value2) {
            addCriterion("orderBy between", value1, value2, "orderby");
            return (Criteria) this;
        }

        public Criteria andOrderbyNotBetween(Integer value1, Integer value2) {
            addCriterion("orderBy not between", value1, value2, "orderby");
            return (Criteria) this;
        }

        public Criteria andNameIsNull() {
            addCriterion("name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andTypeIsNull() {
            addCriterion("type is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("type is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(String value) {
            addCriterion("type =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(String value) {
            addCriterion("type <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(String value) {
            addCriterion("type >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(String value) {
            addCriterion("type >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(String value) {
            addCriterion("type <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(String value) {
            addCriterion("type <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLike(String value) {
            addCriterion("type like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotLike(String value) {
            addCriterion("type not like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<String> values) {
            addCriterion("type in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<String> values) {
            addCriterion("type not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(String value1, String value2) {
            addCriterion("type between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(String value1, String value2) {
            addCriterion("type not between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andAuthorIsNull() {
            addCriterion("author is null");
            return (Criteria) this;
        }

        public Criteria andAuthorIsNotNull() {
            addCriterion("author is not null");
            return (Criteria) this;
        }

        public Criteria andAuthorEqualTo(String value) {
            addCriterion("author =", value, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorNotEqualTo(String value) {
            addCriterion("author <>", value, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorGreaterThan(String value) {
            addCriterion("author >", value, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorGreaterThanOrEqualTo(String value) {
            addCriterion("author >=", value, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorLessThan(String value) {
            addCriterion("author <", value, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorLessThanOrEqualTo(String value) {
            addCriterion("author <=", value, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorLike(String value) {
            addCriterion("author like", value, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorNotLike(String value) {
            addCriterion("author not like", value, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorIn(List<String> values) {
            addCriterion("author in", values, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorNotIn(List<String> values) {
            addCriterion("author not in", values, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorBetween(String value1, String value2) {
            addCriterion("author between", value1, value2, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorNotBetween(String value1, String value2) {
            addCriterion("author not between", value1, value2, "author");
            return (Criteria) this;
        }

        public Criteria andPriceIsNull() {
            addCriterion("price is null");
            return (Criteria) this;
        }

        public Criteria andPriceIsNotNull() {
            addCriterion("price is not null");
            return (Criteria) this;
        }

        public Criteria andPriceEqualTo(Double value) {
            addCriterion("price =", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotEqualTo(Double value) {
            addCriterion("price <>", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThan(Double value) {
            addCriterion("price >", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThanOrEqualTo(Double value) {
            addCriterion("price >=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThan(Double value) {
            addCriterion("price <", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThanOrEqualTo(Double value) {
            addCriterion("price <=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceIn(List<Double> values) {
            addCriterion("price in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotIn(List<Double> values) {
            addCriterion("price not in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceBetween(Double value1, Double value2) {
            addCriterion("price between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotBetween(Double value1, Double value2) {
            addCriterion("price not between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andCurrpriceIsNull() {
            addCriterion("currPrice is null");
            return (Criteria) this;
        }

        public Criteria andCurrpriceIsNotNull() {
            addCriterion("currPrice is not null");
            return (Criteria) this;
        }

        public Criteria andCurrpriceEqualTo(Double value) {
            addCriterion("currPrice =", value, "currprice");
            return (Criteria) this;
        }

        public Criteria andCurrpriceNotEqualTo(Double value) {
            addCriterion("currPrice <>", value, "currprice");
            return (Criteria) this;
        }

        public Criteria andCurrpriceGreaterThan(Double value) {
            addCriterion("currPrice >", value, "currprice");
            return (Criteria) this;
        }

        public Criteria andCurrpriceGreaterThanOrEqualTo(Double value) {
            addCriterion("currPrice >=", value, "currprice");
            return (Criteria) this;
        }

        public Criteria andCurrpriceLessThan(Double value) {
            addCriterion("currPrice <", value, "currprice");
            return (Criteria) this;
        }

        public Criteria andCurrpriceLessThanOrEqualTo(Double value) {
            addCriterion("currPrice <=", value, "currprice");
            return (Criteria) this;
        }

        public Criteria andCurrpriceIn(List<Double> values) {
            addCriterion("currPrice in", values, "currprice");
            return (Criteria) this;
        }

        public Criteria andCurrpriceNotIn(List<Double> values) {
            addCriterion("currPrice not in", values, "currprice");
            return (Criteria) this;
        }

        public Criteria andCurrpriceBetween(Double value1, Double value2) {
            addCriterion("currPrice between", value1, value2, "currprice");
            return (Criteria) this;
        }

        public Criteria andCurrpriceNotBetween(Double value1, Double value2) {
            addCriterion("currPrice not between", value1, value2, "currprice");
            return (Criteria) this;
        }

        public Criteria andDiscountIsNull() {
            addCriterion("discount is null");
            return (Criteria) this;
        }

        public Criteria andDiscountIsNotNull() {
            addCriterion("discount is not null");
            return (Criteria) this;
        }

        public Criteria andDiscountEqualTo(Double value) {
            addCriterion("discount =", value, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountNotEqualTo(Double value) {
            addCriterion("discount <>", value, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountGreaterThan(Double value) {
            addCriterion("discount >", value, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountGreaterThanOrEqualTo(Double value) {
            addCriterion("discount >=", value, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountLessThan(Double value) {
            addCriterion("discount <", value, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountLessThanOrEqualTo(Double value) {
            addCriterion("discount <=", value, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountIn(List<Double> values) {
            addCriterion("discount in", values, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountNotIn(List<Double> values) {
            addCriterion("discount not in", values, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountBetween(Double value1, Double value2) {
            addCriterion("discount between", value1, value2, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountNotBetween(Double value1, Double value2) {
            addCriterion("discount not between", value1, value2, "discount");
            return (Criteria) this;
        }

        public Criteria andPressIsNull() {
            addCriterion("press is null");
            return (Criteria) this;
        }

        public Criteria andPressIsNotNull() {
            addCriterion("press is not null");
            return (Criteria) this;
        }

        public Criteria andPressEqualTo(String value) {
            addCriterion("press =", value, "press");
            return (Criteria) this;
        }

        public Criteria andPressNotEqualTo(String value) {
            addCriterion("press <>", value, "press");
            return (Criteria) this;
        }

        public Criteria andPressGreaterThan(String value) {
            addCriterion("press >", value, "press");
            return (Criteria) this;
        }

        public Criteria andPressGreaterThanOrEqualTo(String value) {
            addCriterion("press >=", value, "press");
            return (Criteria) this;
        }

        public Criteria andPressLessThan(String value) {
            addCriterion("press <", value, "press");
            return (Criteria) this;
        }

        public Criteria andPressLessThanOrEqualTo(String value) {
            addCriterion("press <=", value, "press");
            return (Criteria) this;
        }

        public Criteria andPressLike(String value) {
            addCriterion("press like", value, "press");
            return (Criteria) this;
        }

        public Criteria andPressNotLike(String value) {
            addCriterion("press not like", value, "press");
            return (Criteria) this;
        }

        public Criteria andPressIn(List<String> values) {
            addCriterion("press in", values, "press");
            return (Criteria) this;
        }

        public Criteria andPressNotIn(List<String> values) {
            addCriterion("press not in", values, "press");
            return (Criteria) this;
        }

        public Criteria andPressBetween(String value1, String value2) {
            addCriterion("press between", value1, value2, "press");
            return (Criteria) this;
        }

        public Criteria andPressNotBetween(String value1, String value2) {
            addCriterion("press not between", value1, value2, "press");
            return (Criteria) this;
        }

        public Criteria andPublishtimeIsNull() {
            addCriterion("publishtime is null");
            return (Criteria) this;
        }

        public Criteria andPublishtimeIsNotNull() {
            addCriterion("publishtime is not null");
            return (Criteria) this;
        }

        public Criteria andPublishtimeEqualTo(String value) {
            addCriterion("publishtime =", value, "publishtime");
            return (Criteria) this;
        }

        public Criteria andPublishtimeNotEqualTo(String value) {
            addCriterion("publishtime <>", value, "publishtime");
            return (Criteria) this;
        }

        public Criteria andPublishtimeGreaterThan(String value) {
            addCriterion("publishtime >", value, "publishtime");
            return (Criteria) this;
        }

        public Criteria andPublishtimeGreaterThanOrEqualTo(String value) {
            addCriterion("publishtime >=", value, "publishtime");
            return (Criteria) this;
        }

        public Criteria andPublishtimeLessThan(String value) {
            addCriterion("publishtime <", value, "publishtime");
            return (Criteria) this;
        }

        public Criteria andPublishtimeLessThanOrEqualTo(String value) {
            addCriterion("publishtime <=", value, "publishtime");
            return (Criteria) this;
        }

        public Criteria andPublishtimeLike(String value) {
            addCriterion("publishtime like", value, "publishtime");
            return (Criteria) this;
        }

        public Criteria andPublishtimeNotLike(String value) {
            addCriterion("publishtime not like", value, "publishtime");
            return (Criteria) this;
        }

        public Criteria andPublishtimeIn(List<String> values) {
            addCriterion("publishtime in", values, "publishtime");
            return (Criteria) this;
        }

        public Criteria andPublishtimeNotIn(List<String> values) {
            addCriterion("publishtime not in", values, "publishtime");
            return (Criteria) this;
        }

        public Criteria andPublishtimeBetween(String value1, String value2) {
            addCriterion("publishtime between", value1, value2, "publishtime");
            return (Criteria) this;
        }

        public Criteria andPublishtimeNotBetween(String value1, String value2) {
            addCriterion("publishtime not between", value1, value2, "publishtime");
            return (Criteria) this;
        }

        public Criteria andEditionIsNull() {
            addCriterion("edition is null");
            return (Criteria) this;
        }

        public Criteria andEditionIsNotNull() {
            addCriterion("edition is not null");
            return (Criteria) this;
        }

        public Criteria andEditionEqualTo(Integer value) {
            addCriterion("edition =", value, "edition");
            return (Criteria) this;
        }

        public Criteria andEditionNotEqualTo(Integer value) {
            addCriterion("edition <>", value, "edition");
            return (Criteria) this;
        }

        public Criteria andEditionGreaterThan(Integer value) {
            addCriterion("edition >", value, "edition");
            return (Criteria) this;
        }

        public Criteria andEditionGreaterThanOrEqualTo(Integer value) {
            addCriterion("edition >=", value, "edition");
            return (Criteria) this;
        }

        public Criteria andEditionLessThan(Integer value) {
            addCriterion("edition <", value, "edition");
            return (Criteria) this;
        }

        public Criteria andEditionLessThanOrEqualTo(Integer value) {
            addCriterion("edition <=", value, "edition");
            return (Criteria) this;
        }

        public Criteria andEditionIn(List<Integer> values) {
            addCriterion("edition in", values, "edition");
            return (Criteria) this;
        }

        public Criteria andEditionNotIn(List<Integer> values) {
            addCriterion("edition not in", values, "edition");
            return (Criteria) this;
        }

        public Criteria andEditionBetween(Integer value1, Integer value2) {
            addCriterion("edition between", value1, value2, "edition");
            return (Criteria) this;
        }

        public Criteria andEditionNotBetween(Integer value1, Integer value2) {
            addCriterion("edition not between", value1, value2, "edition");
            return (Criteria) this;
        }

        public Criteria andPagenumIsNull() {
            addCriterion("pageNum is null");
            return (Criteria) this;
        }

        public Criteria andPagenumIsNotNull() {
            addCriterion("pageNum is not null");
            return (Criteria) this;
        }

        public Criteria andPagenumEqualTo(Integer value) {
            addCriterion("pageNum =", value, "pagenum");
            return (Criteria) this;
        }

        public Criteria andPagenumNotEqualTo(Integer value) {
            addCriterion("pageNum <>", value, "pagenum");
            return (Criteria) this;
        }

        public Criteria andPagenumGreaterThan(Integer value) {
            addCriterion("pageNum >", value, "pagenum");
            return (Criteria) this;
        }

        public Criteria andPagenumGreaterThanOrEqualTo(Integer value) {
            addCriterion("pageNum >=", value, "pagenum");
            return (Criteria) this;
        }

        public Criteria andPagenumLessThan(Integer value) {
            addCriterion("pageNum <", value, "pagenum");
            return (Criteria) this;
        }

        public Criteria andPagenumLessThanOrEqualTo(Integer value) {
            addCriterion("pageNum <=", value, "pagenum");
            return (Criteria) this;
        }

        public Criteria andPagenumIn(List<Integer> values) {
            addCriterion("pageNum in", values, "pagenum");
            return (Criteria) this;
        }

        public Criteria andPagenumNotIn(List<Integer> values) {
            addCriterion("pageNum not in", values, "pagenum");
            return (Criteria) this;
        }

        public Criteria andPagenumBetween(Integer value1, Integer value2) {
            addCriterion("pageNum between", value1, value2, "pagenum");
            return (Criteria) this;
        }

        public Criteria andPagenumNotBetween(Integer value1, Integer value2) {
            addCriterion("pageNum not between", value1, value2, "pagenum");
            return (Criteria) this;
        }

        public Criteria andWordnumIsNull() {
            addCriterion("wordNum is null");
            return (Criteria) this;
        }

        public Criteria andWordnumIsNotNull() {
            addCriterion("wordNum is not null");
            return (Criteria) this;
        }

        public Criteria andWordnumEqualTo(Integer value) {
            addCriterion("wordNum =", value, "wordnum");
            return (Criteria) this;
        }

        public Criteria andWordnumNotEqualTo(Integer value) {
            addCriterion("wordNum <>", value, "wordnum");
            return (Criteria) this;
        }

        public Criteria andWordnumGreaterThan(Integer value) {
            addCriterion("wordNum >", value, "wordnum");
            return (Criteria) this;
        }

        public Criteria andWordnumGreaterThanOrEqualTo(Integer value) {
            addCriterion("wordNum >=", value, "wordnum");
            return (Criteria) this;
        }

        public Criteria andWordnumLessThan(Integer value) {
            addCriterion("wordNum <", value, "wordnum");
            return (Criteria) this;
        }

        public Criteria andWordnumLessThanOrEqualTo(Integer value) {
            addCriterion("wordNum <=", value, "wordnum");
            return (Criteria) this;
        }

        public Criteria andWordnumIn(List<Integer> values) {
            addCriterion("wordNum in", values, "wordnum");
            return (Criteria) this;
        }

        public Criteria andWordnumNotIn(List<Integer> values) {
            addCriterion("wordNum not in", values, "wordnum");
            return (Criteria) this;
        }

        public Criteria andWordnumBetween(Integer value1, Integer value2) {
            addCriterion("wordNum between", value1, value2, "wordnum");
            return (Criteria) this;
        }

        public Criteria andWordnumNotBetween(Integer value1, Integer value2) {
            addCriterion("wordNum not between", value1, value2, "wordnum");
            return (Criteria) this;
        }

        public Criteria andPrinttimeIsNull() {
            addCriterion("printtime is null");
            return (Criteria) this;
        }

        public Criteria andPrinttimeIsNotNull() {
            addCriterion("printtime is not null");
            return (Criteria) this;
        }

        public Criteria andPrinttimeEqualTo(String value) {
            addCriterion("printtime =", value, "printtime");
            return (Criteria) this;
        }

        public Criteria andPrinttimeNotEqualTo(String value) {
            addCriterion("printtime <>", value, "printtime");
            return (Criteria) this;
        }

        public Criteria andPrinttimeGreaterThan(String value) {
            addCriterion("printtime >", value, "printtime");
            return (Criteria) this;
        }

        public Criteria andPrinttimeGreaterThanOrEqualTo(String value) {
            addCriterion("printtime >=", value, "printtime");
            return (Criteria) this;
        }

        public Criteria andPrinttimeLessThan(String value) {
            addCriterion("printtime <", value, "printtime");
            return (Criteria) this;
        }

        public Criteria andPrinttimeLessThanOrEqualTo(String value) {
            addCriterion("printtime <=", value, "printtime");
            return (Criteria) this;
        }

        public Criteria andPrinttimeLike(String value) {
            addCriterion("printtime like", value, "printtime");
            return (Criteria) this;
        }

        public Criteria andPrinttimeNotLike(String value) {
            addCriterion("printtime not like", value, "printtime");
            return (Criteria) this;
        }

        public Criteria andPrinttimeIn(List<String> values) {
            addCriterion("printtime in", values, "printtime");
            return (Criteria) this;
        }

        public Criteria andPrinttimeNotIn(List<String> values) {
            addCriterion("printtime not in", values, "printtime");
            return (Criteria) this;
        }

        public Criteria andPrinttimeBetween(String value1, String value2) {
            addCriterion("printtime between", value1, value2, "printtime");
            return (Criteria) this;
        }

        public Criteria andPrinttimeNotBetween(String value1, String value2) {
            addCriterion("printtime not between", value1, value2, "printtime");
            return (Criteria) this;
        }

        public Criteria andBooksizeIsNull() {
            addCriterion("booksize is null");
            return (Criteria) this;
        }

        public Criteria andBooksizeIsNotNull() {
            addCriterion("booksize is not null");
            return (Criteria) this;
        }

        public Criteria andBooksizeEqualTo(Integer value) {
            addCriterion("booksize =", value, "booksize");
            return (Criteria) this;
        }

        public Criteria andBooksizeNotEqualTo(Integer value) {
            addCriterion("booksize <>", value, "booksize");
            return (Criteria) this;
        }

        public Criteria andBooksizeGreaterThan(Integer value) {
            addCriterion("booksize >", value, "booksize");
            return (Criteria) this;
        }

        public Criteria andBooksizeGreaterThanOrEqualTo(Integer value) {
            addCriterion("booksize >=", value, "booksize");
            return (Criteria) this;
        }

        public Criteria andBooksizeLessThan(Integer value) {
            addCriterion("booksize <", value, "booksize");
            return (Criteria) this;
        }

        public Criteria andBooksizeLessThanOrEqualTo(Integer value) {
            addCriterion("booksize <=", value, "booksize");
            return (Criteria) this;
        }

        public Criteria andBooksizeIn(List<Integer> values) {
            addCriterion("booksize in", values, "booksize");
            return (Criteria) this;
        }

        public Criteria andBooksizeNotIn(List<Integer> values) {
            addCriterion("booksize not in", values, "booksize");
            return (Criteria) this;
        }

        public Criteria andBooksizeBetween(Integer value1, Integer value2) {
            addCriterion("booksize between", value1, value2, "booksize");
            return (Criteria) this;
        }

        public Criteria andBooksizeNotBetween(Integer value1, Integer value2) {
            addCriterion("booksize not between", value1, value2, "booksize");
            return (Criteria) this;
        }

        public Criteria andPaperIsNull() {
            addCriterion("paper is null");
            return (Criteria) this;
        }

        public Criteria andPaperIsNotNull() {
            addCriterion("paper is not null");
            return (Criteria) this;
        }

        public Criteria andPaperEqualTo(String value) {
            addCriterion("paper =", value, "paper");
            return (Criteria) this;
        }

        public Criteria andPaperNotEqualTo(String value) {
            addCriterion("paper <>", value, "paper");
            return (Criteria) this;
        }

        public Criteria andPaperGreaterThan(String value) {
            addCriterion("paper >", value, "paper");
            return (Criteria) this;
        }

        public Criteria andPaperGreaterThanOrEqualTo(String value) {
            addCriterion("paper >=", value, "paper");
            return (Criteria) this;
        }

        public Criteria andPaperLessThan(String value) {
            addCriterion("paper <", value, "paper");
            return (Criteria) this;
        }

        public Criteria andPaperLessThanOrEqualTo(String value) {
            addCriterion("paper <=", value, "paper");
            return (Criteria) this;
        }

        public Criteria andPaperLike(String value) {
            addCriterion("paper like", value, "paper");
            return (Criteria) this;
        }

        public Criteria andPaperNotLike(String value) {
            addCriterion("paper not like", value, "paper");
            return (Criteria) this;
        }

        public Criteria andPaperIn(List<String> values) {
            addCriterion("paper in", values, "paper");
            return (Criteria) this;
        }

        public Criteria andPaperNotIn(List<String> values) {
            addCriterion("paper not in", values, "paper");
            return (Criteria) this;
        }

        public Criteria andPaperBetween(String value1, String value2) {
            addCriterion("paper between", value1, value2, "paper");
            return (Criteria) this;
        }

        public Criteria andPaperNotBetween(String value1, String value2) {
            addCriterion("paper not between", value1, value2, "paper");
            return (Criteria) this;
        }

        public Criteria andCidIsNull() {
            addCriterion("cid is null");
            return (Criteria) this;
        }

        public Criteria andCidIsNotNull() {
            addCriterion("cid is not null");
            return (Criteria) this;
        }

        public Criteria andCidEqualTo(String value) {
            addCriterion("cid =", value, "cid");
            return (Criteria) this;
        }

        public Criteria andCidNotEqualTo(String value) {
            addCriterion("cid <>", value, "cid");
            return (Criteria) this;
        }

        public Criteria andCidGreaterThan(String value) {
            addCriterion("cid >", value, "cid");
            return (Criteria) this;
        }

        public Criteria andCidGreaterThanOrEqualTo(String value) {
            addCriterion("cid >=", value, "cid");
            return (Criteria) this;
        }

        public Criteria andCidLessThan(String value) {
            addCriterion("cid <", value, "cid");
            return (Criteria) this;
        }

        public Criteria andCidLessThanOrEqualTo(String value) {
            addCriterion("cid <=", value, "cid");
            return (Criteria) this;
        }

        public Criteria andCidLike(String value) {
            addCriterion("cid like", value, "cid");
            return (Criteria) this;
        }

        public Criteria andCidNotLike(String value) {
            addCriterion("cid not like", value, "cid");
            return (Criteria) this;
        }

        public Criteria andCidIn(List<String> values) {
            addCriterion("cid in", values, "cid");
            return (Criteria) this;
        }

        public Criteria andCidNotIn(List<String> values) {
            addCriterion("cid not in", values, "cid");
            return (Criteria) this;
        }

        public Criteria andCidBetween(String value1, String value2) {
            addCriterion("cid between", value1, value2, "cid");
            return (Criteria) this;
        }

        public Criteria andCidNotBetween(String value1, String value2) {
            addCriterion("cid not between", value1, value2, "cid");
            return (Criteria) this;
        }

        public Criteria andImagewIsNull() {
            addCriterion("imageW is null");
            return (Criteria) this;
        }

        public Criteria andImagewIsNotNull() {
            addCriterion("imageW is not null");
            return (Criteria) this;
        }

        public Criteria andImagewEqualTo(String value) {
            addCriterion("imageW =", value, "imagew");
            return (Criteria) this;
        }

        public Criteria andImagewNotEqualTo(String value) {
            addCriterion("imageW <>", value, "imagew");
            return (Criteria) this;
        }

        public Criteria andImagewGreaterThan(String value) {
            addCriterion("imageW >", value, "imagew");
            return (Criteria) this;
        }

        public Criteria andImagewGreaterThanOrEqualTo(String value) {
            addCriterion("imageW >=", value, "imagew");
            return (Criteria) this;
        }

        public Criteria andImagewLessThan(String value) {
            addCriterion("imageW <", value, "imagew");
            return (Criteria) this;
        }

        public Criteria andImagewLessThanOrEqualTo(String value) {
            addCriterion("imageW <=", value, "imagew");
            return (Criteria) this;
        }

        public Criteria andImagewLike(String value) {
            addCriterion("imageW like", value, "imagew");
            return (Criteria) this;
        }

        public Criteria andImagewNotLike(String value) {
            addCriterion("imageW not like", value, "imagew");
            return (Criteria) this;
        }

        public Criteria andImagewIn(List<String> values) {
            addCriterion("imageW in", values, "imagew");
            return (Criteria) this;
        }

        public Criteria andImagewNotIn(List<String> values) {
            addCriterion("imageW not in", values, "imagew");
            return (Criteria) this;
        }

        public Criteria andImagewBetween(String value1, String value2) {
            addCriterion("imageW between", value1, value2, "imagew");
            return (Criteria) this;
        }

        public Criteria andImagewNotBetween(String value1, String value2) {
            addCriterion("imageW not between", value1, value2, "imagew");
            return (Criteria) this;
        }

        public Criteria andImagebIsNull() {
            addCriterion("imageB is null");
            return (Criteria) this;
        }

        public Criteria andImagebIsNotNull() {
            addCriterion("imageB is not null");
            return (Criteria) this;
        }

        public Criteria andImagebEqualTo(String value) {
            addCriterion("imageB =", value, "imageb");
            return (Criteria) this;
        }

        public Criteria andImagebNotEqualTo(String value) {
            addCriterion("imageB <>", value, "imageb");
            return (Criteria) this;
        }

        public Criteria andImagebGreaterThan(String value) {
            addCriterion("imageB >", value, "imageb");
            return (Criteria) this;
        }

        public Criteria andImagebGreaterThanOrEqualTo(String value) {
            addCriterion("imageB >=", value, "imageb");
            return (Criteria) this;
        }

        public Criteria andImagebLessThan(String value) {
            addCriterion("imageB <", value, "imageb");
            return (Criteria) this;
        }

        public Criteria andImagebLessThanOrEqualTo(String value) {
            addCriterion("imageB <=", value, "imageb");
            return (Criteria) this;
        }

        public Criteria andImagebLike(String value) {
            addCriterion("imageB like", value, "imageb");
            return (Criteria) this;
        }

        public Criteria andImagebNotLike(String value) {
            addCriterion("imageB not like", value, "imageb");
            return (Criteria) this;
        }

        public Criteria andImagebIn(List<String> values) {
            addCriterion("imageB in", values, "imageb");
            return (Criteria) this;
        }

        public Criteria andImagebNotIn(List<String> values) {
            addCriterion("imageB not in", values, "imageb");
            return (Criteria) this;
        }

        public Criteria andImagebBetween(String value1, String value2) {
            addCriterion("imageB between", value1, value2, "imageb");
            return (Criteria) this;
        }

        public Criteria andImagebNotBetween(String value1, String value2) {
            addCriterion("imageB not between", value1, value2, "imageb");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNull() {
            addCriterion("description is null");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNotNull() {
            addCriterion("description is not null");
            return (Criteria) this;
        }

        public Criteria andDescriptionEqualTo(String value) {
            addCriterion("description =", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotEqualTo(String value) {
            addCriterion("description <>", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThan(String value) {
            addCriterion("description >", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("description >=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThan(String value) {
            addCriterion("description <", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThanOrEqualTo(String value) {
            addCriterion("description <=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLike(String value) {
            addCriterion("description like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotLike(String value) {
            addCriterion("description not like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionIn(List<String> values) {
            addCriterion("description in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotIn(List<String> values) {
            addCriterion("description not in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionBetween(String value1, String value2) {
            addCriterion("description between", value1, value2, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotBetween(String value1, String value2) {
            addCriterion("description not between", value1, value2, "description");
            return (Criteria) this;
        }

        public Criteria andUsernameIsNull() {
            addCriterion("username is null");
            return (Criteria) this;
        }

        public Criteria andUsernameIsNotNull() {
            addCriterion("username is not null");
            return (Criteria) this;
        }

        public Criteria andUsernameEqualTo(String value) {
            addCriterion("username =", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotEqualTo(String value) {
            addCriterion("username <>", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameGreaterThan(String value) {
            addCriterion("username >", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameGreaterThanOrEqualTo(String value) {
            addCriterion("username >=", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLessThan(String value) {
            addCriterion("username <", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLessThanOrEqualTo(String value) {
            addCriterion("username <=", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLike(String value) {
            addCriterion("username like", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotLike(String value) {
            addCriterion("username not like", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameIn(List<String> values) {
            addCriterion("username in", values, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotIn(List<String> values) {
            addCriterion("username not in", values, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameBetween(String value1, String value2) {
            addCriterion("username between", value1, value2, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotBetween(String value1, String value2) {
            addCriterion("username not between", value1, value2, "username");
            return (Criteria) this;
        }

        public Criteria andUseridIsNull() {
            addCriterion("userId is null");
            return (Criteria) this;
        }

        public Criteria andUseridIsNotNull() {
            addCriterion("userId is not null");
            return (Criteria) this;
        }

        public Criteria andUseridEqualTo(Integer value) {
            addCriterion("userId =", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotEqualTo(Integer value) {
            addCriterion("userId <>", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThan(Integer value) {
            addCriterion("userId >", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThanOrEqualTo(Integer value) {
            addCriterion("userId >=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThan(Integer value) {
            addCriterion("userId <", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThanOrEqualTo(Integer value) {
            addCriterion("userId <=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridIn(List<Integer> values) {
            addCriterion("userId in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotIn(List<Integer> values) {
            addCriterion("userId not in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridBetween(Integer value1, Integer value2) {
            addCriterion("userId between", value1, value2, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotBetween(Integer value1, Integer value2) {
            addCriterion("userId not between", value1, value2, "userid");
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