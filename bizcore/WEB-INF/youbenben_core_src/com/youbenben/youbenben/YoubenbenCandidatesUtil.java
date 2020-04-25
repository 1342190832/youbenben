package com.youbenben.youbenben;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

import com.youbenben.youbenben.tree.Node;
import com.terapico.caf.baseelement.CandidateQuery;
import com.terapico.utils.BaseCandidatesUtil;

public class YoubenbenCandidatesUtil extends BaseCandidatesUtil{
	static {
		_for("truck_driver").referTo("transport_fleet").withRole("belongs_to");
		_for("truck_driver").usedIn("transport_task").withRole("driver");
		_for("truck_driver").isTree("false");
		_for("truck_driver").hasFields(";id;name;driver_license_number;contact_number;version;");
		_for("truck_driver").targetType("truck_driver");
		_for("truck_driver").anchorColumn("belongs_to");
		_for("retail_store_country_center").usedIn("public_holiday").withRole("company");
		_for("retail_store_country_center").usedIn("transport_fleet").withRole("owner");
		_for("retail_store_country_center").usedIn("catalog").withRole("owner");
		_for("retail_store_country_center").usedIn("termination_reason").withRole("company");
		_for("retail_store_country_center").usedIn("interview_type").withRole("company");
		_for("retail_store_country_center").usedIn("training_course_type").withRole("company");
		_for("retail_store_country_center").usedIn("retail_store").withRole("retail_store_country_center");
		_for("retail_store_country_center").usedIn("warehouse").withRole("owner");
		_for("retail_store_country_center").usedIn("employee").withRole("company");
		_for("retail_store_country_center").usedIn("retail_store_order").withRole("seller");
		_for("retail_store_country_center").usedIn("responsibility_type").withRole("company");
		_for("retail_store_country_center").usedIn("termination_type").withRole("company");
		_for("retail_store_country_center").usedIn("salary_grade").withRole("company");
		_for("retail_store_country_center").usedIn("company_training").withRole("company");
		_for("retail_store_country_center").usedIn("goods_supplier").withRole("belong_to");
		_for("retail_store_country_center").usedIn("occupation_type").withRole("company");
		_for("retail_store_country_center").usedIn("instructor").withRole("company");
		_for("retail_store_country_center").usedIn("account_set").withRole("country_center");
		_for("retail_store_country_center").usedIn("leave_type").withRole("company");
		_for("retail_store_country_center").usedIn("retail_store_member").withRole("owner");
		_for("retail_store_country_center").usedIn("level_one_department").withRole("belongs_to");
		_for("retail_store_country_center").usedIn("skill_type").withRole("company");
		_for("retail_store_country_center").usedIn("retail_store_province_center").withRole("country");
		_for("retail_store_country_center").usedIn("supply_order").withRole("buyer");
		_for("retail_store_country_center").isTree("false");
		_for("retail_store_country_center").hasFields(";id;name;service_number;founded;web_site;address;operated_by;legal_representative;description;version;");
		_for("retail_store_country_center").targetType("retail_store_country_center");
		_for("supplier_product").referTo("goods_supplier").withRole("supplier");
		_for("supplier_product").usedIn("product_supply_duration").withRole("product");
		_for("supplier_product").isTree("false");
		_for("supplier_product").hasFields(";id;product_name;product_description;product_unit;version;");
		_for("supplier_product").targetType("supplier_product");
		_for("supplier_product").anchorColumn("supplier");
		_for("catalog").referTo("retail_store_country_center").withRole("owner");
		_for("catalog").usedIn("level_one_category").withRole("catalog");
		_for("catalog").isTree("false");
		_for("catalog").hasFields(";id;name;sub_count;amount;version;");
		_for("catalog").targetType("catalog");
		_for("catalog").anchorColumn("owner");
		_for("supply_order_confirmation").usedIn("consumer_order").withRole("confirmation");
		_for("supply_order_confirmation").usedIn("supply_order").withRole("confirmation");
		_for("supply_order_confirmation").isTree("false");
		_for("supply_order_confirmation").hasFields(";id;who;confirm_time;version;");
		_for("supply_order_confirmation").targetType("supply_order_confirmation");
		_for("potential_customer").referTo("city_partner").withRole("city_partner");
		_for("potential_customer").referTo("retail_store_city_service_center").withRole("city_service_center");
		_for("potential_customer").usedIn("potential_customer_contact").withRole("potential_customer");
		_for("potential_customer").usedIn("potential_customer_contact_person").withRole("potential_customer");
		_for("potential_customer").usedIn("event_attendance").withRole("potential_customer");
		_for("potential_customer").isTree("false");
		_for("potential_customer").hasFields(";id;name;mobile;description;last_update_time;version;");
		_for("potential_customer").targetType("potential_customer");
		_for("potential_customer").anchorColumn("city_service_center");
		_for("retail_store").referTo("retail_store_country_center").withRole("retail_store_country_center");
		_for("retail_store").referTo("retail_store_franchising").withRole("franchising");
		_for("retail_store").referTo("retail_store_decoration").withRole("decoration");
		_for("retail_store").referTo("retail_store_closing").withRole("closing");
		_for("retail_store").referTo("retail_store_creation").withRole("creation");
		_for("retail_store").referTo("retail_store_city_service_center").withRole("city_service_center");
		_for("retail_store").referTo("retail_store_investment_invitation").withRole("investment_invitation");
		_for("retail_store").referTo("retail_store_opening").withRole("opening");
		_for("retail_store").usedIn("consumer_order").withRole("store");
		_for("retail_store").usedIn("account_set").withRole("retail_store");
		_for("retail_store").usedIn("goods").withRole("retail_store");
		_for("retail_store").usedIn("transport_task").withRole("end");
		_for("retail_store").usedIn("retail_store_order").withRole("buyer");
		_for("retail_store").isTree("false");
		_for("retail_store").hasFields(";id;name;telephone;owner;founded;latitude;longitude;description;last_update_time;version;");
		_for("retail_store").targetType("retail_store");
		_for("retail_store").anchorColumn("retail_store_country_center");
		_for("original_voucher_auditing").usedIn("original_voucher").withRole("auditing");
		_for("original_voucher_auditing").isTree("false");
		_for("original_voucher_auditing").hasFields(";id;who;comments;make_date;version;");
		_for("original_voucher_auditing").targetType("original_voucher_auditing");
		_for("responsibility_type").referTo("retail_store_country_center").withRole("company");
		_for("responsibility_type").usedIn("employee").withRole("responsible_for");
		_for("responsibility_type").isTree("false");
		_for("responsibility_type").hasFields(";id;code;base_description;detail_description;version;");
		_for("responsibility_type").targetType("responsibility_type");
		_for("responsibility_type").anchorColumn("company");
		_for("termination_type").referTo("retail_store_country_center").withRole("company");
		_for("termination_type").usedIn("termination").withRole("type");
		_for("termination_type").isTree("false");
		_for("termination_type").hasFields(";id;code;base_description;detail_description;version;");
		_for("termination_type").targetType("termination_type");
		_for("termination_type").anchorColumn("company");
		_for("accounting_document_creation").usedIn("accounting_document").withRole("creation");
		_for("accounting_document_creation").isTree("false");
		_for("accounting_document_creation").hasFields(";id;who;comments;make_date;version;");
		_for("accounting_document_creation").targetType("accounting_document_creation");
		_for("retail_store_city_service_center").referTo("retail_store_province_center").withRole("belongs_to");
		_for("retail_store_city_service_center").usedIn("city_event").withRole("city_service_center");
		_for("retail_store_city_service_center").usedIn("city_partner").withRole("city_service_center");
		_for("retail_store_city_service_center").usedIn("potential_customer").withRole("city_service_center");
		_for("retail_store_city_service_center").usedIn("retail_store").withRole("city_service_center");
		_for("retail_store_city_service_center").isTree("false");
		_for("retail_store_city_service_center").hasFields(";id;name;founded;last_update_time;version;");
		_for("retail_store_city_service_center").targetType("retail_store_city_service_center");
		_for("retail_store_city_service_center").anchorColumn("belongs_to");
		_for("sku").referTo("product").withRole("product");
		_for("sku").usedIn("goods").withRole("sku");
		_for("sku").isTree("false");
		_for("sku").hasFields(";id;name;size;barcode;package_type;net_content;price;picture;version;");
		_for("sku").targetType("sku");
		_for("sku").anchorColumn("product");
		_for("candidate_container").usedIn("candidate_element").withRole("container");
		_for("candidate_container").isTree("false");
		_for("candidate_container").hasFields(";id;name;version;");
		_for("candidate_container").targetType("candidate_container");
		_for("termination_reason").referTo("retail_store_country_center").withRole("company");
		_for("termination_reason").usedIn("termination").withRole("reason");
		_for("termination_reason").isTree("false");
		_for("termination_reason").hasFields(";id;code;description;version;");
		_for("termination_reason").targetType("termination_reason");
		_for("termination_reason").anchorColumn("company");
		_for("training_course_type").referTo("retail_store_country_center").withRole("company");
		_for("training_course_type").usedIn("company_training").withRole("training_course_type");
		_for("training_course_type").isTree("false");
		_for("training_course_type").hasFields(";id;code;name;description;version;");
		_for("training_course_type").targetType("training_course_type");
		_for("training_course_type").anchorColumn("company");
		_for("warehouse").referTo("retail_store_country_center").withRole("owner");
		_for("warehouse").usedIn("warehouse_asset").withRole("owner");
		_for("warehouse").usedIn("damage_space").withRole("warehouse");
		_for("warehouse").usedIn("shipping_space").withRole("warehouse");
		_for("warehouse").usedIn("storage_space").withRole("warehouse");
		_for("warehouse").usedIn("supplier_space").withRole("warehouse");
		_for("warehouse").usedIn("smart_pallet").withRole("warehouse");
		_for("warehouse").usedIn("receiving_space").withRole("warehouse");
		_for("warehouse").isTree("false");
		_for("warehouse").hasFields(";id;location;contact_number;total_area;latitude;longitude;last_update_time;version;");
		_for("warehouse").targetType("warehouse");
		_for("warehouse").anchorColumn("owner");
		_for("accounting_document_confirmation").usedIn("accounting_document").withRole("confirmation");
		_for("accounting_document_confirmation").isTree("false");
		_for("accounting_document_confirmation").hasFields(";id;who;comments;make_date;version;");
		_for("accounting_document_confirmation").targetType("accounting_document_confirmation");
		_for("goods_supplier").referTo("retail_store_country_center").withRole("belong_to");
		_for("goods_supplier").usedIn("supplier_product").withRole("supplier");
		_for("goods_supplier").usedIn("account_set").withRole("goods_supplier");
		_for("goods_supplier").usedIn("supply_order").withRole("seller");
		_for("goods_supplier").isTree("false");
		_for("goods_supplier").hasFields(";id;name;supply_product;contact_number;description;last_update_time;version;");
		_for("goods_supplier").targetType("goods_supplier");
		_for("goods_supplier").anchorColumn("belong_to");
		_for("supply_order_shipment").usedIn("consumer_order").withRole("shipment");
		_for("supply_order_shipment").usedIn("supply_order").withRole("shipment");
		_for("supply_order_shipment").isTree("false");
		_for("supply_order_shipment").hasFields(";id;who;ship_time;version;");
		_for("supply_order_shipment").targetType("supply_order_shipment");
		_for("accounting_document_type").referTo("account_set").withRole("accounting_period");
		_for("accounting_document_type").usedIn("accounting_document").withRole("document_type");
		_for("accounting_document_type").isTree("false");
		_for("accounting_document_type").hasFields(";id;name;description;version;");
		_for("accounting_document_type").targetType("accounting_document_type");
		_for("accounting_document_type").anchorColumn("accounting_period");
		_for("shipping_space").referTo("warehouse").withRole("warehouse");
		_for("shipping_space").usedIn("goods").withRole("shipping_space");
		_for("shipping_space").isTree("false");
		_for("shipping_space").hasFields(";id;location;contact_number;total_area;latitude;longitude;description;last_update_time;version;");
		_for("shipping_space").targetType("shipping_space");
		_for("shipping_space").anchorColumn("warehouse");
		_for("retail_store_order_confirmation").usedIn("retail_store_order").withRole("confirmation");
		_for("retail_store_order_confirmation").isTree("false");
		_for("retail_store_order_confirmation").hasFields(";id;who;confirm_time;version;");
		_for("retail_store_order_confirmation").targetType("retail_store_order_confirmation");
		_for("transport_task").referTo("truck_driver").withRole("driver");
		_for("transport_task").referTo("transport_fleet").withRole("belongs_to");
		_for("transport_task").referTo("transport_truck").withRole("truck");
		_for("transport_task").referTo("retail_store").withRole("end");
		_for("transport_task").usedIn("goods").withRole("transport_task");
		_for("transport_task").usedIn("transport_task_track").withRole("movement");
		_for("transport_task").isTree("false");
		_for("transport_task").hasFields(";id;name;start;begin_time;latitude;longitude;version;");
		_for("transport_task").targetType("transport_task");
		_for("transport_task").anchorColumn("end");
		_for("page_type").referTo("mobile_app").withRole("mobile_app");
		_for("page_type").usedIn("page").withRole("page_type");
		_for("page_type").isTree("false");
		_for("page_type").hasFields(";id;name;code;footer_tab;version;");
		_for("page_type").targetType("page_type");
		_for("page_type").anchorColumn("mobile_app");
		_for("accounting_subject").referTo("account_set").withRole("account_set");
		_for("accounting_subject").usedIn("accounting_document_line").withRole("accounting_subject");
		_for("accounting_subject").isTree("false");
		_for("accounting_subject").hasFields(";id;accounting_subject_code;accounting_subject_name;accounting_subject_class_code;accounting_subject_class_name;version;");
		_for("accounting_subject").targetType("accounting_subject");
		_for("accounting_subject").anchorColumn("account_set");
		_for("smart_pallet").referTo("warehouse").withRole("warehouse");
		_for("smart_pallet").usedIn("goods").withRole("smart_pallet");
		_for("smart_pallet").isTree("false");
		_for("smart_pallet").hasFields(";id;location;contact_number;total_area;latitude;longitude;last_update_time;version;");
		_for("smart_pallet").targetType("smart_pallet");
		_for("smart_pallet").anchorColumn("warehouse");
		_for("accounting_document_auditing").usedIn("accounting_document").withRole("auditing");
		_for("accounting_document_auditing").isTree("false");
		_for("accounting_document_auditing").hasFields(";id;who;comments;make_date;version;");
		_for("accounting_document_auditing").targetType("accounting_document_auditing");
		_for("retail_store_opening").usedIn("retail_store").withRole("opening");
		_for("retail_store_opening").isTree("false");
		_for("retail_store_opening").hasFields(";id;comment;version;");
		_for("retail_store_opening").targetType("retail_store_opening");
		_for("salary_grade").referTo("retail_store_country_center").withRole("company");
		_for("salary_grade").usedIn("employee_salary_sheet").withRole("current_salary_grade");
		_for("salary_grade").usedIn("employee").withRole("current_salary_grade");
		_for("salary_grade").isTree("false");
		_for("salary_grade").hasFields(";id;code;name;detail_description;version;");
		_for("salary_grade").targetType("salary_grade");
		_for("salary_grade").anchorColumn("company");
		_for("company_training").referTo("retail_store_country_center").withRole("company");
		_for("company_training").referTo("instructor").withRole("instructor");
		_for("company_training").referTo("training_course_type").withRole("training_course_type");
		_for("company_training").usedIn("employee_company_training").withRole("training");
		_for("company_training").isTree("false");
		_for("company_training").hasFields(";id;title;time_start;duration_hours;last_update_time;version;");
		_for("company_training").targetType("company_training");
		_for("company_training").anchorColumn("company");
		_for("occupation_type").referTo("retail_store_country_center").withRole("company");
		_for("occupation_type").usedIn("employee").withRole("occupation");
		_for("occupation_type").isTree("false");
		_for("occupation_type").hasFields(";id;code;description;detail_description;version;");
		_for("occupation_type").targetType("occupation_type");
		_for("occupation_type").anchorColumn("company");
		_for("retail_store_order_shipment").usedIn("retail_store_order").withRole("shipment");
		_for("retail_store_order_shipment").isTree("false");
		_for("retail_store_order_shipment").hasFields(";id;who;ship_time;version;");
		_for("retail_store_order_shipment").targetType("retail_store_order_shipment");
		_for("level_one_department").referTo("retail_store_country_center").withRole("belongs_to");
		_for("level_one_department").usedIn("level_two_department").withRole("belongs_to");
		_for("level_one_department").isTree("false");
		_for("level_one_department").hasFields(";id;name;description;manager;founded;version;");
		_for("level_one_department").targetType("level_one_department");
		_for("level_one_department").anchorColumn("belongs_to");
		_for("profession_interview").usedIn("employee").withRole("profession_interview");
		_for("profession_interview").isTree("false");
		_for("profession_interview").hasFields(";id;who;interview_time;comments;version;");
		_for("profession_interview").targetType("profession_interview");
		_for("supply_order").referTo("supply_order_approval").withRole("approval");
		_for("supply_order").referTo("retail_store_country_center").withRole("buyer");
		_for("supply_order").referTo("supply_order_delivery").withRole("delivery");
		_for("supply_order").referTo("goods_supplier").withRole("seller");
		_for("supply_order").referTo("supply_order_picking").withRole("picking");
		_for("supply_order").referTo("supply_order_shipment").withRole("shipment");
		_for("supply_order").referTo("supply_order_confirmation").withRole("confirmation");
		_for("supply_order").referTo("supply_order_processing").withRole("processing");
		_for("supply_order").usedIn("supply_order_shipping_group").withRole("biz_order");
		_for("supply_order").usedIn("supply_order_line_item").withRole("biz_order");
		_for("supply_order").usedIn("supply_order_payment_group").withRole("biz_order");
		_for("supply_order").usedIn("goods").withRole("biz_order");
		_for("supply_order").isTree("false");
		_for("supply_order").hasFields(";id;title;total_amount;last_update_time;version;");
		_for("supply_order").targetType("supply_order");
		_for("supply_order").anchorColumn("buyer");
		_for("receiving_space").referTo("warehouse").withRole("warehouse");
		_for("receiving_space").usedIn("goods").withRole("receiving_space");
		_for("receiving_space").isTree("false");
		_for("receiving_space").hasFields(";id;location;contact_number;description;total_area;latitude;longitude;last_update_time;version;");
		_for("receiving_space").targetType("receiving_space");
		_for("receiving_space").anchorColumn("warehouse");
		_for("product").referTo("level_three_category").withRole("parent_category");
		_for("product").usedIn("sku").withRole("product");
		_for("product").isTree("false");
		_for("product").hasFields(";id;name;origin;remark;brand;picture;last_update_time;version;");
		_for("product").targetType("product");
		_for("product").anchorColumn("parent_category");
		_for("original_voucher_creation").usedIn("original_voucher").withRole("creation");
		_for("original_voucher_creation").isTree("false");
		_for("original_voucher_creation").hasFields(";id;who;comments;make_date;version;");
		_for("original_voucher_creation").targetType("original_voucher_creation");
		_for("scoring").usedIn("employee_company_training").withRole("scoring");
		_for("scoring").isTree("false");
		_for("scoring").hasFields(";id;scored_by;score;comment;version;");
		_for("scoring").targetType("scoring");
		_for("damage_space").referTo("warehouse").withRole("warehouse");
		_for("damage_space").usedIn("goods_shelf").withRole("damage_space");
		_for("damage_space").isTree("false");
		_for("damage_space").hasFields(";id;location;contact_number;total_area;latitude;longitude;last_update_time;version;");
		_for("damage_space").targetType("damage_space");
		_for("damage_space").anchorColumn("warehouse");
		_for("supply_order_delivery").usedIn("consumer_order").withRole("delivery");
		_for("supply_order_delivery").usedIn("supply_order").withRole("delivery");
		_for("supply_order_delivery").isTree("false");
		_for("supply_order_delivery").hasFields(";id;who;delivery_time;version;");
		_for("supply_order_delivery").targetType("supply_order_delivery");
		_for("retail_store_order_delivery").usedIn("retail_store_order").withRole("delivery");
		_for("retail_store_order_delivery").isTree("false");
		_for("retail_store_order_delivery").hasFields(";id;who;delivery_time;version;");
		_for("retail_store_order_delivery").targetType("retail_store_order_delivery");
		_for("job_application").usedIn("employee").withRole("job_application");
		_for("job_application").isTree("false");
		_for("job_application").hasFields(";id;application_time;who;comments;version;");
		_for("job_application").targetType("job_application");
		_for("storage_space").referTo("warehouse").withRole("warehouse");
		_for("storage_space").usedIn("goods_shelf").withRole("storage_space");
		_for("storage_space").isTree("false");
		_for("storage_space").hasFields(";id;location;contact_number;total_area;latitude;longitude;last_update_time;version;");
		_for("storage_space").targetType("storage_space");
		_for("storage_space").anchorColumn("warehouse");
		_for("transport_fleet").referTo("retail_store_country_center").withRole("owner");
		_for("transport_fleet").usedIn("truck_driver").withRole("belongs_to");
		_for("transport_fleet").usedIn("transport_truck").withRole("owner");
		_for("transport_fleet").usedIn("transport_task").withRole("belongs_to");
		_for("transport_fleet").isTree("false");
		_for("transport_fleet").hasFields(";id;name;contact_number;last_update_time;version;");
		_for("transport_fleet").targetType("transport_fleet");
		_for("transport_fleet").anchorColumn("owner");
		_for("retail_store_decoration").usedIn("retail_store").withRole("decoration");
		_for("retail_store_decoration").isTree("false");
		_for("retail_store_decoration").hasFields(";id;comment;version;");
		_for("retail_store_decoration").targetType("retail_store_decoration");
		_for("offer_acceptance").usedIn("employee").withRole("offer_acceptance");
		_for("offer_acceptance").isTree("false");
		_for("offer_acceptance").hasFields(";id;who;accept_time;comments;version;");
		_for("offer_acceptance").targetType("offer_acceptance");
		_for("member_wishlist").referTo("retail_store_member").withRole("owner");
		_for("member_wishlist").usedIn("member_wishlist_product").withRole("owner");
		_for("member_wishlist").isTree("false");
		_for("member_wishlist").hasFields(";id;name;version;");
		_for("member_wishlist").targetType("member_wishlist");
		_for("member_wishlist").anchorColumn("owner");
		_for("goods").referTo("goods_allocation").withRole("goods_allocation");
		_for("goods").referTo("shipping_space").withRole("shipping_space");
		_for("goods").referTo("goods_packaging").withRole("packaging");
		_for("goods").referTo("retail_store").withRole("retail_store");
		_for("goods").referTo("sku").withRole("sku");
		_for("goods").referTo("transport_task").withRole("transport_task");
		_for("goods").referTo("smart_pallet").withRole("smart_pallet");
		_for("goods").referTo("supply_order").withRole("biz_order");
		_for("goods").referTo("receiving_space").withRole("receiving_space");
		_for("goods").referTo("retail_store_order").withRole("retail_store_order");
		_for("goods").usedIn("goods_movement").withRole("goods");
		_for("goods").isTree("false");
		_for("goods").hasFields(";id;name;rfid;uom;max_package;expire_time;version;");
		_for("goods").targetType("goods");
		_for("goods").anchorColumn("sku");
		_for("supplier_space").referTo("warehouse").withRole("warehouse");
		_for("supplier_space").usedIn("goods_shelf").withRole("supplier_space");
		_for("supplier_space").isTree("false");
		_for("supplier_space").hasFields(";id;location;contact_number;total_area;latitude;longitude;last_update_time;version;");
		_for("supplier_space").targetType("supplier_space");
		_for("supplier_space").anchorColumn("warehouse");
		_for("employee").referTo("termination").withRole("termination");
		_for("employee").referTo("retail_store_country_center").withRole("company");
		_for("employee").referTo("responsibility_type").withRole("responsible_for");
		_for("employee").referTo("salary_grade").withRole("current_salary_grade");
		_for("employee").referTo("level_three_department").withRole("department");
		_for("employee").referTo("occupation_type").withRole("occupation");
		_for("employee").referTo("job_application").withRole("job_application");
		_for("employee").referTo("offer_acceptance").withRole("offer_acceptance");
		_for("employee").referTo("offer_approval").withRole("offer_approval");
		_for("employee").referTo("profession_interview").withRole("profession_interview");
		_for("employee").referTo("hr_interview").withRole("hr_interview");
		_for("employee").referTo("employee_boarding").withRole("employee_boarding");
		_for("employee").usedIn("employee_qualifier").withRole("employee");
		_for("employee").usedIn("employee_salary_sheet").withRole("employee");
		_for("employee").usedIn("paying_off").withRole("paid_for");
		_for("employee").usedIn("employee_work_experience").withRole("employee");
		_for("employee").usedIn("employee_performance").withRole("employee");
		_for("employee").usedIn("employee_company_training").withRole("employee");
		_for("employee").usedIn("employee_award").withRole("employee");
		_for("employee").usedIn("employee_interview").withRole("employee");
		_for("employee").usedIn("employee_skill").withRole("employee");
		_for("employee").usedIn("employee_leave").withRole("who");
		_for("employee").usedIn("employee_education").withRole("employee");
		_for("employee").usedIn("employee_attendance").withRole("employee");
		_for("employee").isTree("false");
		_for("employee").hasFields(";id;title;family_name;given_name;email;city;address;cell_phone;salary_account;last_update_time;version;");
		_for("employee").targetType("employee");
		_for("employee").anchorColumn("company");
		_for("goods_shelf").referTo("damage_space").withRole("damage_space");
		_for("goods_shelf").referTo("storage_space").withRole("storage_space");
		_for("goods_shelf").referTo("supplier_space").withRole("supplier_space");
		_for("goods_shelf").usedIn("goods_allocation").withRole("goods_shelf");
		_for("goods_shelf").usedIn("goods_shelf_stock_count").withRole("shelf");
		_for("goods_shelf").isTree("false");
		_for("goods_shelf").hasFields(";id;location;last_update_time;version;");
		_for("goods_shelf").targetType("goods_shelf");
		_for("goods_shelf").anchorColumn("storage_space");
		_for("retail_store_order_processing").usedIn("retail_store_order").withRole("processing");
		_for("retail_store_order_processing").isTree("false");
		_for("retail_store_order_processing").hasFields(";id;who;process_time;version;");
		_for("retail_store_order_processing").targetType("retail_store_order_processing");
		_for("user_app").referTo("sec_user").withRole("sec_user");
		_for("user_app").usedIn("quick_link").withRole("app");
		_for("user_app").usedIn("list_access").withRole("app");
		_for("user_app").isTree("false");
		_for("user_app").hasFields(";id;title;app_icon;full_access;permission;object_type;object_id;location;version;");
		_for("user_app").targetType("user_app");
		_for("user_app").anchorColumn("sec_user");
		_for("supply_order_approval").usedIn("consumer_order").withRole("approval");
		_for("supply_order_approval").usedIn("supply_order").withRole("approval");
		_for("supply_order_approval").isTree("false");
		_for("supply_order_approval").hasFields(";id;who;approve_time;version;");
		_for("supply_order_approval").targetType("supply_order_approval");
		_for("retail_store_order_approval").usedIn("retail_store_order").withRole("approval");
		_for("retail_store_order_approval").isTree("false");
		_for("retail_store_order_approval").hasFields(";id;who;approve_time;version;");
		_for("retail_store_order_approval").targetType("retail_store_order_approval");
		_for("paying_off").referTo("employee").withRole("paid_for");
		_for("paying_off").usedIn("employee_salary_sheet").withRole("paying_off");
		_for("paying_off").isTree("false");
		_for("paying_off").hasFields(";id;who;paid_time;amount;version;");
		_for("paying_off").targetType("paying_off");
		_for("paying_off").anchorColumn("paid_for");
		_for("user_domain").usedIn("user_white_list").withRole("domain");
		_for("user_domain").usedIn("sec_user").withRole("domain");
		_for("user_domain").usedIn("public_key_type").withRole("domain");
		_for("user_domain").isTree("false");
		_for("user_domain").hasFields(";id;name;version;");
		_for("user_domain").targetType("user_domain");
		_for("city_partner").referTo("retail_store_city_service_center").withRole("city_service_center");
		_for("city_partner").usedIn("potential_customer_contact").withRole("city_partner");
		_for("city_partner").usedIn("potential_customer").withRole("city_partner");
		_for("city_partner").isTree("false");
		_for("city_partner").hasFields(";id;name;mobile;description;last_update_time;version;");
		_for("city_partner").targetType("city_partner");
		_for("city_partner").anchorColumn("city_service_center");
		_for("supply_order_processing").usedIn("consumer_order").withRole("processing");
		_for("supply_order_processing").usedIn("supply_order").withRole("processing");
		_for("supply_order_processing").isTree("false");
		_for("supply_order_processing").hasFields(";id;who;process_time;version;");
		_for("supply_order_processing").targetType("supply_order_processing");
		_for("mobile_app").usedIn("page_type").withRole("mobile_app");
		_for("mobile_app").usedIn("page").withRole("mobile_app");
		_for("mobile_app").isTree("false");
		_for("mobile_app").hasFields(";id;name;version;");
		_for("mobile_app").targetType("mobile_app");
		_for("termination").referTo("termination_type").withRole("type");
		_for("termination").referTo("termination_reason").withRole("reason");
		_for("termination").usedIn("employee").withRole("termination");
		_for("termination").isTree("false");
		_for("termination").hasFields(";id;comment;version;");
		_for("termination").targetType("termination");
		_for("termination").anchorColumn("reason");
		_for("retail_store_order_picking").usedIn("retail_store_order").withRole("picking");
		_for("retail_store_order_picking").isTree("false");
		_for("retail_store_order_picking").hasFields(";id;who;process_time;version;");
		_for("retail_store_order_picking").targetType("retail_store_order_picking");
		_for("retail_store_franchising").usedIn("retail_store").withRole("franchising");
		_for("retail_store_franchising").isTree("false");
		_for("retail_store_franchising").hasFields(";id;comment;version;");
		_for("retail_store_franchising").targetType("retail_store_franchising");
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
		_for("level_one_category").referTo("catalog").withRole("catalog");
		_for("level_one_category").usedIn("level_two_category").withRole("parent_category");
		_for("level_one_category").isTree("false");
		_for("level_one_category").hasFields(";id;name;version;");
		_for("level_one_category").targetType("level_one_category");
		_for("level_one_category").anchorColumn("catalog");
		_for("retail_store_investment_invitation").usedIn("retail_store").withRole("investment_invitation");
		_for("retail_store_investment_invitation").isTree("false");
		_for("retail_store_investment_invitation").hasFields(";id;comment;version;");
		_for("retail_store_investment_invitation").targetType("retail_store_investment_invitation");
		_for("retail_store_order").referTo("retail_store_order_approval").withRole("approval");
		_for("retail_store_order").referTo("retail_store_country_center").withRole("seller");
		_for("retail_store_order").referTo("retail_store_order_delivery").withRole("delivery");
		_for("retail_store_order").referTo("retail_store_order_picking").withRole("picking");
		_for("retail_store_order").referTo("retail_store_order_shipment").withRole("shipment");
		_for("retail_store_order").referTo("retail_store_order_confirmation").withRole("confirmation");
		_for("retail_store_order").referTo("retail_store").withRole("buyer");
		_for("retail_store_order").referTo("retail_store_order_processing").withRole("processing");
		_for("retail_store_order").usedIn("retail_store_order_payment_group").withRole("biz_order");
		_for("retail_store_order").usedIn("retail_store_order_line_item").withRole("biz_order");
		_for("retail_store_order").usedIn("retail_store_order_shipping_group").withRole("biz_order");
		_for("retail_store_order").usedIn("goods").withRole("retail_store_order");
		_for("retail_store_order").isTree("false");
		_for("retail_store_order").hasFields(";id;title;total_amount;last_update_time;version;");
		_for("retail_store_order").targetType("retail_store_order");
		_for("retail_store_order").anchorColumn("buyer");
		_for("level_three_category").referTo("level_two_category").withRole("parent_category");
		_for("level_three_category").usedIn("product").withRole("parent_category");
		_for("level_three_category").isTree("false");
		_for("level_three_category").hasFields(";id;name;version;");
		_for("level_three_category").targetType("level_three_category");
		_for("level_three_category").anchorColumn("parent_category");
		_for("goods_allocation").referTo("goods_shelf").withRole("goods_shelf");
		_for("goods_allocation").usedIn("goods").withRole("goods_allocation");
		_for("goods_allocation").isTree("false");
		_for("goods_allocation").hasFields(";id;location;latitude;longitude;version;");
		_for("goods_allocation").targetType("goods_allocation");
		_for("goods_allocation").anchorColumn("goods_shelf");
		_for("level_three_department").referTo("level_two_department").withRole("belongs_to");
		_for("level_three_department").usedIn("employee").withRole("department");
		_for("level_three_department").isTree("false");
		_for("level_three_department").hasFields(";id;name;description;founded;version;");
		_for("level_three_department").targetType("level_three_department");
		_for("level_three_department").anchorColumn("belongs_to");
		_for("instructor").referTo("retail_store_country_center").withRole("company");
		_for("instructor").usedIn("company_training").withRole("instructor");
		_for("instructor").isTree("false");
		_for("instructor").hasFields(";id;title;family_name;given_name;cell_phone;email;introduction;last_update_time;version;");
		_for("instructor").targetType("instructor");
		_for("instructor").anchorColumn("company");
		_for("skill_type").referTo("retail_store_country_center").withRole("company");
		_for("skill_type").usedIn("employee_skill").withRole("skill_type");
		_for("skill_type").isTree("false");
		_for("skill_type").hasFields(";id;code;description;version;");
		_for("skill_type").targetType("skill_type");
		_for("skill_type").anchorColumn("company");
		_for("page").referTo("page_type").withRole("page_type");
		_for("page").referTo("mobile_app").withRole("mobile_app");
		_for("page").usedIn("ui_action").withRole("page");
		_for("page").usedIn("slide").withRole("page");
		_for("page").usedIn("section").withRole("page");
		_for("page").isTree("false");
		_for("page").hasFields(";id;page_title;link_to_url;version;");
		_for("page").targetType("page");
		_for("page").anchorColumn("page_type");
		_for("accounting_period").referTo("account_set").withRole("account_set");
		_for("accounting_period").usedIn("accounting_document").withRole("accounting_period");
		_for("accounting_period").isTree("false");
		_for("accounting_period").hasFields(";id;name;start_date;end_date;version;");
		_for("accounting_period").targetType("accounting_period");
		_for("accounting_period").anchorColumn("account_set");
		_for("employee_boarding").usedIn("employee").withRole("employee_boarding");
		_for("employee_boarding").isTree("false");
		_for("employee_boarding").hasFields(";id;who;employ_time;comments;version;");
		_for("employee_boarding").targetType("employee_boarding");
		_for("retail_store_member_gift_card").referTo("retail_store_member").withRole("owner");
		_for("retail_store_member_gift_card").usedIn("retail_store_member_gift_card_consume_record").withRole("owner");
		_for("retail_store_member_gift_card").isTree("false");
		_for("retail_store_member_gift_card").hasFields(";id;name;number;remain;version;");
		_for("retail_store_member_gift_card").targetType("retail_store_member_gift_card");
		_for("retail_store_member_gift_card").anchorColumn("owner");
		_for("transport_truck").referTo("transport_fleet").withRole("owner");
		_for("transport_truck").usedIn("transport_task").withRole("truck");
		_for("transport_truck").isTree("false");
		_for("transport_truck").hasFields(";id;name;plate_number;contact_number;vehicle_license_number;engine_number;make_date;mileage;body_color;version;");
		_for("transport_truck").targetType("transport_truck");
		_for("transport_truck").anchorColumn("owner");
		_for("interview_type").referTo("retail_store_country_center").withRole("company");
		_for("interview_type").usedIn("employee_interview").withRole("interview_type");
		_for("interview_type").isTree("false");
		_for("interview_type").hasFields(";id;code;description;detail_description;version;");
		_for("interview_type").targetType("interview_type");
		_for("interview_type").anchorColumn("company");
		_for("accounting_document").referTo("accounting_document_type").withRole("document_type");
		_for("accounting_document").referTo("accounting_document_posting").withRole("posting");
		_for("accounting_document").referTo("accounting_document_creation").withRole("creation");
		_for("accounting_document").referTo("accounting_period").withRole("accounting_period");
		_for("accounting_document").referTo("accounting_document_auditing").withRole("auditing");
		_for("accounting_document").referTo("accounting_document_confirmation").withRole("confirmation");
		_for("accounting_document").usedIn("original_voucher").withRole("belongs_to");
		_for("accounting_document").usedIn("accounting_document_line").withRole("belongs_to");
		_for("accounting_document").isTree("false");
		_for("accounting_document").hasFields(";id;name;accounting_document_date;version;");
		_for("accounting_document").targetType("accounting_document");
		_for("accounting_document").anchorColumn("accounting_period");
		_for("hr_interview").usedIn("employee").withRole("hr_interview");
		_for("hr_interview").isTree("false");
		_for("hr_interview").hasFields(";id;who;interview_time;comments;version;");
		_for("hr_interview").targetType("hr_interview");
		_for("province_center_department").referTo("retail_store_province_center").withRole("province_center");
		_for("province_center_department").usedIn("province_center_employee").withRole("department");
		_for("province_center_department").isTree("false");
		_for("province_center_department").hasFields(";id;name;founded;manager;version;");
		_for("province_center_department").targetType("province_center_department");
		_for("province_center_department").anchorColumn("province_center");
		_for("level_two_department").referTo("level_one_department").withRole("belongs_to");
		_for("level_two_department").usedIn("level_three_department").withRole("belongs_to");
		_for("level_two_department").isTree("false");
		_for("level_two_department").hasFields(";id;name;description;founded;version;");
		_for("level_two_department").targetType("level_two_department");
		_for("level_two_department").anchorColumn("belongs_to");
		_for("goods_shelf_stock_count").referTo("goods_shelf").withRole("shelf");
		_for("goods_shelf_stock_count").usedIn("stock_count_issue_track").withRole("stock_count");
		_for("goods_shelf_stock_count").isTree("false");
		_for("goods_shelf_stock_count").hasFields(";id;title;count_time;summary;version;");
		_for("goods_shelf_stock_count").targetType("goods_shelf_stock_count");
		_for("goods_shelf_stock_count").anchorColumn("shelf");
		_for("retail_store_member").referTo("retail_store_country_center").withRole("owner");
		_for("retail_store_member").usedIn("consumer_order").withRole("consumer");
		_for("retail_store_member").usedIn("retail_store_member_address").withRole("owner");
		_for("retail_store_member").usedIn("member_reward_point_redemption").withRole("owner");
		_for("retail_store_member").usedIn("member_wishlist").withRole("owner");
		_for("retail_store_member").usedIn("member_reward_point").withRole("owner");
		_for("retail_store_member").usedIn("retail_store_member_gift_card").withRole("owner");
		_for("retail_store_member").usedIn("retail_store_member_coupon").withRole("owner");
		_for("retail_store_member").isTree("false");
		_for("retail_store_member").hasFields(";id;name;mobile_phone;version;");
		_for("retail_store_member").targetType("retail_store_member");
		_for("retail_store_member").anchorColumn("owner");
		_for("goods_packaging").usedIn("goods").withRole("packaging");
		_for("goods_packaging").isTree("false");
		_for("goods_packaging").hasFields(";id;package_name;rfid;package_time;description;version;");
		_for("goods_packaging").targetType("goods_packaging");
		_for("potential_customer_contact_person").referTo("potential_customer").withRole("potential_customer");
		_for("potential_customer_contact_person").usedIn("potential_customer_contact").withRole("contact_to");
		_for("potential_customer_contact_person").isTree("false");
		_for("potential_customer_contact_person").hasFields(";id;name;mobile;description;version;");
		_for("potential_customer_contact_person").targetType("potential_customer_contact_person");
		_for("potential_customer_contact_person").anchorColumn("potential_customer");
		_for("accounting_document_posting").usedIn("accounting_document").withRole("posting");
		_for("accounting_document_posting").isTree("false");
		_for("accounting_document_posting").hasFields(";id;who;comments;make_date;version;");
		_for("accounting_document_posting").targetType("accounting_document_posting");
		_for("original_voucher_confirmation").usedIn("original_voucher").withRole("confirmation");
		_for("original_voucher_confirmation").isTree("false");
		_for("original_voucher_confirmation").hasFields(";id;who;comments;make_date;version;");
		_for("original_voucher_confirmation").targetType("original_voucher_confirmation");
		_for("public_key_type").referTo("user_domain").withRole("domain");
		_for("public_key_type").usedIn("keypair_identify").withRole("key_type");
		_for("public_key_type").isTree("false");
		_for("public_key_type").hasFields(";id;name;code;version;");
		_for("public_key_type").targetType("public_key_type");
		_for("public_key_type").anchorColumn("domain");
		_for("consumer_order").referTo("supply_order_approval").withRole("approval");
		_for("consumer_order").referTo("supply_order_delivery").withRole("delivery");
		_for("consumer_order").referTo("supply_order_shipment").withRole("shipment");
		_for("consumer_order").referTo("supply_order_confirmation").withRole("confirmation");
		_for("consumer_order").referTo("retail_store_member").withRole("consumer");
		_for("consumer_order").referTo("retail_store").withRole("store");
		_for("consumer_order").referTo("supply_order_processing").withRole("processing");
		_for("consumer_order").usedIn("retail_store_member_gift_card_consume_record").withRole("biz_order");
		_for("consumer_order").usedIn("consumer_order_line_item").withRole("biz_order");
		_for("consumer_order").usedIn("consumer_order_price_adjustment").withRole("biz_order");
		_for("consumer_order").usedIn("consumer_order_payment_group").withRole("biz_order");
		_for("consumer_order").usedIn("consumer_order_shipping_group").withRole("biz_order");
		_for("consumer_order").isTree("false");
		_for("consumer_order").hasFields(";id;title;last_update_time;version;");
		_for("consumer_order").targetType("consumer_order");
		_for("consumer_order").anchorColumn("consumer");
		_for("offer_approval").usedIn("employee").withRole("offer_approval");
		_for("offer_approval").isTree("false");
		_for("offer_approval").hasFields(";id;who;approve_time;comments;version;");
		_for("offer_approval").targetType("offer_approval");
		_for("retail_store_creation").usedIn("retail_store").withRole("creation");
		_for("retail_store_creation").isTree("false");
		_for("retail_store_creation").hasFields(";id;comment;version;");
		_for("retail_store_creation").targetType("retail_store_creation");
		_for("supply_order_picking").usedIn("supply_order").withRole("picking");
		_for("supply_order_picking").isTree("false");
		_for("supply_order_picking").hasFields(";id;who;process_time;version;");
		_for("supply_order_picking").targetType("supply_order_picking");
		_for("city_event").referTo("retail_store_city_service_center").withRole("city_service_center");
		_for("city_event").usedIn("event_attendance").withRole("city_event");
		_for("city_event").isTree("false");
		_for("city_event").hasFields(";id;name;mobile;description;last_update_time;version;");
		_for("city_event").targetType("city_event");
		_for("city_event").anchorColumn("city_service_center");
		_for("account_set").referTo("retail_store_country_center").withRole("country_center");
		_for("account_set").referTo("goods_supplier").withRole("goods_supplier");
		_for("account_set").referTo("retail_store").withRole("retail_store");
		_for("account_set").usedIn("accounting_document_type").withRole("accounting_period");
		_for("account_set").usedIn("accounting_subject").withRole("account_set");
		_for("account_set").usedIn("accounting_period").withRole("account_set");
		_for("account_set").isTree("false");
		_for("account_set").hasFields(";id;name;year_set;effective_date;accounting_system;domestic_currency_code;domestic_currency_name;opening_bank;account_number;last_update_time;version;");
		_for("account_set").targetType("account_set");
		_for("account_set").anchorColumn("country_center");
		_for("leave_type").referTo("retail_store_country_center").withRole("company");
		_for("leave_type").usedIn("employee_leave").withRole("type");
		_for("leave_type").isTree("false");
		_for("leave_type").hasFields(";id;code;description;detail_description;version;");
		_for("leave_type").targetType("leave_type");
		_for("leave_type").anchorColumn("company");
		_for("level_two_category").referTo("level_one_category").withRole("parent_category");
		_for("level_two_category").usedIn("level_three_category").withRole("parent_category");
		_for("level_two_category").isTree("false");
		_for("level_two_category").hasFields(";id;name;version;");
		_for("level_two_category").targetType("level_two_category");
		_for("level_two_category").anchorColumn("parent_category");
		_for("retail_store_closing").usedIn("retail_store").withRole("closing");
		_for("retail_store_closing").isTree("false");
		_for("retail_store_closing").hasFields(";id;comment;version;");
		_for("retail_store_closing").targetType("retail_store_closing");
		_for("retail_store_province_center").referTo("retail_store_country_center").withRole("country");
		_for("retail_store_province_center").usedIn("retail_store_city_service_center").withRole("belongs_to");
		_for("retail_store_province_center").usedIn("province_center_department").withRole("province_center");
		_for("retail_store_province_center").usedIn("province_center_employee").withRole("province_center");
		_for("retail_store_province_center").isTree("false");
		_for("retail_store_province_center").hasFields(";id;name;founded;last_update_time;version;");
		_for("retail_store_province_center").targetType("retail_store_province_center");
		_for("retail_store_province_center").anchorColumn("country");

	}
	
