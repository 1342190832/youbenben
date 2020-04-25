

import React, { PureComponent } from 'react'
import { connect } from 'dva'
import { Row, Col, Card, Form, Input, Select, Icon, Button, Dropdown, Menu, InputNumber, DatePicker, Modal, message } from 'antd'

import styles from './Goods.search.less'
import GlobalComponents from '../../custcomponents'
import CandidateList from '../../components/CandidateList'
import appLocaleName from '../../common/Locale.tool'
import GoodsBase from './Goods.base'
const FormItem = Form.Item
const { Option } = Select
const getValue = obj => Object.keys(obj).map(key => obj[key]).join(',')
const {fieldLabels} = GoodsBase
const pushIfNotNull=(holder,value)=>{
  if(value==null){
    return
  }
  holder.push(value)

}

const overrideValue=(values,defaultValue)=>{
  
  const result = _.findLast(values,it=>!_.isUndefined(it)&&!_.isNull(it))
  if(_.isUndefined(result)){
    return defaultValue
  }
  return result
}


const filterObjectKeys=(targetObject)=>{

  const filteredValues = {}
  for(var key in targetObject){
      const value = targetObject[key]
      if(!value){
        continue
      }
      filteredValues[key] = value
     
  }
  return filteredValues

}

class GoodsSearchForm extends PureComponent {
  state = {
    // addInputValue: '',
    // modalVisible: false,
    expandForm: false,
    // selectedRows: [],
    // formValues: {},
  }
componentDidMount() {
    // const { dispatch } = this.props
    // console.log(this.props)
    // const { getFieldDecorator, setFieldsValue } = this.props.form
    const { setFieldsValue,setFieldValue } = this.props.form
    const { expandForm } = this.props
    
    const { searchFormParameters } = this.props
    if (!searchFormParameters) {
      return
    }
    console.log("searchFormParameters", searchFormParameters)

    setFieldsValue(searchFormParameters)
    if(_.isUndefined(expandForm)){
      this.setState({searchParams:searchFormParameters,expandForm:false})
      return
    }
    this.setState({searchParams:searchFormParameters,expandForm})
    
  }
  toggleForm = () => {
    this.setState({
      expandForm: !this.state.expandForm,
    })
  }
  handleFormReset = () => {
    const { form, dispatch } = this.props
    form.resetFields()
    dispatch({
      type: 'rule/fetch',
      payload: {},
    })
  }
  /*
  buildStringSearchParameters = (formValues, fieldName) => {
    const fieldValue = formValues[fieldName]
    if (!fieldValue) {
      console.log('NO VALUE')
      return {}
    }
    return {
      goodsList: 1,
      'goodsList.searchField': fieldName,
      'goodsList.searchVerb': 'startsWith',
      'goodsList.searchValue': fieldValue,
    }
  }
  */
  buildStringSearchParameters = (listName, formValues, searchVerb, fieldName) => {
    const fieldValue = formValues[fieldName]
    if (!fieldValue) {
      return null
    }
    
    //paramHolder.length
    const value = {}

    value[`${listName}.searchField`] = fieldName
    value[`${listName}.searchVerb`] =  searchVerb
    value[`${listName}.searchValue`] = fieldValue
    
    return value

  }
  
  
  
