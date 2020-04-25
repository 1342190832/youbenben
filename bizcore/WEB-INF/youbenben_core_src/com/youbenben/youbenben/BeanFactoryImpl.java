
package com.youbenben.youbenben;
import java.util.Map;

import com.youbenben.youbenben.franchisedoutletprovincecenter.FranchisedOutletProvinceCenter;
import com.youbenben.youbenben.catalog.Catalog;
import com.youbenben.youbenben.levelonecategory.LevelOneCategory;
import com.youbenben.youbenben.leveltwocategory.LevelTwoCategory;
import com.youbenben.youbenben.levelthreecategory.LevelThreeCategory;
import com.youbenben.youbenben.product.Product;
import com.youbenben.youbenben.sku.Sku;
import com.youbenben.youbenben.franchisedoutletcitycenter.FranchisedOutletCityCenter;
import com.youbenben.youbenben.citycenterdepartment.CityCenterDepartment;
import com.youbenben.youbenben.citycenteremployee.CityCenterEmployee;
import com.youbenben.youbenben.franchisedoutletcityservicecenter.FranchisedOutletCityServiceCenter;
import com.youbenben.youbenben.citypartner.CityPartner;
import com.youbenben.youbenben.potentialcustomer.PotentialCustomer;
import com.youbenben.youbenben.potentialcustomercontactperson.PotentialCustomerContactPerson;
import com.youbenben.youbenben.potentialcustomercontact.PotentialCustomerContact;
import com.youbenben.youbenben.cityevent.CityEvent;
import com.youbenben.youbenben.eventattendance.EventAttendance;
import com.youbenben.youbenben.mobileapp.MobileApp;
import com.youbenben.youbenben.page.Page;
import com.youbenben.youbenben.pagetype.PageType;
import com.youbenben.youbenben.slide.Slide;
import com.youbenben.youbenben.uiaction.UiAction;
import com.youbenben.youbenben.section.Section;
import com.youbenben.youbenben.userdomain.UserDomain;
import com.youbenben.youbenben.userwhitelist.UserWhiteList;
import com.youbenben.youbenben.secuser.SecUser;
import com.youbenben.youbenben.userapp.UserApp;
import com.youbenben.youbenben.quicklink.QuickLink;
import com.youbenben.youbenben.listaccess.ListAccess;
import com.youbenben.youbenben.loginhistory.LoginHistory;
import com.youbenben.youbenben.candidatecontainer.CandidateContainer;
import com.youbenben.youbenben.candidateelement.CandidateElement;
import com.youbenben.youbenben.wechatworkappidentify.WechatWorkappIdentify;
import com.youbenben.youbenben.wechatminiappidentify.WechatMiniappIdentify;
import com.youbenben.youbenben.keypairidentify.KeypairIdentify;
import com.youbenben.youbenben.publickeytype.PublicKeyType;
import com.youbenben.youbenben.treenode.TreeNode;

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

















