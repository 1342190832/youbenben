
import { get,put,postForm,PREFIX,joinParameters,joinPostParameters } from '../../axios/tools'

const view = (targetObjectId) => {
  return get({
    url: `${PREFIX}employeeBoardingManager/view/${targetObjectId}/`,
  })
}



const load = (targetObjectId, parameters) => {
  const parametersExpr = joinParameters(parameters)
  return get({
    url: `${PREFIX}employeeBoardingManager/loadEmployeeBoarding/${targetObjectId}/${parametersExpr}/`,
  })
}


const queryCandidates = ({scenarioCode,ownerType,ownerId,listType,groupBy,filterKey,targetType}) => {
  
  const url = `${PREFIX}employeeBoardingManager/queryCandidates/`
  const data = JSON.stringify({scenarioCode,ownerType,ownerId,listType,groupBy,targetType,filterKey})
  console.log("requestParameters",data)
  return put({url,data})
} 






const addEmployee = (targetObjectId, parameters) => {
  const url = `${PREFIX}employeeBoardingManager/addEmployee/employeeBoardingId/companyId/title/departmentId/familyName/givenName/email/city/address/cellPhone/occupationId/responsibleForId/currentSalaryGradeId/salaryAccount/jobApplicationId/professionInterviewId/hrInterviewId/offerApprovalId/offerAcceptanceId/terminationId/tokensExpr/`
  const employeeBoardingId = targetObjectId
  const requestParameters = { ...parameters, employeeBoardingId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateEmployee = (targetObjectId, parameters) => {
  const url = `${PREFIX}employeeBoardingManager/updateEmployeeProperties/employeeBoardingId/id/title/familyName/givenName/email/city/address/cellPhone/salaryAccount/tokensExpr/`
  const employeeBoardingId = targetObjectId
  const requestParameters = { ...parameters, employeeBoardingId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeEmployeeList = (targetObjectId, parameters) => {
  const url = `${PREFIX}employeeBoardingManager/removeEmployeeList/employeeBoardingId/employeeIds/tokensExpr/`
  const requestParameters = { ...parameters, employeeBoardingId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}



// Filter this out when no functions

const  listFunctions = () => {
  return get({
    url: `${PREFIX}employeeBoardingService/listFunctions/`,
  })
}


const  saveRequest = (data) => {

  return put({
    url: `${PREFIX}employeeBoardingService/save/`,
    data,
  })
}


const  processRequest = (data) => {

  return put({
    url: `${PREFIX}employeeBoardingService/process/`,
    data,
  })
}

const EmployeeBoardingService = { view,
  load,
  addEmployee,
  updateEmployee,
  removeEmployeeList, listFunctions, saveRequest, processRequest, queryCandidates}
export default EmployeeBoardingService

