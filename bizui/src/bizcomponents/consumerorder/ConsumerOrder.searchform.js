

import React, { PureComponent } from 'react'
import { connect } from 'dva'
import { Row, Col, Card, Form, Input, Select, Icon, Button, Dropdown, Menu, InputNumber, DatePicker, Modal, message } from 'antd'

import styles from './ConsumerOrder.search.less'
import GlobalComponents from '../../custcomponents'
import CandidateList from '../../components/CandidateList'
import appLocaleName from '../../common/Locale.tool'
import ConsumerOrderBase from './ConsumerOrder.base'
const FormItem = Form.Item
const { Option } = Select
const getValue = obj => Object.keys(obj).map(key => obj[key]).join(',')
const {fieldLabels} = ConsumerOrderBase
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

class ConsumerOrderSearchForm extends PureComponent {
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
      consumerOrderList: 1,
      'consumerOrderList.searchField': fieldName,
      'consumerOrderList.searchVerb': 'startsWith',
      'consumerOrderList.searchValue': fieldValue,
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
		pushIfNotNull(paramList,this.buildStringSearchParameters(listName, fieldsValue,'contains', 'title'))
		pushIfNotNull(paramList,this.buildStringSearchParameters(listName, fieldsValue,'eq', 'consumer'))
		pushIfNotNull(paramList,this.buildStringSearchParameters(listName, fieldsValue,'eq', 'confirmation'))
		pushIfNotNull(paramList,this.buildStringSearchParameters(listName, fieldsValue,'eq', 'approval'))
		pushIfNotNull(paramList,this.buildStringSearchParameters(listName, fieldsValue,'eq', 'processing'))
		pushIfNotNull(paramList,this.buildStringSearchParameters(listName, fieldsValue,'eq', 'shipment'))
		pushIfNotNull(paramList,this.buildStringSearchParameters(listName, fieldsValue,'eq', 'delivery'))
		pushIfNotNull(paramList,this.buildStringSearchParameters(listName, fieldsValue,'eq', 'store'))

     
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
        consumerOrderSearchFormParameters: filterObjectKeys(fieldsValue),
        searchParameters: params,
        expandForm },
      })
    })
  }
      
  renderSimpleForm() {
    const { getFieldDecorator } = this.props.form
    const userContext = null
     const { owner } = this.props
    const {ConsumerOrderService} = GlobalComponents
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
         <FormItem label={fieldLabels.title}>
           {getFieldDecorator('title')(
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
  	const {ConsumerOrderService} = GlobalComponents
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
            <FormItem label={fieldLabels.title}>
              {getFieldDecorator('title')(
                <Input placeholder={appLocaleName(userContext,"PleaseInput")} />
              )}
            </FormItem>
          </Col>
 <Col md={8} sm={24}>
                    <Form.Item label={fieldLabels.consumer}>
                  {getFieldDecorator('consumer', {initialValue: tryinit('consumer')})(
                  
                  <CandidateList 
		                 disabled={!availableForEdit('consumer')}
		                 ownerType={owner.type}
		                 ownerId={owner.id}
		                 scenarioCode={"search"}
		                 listType={"consumer_order"} 
		                 targetType={"retail_store_member"} 
                 
                    requestFunction={ConsumerOrderService.queryCandidates} useForSearch />
                  	
                 
                  )}
                </Form.Item></Col>
 <Col md={8} sm={24}>
                    <Form.Item label={fieldLabels.confirmation}>
                  {getFieldDecorator('confirmation', {initialValue: tryinit('confirmation')})(
                  
                  <CandidateList 
		                 disabled={!availableForEdit('confirmation')}
		                 ownerType={owner.type}
		                 ownerId={owner.id}
		                 scenarioCode={"search"}
		                 listType={"consumer_order"} 
		                 targetType={"supply_order_confirmation"} 
                 
                    requestFunction={ConsumerOrderService.queryCandidates} useForSearch />
                  	
                 
                  )}
                </Form.Item></Col>
 <Col md={8} sm={24}>
                    <Form.Item label={fieldLabels.approval}>
                  {getFieldDecorator('approval', {initialValue: tryinit('approval')})(
                  
                  <CandidateList 
		                 disabled={!availableForEdit('approval')}
		                 ownerType={owner.type}
		                 ownerId={owner.id}
		                 scenarioCode={"search"}
		                 listType={"consumer_order"} 
		                 targetType={"supply_order_approval"} 
                 
                    requestFunction={ConsumerOrderService.queryCandidates} useForSearch />
                  	
                 
                  )}
                </Form.Item></Col>
 <Col md={8} sm={24}>
                    <Form.Item label={fieldLabels.processing}>
                  {getFieldDecorator('processing', {initialValue: tryinit('processing')})(
                  
                  <CandidateList 
		                 disabled={!availableForEdit('processing')}
		                 ownerType={owner.type}
		                 ownerId={owner.id}
		                 scenarioCode={"search"}
		                 listType={"consumer_order"} 
		                 targetType={"supply_order_processing"} 
                 
                    requestFunction={ConsumerOrderService.queryCandidates} useForSearch />
                  	
                 
                  )}
                </Form.Item></Col>
 <Col md={8} sm={24}>
                    <Form.Item label={fieldLabels.shipment}>
                  {getFieldDecorator('shipment', {initialValue: tryinit('shipment')})(
                  
                  <CandidateList 
		                 disabled={!availableForEdit('shipment')}
		                 ownerType={owner.type}
		                 ownerId={owner.id}
		                 scenarioCode={"search"}
		                 listType={"consumer_order"} 
		                 targetType={"supply_order_shipment"} 
                 
                    requestFunction={ConsumerOrderService.queryCandidates} useForSearch />
                  	
                 
                  )}
                </Form.Item></Col>
 <Col md={8} sm={24}>
                    <Form.Item label={fieldLabels.delivery}>
                  {getFieldDecorator('delivery', {initialValue: tryinit('delivery')})(
                  
                  <CandidateList 
		                 disabled={!availableForEdit('delivery')}
		                 ownerType={owner.type}
		                 ownerId={owner.id}
		                 scenarioCode={"search"}
		                 listType={"consumer_order"} 
		                 targetType={"supply_order_delivery"} 
                 
                    requestFunction={ConsumerOrderService.queryCandidates} useForSearch />
                  	
                 
                  )}
                </Form.Item></Col>
 <Col md={8} sm={24}>
                    <Form.Item label={fieldLabels.store}>
                  {getFieldDecorator('store', {initialValue: tryinit('store')})(
                  
                  <CandidateList 
		                 disabled={!availableForEdit('store')}
		                 ownerType={owner.type}
		                 ownerId={owner.id}
		                 scenarioCode={"search"}
		                 listType={"consumer_order"} 
		                 targetType={"retail_store"} 
                 
                    requestFunction={ConsumerOrderService.queryCandidates} useForSearch />
                  	
                 
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

export default Form.create()(ConsumerOrderSearchForm)


