
package com.xingyou.xingyou.franchisedoutletprovincecenter;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.xingyou.xingyou.XingyouUserContext;
import com.xingyou.xingyou.BaseEntity;
import com.xingyou.xingyou.BaseManager;
import com.xingyou.xingyou.SmartList;

public interface FranchisedOutletProvinceCenterManager extends BaseManager{

		

	public FranchisedOutletProvinceCenter createFranchisedOutletProvinceCenter(XingyouUserContext userContext, String name,String serviceNumber,Date founded,String webSite,String address,String operatedBy,String legalRepresentative,String description) throws Exception;
	public FranchisedOutletProvinceCenter updateFranchisedOutletProvinceCenter(XingyouUserContext userContext,String franchisedOutletProvinceCenterId, int franchisedOutletProvinceCenterVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public FranchisedOutletProvinceCenter loadFranchisedOutletProvinceCenter(XingyouUserContext userContext, String franchisedOutletProvinceCenterId, String [] tokensExpr) throws Exception;
	public FranchisedOutletProvinceCenter internalSaveFranchisedOutletProvinceCenter(XingyouUserContext userContext, FranchisedOutletProvinceCenter franchisedOutletProvinceCenter) throws Exception;
	public FranchisedOutletProvinceCenter internalSaveFranchisedOutletProvinceCenter(XingyouUserContext userContext, FranchisedOutletProvinceCenter franchisedOutletProvinceCenter,Map<String,Object>option) throws Exception;



	public void delete(XingyouUserContext userContext, String franchisedOutletProvinceCenterId, int version) throws Exception;
	public int deleteAll(XingyouUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(XingyouUserContext userContext, FranchisedOutletProvinceCenter newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/


	//public  CatalogManager getCatalogManager(XingyouUserContext userContext, String franchisedOutletProvinceCenterId, String name, int subCount, BigDecimal amount ,String [] tokensExpr)  throws Exception;

	public  FranchisedOutletProvinceCenter addCatalog(XingyouUserContext userContext, String franchisedOutletProvinceCenterId, String name, int subCount, BigDecimal amount , String [] tokensExpr)  throws Exception;
	public  FranchisedOutletProvinceCenter removeCatalog(XingyouUserContext userContext, String franchisedOutletProvinceCenterId, String catalogId, int catalogVersion,String [] tokensExpr)  throws Exception;
	public  FranchisedOutletProvinceCenter updateCatalog(XingyouUserContext userContext, String franchisedOutletProvinceCenterId, String catalogId, int catalogVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/



}


