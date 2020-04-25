
import { get,put,postForm,PREFIX,joinParameters,joinPostParameters } from '../../axios/tools'

const view = (targetObjectId) => {
  return get({
    url: `${PREFIX}retailStoreOrderDeliveryManager/view/${targetObjectId}/`,
  })
}



const load = (targetObjectId, parameters) => {
  const parametersExpr = joinParameters(parameters)
  return get({
    url: `${PREFIX}retailStoreOrderDeliveryManager/loadRetailStoreOrderDelivery/${targetObjectId}/${parametersExpr}/`,
  })
}


const queryCandidates = ({scenarioCode,ownerType,ownerId,listType,groupBy,filterKey,targetType}) => {
  
  const url = `${PREFIX}retailStoreOrderDeliveryManager/queryCandidates/`
  const data = JSON.stringify({scenarioCode,ownerType,ownerId,listType,groupBy,targetType,filterKey})
  console.log("requestParameters",data)
  return put({url,data})
} 






const addRetailStoreOrder = (targetObjectId, parameters) => {
  const url = `${PREFIX}retailStoreOrderDeliveryManager/addRetailStoreOrder/retailStoreOrderDeliveryId/buyerId/sellerId/title/totalAmount/confirmationId/approvalId/processingId/pickingId/shipmentId/tokensExpr/`
  const retailStoreOrderDeliveryId = targetObjectId
  const requestParameters = { ...parameters, retailStoreOrderDeliveryId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateRetailStoreOrder = (targetObjectId, parameters) => {
  const url = `${PREFIX}retailStoreOrderDeliveryManager/updateRetailStoreOrderProperties/retailStoreOrderDeliveryId/id/title/totalAmount/tokensExpr/`
  const retailStoreOrderDeliveryId = targetObjectId
  const requestParameters = { ...parameters, retailStoreOrderDeliveryId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeRetailStoreOrderList = (targetObjectId, parameters) => {
  const url = `${PREFIX}retailStoreOrderDeliveryManager/removeRetailStoreOrderList/retailStoreOrderDeliveryId/retailStoreOrderIds/tokensExpr/`
  const requestParameters = { ...parameters, retailStoreOrderDeliveryId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}



// Filter this out when no functions

const  listFunctions = () => {
  return get({
    url: `${PREFIX}retailStoreOrderDeliveryService/listFunctions/`,
  })
}


const  saveRequest = (data) => {

  return put({
    url: `${PREFIX}retailStoreOrderDeliveryService/save/`,
    data,
  })
}


const  processRequest = (data) => {

  return put({
    url: `${PREFIX}retailStoreOrderDeliveryService/process/`,
    data,
  })
}

const RetailStoreOrderDeliveryService = { view,
  load,
  addRetailStoreOrder,
  updateRetailStoreOrder,
  removeRetailStoreOrderList, listFunctions, saveRequest, processRequest, queryCandidates}
export default RetailStoreOrderDeliveryService

