package com.xingyou.xingyou;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

import com.xingyou.xingyou.tree.Node;
import com.terapico.caf.baseelement.CandidateQuery;
import com.terapico.utils.BaseCandidatesUtil;

public class XingyouCandidatesUtil extends BaseCandidatesUtil{
	static {
		_for("candidate_container").usedIn("candidate_element").withRole("container");
		_for("candidate_container").isTree("false");
		_for("candidate_container").hasFields(";id;name;version;");
		_for("candidate_container").targetType("candidate_container");
		_for("product").referTo("level_three_category").withRole("parent_category");
		_for("product").usedIn("sku").withRole("product");
		_for("product").isTree("false");
		_for("product").hasFields(";id;name;origin;remark;brand;picture;last_update_time;version;");
		_for("product").targetType("product");
		_for("product").anchorColumn("parent_category");
		_for("sec_user").referTo("user_domain").withRole("domain");
		_for("sec_user").usedIn("wechat_miniapp_identify").withRole("sec_user");
		_for("sec_user").usedIn("login_history").withRole("sec_user");
		_for("sec_user").usedIn("wechat_workapp_identify").withRole("sec_user");
		_for("sec_user").usedIn("keypair_identify").withRole("sec_user");
		_for("sec_user").usedIn("user_app").withRole("sec_user");
		_for("sec_user").isTree("false");
		_for("sec_user").hasFields(";id;login;mobile;email;pwd;weixin_openid;weixin_appid;access_token;verification_code;verification_code_expire;last_login_time;version;");
		_for("sec_user").targetType("sec_user");
		_for("sec_user").anchorColumn("domain");
		_for("page_type").referTo("mobile_app").withRole("mobile_app");
		_for("page_type").usedIn("page").withRole("page_type");
		_for("page_type").isTree("false");
		_for("page_type").hasFields(";id;name;code;footer_tab;version;");
		_for("page_type").targetType("page_type");
		_for("page_type").anchorColumn("mobile_app");
		_for("catalog").referTo("franchised_outlet_province_center").withRole("owner");
		_for("catalog").usedIn("level_one_category").withRole("catalog");
		_for("catalog").isTree("false");
		_for("catalog").hasFields(";id;name;sub_count;amount;version;");
		_for("catalog").targetType("catalog");
		_for("catalog").anchorColumn("owner");
		_for("level_one_category").referTo("catalog").withRole("catalog");
		_for("level_one_category").usedIn("level_two_category").withRole("parent_category");
		_for("level_one_category").isTree("false");
		_for("level_one_category").hasFields(";id;name;version;");
		_for("level_one_category").targetType("level_one_category");
		_for("level_one_category").anchorColumn("catalog");
		_for("potential_customer").referTo("franchised_outlet_city_service_center").withRole("city_service_center");
		_for("potential_customer").referTo("city_partner").withRole("city_partner");
		_for("potential_customer").usedIn("potential_customer_contact").withRole("potential_customer");
		_for("potential_customer").usedIn("potential_customer_contact_person").withRole("potential_customer");
		_for("potential_customer").usedIn("event_attendance").withRole("potential_customer");
		_for("potential_customer").isTree("false");
		_for("potential_customer").hasFields(";id;name;mobile;description;last_update_time;version;");
		_for("potential_customer").targetType("potential_customer");
		_for("potential_customer").anchorColumn("city_service_center");
		_for("franchised_outlet_city_center").referTo("franchised_outlet_city_center").withRole("city");
		_for("franchised_outlet_city_center").usedIn("franchised_outlet_city_service_center").withRole("belongs_to");
		_for("franchised_outlet_city_center").usedIn("franchised_outlet_city_center").withRole("city");
		_for("franchised_outlet_city_center").usedIn("city_center_department").withRole("city_center");
		_for("franchised_outlet_city_center").usedIn("city_center_employee").withRole("city_center");
		_for("franchised_outlet_city_center").isTree("false");
		_for("franchised_outlet_city_center").hasFields(";id;name;founded;last_update_time;version;");
		_for("franchised_outlet_city_center").targetType("franchised_outlet_city_center");
		_for("franchised_outlet_city_center").anchorColumn("city");
		_for("user_app").referTo("sec_user").withRole("sec_user");
		_for("user_app").usedIn("quick_link").withRole("app");
		_for("user_app").usedIn("list_access").withRole("app");
		_for("user_app").isTree("false");
		_for("user_app").hasFields(";id;title;app_icon;full_access;permission;object_type;object_id;location;version;");
		_for("user_app").targetType("user_app");
		_for("user_app").anchorColumn("sec_user");
		_for("franchised_outlet_city_service_center").referTo("franchised_outlet_city_center").withRole("belongs_to");
		_for("franchised_outlet_city_service_center").usedIn("city_event").withRole("city_service_center");
		_for("franchised_outlet_city_service_center").usedIn("city_partner").withRole("town_service_center");
		_for("franchised_outlet_city_service_center").usedIn("potential_customer").withRole("city_service_center");
		_for("franchised_outlet_city_service_center").isTree("false");
		_for("franchised_outlet_city_service_center").hasFields(";id;name;founded;last_update_time;version;");
		_for("franchised_outlet_city_service_center").targetType("franchised_outlet_city_service_center");
		_for("franchised_outlet_city_service_center").anchorColumn("belongs_to");
		_for("level_three_category").referTo("level_two_category").withRole("parent_category");
		_for("level_three_category").usedIn("product").withRole("parent_category");
		_for("level_three_category").isTree("false");
		_for("level_three_category").hasFields(";id;name;version;");
		_for("level_three_category").targetType("level_three_category");
		_for("level_three_category").anchorColumn("parent_category");
		_for("city_event").referTo("franchised_outlet_city_service_center").withRole("city_service_center");
		_for("city_event").usedIn("event_attendance").withRole("city_event");
		_for("city_event").isTree("false");
		_for("city_event").hasFields(";id;name;mobile;description;last_update_time;version;");
		_for("city_event").targetType("city_event");
		_for("city_event").anchorColumn("city_service_center");
		_for("user_domain").usedIn("user_white_list").withRole("domain");
		_for("user_domain").usedIn("sec_user").withRole("domain");
		_for("user_domain").usedIn("public_key_type").withRole("domain");
		_for("user_domain").isTree("false");
		_for("user_domain").hasFields(";id;name;version;");
		_for("user_domain").targetType("user_domain");
		_for("franchised_outlet_province_center").usedIn("catalog").withRole("owner");
		_for("franchised_outlet_province_center").isTree("false");
		_for("franchised_outlet_province_center").hasFields(";id;name;service_number;founded;web_site;address;operated_by;legal_representative;description;version;");
		_for("franchised_outlet_province_center").targetType("franchised_outlet_province_center");
		_for("level_two_category").referTo("level_one_category").withRole("parent_category");
		_for("level_two_category").usedIn("level_three_category").withRole("parent_category");
		_for("level_two_category").isTree("false");
		_for("level_two_category").hasFields(";id;name;version;");
		_for("level_two_category").targetType("level_two_category");
		_for("level_two_category").anchorColumn("parent_category");
		_for("city_partner").referTo("franchised_outlet_city_service_center").withRole("town_service_center");
		_for("city_partner").usedIn("potential_customer_contact").withRole("city_partner");
		_for("city_partner").usedIn("potential_customer").withRole("city_partner");
		_for("city_partner").isTree("false");
		_for("city_partner").hasFields(";id;name;mobile;description;last_update_time;version;");
		_for("city_partner").targetType("city_partner");
		_for("city_partner").anchorColumn("town_service_center");
		_for("potential_customer_contact_person").referTo("potential_customer").withRole("potential_customer");
		_for("potential_customer_contact_person").usedIn("potential_customer_contact").withRole("contact_to");
		_for("potential_customer_contact_person").isTree("false");
		_for("potential_customer_contact_person").hasFields(";id;name;mobile;description;version;");
		_for("potential_customer_contact_person").targetType("potential_customer_contact_person");
		_for("potential_customer_contact_person").anchorColumn("potential_customer");
		_for("city_center_department").referTo("franchised_outlet_city_center").withRole("city_center");
		_for("city_center_department").usedIn("city_center_employee").withRole("department");
		_for("city_center_department").isTree("false");
		_for("city_center_department").hasFields(";id;name;founded;manager;version;");
		_for("city_center_department").targetType("city_center_department");
		_for("city_center_department").anchorColumn("city_center");
		_for("page").referTo("page_type").withRole("page_type");
		_for("page").referTo("mobile_app").withRole("mobile_app");
		_for("page").usedIn("ui_action").withRole("page");
		_for("page").usedIn("slide").withRole("page");
		_for("page").usedIn("section").withRole("page");
		_for("page").isTree("false");
		_for("page").hasFields(";id;page_title;link_to_url;version;");
		_for("page").targetType("page");
		_for("page").anchorColumn("page_type");
		_for("public_key_type").referTo("user_domain").withRole("domain");
		_for("public_key_type").usedIn("keypair_identify").withRole("key_type");
		_for("public_key_type").isTree("false");
		_for("public_key_type").hasFields(";id;name;code;version;");
		_for("public_key_type").targetType("public_key_type");
		_for("public_key_type").anchorColumn("domain");
		_for("mobile_app").usedIn("page_type").withRole("mobile_app");
		_for("mobile_app").usedIn("page").withRole("mobile_app");
		_for("mobile_app").isTree("false");
		_for("mobile_app").hasFields(";id;name;version;");
		_for("mobile_app").targetType("mobile_app");

	}
	
