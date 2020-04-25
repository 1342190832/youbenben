
import React, { PureComponent } from 'react'
import { connect } from 'dva'
import Result from '../../components/Result'
import { Row, Col, Card, Form, Input, Select, Icon, Button, Dropdown, Menu, InputNumber, DatePicker, Modal, message,Alert } from 'antd';
import GlobalComponents from '../../custcomponents'
import PageHeaderLayout from '../../layouts/PageHeaderLayout'
import styles from './ConsumerOrder.search.less'
import ListViewTool from '../../common/ListView.tool'
import ConsumerOrderBase from './ConsumerOrder.base'
import PermissionSettingService from '../../permission/PermissionSetting.service'
import appLocaleName from '../../common/Locale.tool'

import { Link, Route, Redirect} from 'dva/router'
import TreeContainer from '../../components/TreeContainer'
const  {  hasCreatePermission,hasExecutionPermission,hasDeletePermission,hasUpdatePermission,hasReadPermission } = PermissionSettingService
const {fieldLabels} = ConsumerOrderBase
import { PREFIX } from '../../axios/tools'
const {handleSelectRows,handleStandardTableChange,
  showDeletionDialog,handleUpdate,handleDeletionModalVisible,
  handleElementCreate,toggleAssociateModalVisible,handleCloseAlert}=ListViewTool


const buttonMenuFor =(targetComponent, internalName, localeName)=> {
  const userContext = null
  return (
   <Menu >
     <Menu.Item key="1" onClick={()=>toggleAssociateModalVisible(targetComponent,internalName)}>{appLocaleName(userContext,"New")}{localeName}</Menu.Item>
     <Menu.Item key="2">{appLocaleName(userContext,"Merge")}{localeName}</Menu.Item>
    </Menu>
  )

}


const beanNameOf=(owner)=>{
	return owner.type.substring(1)
}
 
const showListActionBar = (targetComponent)=>{

  const {selectedRows} = targetComponent.state
  const {metaInfo,owner} = targetComponent.props
  const {referenceName,listName} = owner
  const disable = (selectedRows.length === 0)
  const userContext = null
  return (<div className={styles.tableListOperator}>
  

    {hasCreatePermission(metaInfo)&&<Button icon="plus" type="primary" onClick={() => handleElementCreate(targetComponent)}>{appLocaleName(userContext,"New")}</Button>}


    {hasUpdatePermission(metaInfo)&&<Button onClick={()=>handleUpdate(targetComponent)} icon="edit" disabled={disable}>{appLocaleName(userContext,"BatchUpdate")}</Button>}
 
 
    {hasDeletePermission(metaInfo)&&<Button onClick={(event)=>handleDeletionModalVisible(event,targetComponent)} type="danger" icon="delete" disabled={disable}>{appLocaleName(userContext,"BatchDelete")}</Button>}

	
	<a href={`${PREFIX}${beanNameOf(owner)}Manager/exportExcelFromList/${owner.id}/${listName}/`} className={'ant-btn'}  ><Icon type="file-excel" /><span>导出全部</span></a>
    

</div> )


}


const showAssociateDialog = (targetComponent) => {
  const {data, owner, visible,onCancel,onCreate} = targetComponent.props
  const {currentAssociateModal} = targetComponent.state
  
  const {selectedRows} = targetComponent.state
  
  const { RetailStoreMemberAssociateForm } = GlobalComponents
  const { SupplyOrderConfirmationAssociateForm } = GlobalComponents
  const { SupplyOrderApprovalAssociateForm } = GlobalComponents
  const { SupplyOrderProcessingAssociateForm } = GlobalComponents
  const { SupplyOrderShipmentAssociateForm } = GlobalComponents
  const { SupplyOrderDeliveryAssociateForm } = GlobalComponents
  const { RetailStoreAssociateForm } = GlobalComponents


  return (
  <div>
  
   
  
    <RetailStoreMemberAssociateForm 
	visible={currentAssociateModal==='consumer'} 
	data={{consumerOrderList:selectedRows}} owner={owner}  
	onCancel={()=>toggleAssociateModalVisible(targetComponent,'consumer')} 
	onCreate={()=>toggleAssociateModalVisible(targetComponent,'consumer')}/> <SupplyOrderConfirmationAssociateForm 
	visible={currentAssociateModal==='confirmation'} 
	data={{consumerOrderList:selectedRows}} owner={owner}  
	onCancel={()=>toggleAssociateModalVisible(targetComponent,'confirmation')} 
	onCreate={()=>toggleAssociateModalVisible(targetComponent,'confirmation')}/> <SupplyOrderApprovalAssociateForm 
	visible={currentAssociateModal==='approval'} 
	data={{consumerOrderList:selectedRows}} owner={owner}  
	onCancel={()=>toggleAssociateModalVisible(targetComponent,'approval')} 
	onCreate={()=>toggleAssociateModalVisible(targetComponent,'approval')}/> <SupplyOrderProcessingAssociateForm 
	visible={currentAssociateModal==='processing'} 
	data={{consumerOrderList:selectedRows}} owner={owner}  
	onCancel={()=>toggleAssociateModalVisible(targetComponent,'processing')} 
	onCreate={()=>toggleAssociateModalVisible(targetComponent,'processing')}/> <SupplyOrderShipmentAssociateForm 
	visible={currentAssociateModal==='shipment'} 
	data={{consumerOrderList:selectedRows}} owner={owner}  
	onCancel={()=>toggleAssociateModalVisible(targetComponent,'shipment')} 
	onCreate={()=>toggleAssociateModalVisible(targetComponent,'shipment')}/> <SupplyOrderDeliveryAssociateForm 
	visible={currentAssociateModal==='delivery'} 
	data={{consumerOrderList:selectedRows}} owner={owner}  
	onCancel={()=>toggleAssociateModalVisible(targetComponent,'delivery')} 
	onCreate={()=>toggleAssociateModalVisible(targetComponent,'delivery')}/> <RetailStoreAssociateForm 
	visible={currentAssociateModal==='store'} 
	data={{consumerOrderList:selectedRows}} owner={owner}  
	onCancel={()=>toggleAssociateModalVisible(targetComponent,'store')} 
	onCreate={()=>toggleAssociateModalVisible(targetComponent,'store')}/> 
 


    </div>
    
    
    
    )
}


