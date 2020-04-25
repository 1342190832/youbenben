
package com.youbenben.youbenben.franchisedoutletprovincecenter;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.youbenben.youbenben.YoubenbenUserContext;
import com.youbenben.youbenben.BaseEntity;
import com.youbenben.youbenben.BaseManager;
import com.youbenben.youbenben.SmartList;

public interface FranchisedOutletProvinceCenterManager extends BaseManager{

		

	public FranchisedOutletProvinceCenter createFranchisedOutletProvinceCenter(YoubenbenUserContext userContext, String name,String serviceNumber,Date founded,String webSite,String address,String operatedBy,String legalRepresentative,String description) throws Exception;
	public FranchisedOutletProvinceCenter updateFranchisedOutletProvinceCenter(YoubenbenUserContext userContext,String franchisedOutletProvinceCenterId, int franchisedOutletProvinceCenterVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public FranchisedOutletProvinceCenter loadFranchisedOutletProvinceCenter(YoubenbenUserContext userContext, String franchisedOutletProvinceCenterId, String [] tokensExpr) throws Exception;
	public FranchisedOutletProvinceCenter internalSaveFranchisedOutletProvinceCenter(YoubenbenUserContext userContext, FranchisedOutletProvinceCenter franchisedOutletProvinceCenter) throws Exception;
	public FranchisedOutletProvinceCenter internalSaveFranchisedOutletProvinceCenter(YoubenbenUserContext userContext, FranchisedOutletProvinceCenter franchisedOutletProvinceCenter,Map<String,Object>option) throws Exception;



	public void delete(YoubenbenUserContext userContext, String franchisedOutletProvinceCenterId, int version) throws Exception;
	public int deleteAll(YoubenbenUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(YoubenbenUserContext userContext, FranchisedOutletProvinceCenter newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/


	//public  CatalogManager getCatalogManager(YoubenbenUserContext userContext, String franchisedOutletProvinceCenterId, String name, int subCount, BigDecimal amount ,String [] tokensExpr)  throws Exception;

	public  FranchisedOutletProvinceCenter addCatalog(YoubenbenUserContext userContext, String franchisedOutletProvinceCenterId, String name, int subCount, BigDecimal amount , String [] tokensExpr)  throws Exception;
	public  FranchisedOutletProvinceCenter removeCatalog(YoubenbenUserContext userContext, String franchisedOutletProvinceCenterId, String catalogId, int catalogVersion,String [] tokensExpr)  throws Exception;
	public  FranchisedOutletProvinceCenter updateCatalog(YoubenbenUserContext userContext, String franchisedOutletProvinceCenterId, String catalogId, int catalogVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/



}


