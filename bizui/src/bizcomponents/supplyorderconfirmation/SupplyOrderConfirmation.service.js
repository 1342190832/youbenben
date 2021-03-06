
import { get,put,postForm,PREFIX,joinParameters,joinPostParameters } from '../../axios/tools'

const view = (targetObjectId) => {
  return get({
    url: `${PREFIX}supplyOrderConfirmationManager/view/${targetObjectId}/`,
  })
}



const load = (targetObjectId, parameters) => {
  const parametersExpr = joinParameters(parameters)
  return get({
    url: `${PREFIX}supplyOrderConfirmationManager/loadSupplyOrderConfirmation/${targetObjectId}/${parametersExpr}/`,
  })
}


const queryCandidates = ({scenarioCode,ownerType,ownerId,listType,groupBy,filterKey,targetType}) => {
  
  const url = `${PREFIX}supplyOrderConfirmationManager/queryCandidates/`
  const data = JSON.stringify({scenarioCode,ownerType,ownerId,listType,groupBy,targetType,filterKey})
  console.log("requestParameters",data)
  return put({url,data})
} 






const addConsumerOrder = (targetObjectId, parameters) => {
  const url = `${PREFIX}supplyOrderConfirmationManager/addConsumerOrder/supplyOrderConfirmationId/title/consumerId/approvalId/processingId/shipmentId/deliveryId/storeId/tokensExpr/`
  const supplyOrderConfirmationId = targetObjectId
  const requestParameters = { ...parameters, supplyOrderConfirmationId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateConsumerOrder = (targetObjectId, parameters) => {
  const url = `${PREFIX}supplyOrderConfirmationManager/updateConsumerOrderProperties/supplyOrderConfirmationId/id/title/tokensExpr/`
  const supplyOrderConfirmationId = targetObjectId
  const requestParameters = { ...parameters, supplyOrderConfirmationId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeConsumerOrderList = (targetObjectId, parameters) => {
  const url = `${PREFIX}supplyOrderConfirmationManager/removeConsumerOrderList/supplyOrderConfirmationId/consumerOrderIds/tokensExpr/`
  const requestParameters = { ...parameters, supplyOrderConfirmationId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}



const addSupplyOrder = (targetObjectId, parameters) => {
  const url = `${PREFIX}supplyOrderConfirmationManager/addSupplyOrder/supplyOrderConfirmationId/buyerId/sellerId/title/totalAmount/approvalId/processingId/pickingId/shipmentId/deliveryId/tokensExpr/`
  const supplyOrderConfirmationId = targetObjectId
  const requestParameters = { ...parameters, supplyOrderConfirmationId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateSupplyOrder = (targetObjectId, parameters) => {
  const url = `${PREFIX}supplyOrderConfirmationManager/updateSupplyOrderProperties/supplyOrderConfirmationId/id/title/totalAmount/tokensExpr/`
  const supplyOrderConfirmationId = targetObjectId
  const requestParameters = { ...parameters, supplyOrderConfirmationId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeSupplyOrderList = (targetObjectId, parameters) => {
  const url = `${PREFIX}supplyOrderConfirmationManager/removeSupplyOrderList/supplyOrderConfirmationId/supplyOrderIds/tokensExpr/`
  const requestParameters = { ...parameters, supplyOrderConfirmationId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}



// Filter this out when no functions

const  listFunctions = () => {
  return get({
    url: `${PREFIX}supplyOrderConfirmationService/listFunctions/`,
  })
}


const  saveRequest = (data) => {

  return put({
    url: `${PREFIX}supplyOrderConfirmationService/save/`,
    data,
  })
}


const  processRequest = (data) => {

  return put({
    url: `${PREFIX}supplyOrderConfirmationService/process/`,
    data,
  })
}

const SupplyOrderConfirmationService = { view,
  load,
  addConsumerOrder,
  addSupplyOrder,
  updateConsumerOrder,
  updateSupplyOrder,
  removeConsumerOrderList,
  removeSupplyOrderList, listFunctions, saveRequest, processRequest, queryCandidates}
export default SupplyOrderConfirmationService

