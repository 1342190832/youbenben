

import React, { PureComponent } from 'react'
import { connect } from 'dva'
import { Row, Col, Card, Form, Input, Select, Icon, Button, Dropdown, Menu, InputNumber, DatePicker, Modal, message } from 'antd'

import styles from './Employee.search.less'
import GlobalComponents from '../../custcomponents'
import CandidateList from '../../components/CandidateList'
import appLocaleName from '../../common/Locale.tool'
import EmployeeBase from './Employee.base'
const FormItem = Form.Item
const { Option } = Select
const getValue = obj => Object.keys(obj).map(key => obj[key]).join(',')
const {fieldLabels} = EmployeeBase
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

class EmployeeSearchForm extends PureComponent {
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
      employeeList: 1,
      'employeeList.searchField': fieldName,
      'employeeList.searchVerb': 'startsWith',
      'employeeList.searchValue': fieldValue,
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
		pushIfNotNull(paramList,this.buildStringSearchParameters(listName, fieldsValue,'eq', 'company'))
		pushIfNotNull(paramList,this.buildStringSearchParameters(listName, fieldsValue,'contains', 'title'))
		pushIfNotNull(paramList,this.buildStringSearchParameters(listName, fieldsValue,'eq', 'department'))
		pushIfNotNull(paramList,this.buildStringSearchParameters(listName, fieldsValue,'contains', 'familyName'))
		pushIfNotNull(paramList,this.buildStringSearchParameters(listName, fieldsValue,'contains', 'givenName'))
		pushIfNotNull(paramList,this.buildStringSearchParameters(listName, fieldsValue,'contains', 'email'))
		pushIfNotNull(paramList,this.buildStringSearchParameters(listName, fieldsValue,'contains', 'city'))
		pushIfNotNull(paramList,this.buildStringSearchParameters(listName, fieldsValue,'contains', 'address'))
		pushIfNotNull(paramList,this.buildStringSearchParameters(listName, fieldsValue,'contains', 'cellPhone'))
		pushIfNotNull(paramList,this.buildStringSearchParameters(listName, fieldsValue,'eq', 'occupation'))
		pushIfNotNull(paramList,this.buildStringSearchParameters(listName, fieldsValue,'eq', 'responsibleFor'))
		pushIfNotNull(paramList,this.buildStringSearchParameters(listName, fieldsValue,'eq', 'currentSalaryGrade'))
		pushIfNotNull(paramList,this.buildStringSearchParameters(listName, fieldsValue,'contains', 'salaryAccount'))
		pushIfNotNull(paramList,this.buildStringSearchParameters(listName, fieldsValue,'eq', 'jobApplication'))
		pushIfNotNull(paramList,this.buildStringSearchParameters(listName, fieldsValue,'eq', 'professionInterview'))
		pushIfNotNull(paramList,this.buildStringSearchParameters(listName, fieldsValue,'eq', 'hrInterview'))
		pushIfNotNull(paramList,this.buildStringSearchParameters(listName, fieldsValue,'eq', 'offerApproval'))
		pushIfNotNull(paramList,this.buildStringSearchParameters(listName, fieldsValue,'eq', 'offerAcceptance'))
		pushIfNotNull(paramList,this.buildStringSearchParameters(listName, fieldsValue,'eq', 'employeeBoarding'))
		pushIfNotNull(paramList,this.buildStringSearchParameters(listName, fieldsValue,'eq', 'termination'))

     
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
        employeeSearchFormParameters: filterObjectKeys(fieldsValue),
        searchParameters: params,
        expandForm },
      })
    })
  }
      
  renderSimpleForm() {
    const { getFieldDecorator } = this.props.form
    const userContext = null
     const { owner } = this.props
    const {EmployeeService} = GlobalComponents
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
                 <Form.Item label={fieldLabels.company}>
               {getFieldDecorator('company', {initialValue: tryinit('company')})(
               
               <CandidateList 
                 disabled={!availableForEdit('company')}
                 ownerType={owner.type}
                 ownerId={owner.id}
                 scenarioCode={"search"}
                 listType={"employee"} 
                 targetType={"retail_store_country_center"} 
                 
                 
                 requestFunction={EmployeeService.queryCandidates} useForSearch />
               	 
       
               )}
             </Form.Item></Col>

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
  	const {EmployeeService} = GlobalComponents
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
                    <Form.Item label={fieldLabels.company}>
                  {getFieldDecorator('company', {initialValue: tryinit('company')})(
                  
                  <CandidateList 
		                 disabled={!availableForEdit('company')}
		                 ownerType={owner.type}
		                 ownerId={owner.id}
		                 scenarioCode={"search"}
		                 listType={"employee"} 
		                 targetType={"retail_store_country_center"} 
                 
                    requestFunction={EmployeeService.queryCandidates} useForSearch />
                  	
                 
                  )}
                </Form.Item></Col>

          <Col md={8} sm={24}>
            <FormItem label={fieldLabels.title}>
              {getFieldDecorator('title')(
                <Input placeholder={appLocaleName(userContext,"PleaseInput")} />
              )}
            </FormItem>
          </Col>
 <Col md={8} sm={24}>
                    <Form.Item label={fieldLabels.department}>
                  {getFieldDecorator('department', {initialValue: tryinit('department')})(
                  
                  <CandidateList 
		                 disabled={!availableForEdit('department')}
		                 ownerType={owner.type}
		                 ownerId={owner.id}
		                 scenarioCode={"search"}
		                 listType={"employee"} 
		                 targetType={"level_three_department"} 
                 
                    requestFunction={EmployeeService.queryCandidates} useForSearch />
                  	
                 
                  )}
                </Form.Item></Col>

          <Col md={8} sm={24}>
            <FormItem label={fieldLabels.familyName}>
              {getFieldDecorator('familyName')(
                <Input placeholder={appLocaleName(userContext,"PleaseInput")} />
              )}
            </FormItem>
          </Col>

          <Col md={8} sm={24}>
            <FormItem label={fieldLabels.givenName}>
              {getFieldDecorator('givenName')(
                <Input placeholder={appLocaleName(userContext,"PleaseInput")} />
              )}
            </FormItem>
          </Col>

          <Col md={8} sm={24}>
            <FormItem label={fieldLabels.email}>
              {getFieldDecorator('email')(
                <Input placeholder={appLocaleName(userContext,"PleaseInput")} />
              )}
            </FormItem>
          </Col>

          <Col md={8} sm={24}>
            <FormItem label={fieldLabels.city}>
              {getFieldDecorator('city')(
                <Input placeholder={appLocaleName(userContext,"PleaseInput")} />
              )}
            </FormItem>
          </Col>

          <Col md={8} sm={24}>
            <FormItem label={fieldLabels.address}>
              {getFieldDecorator('address')(
                <Input placeholder={appLocaleName(userContext,"PleaseInput")} />
              )}
            </FormItem>
          </Col>

          <Col md={8} sm={24}>
            <FormItem label={fieldLabels.cellPhone}>
              {getFieldDecorator('cellPhone')(
                <Input placeholder={appLocaleName(userContext,"PleaseInput")} />
              )}
            </FormItem>
          </Col>
 <Col md={8} sm={24}>
                    <Form.Item label={fieldLabels.occupation}>
                  {getFieldDecorator('occupation', {initialValue: tryinit('occupation')})(
                  
                  <CandidateList 
		                 disabled={!availableForEdit('occupation')}
		                 ownerType={owner.type}
		                 ownerId={owner.id}
		                 scenarioCode={"search"}
		                 listType={"employee"} 
		                 targetType={"occupation_type"} 
                 
                    requestFunction={EmployeeService.queryCandidates} useForSearch />
                  	
                 
                  )}
                </Form.Item></Col>
 <Col md={8} sm={24}>
                    <Form.Item label={fieldLabels.responsibleFor}>
                  {getFieldDecorator('responsibleFor', {initialValue: tryinit('responsibleFor')})(
                  
                  <CandidateList 
		                 disabled={!availableForEdit('responsibleFor')}
		                 ownerType={owner.type}
		                 ownerId={owner.id}
		                 scenarioCode={"search"}
		                 listType={"employee"} 
		                 targetType={"responsibility_type"} 
                 
                    requestFunction={EmployeeService.queryCandidates} useForSearch />
                  	
                 
                  )}
                </Form.Item></Col>
 <Col md={8} sm={24}>
                    <Form.Item label={fieldLabels.currentSalaryGrade}>
                  {getFieldDecorator('currentSalaryGrade', {initialValue: tryinit('currentSalaryGrade')})(
                  
                  <CandidateList 
		                 disabled={!availableForEdit('currentSalaryGrade')}
		                 ownerType={owner.type}
		                 ownerId={owner.id}
		                 scenarioCode={"search"}
		                 listType={"employee"} 
		                 targetType={"salary_grade"} 
                 
                    requestFunction={EmployeeService.queryCandidates} useForSearch />
                  	
                 
                  )}
                </Form.Item></Col>

          <Col md={8} sm={24}>
            <FormItem label={fieldLabels.salaryAccount}>
              {getFieldDecorator('salaryAccount')(
                <Input placeholder={appLocaleName(userContext,"PleaseInput")} />
              )}
            </FormItem>
          </Col>
 <Col md={8} sm={24}>
                    <Form.Item label={fieldLabels.jobApplication}>
                  {getFieldDecorator('jobApplication', {initialValue: tryinit('jobApplication')})(
                  
                  <CandidateList 
		                 disabled={!availableForEdit('jobApplication')}
		                 ownerType={owner.type}
		                 ownerId={owner.id}
		                 scenarioCode={"search"}
		                 listType={"employee"} 
		                 targetType={"job_application"} 
                 
                    requestFunction={EmployeeService.queryCandidates} useForSearch />
                  	
                 
                  )}
                </Form.Item></Col>
 <Col md={8} sm={24}>
                    <Form.Item label={fieldLabels.professionInterview}>
                  {getFieldDecorator('professionInterview', {initialValue: tryinit('professionInterview')})(
                  
                  <CandidateList 
		                 disabled={!availableForEdit('professionInterview')}
		                 ownerType={owner.type}
		                 ownerId={owner.id}
		                 scenarioCode={"search"}
		                 listType={"employee"} 
		                 targetType={"profession_interview"} 
                 
                    requestFunction={EmployeeService.queryCandidates} useForSearch />
                  	
                 
                  )}
                </Form.Item></Col>
 <Col md={8} sm={24}>
                    <Form.Item label={fieldLabels.hrInterview}>
                  {getFieldDecorator('hrInterview', {initialValue: tryinit('hrInterview')})(
                  
                  <CandidateList 
		                 disabled={!availableForEdit('hrInterview')}
		                 ownerType={owner.type}
		                 ownerId={owner.id}
		                 scenarioCode={"search"}
		                 listType={"employee"} 
		                 targetType={"hr_interview"} 
                 
                    requestFunction={EmployeeService.queryCandidates} useForSearch />
                  	
                 
                  )}
                </Form.Item></Col>
 <Col md={8} sm={24}>
                    <Form.Item label={fieldLabels.offerApproval}>
                  {getFieldDecorator('offerApproval', {initialValue: tryinit('offerApproval')})(
                  
                  <CandidateList 
		                 disabled={!availableForEdit('offerApproval')}
		                 ownerType={owner.type}
		                 ownerId={owner.id}
		                 scenarioCode={"search"}
		                 listType={"employee"} 
		                 targetType={"offer_approval"} 
                 
                    requestFunction={EmployeeService.queryCandidates} useForSearch />
                  	
                 
                  )}
                </Form.Item></Col>
 <Col md={8} sm={24}>
                    <Form.Item label={fieldLabels.offerAcceptance}>
                  {getFieldDecorator('offerAcceptance', {initialValue: tryinit('offerAcceptance')})(
                  
                  <CandidateList 
		                 disabled={!availableForEdit('offerAcceptance')}
		                 ownerType={owner.type}
		                 ownerId={owner.id}
		                 scenarioCode={"search"}
		                 listType={"employee"} 
		                 targetType={"offer_acceptance"} 
                 
                    requestFunction={EmployeeService.queryCandidates} useForSearch />
                  	
                 
                  )}
                </Form.Item></Col>
 <Col md={8} sm={24}>
                    <Form.Item label={fieldLabels.employeeBoarding}>
                  {getFieldDecorator('employeeBoarding', {initialValue: tryinit('employeeBoarding')})(
                  
                  <CandidateList 
		                 disabled={!availableForEdit('employeeBoarding')}
		                 ownerType={owner.type}
		                 ownerId={owner.id}
		                 scenarioCode={"search"}
		                 listType={"employee"} 
		                 targetType={"employee_boarding"} 
                 
                    requestFunction={EmployeeService.queryCandidates} useForSearch />
                  	
                 
                  )}
                </Form.Item></Col>
 <Col md={8} sm={24}>
                    <Form.Item label={fieldLabels.termination}>
                  {getFieldDecorator('termination', {initialValue: tryinit('termination')})(
                  
                  <CandidateList 
		                 disabled={!availableForEdit('termination')}
		                 ownerType={owner.type}
		                 ownerId={owner.id}
		                 scenarioCode={"search"}
		                 listType={"employee"} 
		                 targetType={"termination"} 
                 
                    requestFunction={EmployeeService.queryCandidates} useForSearch />
                  	
                 
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

export default Form.create()(EmployeeSearchForm)