	protected XingyouBaseDAOImpl currentDAO = null;
	
	public Object queryCandidates(XingyouUserContext userContext, CandidateQuery query) throws Exception {
		if (CandidateQuery.FOR_SEARCH.equals(query.getScenceCode())) {
			return queryCandidatesForSearch(userContext, query);
		}
		return queryCandidatesForAssign(userContext, query);
	}
	
	public Object queryCandidatesForAssign(XingyouUserContext userContext, CandidateQuery query) throws Exception {
		query.setScenceCode(CandidateQuery.FOR_ASSIGN);
		query = prepareQueryInput(query);
		List<Object> params = new ArrayList<>();
		String sql = prepareSqlForAssign(query, params);
		BaseCandidateEntity<? extends BaseEntity> candidates = executeQuery(userContext, query, sql, params);
		enhanceGroupByValues(userContext, query, candidates);
		return wrapperCandidates(userContext, candidates);
	}

	public Object queryCandidatesForSearch(XingyouUserContext userContext, CandidateQuery query) throws Exception {
		query.setScenceCode(CandidateQuery.FOR_SEARCH);
		query = prepareQueryInput(query);
		List<Object> params = new ArrayList<>();
		String sql = prepareSqlForSearch(query, params);
		BaseCandidateEntity<? extends BaseEntity> candidates = executeQuery(userContext, query, sql, params);
		enhanceGroupByValues(userContext, query, candidates);
		return wrapperCandidates(userContext, candidates);
	}
	