  handleSearch = (e) => {
    e.preventDefault()
    const { dispatch, form } = this.props
    form.validateFields((err, fieldsValue) => {
      if (err) return
      const paramList = []
      const { owner } = this.props
      const {listName} = owner
     
		pushIfNotNull(paramList,this.buildStringSearchParameters(listName, fieldsValue,'contains', 'id'))
		pushIfNotNull(paramList,this.buildStringSearchParameters(listName, fieldsValue,'contains', 'name'))
		pushIfNotNull(paramList,this.buildStringSearchParameters(listName, fieldsValue,'contains', 'rfid'))
		pushIfNotNull(paramList,this.buildStringSearchParameters(listName, fieldsValue,'contains', 'uom'))
		pushIfNotNull(paramList,this.buildStringSearchParameters(listName, fieldsValue,'eq', 'sku'))
		pushIfNotNull(paramList,this.buildStringSearchParameters(listName, fieldsValue,'eq', 'receivingSpace'))
		pushIfNotNull(paramList,this.buildStringSearchParameters(listName, fieldsValue,'eq', 'goodsAllocation'))
		pushIfNotNull(paramList,this.buildStringSearchParameters(listName, fieldsValue,'eq', 'smartPallet'))
		pushIfNotNull(paramList,this.buildStringSearchParameters(listName, fieldsValue,'eq', 'shippingSpace'))
		pushIfNotNull(paramList,this.buildStringSearchParameters(listName, fieldsValue,'eq', 'transportTask'))
		pushIfNotNull(paramList,this.buildStringSearchParameters(listName, fieldsValue,'eq', 'retailStore'))
		pushIfNotNull(paramList,this.buildStringSearchParameters(listName, fieldsValue,'eq', 'bizOrder'))
		pushIfNotNull(paramList,this.buildStringSearchParameters(listName, fieldsValue,'eq', 'retailStoreOrder'))
		pushIfNotNull(paramList,this.buildStringSearchParameters(listName, fieldsValue,'eq', 'packaging'))

     
      console.log("the final parameter", paramList)
      
      const params = {}
      
     
      for(var i=0;i<paramList.length;i++){
        const element = paramList[i];
        for (var key in element) {
          params[key+"."+i]=element[key]
        }

      }
     
      
      params[`${listName}`] = 1
      params[`${listName}.orderBy.0`] = "id"
      params[`${listName}.descOrAsc.0`] = "desc"
      
      
      const expandForm = overrideValue([this.state.expandForm],false)
      dispatch({
        type: `${owner.type}/load`,
        payload: { id: owner.id, parameters: params, 
        goodsSearchFormParameters: filterObjectKeys(fieldsValue),
        searchParameters: params,
        expandForm },
      })
    })
  }
      