	protected YoubenbenBaseDAOImpl currentDAO = null;
	
	public Object queryCandidates(YoubenbenUserContext userContext, CandidateQuery query) throws Exception {
		if (CandidateQuery.FOR_SEARCH.equals(query.getScenceCode())) {
			return queryCandidatesForSearch(userContext, query);
		}
		return queryCandidatesForAssign(userContext, query);
	}
	
	public Object queryCandidatesForAssign(YoubenbenUserContext userContext, CandidateQuery query) throws Exception {
		query.setScenceCode(CandidateQuery.FOR_ASSIGN);
		query = prepareQueryInput(query);
		List<Object> params = new ArrayList<>();
		String sql = prepareSqlForAssign(query, params);
		BaseCandidateEntity<? extends BaseEntity> candidates = executeQuery(userContext, query, sql, params);
		enhanceGroupByValues(userContext, query, candidates);
		return wrapperCandidates(userContext, candidates);
	}

	public Object queryCandidatesForSearch(YoubenbenUserContext userContext, CandidateQuery query) throws Exception {
		query.setScenceCode(CandidateQuery.FOR_SEARCH);
		query = prepareQueryInput(query);
		List<Object> params = new ArrayList<>();
		String sql = prepareSqlForSearch(query, params);
		BaseCandidateEntity<? extends BaseEntity> candidates = executeQuery(userContext, query, sql, params);
		enhanceGroupByValues(userContext, query, candidates);
		return wrapperCandidates(userContext, candidates);
	}
	