	protected Object wrapperCandidates(XingyouUserContext userContext, BaseCandidateEntity<? extends BaseEntity> candidates) throws Exception {
		SmartList<BaseEntity> cs = (SmartList<BaseEntity>) candidates.getCandidates();
		
		List<Object> rList = new ArrayList<>();
		cs.forEach(v->{
			Map<String, Object> data = new HashMap<>();
			data.put("id",v.getId());
			data.put("name",v.getDisplayName());
			data.put("valuesOfGroupBy",v.valueByKey("valuesOfGroupBy"));
			rList.add(data);
		});
		return rList;
	}
	
	protected String normalizeModelName(String name) throws Exception {
		if (name == null) {
			return null;
		}
		if (!isValidFieldName(name)) {
			throw new Exception(name+"不是一个合法的字段名");
		}
		return new XingyouNamingServiceDAO().mapToInternalColumn(name);
	}
	
	protected String getDisplayNameColumn(String typeName) {
		String displayNameColumn = XingyouNamingServiceDAO.getDisplayNameColumnName(getJavaClassName(typeName));
		return displayNameColumn;
	}

	protected BaseCandidateEntity<? extends BaseEntity> executeQuery(XingyouUserContext userContext, CandidateQuery query, String sql,
			List<Object> params) throws Exception{
		switch (query.getTargetType()) {
		case "franchised_outlet_province_center":
			currentDAO = (XingyouBaseDAOImpl)userContext.getDAOGroup().getFranchisedOutletProvinceCenterDAO();
			return userContext.getDAOGroup().getFranchisedOutletProvinceCenterDAO().executeCandidatesQuery(query, sql, params.toArray());
		case "catalog":
			currentDAO = (XingyouBaseDAOImpl)userContext.getDAOGroup().getCatalogDAO();
			return userContext.getDAOGroup().getCatalogDAO().executeCandidatesQuery(query, sql, params.toArray());
		case "level_one_category":
			currentDAO = (XingyouBaseDAOImpl)userContext.getDAOGroup().getLevelOneCategoryDAO();
			return userContext.getDAOGroup().getLevelOneCategoryDAO().executeCandidatesQuery(query, sql, params.toArray());
		case "level_two_category":
			currentDAO = (XingyouBaseDAOImpl)userContext.getDAOGroup().getLevelTwoCategoryDAO();
			return userContext.getDAOGroup().getLevelTwoCategoryDAO().executeCandidatesQuery(query, sql, params.toArray());
		case "level_three_category":
			currentDAO = (XingyouBaseDAOImpl)userContext.getDAOGroup().getLevelThreeCategoryDAO();
			return userContext.getDAOGroup().getLevelThreeCategoryDAO().executeCandidatesQuery(query, sql, params.toArray());
		case "product":
			currentDAO = (XingyouBaseDAOImpl)userContext.getDAOGroup().getProductDAO();
			return userContext.getDAOGroup().getProductDAO().executeCandidatesQuery(query, sql, params.toArray());
		case "franchised_outlet_city_center":
			currentDAO = (XingyouBaseDAOImpl)userContext.getDAOGroup().getFranchisedOutletCityCenterDAO();
			return userContext.getDAOGroup().getFranchisedOutletCityCenterDAO().executeCandidatesQuery(query, sql, params.toArray());
		case "city_center_department":
			currentDAO = (XingyouBaseDAOImpl)userContext.getDAOGroup().getCityCenterDepartmentDAO();
			return userContext.getDAOGroup().getCityCenterDepartmentDAO().executeCandidatesQuery(query, sql, params.toArray());
		case "franchised_outlet_city_service_center":
			currentDAO = (XingyouBaseDAOImpl)userContext.getDAOGroup().getFranchisedOutletCityServiceCenterDAO();
			return userContext.getDAOGroup().getFranchisedOutletCityServiceCenterDAO().executeCandidatesQuery(query, sql, params.toArray());
		case "city_partner":
			currentDAO = (XingyouBaseDAOImpl)userContext.getDAOGroup().getCityPartnerDAO();
			return userContext.getDAOGroup().getCityPartnerDAO().executeCandidatesQuery(query, sql, params.toArray());
		case "potential_customer":
			currentDAO = (XingyouBaseDAOImpl)userContext.getDAOGroup().getPotentialCustomerDAO();
			return userContext.getDAOGroup().getPotentialCustomerDAO().executeCandidatesQuery(query, sql, params.toArray());
		case "potential_customer_contact_person":
			currentDAO = (XingyouBaseDAOImpl)userContext.getDAOGroup().getPotentialCustomerContactPersonDAO();
			return userContext.getDAOGroup().getPotentialCustomerContactPersonDAO().executeCandidatesQuery(query, sql, params.toArray());
		case "city_event":
			currentDAO = (XingyouBaseDAOImpl)userContext.getDAOGroup().getCityEventDAO();
			return userContext.getDAOGroup().getCityEventDAO().executeCandidatesQuery(query, sql, params.toArray());
		case "mobile_app":
			currentDAO = (XingyouBaseDAOImpl)userContext.getDAOGroup().getMobileAppDAO();
			return userContext.getDAOGroup().getMobileAppDAO().executeCandidatesQuery(query, sql, params.toArray());
		case "page":
			currentDAO = (XingyouBaseDAOImpl)userContext.getDAOGroup().getPageDAO();
			return userContext.getDAOGroup().getPageDAO().executeCandidatesQuery(query, sql, params.toArray());
		case "page_type":
			currentDAO = (XingyouBaseDAOImpl)userContext.getDAOGroup().getPageTypeDAO();
			return userContext.getDAOGroup().getPageTypeDAO().executeCandidatesQuery(query, sql, params.toArray());
		case "user_domain":
			currentDAO = (XingyouBaseDAOImpl)userContext.getDAOGroup().getUserDomainDAO();
			return userContext.getDAOGroup().getUserDomainDAO().executeCandidatesQuery(query, sql, params.toArray());
		case "sec_user":
			currentDAO = (XingyouBaseDAOImpl)userContext.getDAOGroup().getSecUserDAO();
			return userContext.getDAOGroup().getSecUserDAO().executeCandidatesQuery(query, sql, params.toArray());
		case "user_app":
			currentDAO = (XingyouBaseDAOImpl)userContext.getDAOGroup().getUserAppDAO();
			return userContext.getDAOGroup().getUserAppDAO().executeCandidatesQuery(query, sql, params.toArray());
		case "candidate_container":
			currentDAO = (XingyouBaseDAOImpl)userContext.getDAOGroup().getCandidateContainerDAO();
			return userContext.getDAOGroup().getCandidateContainerDAO().executeCandidatesQuery(query, sql, params.toArray());
		case "public_key_type":
			currentDAO = (XingyouBaseDAOImpl)userContext.getDAOGroup().getPublicKeyTypeDAO();
			return userContext.getDAOGroup().getPublicKeyTypeDAO().executeCandidatesQuery(query, sql, params.toArray());

		default:
			throw new Exception("OOTB不支持"+query.getTargetType()+"的候选值查询");
		}
	}
	
