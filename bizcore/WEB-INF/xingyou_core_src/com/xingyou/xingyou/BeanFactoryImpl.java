
package com.xingyou.xingyou;
import java.util.Map;

import com.xingyou.xingyou.franchisedoutletprovincecenter.FranchisedOutletProvinceCenter;
import com.xingyou.xingyou.catalog.Catalog;
import com.xingyou.xingyou.levelonecategory.LevelOneCategory;
import com.xingyou.xingyou.leveltwocategory.LevelTwoCategory;
import com.xingyou.xingyou.levelthreecategory.LevelThreeCategory;
import com.xingyou.xingyou.product.Product;
import com.xingyou.xingyou.sku.Sku;
import com.xingyou.xingyou.franchisedoutletcitycenter.FranchisedOutletCityCenter;
import com.xingyou.xingyou.citycenterdepartment.CityCenterDepartment;
import com.xingyou.xingyou.citycenteremployee.CityCenterEmployee;
import com.xingyou.xingyou.franchisedoutletcityservicecenter.FranchisedOutletCityServiceCenter;
import com.xingyou.xingyou.citypartner.CityPartner;
import com.xingyou.xingyou.potentialcustomer.PotentialCustomer;
import com.xingyou.xingyou.potentialcustomercontactperson.PotentialCustomerContactPerson;
import com.xingyou.xingyou.potentialcustomercontact.PotentialCustomerContact;
import com.xingyou.xingyou.cityevent.CityEvent;
import com.xingyou.xingyou.eventattendance.EventAttendance;
import com.xingyou.xingyou.mobileapp.MobileApp;
import com.xingyou.xingyou.page.Page;
import com.xingyou.xingyou.pagetype.PageType;
import com.xingyou.xingyou.slide.Slide;
import com.xingyou.xingyou.uiaction.UiAction;
import com.xingyou.xingyou.section.Section;
import com.xingyou.xingyou.userdomain.UserDomain;
import com.xingyou.xingyou.userwhitelist.UserWhiteList;
import com.xingyou.xingyou.secuser.SecUser;
import com.xingyou.xingyou.userapp.UserApp;
import com.xingyou.xingyou.quicklink.QuickLink;
import com.xingyou.xingyou.listaccess.ListAccess;
import com.xingyou.xingyou.loginhistory.LoginHistory;
import com.xingyou.xingyou.candidatecontainer.CandidateContainer;
import com.xingyou.xingyou.candidateelement.CandidateElement;
import com.xingyou.xingyou.wechatworkappidentify.WechatWorkappIdentify;
import com.xingyou.xingyou.wechatminiappidentify.WechatMiniappIdentify;
import com.xingyou.xingyou.keypairidentify.KeypairIdentify;
import com.xingyou.xingyou.publickeytype.PublicKeyType;
import com.xingyou.xingyou.treenode.TreeNode;

public class BeanFactoryImpl{


	public FranchisedOutletProvinceCenter createFranchisedOutletProvinceCenter(Map<String,Object> options){
		return new FranchisedOutletProvinceCenter();
	}


	public Catalog createCatalog(Map<String,Object> options){
		return new Catalog();
	}


	public LevelOneCategory createLevelOneCategory(Map<String,Object> options){
		return new LevelOneCategory();
	}


	public LevelTwoCategory createLevelTwoCategory(Map<String,Object> options){
		return new LevelTwoCategory();
	}


	public LevelThreeCategory createLevelThreeCategory(Map<String,Object> options){
		return new LevelThreeCategory();
	}


	public Product createProduct(Map<String,Object> options){
		return new Product();
	}


	public Sku createSku(Map<String,Object> options){
		return new Sku();
	}


	public FranchisedOutletCityCenter createFranchisedOutletCityCenter(Map<String,Object> options){
		return new FranchisedOutletCityCenter();
	}


	public CityCenterDepartment createCityCenterDepartment(Map<String,Object> options){
		return new CityCenterDepartment();
	}


	public CityCenterEmployee createCityCenterEmployee(Map<String,Object> options){
		return new CityCenterEmployee();
	}


	public FranchisedOutletCityServiceCenter createFranchisedOutletCityServiceCenter(Map<String,Object> options){
		return new FranchisedOutletCityServiceCenter();
	}


	public CityPartner createCityPartner(Map<String,Object> options){
		return new CityPartner();
	}


	public PotentialCustomer createPotentialCustomer(Map<String,Object> options){
		return new PotentialCustomer();
	}


	public PotentialCustomerContactPerson createPotentialCustomerContactPerson(Map<String,Object> options){
		return new PotentialCustomerContactPerson();
	}


	public PotentialCustomerContact createPotentialCustomerContact(Map<String,Object> options){
		return new PotentialCustomerContact();
	}


	public CityEvent createCityEvent(Map<String,Object> options){
		return new CityEvent();
	}


	public EventAttendance createEventAttendance(Map<String,Object> options){
		return new EventAttendance();
	}


	public MobileApp createMobileApp(Map<String,Object> options){
		return new MobileApp();
	}


	public Page createPage(Map<String,Object> options){
		return new Page();
	}


	public PageType createPageType(Map<String,Object> options){
		return new PageType();
	}


	public Slide createSlide(Map<String,Object> options){
		return new Slide();
	}


	public UiAction createUiAction(Map<String,Object> options){
		return new UiAction();
	}


	public Section createSection(Map<String,Object> options){
		return new Section();
	}


	public UserDomain createUserDomain(Map<String,Object> options){
		return new UserDomain();
	}


	public UserWhiteList createUserWhiteList(Map<String,Object> options){
		return new UserWhiteList();
	}


	public SecUser createSecUser(Map<String,Object> options){
		return new SecUser();
	}


	public UserApp createUserApp(Map<String,Object> options){
		return new UserApp();
	}


	public QuickLink createQuickLink(Map<String,Object> options){
		return new QuickLink();
	}


	public ListAccess createListAccess(Map<String,Object> options){
		return new ListAccess();
	}


	public LoginHistory createLoginHistory(Map<String,Object> options){
		return new LoginHistory();
	}


	public CandidateContainer createCandidateContainer(Map<String,Object> options){
		return new CandidateContainer();
	}


	public CandidateElement createCandidateElement(Map<String,Object> options){
		return new CandidateElement();
	}


	public WechatWorkappIdentify createWechatWorkappIdentify(Map<String,Object> options){
		return new WechatWorkappIdentify();
	}


	public WechatMiniappIdentify createWechatMiniappIdentify(Map<String,Object> options){
		return new WechatMiniappIdentify();
	}


	public KeypairIdentify createKeypairIdentify(Map<String,Object> options){
		return new KeypairIdentify();
	}


	public PublicKeyType createPublicKeyType(Map<String,Object> options){
		return new PublicKeyType();
	}


	public TreeNode createTreeNode(Map<String,Object> options){
		return new TreeNode();
	}





}

















