import React, { Component } from 'react'
import { Card, Button, Form, Icon, Col, Row, DatePicker, TimePicker, Input, Select, Popover,Switch,Modal } from 'antd'
import { connect } from 'dva'
import PageHeaderLayout from '../../layouts/PageHeaderLayout'
import {ImageComponent} from '../../axios/tools'
import FooterToolbar from '../../components/FooterToolbar'
import styles from './Employee.createform.less'
import {mapBackToImageValues, mapFromImageValues} from '../../axios/tools'
import GlobalComponents from '../../custcomponents';
import EmployeeBase from './Employee.base'
import SelectObject from '../../components/SelectObject'
import appLocaleName from '../../common/Locale.tool'

const { Option } = Select
const { RangePicker } = DatePicker
const { TextArea } = Input

const testValues = {};
/*
const testValues = {
  title: '程序员',
  familyName: '张',
  givenName: '文强',
  email: 'share@163.com',
  city: '济南',
  address: '英雄山路',
  cellPhone: '18677778888',
  salaryAccount: '6226 7788 9908 ',
  companyId: 'RSCC000001',
  departmentId: 'LTD000001',
  occupationId: 'OT000001',
  responsibleForId: 'RT000001',
  currentSalaryGradeId: 'SG000001',
  jobApplicationId: 'JA000001',
  professionInterviewId: 'PI000001',
  hrInterviewId: 'HI000001',
  offerApprovalId: 'OA000001',
  offerAcceptanceId: 'OA000001',
  employeeBoardingId: 'EB000001',
  terminationId: 'T000001',
}
*/


const imageKeys = [
]


class EmployeeAssociateForm extends Component {
  state = {
    previewVisible: false,
    previewImage: '',
    convertedImagesValues: {},
  }

  componentDidMount() {
 
    
    
    
  }

  handlePreview = (file) => {
    console.log('preview file', file)
    this.setState({
      previewImage: file.url || file.thumbUrl,
      previewVisible: true,
    })
  }

  



  handleChange = (event, source) => {
    console.log('get file list from change in update change:', source)

    const { fileList } = event
    const { convertedImagesValues } = this.state

    convertedImagesValues[source] = fileList
    this.setState({ convertedImagesValues })
    console.log('/get file list from change in update change:', source)
  }
	
  

