import React, { Component } from 'react'
import { Card, Button, Form, Icon, Col, Row, DatePicker, TimePicker, Input, Select, Popover,Switch } from 'antd'
import { connect } from 'dva'
import PageHeaderLayout from '../../layouts/PageHeaderLayout'
import CandidateList from '../../components/CandidateList'
import {ImageComponent} from '../../axios/tools'
import FooterToolbar from '../../components/FooterToolbar'
import styles from './SupplyOrder.createform.less'
import {mapBackToImageValues, mapFromImageValues} from '../../axios/tools'
import GlobalComponents from '../../custcomponents';
import SupplyOrderBase from './SupplyOrder.base'
import appLocaleName from '../../common/Locale.tool'
const { Option } = Select
const { RangePicker } = DatePicker
const { TextArea } = Input
const {fieldLabels} = SupplyOrderBase
const testValues = {};
/*
const testValues = {
  title: '油奔奔给供货商下的订单',
  totalAmount: '2849253120.00',
  buyerId: 'RSCC000001',
  sellerId: 'GS000001',
  confirmationId: 'SOC000001',
  approvalId: 'SOA000001',
  processingId: 'SOP000001',
  pickingId: 'SOP000001',
  shipmentId: 'SOS000001',
  deliveryId: 'SOD000001',
}
*/

const imageKeys = [
]


class SupplyOrderCreateFormBody extends Component {
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

 


  handleImageChange = (event, source) => {

    const {handleImageChange} = this.props
    if(!handleImageChange){
      console.log('FAILED GET PROCESS FUNCTION TO HANDLE IMAGE VALUE CHANGE', source)
      return 
    }

    const { convertedImagesValues } = this.state
    const { fileList } = event
    convertedImagesValues[source] = fileList
    this.setState({ convertedImagesValues })
    handleImageChange(event, source)
	
 
  }
  

