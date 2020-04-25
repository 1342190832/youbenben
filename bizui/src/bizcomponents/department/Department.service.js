
import { get,put,postForm,PREFIX,joinParameters,joinPostParameters } from '../../axios/tools'

const view = (targetObjectId) => {
  return get({
    url: `${PREFIX}departmentManager/view/${targetObjectId}/`,
  })
}



const load = (targetObjectId, parameters) => {
  const parametersExpr = joinParameters(parameters)
  return get({
    url: `${PREFIX}departmentManager/loadDepartment/${targetObjectId}/${parametersExpr}/`,
  })
}


const queryCandidates = ({scenarioCode,ownerType,ownerId,listType,groupBy,filterKey,targetType}) => {
  
  const url = `${PREFIX}departmentManager/queryCandidates/`
  const data = JSON.stringify({scenarioCode,ownerType,ownerId,listType,groupBy,targetType,filterKey})
  console.log("requestParameters",data)
  return put({url,data})
} 


const requestCandidateHospital = (ownerClass, id, filterKey, pageNo) => {
 
  const url = `${PREFIX}departmentManager/requestCandidateHospital/ownerClass/id/filterKey/pageNo/`
  const requestParameters = {id, ownerClass,filterKey, pageNo}
  return postForm({url,requestParameters})
}	

const transferToAnotherHospital = (id, parameters) => {
  const url = `${PREFIX}departmentManager/transferToAnotherHospital/id/anotherHospitalId/`
  const requestParameters = {id, ...parameters}
  return postForm({url,requestParameters})
}







const addDoctorAssignment = (targetObjectId, parameters) => {
  const url = `${PREFIX}departmentManager/addDoctorAssignment/departmentId/name/doctorId/tokensExpr/`
  const departmentId = targetObjectId
  const requestParameters = { ...parameters, departmentId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateDoctorAssignment = (targetObjectId, parameters) => {
  const url = `${PREFIX}departmentManager/updateDoctorAssignmentProperties/departmentId/id/name/tokensExpr/`
  const departmentId = targetObjectId
  const requestParameters = { ...parameters, departmentId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeDoctorAssignmentList = (targetObjectId, parameters) => {
  const url = `${PREFIX}departmentManager/removeDoctorAssignmentList/departmentId/doctorAssignmentIds/tokensExpr/`
  const requestParameters = { ...parameters, departmentId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}



const addDoctorSchedule = (targetObjectId, parameters) => {
  const url = `${PREFIX}departmentManager/addDoctorSchedule/departmentId/name/doctorId/scheduleDate/periodId/available/price/expenseTypeId/hospitalId/tokensExpr/`
  const departmentId = targetObjectId
  const requestParameters = { ...parameters, departmentId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateDoctorSchedule = (targetObjectId, parameters) => {
  const url = `${PREFIX}departmentManager/updateDoctorScheduleProperties/departmentId/id/name/scheduleDate/available/price/tokensExpr/`
  const departmentId = targetObjectId
  const requestParameters = { ...parameters, departmentId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeDoctorScheduleList = (targetObjectId, parameters) => {
  const url = `${PREFIX}departmentManager/removeDoctorScheduleList/departmentId/doctorScheduleIds/tokensExpr/`
  const requestParameters = { ...parameters, departmentId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}



// Filter this out when no functions

const  listFunctions = () => {
  return get({
    url: `${PREFIX}departmentService/listFunctions/`,
  })
}


const  saveRequest = (data) => {

  return put({
    url: `${PREFIX}departmentService/save/`,
    data,
  })
}


const  processRequest = (data) => {

  return put({
    url: `${PREFIX}departmentService/process/`,
    data,
  })
}

const DepartmentService = { view,
  load,
  addDoctorAssignment,
  addDoctorSchedule,
  updateDoctorAssignment,
  updateDoctorSchedule,
  removeDoctorAssignmentList,
  removeDoctorScheduleList,
  requestCandidateHospital,
  transferToAnotherHospital, listFunctions, saveRequest, processRequest, queryCandidates}
export default DepartmentService