	protected Object wrapperCandidates(YoubenbenUserContext userContext, BaseCandidateEntity<? extends BaseEntity> candidates) throws Exception {
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
		return new YoubenbenNamingServiceDAO().mapToInternalColumn(name);
	}
	
	protected String getDisplayNameColumn(String typeName) {
		String displayNameColumn = YoubenbenNamingServiceDAO.getDisplayNameColumnName(getJavaClassName(typeName));
		return displayNameColumn;
	}

	protected BaseCandidateEntity<? extends BaseEntity> executeQuery(YoubenbenUserContext userContext, CandidateQuery query, String sql,
			List<Object> params) throws Exception{
		switch (query.getTargetType()) {
		case "retail_store_country_center":
			currentDAO = (YoubenbenBaseDAOImpl)userContext.getDAOGroup().getRetailStoreCountryCenterDAO();
			return userContext.getDAOGroup().getRetailStoreCountryCenterDAO().executeCandidatesQuery(query, sql, params.toArray());
		case "catalog":
			currentDAO = (YoubenbenBaseDAOImpl)userContext.getDAOGroup().getCatalogDAO();
			return userContext.getDAOGroup().getCatalogDAO().executeCandidatesQuery(query, sql, params.toArray());
		case "level_one_category":
			currentDAO = (YoubenbenBaseDAOImpl)userContext.getDAOGroup().getLevelOneCategoryDAO();
			return userContext.getDAOGroup().getLevelOneCategoryDAO().executeCandidatesQuery(query, sql, params.toArray());
		case "level_two_category":
			currentDAO = (YoubenbenBaseDAOImpl)userContext.getDAOGroup().getLevelTwoCategoryDAO();
			return userContext.getDAOGroup().getLevelTwoCategoryDAO().executeCandidatesQuery(query, sql, params.toArray());
		case "level_three_category":
			currentDAO = (YoubenbenBaseDAOImpl)userContext.getDAOGroup().getLevelThreeCategoryDAO();
			return userContext.getDAOGroup().getLevelThreeCategoryDAO().executeCandidatesQuery(query, sql, params.toArray());
		case "product":
			currentDAO = (YoubenbenBaseDAOImpl)userContext.getDAOGroup().getProductDAO();
			return userContext.getDAOGroup().getProductDAO().executeCandidatesQuery(query, sql, params.toArray());
		case "sku":
			currentDAO = (YoubenbenBaseDAOImpl)userContext.getDAOGroup().getSkuDAO();
			return userContext.getDAOGroup().getSkuDAO().executeCandidatesQuery(query, sql, params.toArray());
		case "retail_store_province_center":
			currentDAO = (YoubenbenBaseDAOImpl)userContext.getDAOGroup().getRetailStoreProvinceCenterDAO();
			return userContext.getDAOGroup().getRetailStoreProvinceCenterDAO().executeCandidatesQuery(query, sql, params.toArray());
		case "province_center_department":
			currentDAO = (YoubenbenBaseDAOImpl)userContext.getDAOGroup().getProvinceCenterDepartmentDAO();
			return userContext.getDAOGroup().getProvinceCenterDepartmentDAO().executeCandidatesQuery(query, sql, params.toArray());
		case "retail_store_city_service_center":
			currentDAO = (YoubenbenBaseDAOImpl)userContext.getDAOGroup().getRetailStoreCityServiceCenterDAO();
			return userContext.getDAOGroup().getRetailStoreCityServiceCenterDAO().executeCandidatesQuery(query, sql, params.toArray());
		case "city_partner":
			currentDAO = (YoubenbenBaseDAOImpl)userContext.getDAOGroup().getCityPartnerDAO();
			return userContext.getDAOGroup().getCityPartnerDAO().executeCandidatesQuery(query, sql, params.toArray());
		case "potential_customer":
			currentDAO = (YoubenbenBaseDAOImpl)userContext.getDAOGroup().getPotentialCustomerDAO();
			return userContext.getDAOGroup().getPotentialCustomerDAO().executeCandidatesQuery(query, sql, params.toArray());
		case "potential_customer_contact_person":
			currentDAO = (YoubenbenBaseDAOImpl)userContext.getDAOGroup().getPotentialCustomerContactPersonDAO();
			return userContext.getDAOGroup().getPotentialCustomerContactPersonDAO().executeCandidatesQuery(query, sql, params.toArray());
		case "city_event":
			currentDAO = (YoubenbenBaseDAOImpl)userContext.getDAOGroup().getCityEventDAO();
			return userContext.getDAOGroup().getCityEventDAO().executeCandidatesQuery(query, sql, params.toArray());
		case "retail_store":
			currentDAO = (YoubenbenBaseDAOImpl)userContext.getDAOGroup().getRetailStoreDAO();
			return userContext.getDAOGroup().getRetailStoreDAO().executeCandidatesQuery(query, sql, params.toArray());
		case "retail_store_creation":
			currentDAO = (YoubenbenBaseDAOImpl)userContext.getDAOGroup().getRetailStoreCreationDAO();
			return userContext.getDAOGroup().getRetailStoreCreationDAO().executeCandidatesQuery(query, sql, params.toArray());
		case "retail_store_investment_invitation":
			currentDAO = (YoubenbenBaseDAOImpl)userContext.getDAOGroup().getRetailStoreInvestmentInvitationDAO();
			return userContext.getDAOGroup().getRetailStoreInvestmentInvitationDAO().executeCandidatesQuery(query, sql, params.toArray());
		case "retail_store_franchising":
			currentDAO = (YoubenbenBaseDAOImpl)userContext.getDAOGroup().getRetailStoreFranchisingDAO();
			return userContext.getDAOGroup().getRetailStoreFranchisingDAO().executeCandidatesQuery(query, sql, params.toArray());
		case "retail_store_decoration":
			currentDAO = (YoubenbenBaseDAOImpl)userContext.getDAOGroup().getRetailStoreDecorationDAO();
			return userContext.getDAOGroup().getRetailStoreDecorationDAO().executeCandidatesQuery(query, sql, params.toArray());
		case "retail_store_opening":
			currentDAO = (YoubenbenBaseDAOImpl)userContext.getDAOGroup().getRetailStoreOpeningDAO();
			return userContext.getDAOGroup().getRetailStoreOpeningDAO().executeCandidatesQuery(query, sql, params.toArray());
		case "retail_store_closing":
			currentDAO = (YoubenbenBaseDAOImpl)userContext.getDAOGroup().getRetailStoreClosingDAO();
			return userContext.getDAOGroup().getRetailStoreClosingDAO().executeCandidatesQuery(query, sql, params.toArray());
		case "retail_store_member":
			currentDAO = (YoubenbenBaseDAOImpl)userContext.getDAOGroup().getRetailStoreMemberDAO();
			return userContext.getDAOGroup().getRetailStoreMemberDAO().executeCandidatesQuery(query, sql, params.toArray());
		case "consumer_order":
			currentDAO = (YoubenbenBaseDAOImpl)userContext.getDAOGroup().getConsumerOrderDAO();
			return userContext.getDAOGroup().getConsumerOrderDAO().executeCandidatesQuery(query, sql, params.toArray());
		case "member_wishlist":
			currentDAO = (YoubenbenBaseDAOImpl)userContext.getDAOGroup().getMemberWishlistDAO();
			return userContext.getDAOGroup().getMemberWishlistDAO().executeCandidatesQuery(query, sql, params.toArray());
		case "retail_store_member_gift_card":
			currentDAO = (YoubenbenBaseDAOImpl)userContext.getDAOGroup().getRetailStoreMemberGiftCardDAO();
			return userContext.getDAOGroup().getRetailStoreMemberGiftCardDAO().executeCandidatesQuery(query, sql, params.toArray());
		case "goods_supplier":
			currentDAO = (YoubenbenBaseDAOImpl)userContext.getDAOGroup().getGoodsSupplierDAO();
			return userContext.getDAOGroup().getGoodsSupplierDAO().executeCandidatesQuery(query, sql, params.toArray());
		case "supplier_product":
			currentDAO = (YoubenbenBaseDAOImpl)userContext.getDAOGroup().getSupplierProductDAO();
			return userContext.getDAOGroup().getSupplierProductDAO().executeCandidatesQuery(query, sql, params.toArray());
		case "supply_order":
			currentDAO = (YoubenbenBaseDAOImpl)userContext.getDAOGroup().getSupplyOrderDAO();
			return userContext.getDAOGroup().getSupplyOrderDAO().executeCandidatesQuery(query, sql, params.toArray());
		case "supply_order_confirmation":
			currentDAO = (YoubenbenBaseDAOImpl)userContext.getDAOGroup().getSupplyOrderConfirmationDAO();
			return userContext.getDAOGroup().getSupplyOrderConfirmationDAO().executeCandidatesQuery(query, sql, params.toArray());
		case "supply_order_approval":
			currentDAO = (YoubenbenBaseDAOImpl)userContext.getDAOGroup().getSupplyOrderApprovalDAO();
			return userContext.getDAOGroup().getSupplyOrderApprovalDAO().executeCandidatesQuery(query, sql, params.toArray());
		case "supply_order_processing":
			currentDAO = (YoubenbenBaseDAOImpl)userContext.getDAOGroup().getSupplyOrderProcessingDAO();
			return userContext.getDAOGroup().getSupplyOrderProcessingDAO().executeCandidatesQuery(query, sql, params.toArray());
		case "supply_order_picking":
			currentDAO = (YoubenbenBaseDAOImpl)userContext.getDAOGroup().getSupplyOrderPickingDAO();
			return userContext.getDAOGroup().getSupplyOrderPickingDAO().executeCandidatesQuery(query, sql, params.toArray());
		case "supply_order_shipment":
			currentDAO = (YoubenbenBaseDAOImpl)userContext.getDAOGroup().getSupplyOrderShipmentDAO();
			return userContext.getDAOGroup().getSupplyOrderShipmentDAO().executeCandidatesQuery(query, sql, params.toArray());
		case "supply_order_delivery":
			currentDAO = (YoubenbenBaseDAOImpl)userContext.getDAOGroup().getSupplyOrderDeliveryDAO();
			return userContext.getDAOGroup().getSupplyOrderDeliveryDAO().executeCandidatesQuery(query, sql, params.toArray());
		case "retail_store_order":
			currentDAO = (YoubenbenBaseDAOImpl)userContext.getDAOGroup().getRetailStoreOrderDAO();
			return userContext.getDAOGroup().getRetailStoreOrderDAO().executeCandidatesQuery(query, sql, params.toArray());
		case "retail_store_order_confirmation":
			currentDAO = (YoubenbenBaseDAOImpl)userContext.getDAOGroup().getRetailStoreOrderConfirmationDAO();
			return userContext.getDAOGroup().getRetailStoreOrderConfirmationDAO().executeCandidatesQuery(query, sql, params.toArray());
		case "retail_store_order_approval":
			currentDAO = (YoubenbenBaseDAOImpl)userContext.getDAOGroup().getRetailStoreOrderApprovalDAO();
			return userContext.getDAOGroup().getRetailStoreOrderApprovalDAO().executeCandidatesQuery(query, sql, params.toArray());
		case "retail_store_order_processing":
			currentDAO = (YoubenbenBaseDAOImpl)userContext.getDAOGroup().getRetailStoreOrderProcessingDAO();
			return userContext.getDAOGroup().getRetailStoreOrderProcessingDAO().executeCandidatesQuery(query, sql, params.toArray());
		case "retail_store_order_picking":
			currentDAO = (YoubenbenBaseDAOImpl)userContext.getDAOGroup().getRetailStoreOrderPickingDAO();
			return userContext.getDAOGroup().getRetailStoreOrderPickingDAO().executeCandidatesQuery(query, sql, params.toArray());
		case "retail_store_order_shipment":
			currentDAO = (YoubenbenBaseDAOImpl)userContext.getDAOGroup().getRetailStoreOrderShipmentDAO();
			return userContext.getDAOGroup().getRetailStoreOrderShipmentDAO().executeCandidatesQuery(query, sql, params.toArray());
		case "retail_store_order_delivery":
			currentDAO = (YoubenbenBaseDAOImpl)userContext.getDAOGroup().getRetailStoreOrderDeliveryDAO();
			return userContext.getDAOGroup().getRetailStoreOrderDeliveryDAO().executeCandidatesQuery(query, sql, params.toArray());
		case "warehouse":
			currentDAO = (YoubenbenBaseDAOImpl)userContext.getDAOGroup().getWarehouseDAO();
			return userContext.getDAOGroup().getWarehouseDAO().executeCandidatesQuery(query, sql, params.toArray());
		case "storage_space":
			currentDAO = (YoubenbenBaseDAOImpl)userContext.getDAOGroup().getStorageSpaceDAO();
			return userContext.getDAOGroup().getStorageSpaceDAO().executeCandidatesQuery(query, sql, params.toArray());
		case "smart_pallet":
			currentDAO = (YoubenbenBaseDAOImpl)userContext.getDAOGroup().getSmartPalletDAO();
			return userContext.getDAOGroup().getSmartPalletDAO().executeCandidatesQuery(query, sql, params.toArray());
		case "goods_shelf":
			currentDAO = (YoubenbenBaseDAOImpl)userContext.getDAOGroup().getGoodsShelfDAO();
			return userContext.getDAOGroup().getGoodsShelfDAO().executeCandidatesQuery(query, sql, params.toArray());
		case "goods_shelf_stock_count":
			currentDAO = (YoubenbenBaseDAOImpl)userContext.getDAOGroup().getGoodsShelfStockCountDAO();
			return userContext.getDAOGroup().getGoodsShelfStockCountDAO().executeCandidatesQuery(query, sql, params.toArray());
		case "goods_allocation":
			currentDAO = (YoubenbenBaseDAOImpl)userContext.getDAOGroup().getGoodsAllocationDAO();
			return userContext.getDAOGroup().getGoodsAllocationDAO().executeCandidatesQuery(query, sql, params.toArray());
		case "goods":
			currentDAO = (YoubenbenBaseDAOImpl)userContext.getDAOGroup().getGoodsDAO();
			return userContext.getDAOGroup().getGoodsDAO().executeCandidatesQuery(query, sql, params.toArray());
		case "goods_packaging":
			currentDAO = (YoubenbenBaseDAOImpl)userContext.getDAOGroup().getGoodsPackagingDAO();
			return userContext.getDAOGroup().getGoodsPackagingDAO().executeCandidatesQuery(query, sql, params.toArray());
		case "supplier_space":
			currentDAO = (YoubenbenBaseDAOImpl)userContext.getDAOGroup().getSupplierSpaceDAO();
			return userContext.getDAOGroup().getSupplierSpaceDAO().executeCandidatesQuery(query, sql, params.toArray());
		case "receiving_space":
			currentDAO = (YoubenbenBaseDAOImpl)userContext.getDAOGroup().getReceivingSpaceDAO();
			return userContext.getDAOGroup().getReceivingSpaceDAO().executeCandidatesQuery(query, sql, params.toArray());
		case "shipping_space":
			currentDAO = (YoubenbenBaseDAOImpl)userContext.getDAOGroup().getShippingSpaceDAO();
			return userContext.getDAOGroup().getShippingSpaceDAO().executeCandidatesQuery(query, sql, params.toArray());
		case "damage_space":
			currentDAO = (YoubenbenBaseDAOImpl)userContext.getDAOGroup().getDamageSpaceDAO();
			return userContext.getDAOGroup().getDamageSpaceDAO().executeCandidatesQuery(query, sql, params.toArray());
		case "transport_fleet":
			currentDAO = (YoubenbenBaseDAOImpl)userContext.getDAOGroup().getTransportFleetDAO();
			return userContext.getDAOGroup().getTransportFleetDAO().executeCandidatesQuery(query, sql, params.toArray());
		case "transport_truck":
			currentDAO = (YoubenbenBaseDAOImpl)userContext.getDAOGroup().getTransportTruckDAO();
			return userContext.getDAOGroup().getTransportTruckDAO().executeCandidatesQuery(query, sql, params.toArray());
		case "truck_driver":
			currentDAO = (YoubenbenBaseDAOImpl)userContext.getDAOGroup().getTruckDriverDAO();
			return userContext.getDAOGroup().getTruckDriverDAO().executeCandidatesQuery(query, sql, params.toArray());
		case "transport_task":
			currentDAO = (YoubenbenBaseDAOImpl)userContext.getDAOGroup().getTransportTaskDAO();
			return userContext.getDAOGroup().getTransportTaskDAO().executeCandidatesQuery(query, sql, params.toArray());
		case "account_set":
			currentDAO = (YoubenbenBaseDAOImpl)userContext.getDAOGroup().getAccountSetDAO();
			return userContext.getDAOGroup().getAccountSetDAO().executeCandidatesQuery(query, sql, params.toArray());
		case "accounting_subject":
			currentDAO = (YoubenbenBaseDAOImpl)userContext.getDAOGroup().getAccountingSubjectDAO();
			return userContext.getDAOGroup().getAccountingSubjectDAO().executeCandidatesQuery(query, sql, params.toArray());
		case "accounting_period":
			currentDAO = (YoubenbenBaseDAOImpl)userContext.getDAOGroup().getAccountingPeriodDAO();
			return userContext.getDAOGroup().getAccountingPeriodDAO().executeCandidatesQuery(query, sql, params.toArray());
		case "accounting_document_type":
			currentDAO = (YoubenbenBaseDAOImpl)userContext.getDAOGroup().getAccountingDocumentTypeDAO();
			return userContext.getDAOGroup().getAccountingDocumentTypeDAO().executeCandidatesQuery(query, sql, params.toArray());
		case "accounting_document":
			currentDAO = (YoubenbenBaseDAOImpl)userContext.getDAOGroup().getAccountingDocumentDAO();
			return userContext.getDAOGroup().getAccountingDocumentDAO().executeCandidatesQuery(query, sql, params.toArray());
		case "accounting_document_creation":
			currentDAO = (YoubenbenBaseDAOImpl)userContext.getDAOGroup().getAccountingDocumentCreationDAO();
			return userContext.getDAOGroup().getAccountingDocumentCreationDAO().executeCandidatesQuery(query, sql, params.toArray());
		case "accounting_document_confirmation":
			currentDAO = (YoubenbenBaseDAOImpl)userContext.getDAOGroup().getAccountingDocumentConfirmationDAO();
			return userContext.getDAOGroup().getAccountingDocumentConfirmationDAO().executeCandidatesQuery(query, sql, params.toArray());
		case "accounting_document_auditing":
			currentDAO = (YoubenbenBaseDAOImpl)userContext.getDAOGroup().getAccountingDocumentAuditingDAO();
			return userContext.getDAOGroup().getAccountingDocumentAuditingDAO().executeCandidatesQuery(query, sql, params.toArray());
		case "accounting_document_posting":
			currentDAO = (YoubenbenBaseDAOImpl)userContext.getDAOGroup().getAccountingDocumentPostingDAO();
			return userContext.getDAOGroup().getAccountingDocumentPostingDAO().executeCandidatesQuery(query, sql, params.toArray());
		case "original_voucher_creation":
			currentDAO = (YoubenbenBaseDAOImpl)userContext.getDAOGroup().getOriginalVoucherCreationDAO();
			return userContext.getDAOGroup().getOriginalVoucherCreationDAO().executeCandidatesQuery(query, sql, params.toArray());
		case "original_voucher_confirmation":
			currentDAO = (YoubenbenBaseDAOImpl)userContext.getDAOGroup().getOriginalVoucherConfirmationDAO();
			return userContext.getDAOGroup().getOriginalVoucherConfirmationDAO().executeCandidatesQuery(query, sql, params.toArray());
		case "original_voucher_auditing":
			currentDAO = (YoubenbenBaseDAOImpl)userContext.getDAOGroup().getOriginalVoucherAuditingDAO();
			return userContext.getDAOGroup().getOriginalVoucherAuditingDAO().executeCandidatesQuery(query, sql, params.toArray());
		case "level_one_department":
			currentDAO = (YoubenbenBaseDAOImpl)userContext.getDAOGroup().getLevelOneDepartmentDAO();
			return userContext.getDAOGroup().getLevelOneDepartmentDAO().executeCandidatesQuery(query, sql, params.toArray());
		case "level_two_department":
			currentDAO = (YoubenbenBaseDAOImpl)userContext.getDAOGroup().getLevelTwoDepartmentDAO();
			return userContext.getDAOGroup().getLevelTwoDepartmentDAO().executeCandidatesQuery(query, sql, params.toArray());
		case "level_three_department":
			currentDAO = (YoubenbenBaseDAOImpl)userContext.getDAOGroup().getLevelThreeDepartmentDAO();
			return userContext.getDAOGroup().getLevelThreeDepartmentDAO().executeCandidatesQuery(query, sql, params.toArray());
		case "skill_type":
			currentDAO = (YoubenbenBaseDAOImpl)userContext.getDAOGroup().getSkillTypeDAO();
			return userContext.getDAOGroup().getSkillTypeDAO().executeCandidatesQuery(query, sql, params.toArray());
		case "responsibility_type":
			currentDAO = (YoubenbenBaseDAOImpl)userContext.getDAOGroup().getResponsibilityTypeDAO();
			return userContext.getDAOGroup().getResponsibilityTypeDAO().executeCandidatesQuery(query, sql, params.toArray());
		case "termination_reason":
			currentDAO = (YoubenbenBaseDAOImpl)userContext.getDAOGroup().getTerminationReasonDAO();
			return userContext.getDAOGroup().getTerminationReasonDAO().executeCandidatesQuery(query, sql, params.toArray());
		case "termination_type":
			currentDAO = (YoubenbenBaseDAOImpl)userContext.getDAOGroup().getTerminationTypeDAO();
			return userContext.getDAOGroup().getTerminationTypeDAO().executeCandidatesQuery(query, sql, params.toArray());
		case "occupation_type":
			currentDAO = (YoubenbenBaseDAOImpl)userContext.getDAOGroup().getOccupationTypeDAO();
			return userContext.getDAOGroup().getOccupationTypeDAO().executeCandidatesQuery(query, sql, params.toArray());
		case "leave_type":
			currentDAO = (YoubenbenBaseDAOImpl)userContext.getDAOGroup().getLeaveTypeDAO();
			return userContext.getDAOGroup().getLeaveTypeDAO().executeCandidatesQuery(query, sql, params.toArray());
		case "salary_grade":
			currentDAO = (YoubenbenBaseDAOImpl)userContext.getDAOGroup().getSalaryGradeDAO();
			return userContext.getDAOGroup().getSalaryGradeDAO().executeCandidatesQuery(query, sql, params.toArray());
		case "interview_type":
			currentDAO = (YoubenbenBaseDAOImpl)userContext.getDAOGroup().getInterviewTypeDAO();
			return userContext.getDAOGroup().getInterviewTypeDAO().executeCandidatesQuery(query, sql, params.toArray());
		case "training_course_type":
			currentDAO = (YoubenbenBaseDAOImpl)userContext.getDAOGroup().getTrainingCourseTypeDAO();
			return userContext.getDAOGroup().getTrainingCourseTypeDAO().executeCandidatesQuery(query, sql, params.toArray());
		case "termination":
			currentDAO = (YoubenbenBaseDAOImpl)userContext.getDAOGroup().getTerminationDAO();
			return userContext.getDAOGroup().getTerminationDAO().executeCandidatesQuery(query, sql, params.toArray());
		case "employee":
			currentDAO = (YoubenbenBaseDAOImpl)userContext.getDAOGroup().getEmployeeDAO();
			return userContext.getDAOGroup().getEmployeeDAO().executeCandidatesQuery(query, sql, params.toArray());
		case "job_application":
			currentDAO = (YoubenbenBaseDAOImpl)userContext.getDAOGroup().getJobApplicationDAO();
			return userContext.getDAOGroup().getJobApplicationDAO().executeCandidatesQuery(query, sql, params.toArray());
		case "profession_interview":
			currentDAO = (YoubenbenBaseDAOImpl)userContext.getDAOGroup().getProfessionInterviewDAO();
			return userContext.getDAOGroup().getProfessionInterviewDAO().executeCandidatesQuery(query, sql, params.toArray());
		case "hr_interview":
			currentDAO = (YoubenbenBaseDAOImpl)userContext.getDAOGroup().getHrInterviewDAO();
			return userContext.getDAOGroup().getHrInterviewDAO().executeCandidatesQuery(query, sql, params.toArray());
		case "offer_approval":
			currentDAO = (YoubenbenBaseDAOImpl)userContext.getDAOGroup().getOfferApprovalDAO();
			return userContext.getDAOGroup().getOfferApprovalDAO().executeCandidatesQuery(query, sql, params.toArray());
		case "offer_acceptance":
			currentDAO = (YoubenbenBaseDAOImpl)userContext.getDAOGroup().getOfferAcceptanceDAO();
			return userContext.getDAOGroup().getOfferAcceptanceDAO().executeCandidatesQuery(query, sql, params.toArray());
		case "employee_boarding":
			currentDAO = (YoubenbenBaseDAOImpl)userContext.getDAOGroup().getEmployeeBoardingDAO();
			return userContext.getDAOGroup().getEmployeeBoardingDAO().executeCandidatesQuery(query, sql, params.toArray());
		case "instructor":
			currentDAO = (YoubenbenBaseDAOImpl)userContext.getDAOGroup().getInstructorDAO();
			return userContext.getDAOGroup().getInstructorDAO().executeCandidatesQuery(query, sql, params.toArray());
		case "company_training":
			currentDAO = (YoubenbenBaseDAOImpl)userContext.getDAOGroup().getCompanyTrainingDAO();
			return userContext.getDAOGroup().getCompanyTrainingDAO().executeCandidatesQuery(query, sql, params.toArray());
		case "scoring":
			currentDAO = (YoubenbenBaseDAOImpl)userContext.getDAOGroup().getScoringDAO();
			return userContext.getDAOGroup().getScoringDAO().executeCandidatesQuery(query, sql, params.toArray());
		case "paying_off":
			currentDAO = (YoubenbenBaseDAOImpl)userContext.getDAOGroup().getPayingOffDAO();
			return userContext.getDAOGroup().getPayingOffDAO().executeCandidatesQuery(query, sql, params.toArray());
		case "mobile_app":
			currentDAO = (YoubenbenBaseDAOImpl)userContext.getDAOGroup().getMobileAppDAO();
			return userContext.getDAOGroup().getMobileAppDAO().executeCandidatesQuery(query, sql, params.toArray());
		case "page":
			currentDAO = (YoubenbenBaseDAOImpl)userContext.getDAOGroup().getPageDAO();
			return userContext.getDAOGroup().getPageDAO().executeCandidatesQuery(query, sql, params.toArray());
		case "page_type":
			currentDAO = (YoubenbenBaseDAOImpl)userContext.getDAOGroup().getPageTypeDAO();
			return userContext.getDAOGroup().getPageTypeDAO().executeCandidatesQuery(query, sql, params.toArray());
		case "user_domain":
			currentDAO = (YoubenbenBaseDAOImpl)userContext.getDAOGroup().getUserDomainDAO();
			return userContext.getDAOGroup().getUserDomainDAO().executeCandidatesQuery(query, sql, params.toArray());
		case "sec_user":
			currentDAO = (YoubenbenBaseDAOImpl)userContext.getDAOGroup().getSecUserDAO();
			return userContext.getDAOGroup().getSecUserDAO().executeCandidatesQuery(query, sql, params.toArray());
		case "user_app":
			currentDAO = (YoubenbenBaseDAOImpl)userContext.getDAOGroup().getUserAppDAO();
			return userContext.getDAOGroup().getUserAppDAO().executeCandidatesQuery(query, sql, params.toArray());
		case "candidate_container":
			currentDAO = (YoubenbenBaseDAOImpl)userContext.getDAOGroup().getCandidateContainerDAO();
			return userContext.getDAOGroup().getCandidateContainerDAO().executeCandidatesQuery(query, sql, params.toArray());
		case "public_key_type":
			currentDAO = (YoubenbenBaseDAOImpl)userContext.getDAOGroup().getPublicKeyTypeDAO();
			return userContext.getDAOGroup().getPublicKeyTypeDAO().executeCandidatesQuery(query, sql, params.toArray());

		default:
			throw new Exception("OOTB不支持"+query.getTargetType()+"的候选值查询");
		}
	}
	
	protected void enhanceGroupByValues(YoubenbenUserContext userContext, CandidateQuery query,
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




