  render() {
    const { form, dispatch, submitting, role } = this.props
    const { convertedImagesValues } = this.state
	const userContext = null
    const { getFieldDecorator, validateFieldsAndScroll, getFieldsError } = form
    const { owner } = this.props
    const {SupplyOrderService} = GlobalComponents
    
    const capFirstChar = (value)=>{
    	//const upper = value.replace(/^\w/, c => c.toUpperCase());
  		const upper = value.charAt(0).toUpperCase() + value.substr(1);
  		return upper
  	}
    
    
    const tryinit  = (fieldName) => {
      
      if(!owner){
      	return null
      }
      const { referenceName } = owner
      if(referenceName!=fieldName){
        return null
      }
      return owner.id
    }
    
    const availableForEdit= (fieldName) =>{
     
      if(!owner){
      	return true
      }
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

      labelCol: { span: 6 },
      wrapperCol: { span: 12 },

    }
    
    const internalRenderTitle = () =>{
      const linkComp=<a onClick={goback}  > <Icon type="double-left" style={{marginRight:"10px"}} /> </a>
      return (<div>{linkComp}{appLocaleName(userContext,"CreateNew")}{window.trans('supply_order')}</div>)
    }
	
	return (
      <div>
        <Card title={!this.props.hideTitle&&appLocaleName(userContext,"BasicInfo")} className={styles.card} bordered={false}>
          <Form >
          	<Row gutter={16}>
           

              <Col lg={24} md={24} sm={24}>
                <Form.Item label={fieldLabels.title} {...formItemLayout}>
                  {getFieldDecorator('title', {
                    rules: [{ required: true, message: appLocaleName(userContext,"PleaseInput") }],
                  })(
                    <Input size="large"  placeHolder={fieldLabels.title} />
                  )}
                </Form.Item>
              </Col>

              <Col lg={24} md={24} sm={24}>
                <Form.Item label={fieldLabels.totalAmount} {...formItemLayout}>
                  {getFieldDecorator('totalAmount', {
                    rules: [{ required: true, message: appLocaleName(userContext,"PleaseInput") }],
                  })(
                    <Input size="large" prefix={`${appLocaleName(userContext,"Currency")}`} placeHolder={fieldLabels.totalAmount} />
                  )}
                </Form.Item>
              </Col>


       
 
              <Col lg={24} md={24} sm={24}>
                <Form.Item label={fieldLabels.buyer} {...formItemLayout}>
                  {getFieldDecorator('buyerId', {
                  	initialValue: tryinit('buyer'),
                    rules: [{ required: true, message: appLocaleName(userContext,"PleaseInput") }],
                  })(
                  
                  
                  <CandidateList 
		                 disabled={!availableForEdit('buyer')}
		                 ownerType={owner.type}
		                 ownerId={owner.id}
		                 scenarioCode={"assign"}
		                 listType={"supply_order"} 
		                 targetType={"retail_store_country_center"} 
                 
                    requestFunction={SupplyOrderService.queryCandidates}  />
                  	
                  
                  
                  )}
                </Form.Item>
              </Col>

           

              <Col lg={24} md={24} sm={24}>
                <Form.Item label={fieldLabels.seller} {...formItemLayout}>
                  {getFieldDecorator('sellerId', {
                  	initialValue: tryinit('seller'),
                    rules: [{ required: true, message: appLocaleName(userContext,"PleaseInput") }],
                  })(
                  
                  
                  <CandidateList 
		                 disabled={!availableForEdit('seller')}
		                 ownerType={owner.type}
		                 ownerId={owner.id}
		                 scenarioCode={"assign"}
		                 listType={"supply_order"} 
		                 targetType={"goods_supplier"} 
                 
                    requestFunction={SupplyOrderService.queryCandidates}  />
                  	
                  
                  
                  )}
                </Form.Item>
              </Col>

           

              <Col lg={24} md={24} sm={24}>
                <Form.Item label={fieldLabels.confirmation} {...formItemLayout}>
                  {getFieldDecorator('confirmationId', {
                  	initialValue: tryinit('confirmation'),
                    rules: [{ required: true, message: appLocaleName(userContext,"PleaseInput") }],
                  })(
                  
                  
                  <CandidateList 
		                 disabled={!availableForEdit('confirmation')}
		                 ownerType={owner.type}
		                 ownerId={owner.id}
		                 scenarioCode={"assign"}
		                 listType={"supply_order"} 
		                 targetType={"supply_order_confirmation"} 
                 
                    requestFunction={SupplyOrderService.queryCandidates}  />
                  	
                  
                  
                  )}
                </Form.Item>
              </Col>

           

              <Col lg={24} md={24} sm={24}>
                <Form.Item label={fieldLabels.approval} {...formItemLayout}>
                  {getFieldDecorator('approvalId', {
                  	initialValue: tryinit('approval'),
                    rules: [{ required: true, message: appLocaleName(userContext,"PleaseInput") }],
                  })(
                  
                  
                  <CandidateList 
		                 disabled={!availableForEdit('approval')}
		                 ownerType={owner.type}
		                 ownerId={owner.id}
		                 scenarioCode={"assign"}
		                 listType={"supply_order"} 
		                 targetType={"supply_order_approval"} 
                 
                    requestFunction={SupplyOrderService.queryCandidates}  />
                  	
                  
                  
                  )}
                </Form.Item>
              </Col>

           

              <Col lg={24} md={24} sm={24}>
                <Form.Item label={fieldLabels.processing} {...formItemLayout}>
                  {getFieldDecorator('processingId', {
                  	initialValue: tryinit('processing'),
                    rules: [{ required: true, message: appLocaleName(userContext,"PleaseInput") }],
                  })(
                  
                  
                  <CandidateList 
		                 disabled={!availableForEdit('processing')}
		                 ownerType={owner.type}
		                 ownerId={owner.id}
		                 scenarioCode={"assign"}
		                 listType={"supply_order"} 
		                 targetType={"supply_order_processing"} 
                 
                    requestFunction={SupplyOrderService.queryCandidates}  />
                  	
                  
                  
                  )}
                </Form.Item>
              </Col>

           

              <Col lg={24} md={24} sm={24}>
                <Form.Item label={fieldLabels.picking} {...formItemLayout}>
                  {getFieldDecorator('pickingId', {
                  	initialValue: tryinit('picking'),
                    rules: [{ required: true, message: appLocaleName(userContext,"PleaseInput") }],
                  })(
                  
                  
                  <CandidateList 
		                 disabled={!availableForEdit('picking')}
		                 ownerType={owner.type}
		                 ownerId={owner.id}
		                 scenarioCode={"assign"}
		                 listType={"supply_order"} 
		                 targetType={"supply_order_picking"} 
                 
                    requestFunction={SupplyOrderService.queryCandidates}  />
                  	
                  
                  
                  )}
                </Form.Item>
              </Col>

           

              <Col lg={24} md={24} sm={24}>
                <Form.Item label={fieldLabels.shipment} {...formItemLayout}>
                  {getFieldDecorator('shipmentId', {
                  	initialValue: tryinit('shipment'),
                    rules: [{ required: true, message: appLocaleName(userContext,"PleaseInput") }],
                  })(
                  
                  
                  <CandidateList 
		                 disabled={!availableForEdit('shipment')}
		                 ownerType={owner.type}
		                 ownerId={owner.id}
		                 scenarioCode={"assign"}
		                 listType={"supply_order"} 
		                 targetType={"supply_order_shipment"} 
                 
                    requestFunction={SupplyOrderService.queryCandidates}  />
                  	
                  
                  
                  )}
                </Form.Item>
              </Col>

           

              <Col lg={24} md={24} sm={24}>
                <Form.Item label={fieldLabels.delivery} {...formItemLayout}>
                  {getFieldDecorator('deliveryId', {
                  	initialValue: tryinit('delivery'),
                    rules: [{ required: true, message: appLocaleName(userContext,"PleaseInput") }],
                  })(
                  
                  
                  <CandidateList 
		                 disabled={!availableForEdit('delivery')}
		                 ownerType={owner.type}
		                 ownerId={owner.id}
		                 scenarioCode={"assign"}
		                 listType={"supply_order"} 
		                 targetType={"supply_order_delivery"} 
                 
                    requestFunction={SupplyOrderService.queryCandidates}  />
                  	
                  
                  
                  )}
                </Form.Item>
              </Col>

           



			 </Row>
          </Form>
        </Card>








      
       </div>
    )
  }
}

export default connect(state => ({
  collapsed: state.global.collapsed,
}))(Form.create()(SupplyOrderCreateFormBody))





