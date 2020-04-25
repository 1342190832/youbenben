import merge from 'lodash/merge'
import viewConfig from './viewmapping.config'
import bizConfig from './biz-config'

const baseURL = 'http://localhost:8080/exam/' //后端服务地址

const niceRouterConfig = {
  name: 'NiceRouter App Start',
  baseURL,
  version: 1,
  appType: 'mini-program',
  viewConfig,
  backendRouterPageKeyBlackList: ['refreshPage/', 'goBack/', 'goPrevious/'],
  backendRouterPageBlackList: ['NetworkException'],
  api: {
    FooterHome: 'wxappService/viewHomePage/',
    // FooterHome: 'pocService/startCRTaskDailyReport/',
    FooterMe: 'wxappService/viewMePage/',
    FooterServiceCenter: 'wxappService/viewServiceCenterPage/',
    UpdateProfileInfo: 'wxappService/updateProfileInfo/:name/:avatar/',
    UpdatePhoneNumber: 'wxappService/updatePhoneNumber/:encryptedData/:iv/',

    Login: 'wxappService/clientLogin/',
    VerifyCode: 'sendVerifyCode/:mobile/',
    OSSToken: 'pocService/customGetOssToken/',
  },
  // loginMethod:'wechat',
  // loginMethod:'vcode',
  loginMethod: 'password',
}

const Config = merge(niceRouterConfig, bizConfig)

console.log('***********   current env  ***********   ')
console.log('config.js is', Config)
export default Config