  render() {
	const { form, dispatch, submitting, role,data,owner,toggleAssociatePaymentVisible,visible,onCancel, onCreate } = this.props
    const { convertedImagesValues } = this.state
    const {EmployeeService} = GlobalComponents
    const userContext = null
    
 const {EmployeeCompanyTrainingModalTable} = GlobalComponents;
 const {EmployeeSkillModalTable} = GlobalComponents;
 const {EmployeePerformanceModalTable} = GlobalComponents;
 const {EmployeeWorkExperienceModalTable} = GlobalComponents;
 const {EmployeeLeaveModalTable} = GlobalComponents;
 const {EmployeeInterviewModalTable} = GlobalComponents;
 const {EmployeeAttendanceModalTable} = GlobalComponents;
 const {EmployeeQualifierModalTable} = GlobalComponents;
 const {EmployeeEducationModalTable} = GlobalComponents;
 const {EmployeeAwardModalTable} = GlobalComponents;
 const {EmployeeSalarySheetModalTable} = GlobalComponents;
 const {PayingOffModalTable} = GlobalComponents;


    const { getFieldDecorator, validateFieldsAndScroll, getFieldsError } = form
    const {fieldLabels} = EmployeeBase
    
    const capFirstChar = (value)=>{
    	//const upper = value.replace(/^\w/, c => c.toUpperCase());
  		const upper = value.charAt(0).toUpperCase() + value.substr(1);
  		return upper
  	}
    
    
    

    
    
    const tryinit  = (fieldName, candidates) => {
      
      if(candidates&&candidates.length==1){
          return candidates[0].id
      }
      const { owner } = this.props
      const { referenceName } = owner
      if(referenceName!=fieldName){
        return null
      }
      return owner.id
    }
    
    const availableForEdit= (fieldName) =>{
      const { owner } = this.props
      const { referenceName } = owner
      if(referenceName!=fieldName){
        return true
      }
      return false
    
    }
    const formItemLayout = {
      labelCol: { span: 6 },
      wrapperCol: { span: 12 },
    }
    const switchFormItemLayout = {
      labelCol: { span: 14 },
      wrapperCol: { span: 4 },
    }
   
    return (
 <Modal
          title={appLocaleName(userContext,"CreateNew")}
          visible={visible}
          onOk={onCancel}
          onCancel={onCancel}
          width={920}
          style={{ top: 40}}
        >
        <Card title={appLocaleName(userContext,"BasicInfo")}  className={styles.card} style={{ backgroundColor:"#eee" }}>
          <Form >
            <Row gutter={16}>

              <Col lg={12} md={12} sm={12}>
                <Form.Item label={fieldLabels.title} {...formItemLayout}>
                  {getFieldDecorator('title', {
                    rules: [{ required: true, message: appLocaleName(userContext,"PleaseInput") }],
                  })(
                    <Input size="large"  placeHolder={fieldLabels.title} />
                  )}
                </Form.Item>
              </Col>

              <Col lg={12} md={12} sm={12}>
                <Form.Item label={fieldLabels.familyName} {...formItemLayout}>
                  {getFieldDecorator('familyName', {
                    rules: [{ required: true, message: appLocaleName(userContext,"PleaseInput") }],
                  })(
                    <Input size="large"  placeHolder={fieldLabels.familyName} />
                  )}
                </Form.Item>
              </Col>

              <Col lg={12} md={12} sm={12}>
                <Form.Item label={fieldLabels.givenName} {...formItemLayout}>
                  {getFieldDecorator('givenName', {
                    rules: [{ required: true, message: appLocaleName(userContext,"PleaseInput") }],
                  })(
                    <Input size="large"  placeHolder={fieldLabels.givenName} />
                  )}
                </Form.Item>
              </Col>

              <Col lg={12} md={12} sm={12}>
                <Form.Item label={fieldLabels.email} {...formItemLayout}>
                  {getFieldDecorator('email', {
                    rules: [{ required: true, message: appLocaleName(userContext,"PleaseInput") }],
                  })(
                    <Input size="large"  placeHolder={fieldLabels.email} />
                  )}
                </Form.Item>
              </Col>

              <Col lg={12} md={12} sm={12}>
                <Form.Item label={fieldLabels.city} {...formItemLayout}>
                  {getFieldDecorator('city', {
                    rules: [{ required: true, message: appLocaleName(userContext,"PleaseInput") }],
                  })(
                    <Input size="large"  placeHolder={fieldLabels.city} />
                  )}
                </Form.Item>
              </Col>

              <Col lg={12} md={12} sm={12}>
                <Form.Item label={fieldLabels.address} {...formItemLayout}>
                  {getFieldDecorator('address', {
                    rules: [{ required: true, message: appLocaleName(userContext,"PleaseInput") }],
                  })(
                    <Input size="large"  placeHolder={fieldLabels.address} />
                  )}
                </Form.Item>
              </Col>

              <Col lg={12} md={12} sm={12}>
                <Form.Item label={fieldLabels.cellPhone} {...formItemLayout}>
                  {getFieldDecorator('cellPhone', {
                    rules: [{ required: true, message: appLocaleName(userContext,"PleaseInput") }],
                  })(
                    <Input size="large"  placeHolder={fieldLabels.cellPhone} />
                  )}
                </Form.Item>
              </Col>

              <Col lg={12} md={12} sm={12}>
                <Form.Item label={fieldLabels.salaryAccount} {...formItemLayout}>
                  {getFieldDecorator('salaryAccount', {
                    rules: [{ required: true, message: appLocaleName(userContext,"PleaseInput") }],
                  })(
                    <Input size="large"  placeHolder={fieldLabels.salaryAccount} />
                  )}
                </Form.Item>
              </Col>

            </Row>


       
        









       
            <Row gutter={16}>

              <Col lg={12} md={12} sm={24}>
                <Form.Item label={fieldLabels.company} {...formItemLayout}>
                  {getFieldDecorator('companyId', {
                  	initialValue: tryinit('company'),
                    rules: [{ required: true, message: appLocaleName(userContext,"PleaseInput") }],
                  })(
                <SelectObject 
                    disabled={!availableForEdit('company')}
                    targetType={"company"} 
                    requestFunction={EmployeeService.requestCandidateCompany}/>
  
                  )}
                </Form.Item>
              </Col>

              <Col lg={12} md={12} sm={24}>
                <Form.Item label={fieldLabels.department} {...formItemLayout}>
                  {getFieldDecorator('departmentId', {
                  	initialValue: tryinit('department'),
                    rules: [{ required: true, message: appLocaleName(userContext,"PleaseInput") }],
                  })(
                <SelectObject 
                    disabled={!availableForEdit('department')}
                    targetType={"department"} 
                    requestFunction={EmployeeService.requestCandidateDepartment}/>
  
                  )}
                </Form.Item>
              </Col>

              <Col lg={12} md={12} sm={24}>
                <Form.Item label={fieldLabels.occupation} {...formItemLayout}>
                  {getFieldDecorator('occupationId', {
                  	initialValue: tryinit('occupation'),
                    rules: [{ required: true, message: appLocaleName(userContext,"PleaseInput") }],
                  })(
                <SelectObject 
                    disabled={!availableForEdit('occupation')}
                    targetType={"occupation"} 
                    requestFunction={EmployeeService.requestCandidateOccupation}/>
  
                  )}
                </Form.Item>
              </Col>

              <Col lg={12} md={12} sm={24}>
                <Form.Item label={fieldLabels.responsibleFor} {...formItemLayout}>
                  {getFieldDecorator('responsibleForId', {
                  	initialValue: tryinit('responsibleFor'),
                    rules: [{ required: true, message: appLocaleName(userContext,"PleaseInput") }],
                  })(
                <SelectObject 
                    disabled={!availableForEdit('responsibleFor')}
                    targetType={"responsibleFor"} 
                    requestFunction={EmployeeService.requestCandidateResponsibleFor}/>
  
                  )}
                </Form.Item>
              </Col>

              <Col lg={12} md={12} sm={24}>
                <Form.Item label={fieldLabels.currentSalaryGrade} {...formItemLayout}>
                  {getFieldDecorator('currentSalaryGradeId', {
                  	initialValue: tryinit('currentSalaryGrade'),
                    rules: [{ required: true, message: appLocaleName(userContext,"PleaseInput") }],
                  })(
                <SelectObject 
                    disabled={!availableForEdit('currentSalaryGrade')}
                    targetType={"currentSalaryGrade"} 
                    requestFunction={EmployeeService.requestCandidateCurrentSalaryGrade}/>
  
                  )}
                </Form.Item>
              </Col>

              <Col lg={12} md={12} sm={24}>
                <Form.Item label={fieldLabels.jobApplication} {...formItemLayout}>
                  {getFieldDecorator('jobApplicationId', {
                  	initialValue: tryinit('jobApplication'),
                    rules: [{ required: true, message: appLocaleName(userContext,"PleaseInput") }],
                  })(
                <SelectObject 
                    disabled={!availableForEdit('jobApplication')}
                    targetType={"jobApplication"} 
                    requestFunction={EmployeeService.requestCandidateJobApplication}/>
  
                  )}
                </Form.Item>
              </Col>

              <Col lg={12} md={12} sm={24}>
                <Form.Item label={fieldLabels.professionInterview} {...formItemLayout}>
                  {getFieldDecorator('professionInterviewId', {
                  	initialValue: tryinit('professionInterview'),
                    rules: [{ required: true, message: appLocaleName(userContext,"PleaseInput") }],
                  })(
                <SelectObject 
                    disabled={!availableForEdit('professionInterview')}
                    targetType={"professionInterview"} 
                    requestFunction={EmployeeService.requestCandidateProfessionInterview}/>
  
                  )}
                </Form.Item>
              </Col>

              <Col lg={12} md={12} sm={24}>
                <Form.Item label={fieldLabels.hrInterview} {...formItemLayout}>
                  {getFieldDecorator('hrInterviewId', {
                  	initialValue: tryinit('hrInterview'),
                    rules: [{ required: true, message: appLocaleName(userContext,"PleaseInput") }],
                  })(
                <SelectObject 
                    disabled={!availableForEdit('hrInterview')}
                    targetType={"hrInterview"} 
                    requestFunction={EmployeeService.requestCandidateHrInterview}/>
  
                  )}
                </Form.Item>
              </Col>

              <Col lg={12} md={12} sm={24}>
                <Form.Item label={fieldLabels.offerApproval} {...formItemLayout}>
                  {getFieldDecorator('offerApprovalId', {
                  	initialValue: tryinit('offerApproval'),
                    rules: [{ required: true, message: appLocaleName(userContext,"PleaseInput") }],
                  })(
                <SelectObject 
                    disabled={!availableForEdit('offerApproval')}
                    targetType={"offerApproval"} 
                    requestFunction={EmployeeService.requestCandidateOfferApproval}/>
  
                  )}
                </Form.Item>
              </Col>

              <Col lg={12} md={12} sm={24}>
                <Form.Item label={fieldLabels.offerAcceptance} {...formItemLayout}>
                  {getFieldDecorator('offerAcceptanceId', {
                  	initialValue: tryinit('offerAcceptance'),
                    rules: [{ required: true, message: appLocaleName(userContext,"PleaseInput") }],
                  })(
                <SelectObject 
                    disabled={!availableForEdit('offerAcceptance')}
                    targetType={"offerAcceptance"} 
                    requestFunction={EmployeeService.requestCandidateOfferAcceptance}/>
  
                  )}
                </Form.Item>
              </Col>

              <Col lg={12} md={12} sm={24}>
                <Form.Item label={fieldLabels.employeeBoarding} {...formItemLayout}>
                  {getFieldDecorator('employeeBoardingId', {
                  	initialValue: tryinit('employeeBoarding'),
                    rules: [{ required: true, message: appLocaleName(userContext,"PleaseInput") }],
                  })(
                <SelectObject 
                    disabled={!availableForEdit('employeeBoarding')}
                    targetType={"employeeBoarding"} 
                    requestFunction={EmployeeService.requestCandidateEmployeeBoarding}/>
  
                  )}
                </Form.Item>
              </Col>

              <Col lg={12} md={12} sm={24}>
                <Form.Item label={fieldLabels.termination} {...formItemLayout}>
                  {getFieldDecorator('terminationId', {
                  	initialValue: tryinit('termination'),
                    rules: [{ required: true, message: appLocaleName(userContext,"PleaseInput") }],
                  })(
                <SelectObject 
                    disabled={!availableForEdit('termination')}
                    targetType={"termination"} 
                    requestFunction={EmployeeService.requestCandidateTermination}/>
  
                  )}
                </Form.Item>
              </Col>

            </Row>
         
       

			</Form>
			
			
			
			
        </Card>
        
	<EmployeeCompanyTrainingModalTable data={data.employeeCompanyTrainingList} owner={owner} />
	<EmployeeSkillModalTable data={data.employeeSkillList} owner={owner} />
	<EmployeePerformanceModalTable data={data.employeePerformanceList} owner={owner} />
	<EmployeeWorkExperienceModalTable data={data.employeeWorkExperienceList} owner={owner} />
	<EmployeeLeaveModalTable data={data.employeeLeaveList} owner={owner} />
	<EmployeeInterviewModalTable data={data.employeeInterviewList} owner={owner} />
	<EmployeeAttendanceModalTable data={data.employeeAttendanceList} owner={owner} />
	<EmployeeQualifierModalTable data={data.employeeQualifierList} owner={owner} />
	<EmployeeEducationModalTable data={data.employeeEducationList} owner={owner} />
	<EmployeeAwardModalTable data={data.employeeAwardList} owner={owner} />
	<EmployeeSalarySheetModalTable data={data.employeeSalarySheetList} owner={owner} />
	<PayingOffModalTable data={data.payingOffList} owner={owner} />
        
        
        
      </Modal>)
    
  }
}

export default connect(state => ({
  collapsed: state.global.collapsed,
}))(Form.create()(EmployeeAssociateForm))