class ConsumerOrderSearch extends PureComponent {
  state = {
    deletionModalVisible: false,
    selectedRows: [],
    showDeleteResult: false,
    currentAssociateModal: null,
  }

  handleSelectNode=(selectedKeys, info,searchField) => {
    const {owner,dispatch}=this.props
    const {listName} = owner
    console.log('selected in search form', selectedKeys, info);
    const params = {}
    params[`${listName}`] = 1
    params[`${listName}.orderBy.0`] = "id"
    params[`${listName}.descOrAsc.0`] = "desc"
    params[`${listName}.searchVerb.0`] = "eq"
    params[`${listName}.searchField.0`] = searchField
    params[`${listName}.searchValue.0`] = selectedKeys[0] || "NOVALUE"
    
    dispatch({
      type: `${owner.type}/load`,
      payload: { id: owner.id, parameters: params, 
      searchParameters: params,
      expandForm:false },
    })

  }


  render(){
    const { data, loading, count, currentPage, owner,partialList } = this.props;
    const {displayName} = owner.ref
    const { showDeleteResult, selectedRows, deletionModalVisible, showAssociatePaymentForm } = this.state;
    const {ConsumerOrderTable} = GlobalComponents;
    const {ConsumerOrderSearchForm} = GlobalComponents;
    const {ConsumerOrderModalTable} = GlobalComponents;
    
    const userContext = null
    
    const renderTitle=()=>{
      const {returnURL} = this.props
      
      const linkComp=returnURL?<Link to={returnURL}> <Icon type="double-left" style={{marginRight:"10px"}} /> </Link>:null
      return (<div>{linkComp}{`${displayName}:${this.props.name}${appLocaleName(userContext,"List")}`}</div>);
    }
  	
  	const {ConsumerOrderService} = GlobalComponents
    return (
      <PageHeaderLayout title={renderTitle()}>
      	 <TreeContainer 
      	  
          showLeftTree={false}
          
        >
        <Card bordered={false}>
          <div className={styles.tableList}>
            <div className={styles.tableListForm}>
              <ConsumerOrderSearchForm {...this.props} />
            </div>
            <div className={styles.tableListOperator}>
           
   
              {showListActionBar(this)}
              {partialList&&(
              <div className={styles.searchAlert}>
                	<Alert message={appLocaleName(userContext,"CloseToShowAll")} type="success" closable  afterClose={()=>handleCloseAlert(displayName, this)}/>
              </div>  	
              )}
              
            </div>
            <ConsumerOrderTable
              selectedRows={selectedRows}
              loading={loading}
              data={data}
              count={count}
              current={currentPage}
              onSelectRow={(selectedRows)=>handleSelectRows(selectedRows,this)}
              onChange={(pagination, filtersArg, sorter)=>handleStandardTableChange(pagination, filtersArg, sorter,this)}
              owner={owner}
              {...this.props}
            />
          </div>
        </Card></TreeContainer>
        {showDeletionDialog(this,ConsumerOrderModalTable,"consumerOrderIds")}
        {showAssociateDialog(this)}
      </PageHeaderLayout>
    )
  }
}

export default Form.create()(ConsumerOrderSearch)