  renderSimpleForm() {
    const { getFieldDecorator } = this.props.form
    const userContext = null
     const { owner } = this.props
    const {GoodsService} = GlobalComponents
     const { referenceName } = owner
    const tryinit  = (fieldName) => {
      
    
      if(referenceName!=fieldName){
        return null
      }
      return owner.id
    }
    const availableForEdit = (fieldName) =>{
     
     
      if(referenceName!=fieldName){
        return true
      }
      return false
    }
    
    return (
      <Form onSubmit={this.handleSearch} layout="inline">
        <Row gutter={{ md: 8, lg: 24, xl: 48 }}>

       <Col md={8} sm={24}>
         <FormItem label={fieldLabels.id}>
           {getFieldDecorator('id')(
             <Input size="default" placeholder={appLocaleName(userContext,"PleaseInput")} />
           )}
         </FormItem>
       </Col>

       <Col md={8} sm={24}>
         <FormItem label={fieldLabels.name}>
           {getFieldDecorator('name')(
             <Input size="default" placeholder={appLocaleName(userContext,"PleaseInput")} />
           )}
         </FormItem>
       </Col>

          <Col md={8} sm={24}>
            <span className={styles.submitButtons}>
              <Button  icon="search" type="primary" htmlType="submit">{appLocaleName(userContext,"Search")}</Button>
              <Button  icon="undo" style={{ marginLeft: 8 }} onClick={this.handleFormReset}>{appLocaleName(userContext,"Reset")}</Button>
              <a style={{ marginLeft: 8 }} onClick={this.toggleForm}> {appLocaleName(userContext,"Expand")} <Icon type="down" /> </a>
            </span>
          </Col>
        </Row>
      </Form>
    )
  }
  renderAdvancedForm() {
  	const {GoodsService} = GlobalComponents
    const { getFieldDecorator } = this.props.form
    const { owner } = this.props
    const userContext = null
    const { referenceName } = owner
 
    const tryinit  = (fieldName) => {
     
      if(referenceName!=fieldName){
        return null
      }
      return owner.id
    }
    
    
    const availableForEdit= (fieldName) =>{
      
    
      if(referenceName!=fieldName){
        return true
      }
      return false
    
    }
    
    
    return (
      <Form onSubmit={this.handleSearch} layout="inline">
        <Row gutter={{ md: 8, lg: 24, xl: 48 }}>

          <Col md={8} sm={24}>
            <FormItem label={fieldLabels.id}>
              {getFieldDecorator('id')(
                <Input placeholder={appLocaleName(userContext,"PleaseInput")} />
              )}
            </FormItem>
          </Col>

          <Col md={8} sm={24}>
            <FormItem label={fieldLabels.name}>
              {getFieldDecorator('name')(
                <Input placeholder={appLocaleName(userContext,"PleaseInput")} />
              )}
            </FormItem>
          </Col>

          <Col md={8} sm={24}>
            <FormItem label={fieldLabels.rfid}>
              {getFieldDecorator('rfid')(
                <Input placeholder={appLocaleName(userContext,"PleaseInput")} />
              )}
            </FormItem>
          </Col>

          <Col md={8} sm={24}>
            <FormItem label={fieldLabels.uom}>
              {getFieldDecorator('uom')(
                <Input placeholder={appLocaleName(userContext,"PleaseInput")} />
              )}
            </FormItem>
          </Col>
 <Col md={8} sm={24}>
                    <Form.Item label={fieldLabels.sku}>
                  {getFieldDecorator('sku', {initialValue: tryinit('sku')})(
                  
                  <CandidateList 
		                 disabled={!availableForEdit('sku')}
		                 ownerType={owner.type}
		                 ownerId={owner.id}
		                 scenarioCode={"search"}
		                 listType={"goods"} 
		                 targetType={"sku"} 
                 
                    requestFunction={GoodsService.queryCandidates} useForSearch />
                  	
                 
                  )}
                </Form.Item></Col>
 <Col md={8} sm={24}>
                    <Form.Item label={fieldLabels.receivingSpace}>
                  {getFieldDecorator('receivingSpace', {initialValue: tryinit('receivingSpace')})(
                  
                  <CandidateList 
		                 disabled={!availableForEdit('receivingSpace')}
		                 ownerType={owner.type}
		                 ownerId={owner.id}
		                 scenarioCode={"search"}
		                 listType={"goods"} 
		                 targetType={"receiving_space"} 
                 
                    requestFunction={GoodsService.queryCandidates} useForSearch />
                  	
                 
                  )}
                </Form.Item></Col>
 <Col md={8} sm={24}>
                    <Form.Item label={fieldLabels.goodsAllocation}>
                  {getFieldDecorator('goodsAllocation', {initialValue: tryinit('goodsAllocation')})(
                  
                  <CandidateList 
		                 disabled={!availableForEdit('goodsAllocation')}
		                 ownerType={owner.type}
		                 ownerId={owner.id}
		                 scenarioCode={"search"}
		                 listType={"goods"} 
		                 targetType={"goods_allocation"} 
                 
                    requestFunction={GoodsService.queryCandidates} useForSearch />
                  	
                 
                  )}
                </Form.Item></Col>
 <Col md={8} sm={24}>
                    <Form.Item label={fieldLabels.smartPallet}>
                  {getFieldDecorator('smartPallet', {initialValue: tryinit('smartPallet')})(
                  
                  <CandidateList 
		                 disabled={!availableForEdit('smartPallet')}
		                 ownerType={owner.type}
		                 ownerId={owner.id}
		                 scenarioCode={"search"}
		                 listType={"goods"} 
		                 targetType={"smart_pallet"} 
                 
                    requestFunction={GoodsService.queryCandidates} useForSearch />
                  	
                 
                  )}
                </Form.Item></Col>
 <Col md={8} sm={24}>
                    <Form.Item label={fieldLabels.shippingSpace}>
                  {getFieldDecorator('shippingSpace', {initialValue: tryinit('shippingSpace')})(
                  
                  <CandidateList 
		                 disabled={!availableForEdit('shippingSpace')}
		                 ownerType={owner.type}
		                 ownerId={owner.id}
		                 scenarioCode={"search"}
		                 listType={"goods"} 
		                 targetType={"shipping_space"} 
                 
                    requestFunction={GoodsService.queryCandidates} useForSearch />
                  	
                 
                  )}
                </Form.Item></Col>
 <Col md={8} sm={24}>
                    <Form.Item label={fieldLabels.transportTask}>
                  {getFieldDecorator('transportTask', {initialValue: tryinit('transportTask')})(
                  
                  <CandidateList 
		                 disabled={!availableForEdit('transportTask')}
		                 ownerType={owner.type}
		                 ownerId={owner.id}
		                 scenarioCode={"search"}
		                 listType={"goods"} 
		                 targetType={"transport_task"} 
                 
                    requestFunction={GoodsService.queryCandidates} useForSearch />
                  	
                 
                  )}
                </Form.Item></Col>
 <Col md={8} sm={24}>
                    <Form.Item label={fieldLabels.retailStore}>
                  {getFieldDecorator('retailStore', {initialValue: tryinit('retailStore')})(
                  
                  <CandidateList 
		                 disabled={!availableForEdit('retailStore')}
		                 ownerType={owner.type}
		                 ownerId={owner.id}
		                 scenarioCode={"search"}
		                 listType={"goods"} 
		                 targetType={"retail_store"} 
                 
                    requestFunction={GoodsService.queryCandidates} useForSearch />
                  	
                 
                  )}
                </Form.Item></Col>
 <Col md={8} sm={24}>
                    <Form.Item label={fieldLabels.bizOrder}>
                  {getFieldDecorator('bizOrder', {initialValue: tryinit('bizOrder')})(
                  
                  <CandidateList 
		                 disabled={!availableForEdit('bizOrder')}
		                 ownerType={owner.type}
		                 ownerId={owner.id}
		                 scenarioCode={"search"}
		                 listType={"goods"} 
		                 targetType={"supply_order"} 
                 
                    requestFunction={GoodsService.queryCandidates} useForSearch />
                  	
                 
                  )}
                </Form.Item></Col>
 <Col md={8} sm={24}>
                    <Form.Item label={fieldLabels.retailStoreOrder}>
                  {getFieldDecorator('retailStoreOrder', {initialValue: tryinit('retailStoreOrder')})(
                  
                  <CandidateList 
		                 disabled={!availableForEdit('retailStoreOrder')}
		                 ownerType={owner.type}
		                 ownerId={owner.id}
		                 scenarioCode={"search"}
		                 listType={"goods"} 
		                 targetType={"retail_store_order"} 
                 
                    requestFunction={GoodsService.queryCandidates} useForSearch />
                  	
                 
                  )}
                </Form.Item></Col>
 <Col md={8} sm={24}>
                    <Form.Item label={fieldLabels.packaging}>
                  {getFieldDecorator('packaging', {initialValue: tryinit('packaging')})(
                  
                  <CandidateList 
		                 disabled={!availableForEdit('packaging')}
		                 ownerType={owner.type}
		                 ownerId={owner.id}
		                 scenarioCode={"search"}
		                 listType={"goods"} 
		                 targetType={"goods_packaging"} 
                 
                    requestFunction={GoodsService.queryCandidates} useForSearch />
                  	
                 
                  )}
                </Form.Item></Col>

        </Row>
        <div style={{ overflow: 'hidden' }}>
          <span style={{ float: 'right', marginBottom: 24 }}>
            <Button type="primary" icon="search" htmlType="submit">{appLocaleName(userContext,"Search")}</Button>
            <Button icon="undo" style={{ marginLeft: 8 }} onClick={this.handleFormReset}>{appLocaleName(userContext,"Reset")}</Button>
            <a style={{ marginLeft: 8 }} onClick={this.toggleForm}>{appLocaleName(userContext,"Collapse")} <Icon type="up" /></a>
          </span>
        </div>
      </Form>
    )
  }
	
  render() {
  	const expandForm = overrideValue([this.state.expandForm],false)
    return expandForm ? this.renderAdvancedForm() : this.renderSimpleForm()
  }
}

export default Form.create()(GoodsSearchForm)