	protected void enhanceGroupByValues(XingyouUserContext userContext, CandidateQuery query,
			BaseCandidateEntity<? extends BaseEntity> candidates) throws Exception {
		if (query.getGroupBy() == null) {
			return; // 没有group by就直接返回
		}
		if (!isGroupByObject(query)) {
			// 用字段 group by
			for(BaseEntity cv : candidates.getCandidates()) {
				appendGroupByInfo(cv, String.valueOf(cv.propertyOf(this.getJavaMemberName(query.getGroupBy()))));
			}
			// 收集了数据就OK了
			return; 
		}
		
		List<BaseEntity> list = new ArrayList<>();
		for(BaseEntity cv : candidates.getCandidates()) {
			Object x = cv.propertyOf(this.getJavaMemberName(query.getGroupBy()));
			if (x instanceof BaseEntity) {
				list.add((BaseEntity) x);
			}
		}
		
		currentDAO.alias(list);
		if (!isGroupByTree(query)) {
			for(BaseEntity cv : candidates.getCandidates()) {
				Object x = cv.propertyOf(this.getJavaMemberName(query.getGroupBy()));
				if (x instanceof BaseEntity) {
					appendGroupByInfo(cv, ((BaseEntity) x).getDisplayName());
				}
			}
			return;
		}
		
		String gbTypeName = this.getGroupByTypeName(query);
		Map<String, String[]> groupByNames = new HashMap<>();
		for(BaseEntity cv : candidates.getCandidates()) {
			Object x = cv.propertyOf(this.getJavaMemberName(query.getGroupBy()));
			if (x instanceof BaseEntity) {
				if (groupByNames.containsKey(((BaseEntity) x).getId())) {
					appendGroupByInfo(cv, groupByNames.get(((BaseEntity) x).getId()));
					continue;
				}
				Node<BaseEntity> rootNode = userContext.getTreeService().loadAncestors(userContext, (BaseEntity) x);
				List<String> names = new ArrayList<>();
				rootNode.visit((node)->{
					BaseEntity value = node.value();
					if (value == null) {
						return;
					}
					names.add(String.valueOf(value.getDisplayName()));
				});
				names.add(String.valueOf(((BaseEntity) x).getDisplayName()));
				appendGroupByInfo(cv, names.toArray(new String[] {}));
				groupByNames.put(((BaseEntity) x).getId(),names.toArray(new String[] {}));
			}
		}
	}
	
	protected void appendGroupByInfo(BaseEntity cv, String ... groupBy) {
		cv.addItemToValueMap("valuesOfGroupBy", groupBy);
	}
}




















